import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class contactDao {
    public static void createContact(Contact c) throws SQLException{
        Connection con=DB.connect();
        String query=Query.INSERT;
        PreparedStatement pstm=con.prepareStatement(query);
        pstm.setString(1, c.getName());
        pstm.setString(2, c.getNumber());
        pstm.setString(3, c.getEmail());
        pstm.execute();
        pstm.close();
        con.close();
    }

    public static void updateContact(String oldNumber,String newNumber,String email) throws SQLException {
        Connection con=DB.connect();
        String query=Query.UPDATE;
        PreparedStatement pstm=con.prepareStatement(query);
        pstm.setString(1, newNumber);
        pstm.setString(2, email);
        pstm.setString(3, oldNumber);
        pstm.execute();
        pstm.close();
        con.close();
    }

    public static ArrayList<Contact> readAll() throws SQLException{
        Connection con=DB.connect();
        ArrayList<Contact>conList=new ArrayList<>();
        String query=Query.SELECT;
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery(query);
        while(rs.next()){
            Contact c=new Contact(rs.getString(1), rs.getString(2), rs.getString(3));
            conList.add(c);
        }
        if(conList.size()==0) System.out.println("You dont't have any contacts");
        return conList;
    }

    public static void deleteContact(String name,String number) throws SQLException {
        Connection con=DB.connect();
        String query=Query.DELETE;
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1,number);
        pst.setString(2, name);
        pst.execute();
        pst.close();
        con.close();
    }
}
