import java.sql.*;//this program is executed successfully
public class App {

    App(){
         String url="jdbc:mysql://localhost:3306/bill_system";
        String username="root";
        String password="Aarav@2003";
        String id1="21210121";
        String name1="Divy";
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con=DriverManager.getConnection(url, username, password);

            Statement s=con.createStatement();

            String query="insert into student values('"+id1+"','"+name1+"')";
         
            s.executeUpdate(query);

            ResultSet rs=s.executeQuery("select * from student");


            

            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2));
            }

            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
       new App();
    }
}

