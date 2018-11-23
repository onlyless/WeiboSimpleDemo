package servlet;

import Utils.VerifyUtils;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/VerifyCode.do")
public class VerifyCode  extends HttpServlet {

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("image/jpg");
        VerifyUtils generateCode = VerifyUtils.getInstance();
        try {
            OutputStream outputStream = resp.getOutputStream();
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
            encoder.encode(generateCode.createImage());
            req.getSession(false).setAttribute("verify",generateCode.getCode());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
