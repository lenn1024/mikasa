package ai.code.mikasa.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by lenn on 16/11/8.
 */
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request destroyed, from:");
        System.out.println(sre.getServletRequest().getLocalAddr());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request initialized, from:");
        System.out.println(sre.getServletRequest().getLocalAddr());
    }
}
