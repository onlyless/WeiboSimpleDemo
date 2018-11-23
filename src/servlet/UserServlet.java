package servlet;

import Service.UserService;
import model.Account;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user/*",
initParams = {
        @WebInitParam(name = "USER_VIEW",value = "/user.jsp"),
        @WebInitParam(name = "ERROR_VIEW",value = "/index.jsp")
    }
)
public class UserServlet extends HttpServlet {
    private String USER_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        USER_VIEW = getServletConfig().getInitParameter("USER_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        String username = req.getPathInfo().substring(1);
        System.out.println(username);
        Account account = new Account();
        account.setName(username);
        if(userService.isUserExisted(account)) {
            User user = new User();
            user.setUsername(username);
            List<model.User> users = userService.getUsers(user);
            req.setAttribute("users", users);
            req.setAttribute("username", username);
            req.getRequestDispatcher(USER_VIEW).forward(req, resp);
        }
        resp.sendRedirect(ERROR_VIEW);
    }
}
