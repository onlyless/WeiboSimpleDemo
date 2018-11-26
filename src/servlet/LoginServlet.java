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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/login.do",
    initParams = {
        @WebInitParam(name = "SUCCESS_VIEW" ,value = "member.jsp"),
            @WebInitParam(name = "ERROR_VIEW",value = "login.jsp")
    }
)
public class LoginServlet extends HttpServlet {
    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        UserService userService = (UserService)getServletContext().getAttribute("userService") ;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("verifyCode");
        String rightCode = (String) session.getAttribute("verify");
//        System.out.println(username+" "+password+" "+code+" "+rightCode);
        Account account = new Account();
        account.setName(username);
        account.setPassword(password);
//        System.out.println(username+" "+password);
        if(userService.checkLogin(account)){
            session.setAttribute("login",username);
            User user = new User();
            user.setUsername(username);
            List<User> users = userService.getUsers(user);
            session.setAttribute("users",users);
            req.getRequestDispatcher(SUCCESS_VIEW).forward(req,resp);
        }else{
            resp.sendRedirect(ERROR_VIEW);
        }
    }
}
