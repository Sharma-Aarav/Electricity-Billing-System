import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn() {
        try {
            /*c = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "Aarav@2003");
            s = c.createStatement();
            */
            //Register driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="\"jdbc:mysql://localhost:3306/bill_system";
            String username="root";
            String password="Aarav@2003";
            c=DriverManager.getConnection(url,username,password);

            //create statement

            String q="create table Student(id int, name varchar(10))";
            s=c.createStatement();

            //execute query
            s.executeQuery(q);

            //checking if all included
            System.out.println("Query added");

            //close connection
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}