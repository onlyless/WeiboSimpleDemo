package Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyUtil {
    private static final int PW = 70;
    private static final int PH = 35;
    private static Random random = new Random();
    private static String[] fontnames = {"Chalkboard","Cochin","Skia","Apple Symbols"};
    private String codes="012345678901234567890123456789abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
    private static Color bgColor = Color.BLACK;
    private String code;
    private volatile static VerifyUtil generateCode;

    public static VerifyUtil getInstance(){
        if(generateCode ==null){
            synchronized (VerifyUtil.class){
                if(generateCode ==null){
                    generateCode = new VerifyUtil();
                }
            }
        }
        return generateCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private Color randomColor(){
        return new Color(random.nextInt(150),random.nextInt(150),random.nextInt(150));
    }

    private Font randomFont(){
        int index = random.nextInt(fontnames.length);
        String fontname = fontnames[index];
        int style = random.nextInt(4);
        int size = random.nextInt(5) + 25;
        return new Font(fontname,style,size);
    }

    private String randomCode(){
        int len = codes.length();
        String code = "";
        for(int i=0;i<4;i++){
            int a = random.nextInt(len);
            code += codes.charAt(a);
        }
        return code;
    }

    public BufferedImage createImage(){
        BufferedImage image = new BufferedImage(PW,PH,BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.setColor(bgColor);
        g.fillRect(0,0,PW,PH);
        String num = randomCode();
        this.setCode(num);
        g.setColor(randomColor());
        g.setFont(randomFont());
        g.drawString(num,0,25);
        return image;
    }
}
