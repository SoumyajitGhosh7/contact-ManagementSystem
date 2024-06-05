
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection con=null;
    public static Connection connect() {
            String url=USERNAMEPASSWORD.getURL();
            String username=USERNAMEPASSWORD.getUSERNAME();
            String password=USERNAMEPASSWORD.getPASSWORD();
        try {
            con=DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
