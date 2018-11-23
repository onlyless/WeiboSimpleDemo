package servlet;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@WebServlet("/Draw.do")
public class Draw extends HttpServlet {
    private static final String PHOTO_PATH = "/WEB-INF/IMG_1057.JPG";
    private static final int FONT_SIZE = 20;

    protected void processRequest(HttpServletRequest req,HttpServletResponse resp){
        resp.setContentType("image/jpg");

        String str = req.getParameter("str");
        if(str==null){
            str = "";
        }
        try {
            BufferedImage bufferedImage = ImageIO.read(getServletContext().getResourceAsStream(PHOTO_PATH));
            Graphics graphics = bufferedImage.getGraphics();
            graphics.setColor(Color.BLACK);

            graphics.setFont(new Font("Chalkboard",Font.ITALIC|Font.BOLD,20));
            graphics.drawString(str,20,20);
            ServletOutputStream out = resp.getOutputStream();
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(bufferedImage);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        processRequest(req,resp);
    }
}
