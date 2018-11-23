package servlet;

import Service.UserService;
import Utils.StringEscapeUtils;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/message.do",
    initParams = {
        @WebInitParam(name = "SUCCESS_VIEW",value = "member.jsp"),
            @WebInitParam(name = "ERROR_VIEW",value = "error.jsp")
    }
)
public class MessageServlet extends HttpServlet {
    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getInitParameter("ERROR_VIEW");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        if(session.getAttribute("login")==null){
            resp.sendRedirect("index.html");
            return;
        }
        UserService userService = (UserService)getServletContext().getAttribute("userService") ;
        req.setCharacterEncoding("UTF-8");
        String blabla = req.getParameter("blabla");
        if(blabla!=null&&blabla.length()!=0) {
            String username = (String) req.getSession(false).getAttribute("login");
            User user = new User(StringEscapeUtils.getRandomString(), username, StringEscapeUtils.nowTime(),
                    blabla);
            userService.addUser(user);
            resp.sendRedirect(SUCCESS_VIEW);
        }
    }
}
