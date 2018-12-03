import org.junit.Test;
import Utils.VerifyUtil;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Drawtest {
    @Test
    public void test(){
        VerifyUtil generateCode = VerifyUtil.getInstance();
        try {
            ImageIO.write(generateCode.createImage(),"jpeg",new File("test.jpeg"));
            System.out.println(generateCode.getCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
