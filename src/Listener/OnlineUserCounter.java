package Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class OnlineUserCounter implements HttpSessionListener {
    public static int count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count--;
    }
}
