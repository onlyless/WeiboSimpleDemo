package Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
    public static ComboPooledDataSource dataSource ;

    private volatile static JdbcUtil jdbCutils;

    private JdbcUtil(){
        dataSource = new ComboPooledDataSource();
    }

    public static JdbcUtil getInstance(){
        if(jdbCutils==null){
            synchronized (JdbcUtil.class){
                if(jdbCutils==null){
                    jdbCutils = new JdbcUtil();
                }
            }
        }
        return jdbCutils;
    }

    public ComboPooledDataSource getDateSource(){
        return dataSource;
    }
}
