package ai.code.mikasa.web.view;

import org.springframework.web.servlet.view.AbstractUrlBasedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class GenericFileView extends AbstractUrlBasedView {
    // 默认内容类型
    private final static String CONTENT_TYPE = "text/plain";

    // http response content
    private String responseContent;

    public GenericFileView() {
        super();
        setContentType(CONTENT_TYPE);
    }

    @Override
    public void setContentType(String contentType) {
        super.setContentType(contentType);
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(getContentType());
        // 写入 response 内容
        response.getWriter().write(this.responseContent);
        response.getWriter().close();
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }
}
