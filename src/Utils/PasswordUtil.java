package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class PasswordUtil {
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    private final static String numbers = "0123456789";
    public static String calculateMD5(String password, String salt){
        password = md5Hex(password+salt);
        char[] result = new char[48];
        for(int i=0;i<result.length;i+=3){
            result[i] = password.charAt(i/3*2);
            char c = salt.charAt(i/3);
            result[i] = salt.charAt(i/3);
            result[i+1] = c;
            result[i+2] = password.charAt(i/3*2+1);
        }
        return new String(result);
    }

    public static String generateSalt(){
        Random random = new Random();
        char [] salt = new char[16];
        for(int i = 0; i< salt.length; i++){
            int randomIndex = random.nextInt(numbers.length());
            salt[i] = numbers.charAt(randomIndex);
        }
        return new String(salt);
    }

    private static String md5Hex(String s) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(s.getBytes());
            return bytesToHex(bs);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
