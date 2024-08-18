import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultSetDemo{
    public static void main(String []args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root123");
        PreparedStatement ps=con.prepareStatement("select * from register");

        ResultSet rs=ps.executeQuery();
        try {
            while(rs.next()){
            
                String name1=rs.getString("name");
                String email1=rs.getString("email");
                String password1=rs.getString("mypassword");
                String gender1=rs.getString("gender");
                String city1=rs.getString("city");
    
            System.out.println(name1 +"    "+email1+"       "+password1+"       "+gender1+"     "+city1);            
                
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        con.close();
        rs.close();

    }
}