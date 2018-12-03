package Listener;

import DAO.DAOImpl.AccountDAOJdbcImpl;
import DAO.DAOImpl.RelationDAOJdbcImpl;
import DAO.DAOImpl.UserDAOJdbcImpl;
import Service.RelationService;
import Service.UserService;
import Utils.JdbcUtil;

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
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        DataSource dataSource = jdbcUtil.getDateSource();
        context.setAttribute("userService",new UserService(new AccountDAOJdbcImpl(dataSource),new UserDAOJdbcImpl(dataSource)));
        context.setAttribute("relationService",new RelationService(new RelationDAOJdbcImpl(dataSource)));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
