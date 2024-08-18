import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// import java.sql.SQLException;

public class JDBCDemo{
    public static void main(String []args) {
        Connection con=null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root123");

        String s="Create table  Student(sname varchar(50), srollno int PRIMARY KEY, smarks int )";
        PreparedStatement ps=con.prepareStatement(s);
        ps.executeUpdate();

        // Statement st = con.createStatement();
        // String sql = "SELECT * FROM Student";
        // resultSet = st.executeQuery(sql);

        String s1="Insert into Student values('ABC',1002,95),('XYZ',1008,90),('STU',1005,50),('OPQ',1006,45)";
        PreparedStatement ps1=con.prepareStatement(s1);
        ps1.executeUpdate();

        PreparedStatement ps2=con.prepareStatement("Select * from Student");
        ResultSet rs=ps2.executeQuery();

        System.out.println();
        System.out.println();
        while(rs.next()){
            System.out.println("Name     : "+rs.getString("sname"));
            System.out.println("Roll NO  :"+rs.getInt("srollno"));
            System.out.println("Marks    : "+rs.getInt("smarks"));
            System.out.println("--------------------------------------");
        }
        System.out.println();
        System.out.println();
        System.out.println("Students who scored  greater than 50");
        PreparedStatement ps5=con.prepareStatement("Select * from Student");
        ResultSet rs1=ps5.executeQuery();
        while(rs1.next()){
            int marks=rs1.getInt("smarks");
            if(marks>50){
            System.out.println("Name     : "+rs1.getString("sname"));
            System.out.println("Roll NO  :"+rs1.getInt("srollno"));
            System.out.println("Marks    : "+marks);
            System.out.println("--------------------------------------");
            }
        }
        System.out.println();
        System.out.println();
        PreparedStatement ps3=con.prepareStatement("update Student set smarks= smarks + 4 where smarks < 50");
        int x=ps3.executeUpdate();
        if(x>0) System.out.println("updated successfully");
        else System.out.println("not updated");

        PreparedStatement ps4=con.prepareStatement("delete from Student where srollno=1008 ");
        x=ps4.executeUpdate();
        if(x>0) System.out.println("updated successfully");
        else System.out.println("not updated");

    }
    catch(Exception e){
        e.printStackTrace();
    }
    
    finally{
        try {
            if(con!=null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }
}