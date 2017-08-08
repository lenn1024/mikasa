package ai.code.mikasa.web.viewresolver;

import ai.code.mikasa.web.view.GenericFileView;
import org.springframework.core.Ordered;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

public class GenericFileViewResolver extends AbstractCachingViewResolver implements Ordered {

    private int order;

    @Override
    protected View loadView(String viewName, Locale locale) throws Exception {
        Resource resource = getApplicationContext().getResource(viewName);

        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null){
            sb.append(line).append("\r\n");
        }

        GenericFileView view = new GenericFileView();
        view.setResponseContent(sb.toString());
        return view;
    }

    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
