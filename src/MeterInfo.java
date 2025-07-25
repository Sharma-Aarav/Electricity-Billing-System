import java.awt.*; //Mine
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;
public class MeterInfo extends Frame implements ActionListener 
{
    TextField tfname,tfaddress,tfstate,tfcity,tfemail,tfphone;
    Button next;
    Label lblmeter;
    Choice meterlocation,metertype,phasecode,billtype;
    String meternumber;
    MeterInfo(String meternumber)
    {
        this.meternumber=meternumber;
        setSize(700, 500);
        setLocation(400,200);

        Panel p=new Panel();
        p.setLayout(null);
        p.setBackground(Color.LIGHT_GRAY);
        add(p);

        Label heading=new Label("Meter Information");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        p.add(heading);

        Label lblname=new Label("Meter Number");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);

         Label lblmeternumber=new Label(meternumber);
        lblmeternumber.setBounds(240,80,100,20);
        p.add(lblmeternumber);
        

        Label lblmeterno=new Label("Meter Location");
        lblmeterno.setBounds(100,120,100,20);
        p.add(lblmeterno);

        meterlocation=new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(240,120,200,20);
        p.add(meterlocation); 

        //Random wala 3 line

        Label lbladdress=new Label("Meter Type");
        lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);

        metertype=new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(240,160,200,20);
        p.add(metertype); 

        tfaddress=new TextField();
        tfaddress.setBounds(240,160,200,20);
        p.add(tfaddress);

        Label lblstate=new Label("Phase Code");
        lblstate.setBounds(100,200,100,20);
        p.add(lblstate);

        phasecode=new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(240,200,200,20);
        p.add(phasecode); 

        Label lblcity=new Label("Bill Type");
        lblcity.setBounds(100,240,100,20);
        p.add(lblcity); 

        billtype=new Choice();
        billtype.add("Normal");
        billtype.add("Industrial");
        billtype.setBounds(240,240,200,20);
        p.add(billtype); 

        Label lblemail=new Label("Days");
        lblemail.setBounds(100,280,100,20);
        p.add(lblemail);

        Label lblemails=new Label("30 Days");
        lblemails.setBounds(240,280,100,20);
        lblemails.setFont(new Font("Tahoma",Font.BOLD,15));
        p.add(lblemails);

        Label lblphone=new Label("Note");
        lblphone.setBounds(100,320,100,20);
        p.add(lblphone);

        Label lblphones=new Label("By Default bill is calculated for 30 days only");
        lblphones.setBounds(240,320,500,20);
        lblphones.setFont(new Font("Tahoma",Font.BOLD,15));
        p.add(lblphones);        

        next=new Button("Submit");
        next.setBounds(220,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        

        setLayout(new BorderLayout());
        add(p,"Center");



        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next)
        {
            String meter=meternumber;
            String location=meterlocation.getSelectedItem();
            String type= metertype.getSelectedItem();
            String code=phasecode.getSelectedItem();
            String typebill=billtype.getSelectedItem();
            String days="30";  
             String query="insert into meterinfo values('"+meter+"', '"+location+"', '"+type+"', '"+code+"', '"+typebill+"', '"+days+"')";
             
         

             try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system", "root","Aarav@2003");
                PreparedStatement pstmt=c.prepareStatement(query);
                pstmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Meter Information Added Successfully");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            //new Project();
        }
    }



    public static void main(String[] args) {
        new MeterInfo("");
    }
}
