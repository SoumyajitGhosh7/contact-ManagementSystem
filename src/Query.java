public class Query {
    static String INSERT="INSERT INTO contactDetails values(?,?,?)";
    static String UPDATE="UPDATE contactDetails set mobile_number=?, email=? WHERE mobile_number=?";
    //static String UPDATE_EMAIL="UPDATE contactDetails set email=? WHERE mobile_number=?";
    static String DELETE="DELETE FROM contactDetails WHERE mobile_number=? AND name=?";
    static String SELECT="SELECT * FROM contactDetails";
}
