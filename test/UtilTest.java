import Utils.PasswordUtil;
import org.junit.Test;

public class UtilTest {
    @Test
    public void PasswordTest(){
        String password = "123456a";
        String salt = PasswordUtil.generateSalt();
        System.out.println(salt);
        System.out.println(PasswordUtil.calculateMD5(password,salt));
    }
}
