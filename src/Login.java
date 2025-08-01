import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, cancel, signup;
    JTextField username, password;
    Choice logginin;
    Login() {
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(300, 20, 100, 20);
        add(lblusername);
        
        username = new JTextField();
        username.setBounds(400, 20, 150, 20);
        add(username);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(300, 60, 100, 20);
        add(lblpassword);
        
        password = new JTextField();
        password.setBounds(400, 60, 150, 20);
        add(password);
        
        JLabel loggininas = new JLabel("Loggin in as");
        loggininas.setBounds(300, 100, 100, 20);
        add(loggininas);
        
        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(400, 100, 150, 20);
        add(logginin);
        
        
        login = new JButton("Login");
        login.setBounds(330, 160, 100, 20);
        login.addActionListener(this);
        add(login);
        
       
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 160, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        signup = new JButton("Signup");
        signup.setBounds(380, 200, 100, 20);
        signup.addActionListener(this);
        add(signup);
        
        
        
        
        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
        
        if (ae.getSource() == login) 
        {
            String susername = username.getText();
            String spassword = password.getText();
            String user = logginin.getSelectedItem();
            String passDb=null,meter=null;
            int notfound=0;
            try 
            {
                
                //Conn con=new Conn();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system", "root","Aarav@2003");

                
                String query = "select * from det where username = '"+susername+"' and password = '"+spassword+"' and usertype = '"+user+"'";
                //String query="Select * from detail";
                
                PreparedStatement pstmt=con.prepareStatement(query);

                ResultSet rs = pstmt.executeQuery();
                
                /*while(rs.next())
                {
                    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
                }*/
                while(rs.next())
                {
                    passDb = rs.getString("password");
                    
                    
                    if(spassword.equals(passDb))
                    {
                        meter=rs.getString("meterno");
                        setVisible(false);
                        notfound=1;
                        new Project(user, meter);
                    }
                }
                if(rs.next()==false && notfound==0){
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                }
                /*if(notfound==1 && spassword.equals(passDb))
                {
                    String meter=rs.getString("meterno");
                    setVisible(false);
                    new Project(user,meter);
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                }
                  */                  
            }catch (Exception e) 
            {
                e.printStackTrace();
            }
        
        } 
        else if (ae.getSource() == cancel) 
        {
            System.exit(0);
        } 
        else if (ae.getSource() == signup) 
        {
            setVisible(false);
            
            new Signup();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
