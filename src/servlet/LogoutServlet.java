package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout.do",
    initParams = @WebInitParam(name = "NEXT_VIEW",value = "/logout.jsp")
)
public class LogoutServlet extends HttpServlet {
    private String NEXT_VIEW;

    @Override
    public void init() throws ServletException {
        NEXT_VIEW = getServletConfig().getInitParameter("NEXT_VIEW");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("login");
        session.invalidate();
        req.getSession();
        req.setAttribute("username",username);
        req.getRequestDispatcher(NEXT_VIEW).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
}
