import DAO.DAOImpl.AccountDAOJdbcImpl;
import DAO.DAOImpl.RelationDAOJdbcImpl;
import DAO.DAOImpl.UserDAOJdbcImpl;
import Service.RelationService;
import Service.UserService;
import Utils.JdbcUtil;
import Utils.PasswordUtil;
import Utils.StringEscapeUtil;
import model.Account;
import model.User;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JDBCtest {
    static DataSource dataSource = JdbcUtil.getInstance().getDateSource();
    static UserService userService = new UserService(new AccountDAOJdbcImpl(dataSource),new UserDAOJdbcImpl(dataSource));
    static RelationService relationService = new RelationService(new RelationDAOJdbcImpl(dataSource));
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Test
    public void addAccountTest(){
        Account account = new Account();
        account.setName("hello");
        account.setId(StringEscapeUtil.getRandomString());
        account.setEmail("74932@helo.com");
        String password = "hello";
        String salt = PasswordUtil.generateSalt();
        password = PasswordUtil.calculateMD5(password,salt);
        System.out.println(password+"\n"+salt);
        account.setPassword(password);
        account.setSalt(salt);
        userService.add(account);
    }
    @Test
    public void usernametest() throws SQLException {
        String username = "hello";
        String password = "hello";
        Account account = new Account();
        account.setName(username);
        account.setPassword(password);
        System.out.println(userService.checkLogin(account));
    }

    @Test
    public void addMessage() {
        User user = new User();
        user.setUsername("admin");
        user.setId(StringEscapeUtil.getRandomString());
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
        System.out.println(StringEscapeUtil.escapeHtml(user));
        System.out.println(StringEscapeUtil.escapeHtml(ps));
        System.out.println(StringEscapeUtil.escapeHtml("[b]hh[/b]"));
        System.out.println(StringEscapeUtil.escapeHtml("[i]hh[/i]"));
        System.out.println(StringEscapeUtil.escapeHtml("[big]hh[/big]"));
        System.out.println(StringEscapeUtil.escapeHtml("[small]hh[/small]"));
    }

    @Test
    public void insertDate(){
        String a = "hello";
        Integer b = 12;
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
