import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//agar problem aayi to maine isme se import.java.util.* hata diya hai
import java.sql.*;
//-------------------------------------------------DONE---------------------------------------------------------
public class CalculateBill extends JFrame implements ActionListener{

    JTextField tfname, tfaddress, tfstate, tfunits, tfemail, tfphone;
    JButton next, cancel;
    JLabel lblname, labeladdress;
    Choice meternumber, cmonth;
    CalculateBill() {
        setSize(700, 500);
        setLocation(400, 150);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(100, 10, 400, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);
        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(100, 80, 100, 20);
        p.add(lblmeternumber);
        
        meternumber = new Choice();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system", "root","Aarav@2003");
                String query="select * from customerdet";
                PreparedStatement pstmt=c.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                meternumber.add(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        meternumber.setBounds(240, 80, 200, 20);
        p.add(meternumber);
        
        JLabel lblmeterno = new JLabel("Name");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);
        
        lblname = new JLabel("");
        lblname.setBounds(240, 120, 100, 20);
        p.add(lblname);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);
        
        labeladdress = new JLabel();
        labeladdress.setBounds(240, 160, 200, 20);
        p.add(labeladdress);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system", "root","Aarav@2003");
                String query="select * from customerdet where meter_no = '"+meternumber.getSelectedItem()+"'";
            //ResultSet rs = c.s.executeQuery("select * from customerdet where meter_no = '"+meternumber.getSelectedItem()+"'");
            PreparedStatement s=c.prepareStatement(query);
            ResultSet rs=s.executeQuery();
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                labeladdress.setText(rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        meternumber.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
        
                        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system", "root","Aarav@2003");
                        String query="select * from customerdet where meter_no = '"+meternumber.getSelectedItem()+"'";
                    //ResultSet rs = c.s.executeQuery("select * from customerdet where meter_no = '"+meternumber.getSelectedItem()+"'");
                    PreparedStatement s=c.prepareStatement(query);
                    ResultSet rs=s.executeQuery();
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        labeladdress.setText(rs.getString("address"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        JLabel lblcity = new JLabel("Units Consumed");
        lblcity.setBounds(100, 200, 100, 20);
        p.add(lblcity);
        
        tfunits = new JTextField();
        tfunits.setBounds(240, 200, 200, 20);
        p.add(tfunits);
        
        JLabel lblstate = new JLabel("Month");
        lblstate.setBounds(100, 240, 100, 20);
        p.add(lblstate);
        
        cmonth = new Choice();
        cmonth.setBounds(240, 240, 200, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        p.add(cmonth);
        
        next = new JButton("Submit");
        next.setBounds(120, 350, 100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 350, 100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        
        add(p, "Center");
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String meter = meternumber.getSelectedItem();
            String units = tfunits.getText();
            String month = cmonth.getSelectedItem();
            
            int totalbill = 0;
            int unit_consumed = Integer.parseInt(units);

            String query = "select * from tax";
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
        
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system", "root","Aarav@2003");
                
                //ResultSet rs = c.s.executeQuery("select * from customerdet where meter_no = '"+meternumber.getSelectedItem()+"'");
                PreparedStatement s=c.prepareStatement(query);
                ResultSet rs=s.executeQuery();
                
                while(rs.next()) {
                    totalbill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill += Integer.parseInt(rs.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs.getString("service_charge"));
                    totalbill += Integer.parseInt(rs.getString("service_tax"));
                    totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalbill += Integer.parseInt(rs.getString("fixed_tax"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            String query2 = "insert into bill values('"+meter+"', '"+month+"', '"+units+"', '"+totalbill+"', 'Not Paid')";
        
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system", "root","Aarav@2003");
                PreparedStatement pstmt=c.prepareStatement(query2);
                pstmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new CalculateBill();
    }
}