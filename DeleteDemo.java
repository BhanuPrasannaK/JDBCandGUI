import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDemo{
    public static void main(String []args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root123");
        PreparedStatement ps=con.prepareStatement("delete from register where email=?");
        ps.setString(1,"sada@123");

        int x=ps.executeUpdate();

        if(x>0)
        System.out.println("Deleted successfully"+x);
        else
        System.out.println("Deletion was not successfully "+x);

    }
}