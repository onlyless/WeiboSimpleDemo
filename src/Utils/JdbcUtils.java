package Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
    private static ComboPooledDataSource dataSource;

    private volatile static JdbcUtils jdbCutils;

    private JdbcUtils(){
        dataSource = new ComboPooledDataSource();
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