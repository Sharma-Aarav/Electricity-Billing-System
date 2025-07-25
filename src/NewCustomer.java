import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import javax.swing.*;
//------------------------------------------------DONE--------------------------------------------------
public class NewCustomer extends Frame implements ActionListener 
{
    TextField tfname,tfaddress,tfstate,tfcity,tfemail,tfphone;
    Button next,cancel;
    Label lblmeter;
    NewCustomer()
    {
        setSize(700, 500);
        setLocation(400,200);

        Panel p=new Panel();
        p.setLayout(null);
        p.setBackground(Color.LIGHT_GRAY);
        add(p);

        Label heading=new Label("New Customer");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        p.add(heading);

        Label lblname=new Label("Customer Name");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);

        tfname=new TextField();
        tfname.setBounds(240,80,200,20);
        p.add(tfname);

        Label lblmeterno=new Label("Meter Number");
        lblmeterno.setBounds(100,120,100,20);
        p.add(lblmeterno);

        lblmeter=new Label("");
        lblmeter.setBounds(240,120,100,20);
        p.add(lblmeter);

        Random ran=new Random();
        long number=ran.nextLong() % 1000000;
        lblmeter.setText(""+Math.abs(number));

        Label lbladdress=new Label("Address");
        lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);

        tfaddress=new TextField();
        tfaddress.setBounds(240,160,200,20);
        p.add(tfaddress);

        Label lblstate=new Label("State");
        lblstate.setBounds(100,200,100,20);
        p.add(lblstate);

        tfstate=new TextField();
        tfstate.setBounds(240,200,200,20);
        p.add(tfstate);

        Label lblcity=new Label("City");
        lblcity.setBounds(100,240,100,20);
        p.add(lblcity); 

        tfcity=new TextField();
        tfcity.setBounds(240,240,200,20);
        p.add(tfcity);

        Label lblemail=new Label("Email Id");
        lblemail.setBounds(100,280,100,20);
        p.add(lblemail);

        tfemail=new TextField();
        tfemail.setBounds(240,280,200,20);
        p.add(tfemail);

        Label lblphone=new Label("Phone Number");
        lblphone.setBounds(100,320,100,20);
        p.add(lblphone);

        tfphone=new TextField();
        tfphone.setBounds(240,320,200,20);
        p.add(tfphone);

        next=new Button("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        cancel=new Button("Cancel");
        cancel.setBounds(250,390,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p,"Center");



        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next)
        {
            String name=tfname.getText();
            String meter=lblmeter.getText();
            String address= tfaddress.getText();
            String state=tfstate.getText();
            String city=tfcity.getText();
            String email=tfemail.getText();
            String phone=tfphone.getText();

            //String query1="insert into customerdet values('"+name+"','"+meter+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phone+"')";
            //String query2="insert into det values('"+meter+"',','"+name+"',' ',' ')";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system", "root","Aarav@2003");
                String query1="insert into customerdet values('"+name+"','"+meter+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phone+"')";
                String query2="insert into det values('"+meter+"','"+name+"','', '', '')";
                PreparedStatement s=c.prepareStatement(query1);
                s.executeUpdate();
                PreparedStatement s1=c.prepareStatement(query2);
                s1.executeUpdate();
                JOptionPane.showMessageDialog(null,"Customer Details added Successfully");
                setVisible(false);

                //new frame
                new MeterInfo(meter);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        
        }
    }



    public static void main(String[] args) {
        new NewCustomer();
    }
} 