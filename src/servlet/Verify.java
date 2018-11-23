package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Verify.do")
public class Verify extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String reallycode = (String) req.getSession(false).getAttribute("verify");
        String postcode = req.getParameter("verifycode");
        System.out.println(reallycode + "---" + postcode);
        if(reallycode.equalsIgnoreCase(postcode)){
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }else
            resp.sendRedirect("index.jsp");
    }
}
