import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//--------------------------------------DONE--------------------------------------
import javax.swing.JOptionPane;
public class Signup extends Frame implements ActionListener
{
    Label username,lblpassword,lblname;
    Button create,back;
    TextField tm,tu,tn,tp;
    Choice accountType;
    Signup()
    {
        super("Sign Up Page");
        setSize(700,400);
        setLocation(450,150);
        setBackground(Color.WHITE);
        setLayout(null);

        Panel pan=new Panel();
        pan.setBounds(30,30,650,300);
        pan.setBackground(Color.WHITE);
        setVisible(true);
        pan.setLayout(null);
        add(pan);

        Label heading=new Label("Create Account As");
        heading.setBounds(100,50,140,20);
        pan.add(heading);
        heading.setFont(new Font("Tahoma",Font.BOLD,14));

        accountType=new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,50,150,20);
        pan.add(accountType);

        Label meter=new Label("Meter Number");
        meter.setBounds(100,90,140,20);
        meter.setFont(new Font("Tahoma",Font.BOLD,14));
        pan.add(meter);

        tm=new TextField();
        tm.setBounds(260,90,150,20);
        pan.add(tm);

        username=new Label("Username");
        username.setBounds(100,130,140,20);
        username.setFont(new Font("Tahoma",Font.BOLD,14));
        pan.add(username);

        tu=new TextField();
        tu.setBounds(260,130,150,20);
        pan.add(tu);

        lblname=new Label("Name");
        lblname.setBounds(100,170,140,20);
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        pan.add(lblname);

        tn=new TextField();
        tn.setBounds(260,170,150,20);
        pan.add(tn);

        lblpassword=new Label("Password");
        lblpassword.setBounds(100,210,140,20);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        pan.add(lblpassword);

        tp=new TextField();
        tp.setBounds(260,210,150,20);
        pan.add(tp);

        create=new Button("Create");
        create.setBounds(140,260,120,25);
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.addActionListener(this);
        pan.add(create);

        back=new Button("Back");
        back.setBounds(300,260,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        pan.add(back);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
       
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Login();
        }
        if(ae.getSource()==create)
        {
            String aType=accountType.getSelectedItem();
            String susername=tu.getText();
            String sname=tn.getText();
            String spassword=tp.getText();
            String smeter=tm.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system", "root","Aarav@2003");
                String query="insert into det(meterno,name,username,password,usertype) values('"+smeter+"','"+sname+"','"+susername+"', '"+spassword+"', '"+aType+"')";
                PreparedStatement pstmt=con.prepareStatement(query);  //used to add query into database

                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Account created successfully");

                

            } catch (Exception e) {
                e.printStackTrace();
            } 
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new Signup();
    }
    
}
