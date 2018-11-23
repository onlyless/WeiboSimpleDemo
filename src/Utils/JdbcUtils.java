package Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
    public static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    private volatile static JdbcUtils jdbCutils;

    private JdbcUtils(){
    }

    public static JdbcUtils getInstance(){
        if(jdbCutils==null){
            synchronized (JdbcUtils.class){
                if(jdbCutils==null){
                    jdbCutils = new JdbcUtils();
                }
            }
        }
        return jdbCutils;
    }

    public ComboPooledDataSource getDateSource(){
        return dataSource;
    }
}
