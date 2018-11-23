package Listener;

import DAO.DAOImpl.AccountDAOJdbcImpl;
import DAO.DAOImpl.UserDAOJdbcImpl;
import Service.UserService;
import Utils.JdbcUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class GossipListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        JdbcUtils jdbcUtils = JdbcUtils.getInstance();
        DataSource dataSource = jdbcUtils.getDateSource();
        context.setAttribute("userService",new UserService(new AccountDAOJdbcImpl(dataSource),new UserDAOJdbcImpl(dataSource)));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
