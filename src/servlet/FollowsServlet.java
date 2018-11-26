package servlet;

import Service.RelationService;
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

@WebServlet(urlPatterns = "/follows.do",
        initParams = @WebInitParam(name = "SUCCESS_VIEW",value = "/follows.jsp")
)
public class FollowsServlet extends HttpServlet {
    private String SUCCESS_VIEW;
    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RelationService relationService = (RelationService) getServletContext().getAttribute("relationService");
        String usernamne = (String) session.getAttribute("login");
        User user = new User();
        user.setUsername(usernamne);
        List<User> follows = relationService.getFollows(user);
        session.setAttribute("follows",follows);
        req.getRequestDispatcher(SUCCESS_VIEW).forward(req,resp);
    }
}
