package ai.code.mikasa.web.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("init hello servlet.");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        // this.getServletConfig();
    }

}
