import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCApp {
    public static void main(String[] args) {
        try {
//            step 1: to load driver
              Class.forName("com.mysql.cj.jdbc.Driver");
//            step 2: get connection object
              Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
//            step3: get statement
            Statement stmt=con.createStatement();
//      call execute method and get result into  resultset
            ResultSet rs=stmt.executeQuery("select * from emp");
//iterating the result
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
            }
            rs.close();
            stmt.close();
            con.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
