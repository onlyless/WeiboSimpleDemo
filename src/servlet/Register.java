package servlet;

import Service.UserService;
import Utils.StringEscapeUtils;
import model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/register.do",
    initParams = {
        @WebInitParam(name = "SUCCESS_VIEW",value = "success.view"),
            @WebInitParam(name = "ERROR_VIEW",value = "error.jsp")
    }
)
public class Register extends HttpServlet {
    private String SUCCESS_VIEW;
    private String ERROR_VIEW = "error.jsp";

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS.VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String id = StringEscapeUtils.getRandomString();
        Account account = new Account(id,email,username,password);
        List<String> errors = new ArrayList<>();
        UserService userService = (UserService)getServletContext().getAttribute("userService");

        if(isInvalidEmail(email)){
            errors.add("邮箱格式不正确");
        }
            if(userService.isUserExisted(account)){
                errors.add("用户已存在");
            }
        if(isInvalidPassword(password)) {
            System.out.println(password);
            errors.add("密码格式不正确");
        }
        String reslutPage = ERROR_VIEW;
        if(!errors.isEmpty()){
            req.setAttribute("errors",errors);
        }else{
            reslutPage = SUCCESS_VIEW;
            userService.add(account);
        }
        req.getRequestDispatcher(reslutPage).forward(req,resp);
    }

    private boolean isInvalidPassword(String password) {
        return password == null || password.length()<6||password.length()>16;
    }

    private boolean isInvalidEmail(String email){
        return email == null || !email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
    }
}
