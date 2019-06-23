package ai.code.mikasa.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/bula", asyncSupported = true)
public class HelloServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("init hello servlet.");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        AsyncContext asyncCtx = request.startAsync();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                asyncCtx.getResponse().getWriter().print("async hello world.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            asyncCtx.complete();
        }).start();

    }

}
