package ai.code.mikasa.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *  js的国际化
 *
 *  1. 将需要格式化的js key写到资源文件 /locale.js中， 需要处理 var i18n 变量的内容， 格式为//#后跟国际化properties文件的key, 此key必须在国际化properties文件中存在， 否则会报错
 var i18n= {
 //#ok
 //#cancel
 //#express.reference
 };
 需要注意对js的格式化参数， 目前仅支持 {0} 及纯参数形式， 暂时不支持对日期、货币等的格式化
 2. 在需要js中做国际化的vm/jsp文件中引用此controller对应的js文件， 为contextPath/locale.js
 3. 在js中使用 locale(code, [arg0, arg1, arg2])方式获得本地化的信息
 *
 * Created by zhaoyukai on 2017/6/7.
 */
@Controller
public class LocaleController {
    private static final String ENCODING = "utf-8";
    private static final Object[] EMPTY_ARGS_FOR_TRICK = new Object[]{
            "{0}", "{1}", "{2}", "{3}", "{4}", "{5}", "{6}", "{7}", "{8}", "{9}", "{10}", "{11}", "{12}", "{13}", "{14}", "{15}"
    };


    @Autowired
    private MessageSource messageSource;

    /**
     * 输出js国际化内容
     * @param response httpResponse
     * @throws IOException 资源文件不存在时的异常
     */
    @RequestMapping(value = "/locale.js", method = RequestMethod.GET)
    public void showLocaleJs(HttpServletResponse response) throws IOException {
        setResponseHeader(response);
        String js = getLocaleJs();
        response.getWriter().write(js);
        response.flushBuffer();
    }


    private String getLocaleJs() throws IOException {
        StringWriter stringWriter = new StringWriter(1024);
        PrintWriter writer = null;
        InputStream stream = null;
        InputStreamReader reader = null;
        BufferedReader br = null;
        try {
            writer = new PrintWriter(stringWriter);
            stream = getClass().getResourceAsStream("/locale.js");
            reader = new InputStreamReader(stream, ENCODING);
            br = new BufferedReader(reader);
            boolean isFirstMessage = true;
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }

                String timedLine = line.trim();

                if (timedLine.startsWith("//#")) {
                    String key = timedLine.substring(3).trim();
                    String message = messageSource.getMessage(key, EMPTY_ARGS_FOR_TRICK,
                            LocaleContextHolder.getLocale());
                    if (isFirstMessage) {
                        isFirstMessage = false;
                    } else {
                        writer.write("\n,");
                    }
                    writer.write('\t');
                    writer.write('"');
                    writer.write(key);
                    writer.write('"');
                    writer.write(":");
                    writer.write('"');
                    writer.write(message.replace("\"", "\\\""));
                    writer.write('"');
                } else {
                    writer.write(line);
                    writer.write('\n');
                }
            }
            writer.flush();
            return stringWriter.getBuffer().toString();
        } finally {
            if (stream != null) {
                stream.close();
            }

            if (reader != null) {
                reader.close();
            }

            if (br != null) {
                br.close();
            }

            if (writer != null) {
                writer.close();
            }
        }
    }

    private void setResponseHeader(HttpServletResponse response) {
        response.setContentType("text/javascript");
        response.setCharacterEncoding(ENCODING);
        response.addHeader("Cache-Control", "public");
        response.addHeader("max-age", "3600");
    }

}