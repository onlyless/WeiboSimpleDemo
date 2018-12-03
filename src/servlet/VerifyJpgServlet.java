package servlet;

import Utils.VerifyUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/VerifyCode.jpg")
public class VerifyJpgServlet extends HttpServlet {

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("image/jpg");
        VerifyUtil verifyUtils = VerifyUtil.getInstance();
        try {
            OutputStream outputStream = resp.getOutputStream();
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
            encoder.encode(verifyUtils.createImage());
            req.getSession(false).setAttribute("verify",verifyUtils.getCode());
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
