package servlet;

import Service.UserService;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete.do",
        initParams = {
                @WebInitParam(name = "SUCCESS_VIEW",value = "member.jsp"),
                @WebInitParam(name = "ERROR_VIEW",value = "member.jsp")
        }
)

public class DeleteMessageServlet extends HttpServlet {
    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getInitParameter("ERROR_VIEW");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        if (id == null) {
            resp.sendRedirect(ERROR_VIEW);
        }
        HttpSession session = req.getSession();
        User user = new User();
        user.setId(id);
        user.setUsername((String) session.getAttribute("login"));
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        userService.delUser(user);
        session.setAttribute("users",userService.getUsers(user));
        resp.sendRedirect(SUCCESS_VIEW);
    }

    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            processRequest(req, resp);
        }
}
