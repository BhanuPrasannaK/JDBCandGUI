import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;

class InsertDemo{
    public static void main(String []args) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("enter person details to register :");
        String name=sc.next();
        String email=sc.next();
        String password=sc.next();
        String gender=sc.next();
        String city=sc.next();
        sc.close();
        Connection con=null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root123");

        PreparedStatement ps=con.prepareStatement("Insert into register values(?,?,?,?,?)");
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,password);
        ps.setString(4,gender);
        ps.setString(5,city);

        int x=ps.executeUpdate();
        System.out.println();
        System.out.println();
        if(x>0)
        System.out.println("Inserted successfully");
        else
        System.out.println("Not Inserted successfully");


        }catch (SQLException | ClassNotFoundException e) {
            // Handle errors for JDBC
            e.printStackTrace();
        }finally {
            // Clean up environment
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}