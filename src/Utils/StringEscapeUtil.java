package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringEscapeUtil {
    private static Random random = new Random();
    private static String alp = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:dd");

    public static String getRandomString(){
        int len = alp.length();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<10;i++){
            int index = random.nextInt(len);
            builder.append(alp.charAt(index));
        }
        return builder.toString();
    }
    public static String escapeHtml(String value) {
//        value = value.replaceAll("<","&lt;");
//        value = value.replaceAll(">","&gt;");
//        value = value.replaceAll("\"","&quot;");
        value = value.replaceAll("\\[b\\]","<b>");
        value = value.replaceAll("\\[/b\\]","</b>");
        value = value.replaceAll("\\[i\\]","<i>");
        value = value.replaceAll("\\[/i\\]","</i>");
        value = value.replaceAll("\\[big\\]","<big>");
        value = value.replaceAll("\\[/big\\]","</big>");
        value = value.replaceAll("\\[small\\]","<small>");
        value = value.replaceAll("\\[/small\\]","</small>");
        return value;
    }

    public static String nowTime(){
        return dateFormat.format(new Date());
    }
}
