import java.sql.*;
import javax.swing.*;
//-------------------------------------SUCCESSFULLY EXECUTED AND VALUES STORED IN DATABASE-----------------------------------
import java.awt.*;
import java.awt.event.*;
public class Demo extends JFrame implements ActionListener{
    Button hello;
    TextField t,t1;
    Demo(){
        super("Demo");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Label name = new Label("Name");
        name.setBounds(300, 20, 100, 20);
        add(name);

        t=new TextField();
        t.setBounds(400, 20, 150, 20);
        add(t);

        Label rolln=new Label("Roll No");
        rolln.setBounds(300,60,100,20);
        add(rolln);

        t1=new TextField();
        t1.setBounds(400,60,150,20);
        add(t1);

        hello=new Button("HelloS");
        hello.setBounds(330, 160, 100, 20);
        hello.addActionListener(this);
        add(hello);

        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==hello){
            String sname=t.getText();
            String sroll=t1.getText();
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system", "root","Aarav@2003");

                String query="Insert into student(id,name) values('"+sroll+"','"+sname+"')";
                PreparedStatement pstmt=con.prepareStatement(query);

                pstmt.executeUpdate();
                
                
                

                JOptionPane.showConfirmDialog(null, "Orders saved!",
	                "Result", JOptionPane.DEFAULT_OPTION,
	                JOptionPane.PLAIN_MESSAGE);

            }
            catch(Exception ae){
                ae.printStackTrace();
            }
        }
        
    }
    public static void main(String[] args) {
        new Demo();
    }
    
    
}
