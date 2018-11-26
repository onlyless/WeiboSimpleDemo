import DAO.DAOImpl.AccountDAOJdbcImpl;
import DAO.DAOImpl.RelationDAOJdbcImpl;
import DAO.DAOImpl.UserDAOJdbcImpl;
import Service.RelationService;
import Service.UserService;
import Utils.JdbcUtils;
import Utils.StringEscapeUtils;
import model.Account;
import model.User;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JDBCtest {
    static DataSource dataSource = JdbcUtils.getInstance().getDateSource();
    static UserService userService = new UserService(new AccountDAOJdbcImpl(dataSource),new UserDAOJdbcImpl(dataSource));
    static RelationService relationService = new RelationService(new RelationDAOJdbcImpl(dataSource));
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Test
    public void usernametest() throws SQLException {
        String username = "admin";
        String password = "123456a";
        Account account = new Account();
        account.setName(username);
        account.setPassword(password);
        System.out.println(userService.checkLogin(account));
    }

    @Test
    public void addMessage() {
        User user = new User();
        user.setUsername("admin");
        user.setId(StringEscapeUtils.getRandomString());
        Date date = new Date();
        user.setDate(dateFormat.format(date));
        user.setTxt("hest");
        userService.addUser(user);
//        userService.delUser(user);
        List<User> list = userService.getUsers(user);
        System.out.println(list.size());
    }

    @Test
    public void delete(){
        String user = "admin";
        String message = "test";
        Account account = new Account();
        account.setName(user);
        System.out.println(userService.isUserExisted(account));
    }

    @Test
    public void test(){
        String user = "admin";
        String ps = "123456a";
        String s = "";
        String [] a = s.split("@@@");
        System.out.println(a[0]);
        System.out.println(StringEscapeUtils.escapeHtml(user));
        System.out.println(StringEscapeUtils.escapeHtml(ps));
        System.out.println(StringEscapeUtils.escapeHtml("[b]hh[/b]"));
        System.out.println(StringEscapeUtils.escapeHtml("[i]hh[/i]"));
        System.out.println(StringEscapeUtils.escapeHtml("[big]hh[/big]"));
        System.out.println(StringEscapeUtils.escapeHtml("[small]hh[/small]"));
    }

    @Test
    public void insertDate(){
    }

    @Test
    public void testFans(){
        User user = new User();
        user.setUsername("aa");
        List<User> fans = relationService.getFans(user);
        System.out.println(fans.size());
        for(User fan : fans){
//            System.out.println(user1.getTxt()+" " + user1.getDate());
            System.out.println(fan.getUsername());
        }
    }

    @Test
    public void testFollows(){
        User user = new User();
        user.setUsername("admin");
        List<User> follows = relationService.getFollows(user);
        System.out.println(follows.size());
        for(User follow:follows){
            System.out.println(follow.getUsername());
        }

    }
}
