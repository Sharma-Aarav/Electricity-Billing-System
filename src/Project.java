/*import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Project extends Frame implements ActionListener
{
    Project()
    {
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setBackground(Color.GRAY);

        MenuBar mb=new MenuBar();
        setMenuBar(mb);
       

        Menu master=new Menu("Master");
        mb.add(master);

        MenuItem newcustomer=new MenuItem("New Customer");
        master.add(newcustomer);

         MenuItem customerdetails=new MenuItem("Customer Details");
        master.add(customerdetails);

        MenuItem depositdetails=new MenuItem("Deposit Details");
        master.add(depositdetails);

        MenuItem calculatebill=new MenuItem("Calculate Bill");
        master.add(calculatebill);

        Menu info=new Menu("Information");
        mb.add(info);

        MenuItem updateinfo=new MenuItem("Update Information");
        info.add(updateinfo);

        MenuItem viewinfo=new MenuItem("View Information");
        info.add(viewinfo);

        Menu user=new Menu("User");
        mb.add(user);
        
        MenuItem paybill=new MenuItem("Pay Bill");
        user.add(paybill);

        MenuItem billdetails=new MenuItem("Bill Details");
        user.add(billdetails);

        Menu report=new Menu("Report");
        mb.add(report);
        
        MenuItem generatebill=new MenuItem("Generate Bill");
        report.add(generatebill);

        Menu utitlity=new Menu("Utility");
        mb.add(utitlity);
        
        MenuItem notepad=new MenuItem("Notepad");
        utitlity.add(notepad);

        Menu exit=new Menu("Exit");
        mb.add(exit);

        MenuItem close=new MenuItem("Close");
        exit.add(close);

        setLayout(new FlowLayout());
        setVisible(true);
    }
    
public static void main(String[] args) {
    new Project();
}
public void actionPerformed(ActionEvent e){
    
}
} */
//-----------------------------------------------DONE--------------------------------------------------------------
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{

    String atype, meter;
    Project(String atype, String meter) {
        this.atype = atype;
        this.meter = meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);*/


        //JLabel lb=new JLabel("Welcome");
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLUE);
        
        
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
        newcustomer.setBackground(Color.WHITE);
        //ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        //Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        //newcustomer.setIcon(new ImageIcon(image1));
       
        newcustomer.addActionListener(this);
        
        master.add(newcustomer);
        
        
        
        
        
        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculatebill.setBackground(Color.WHITE);
        //ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        //Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        //calculatebill.setIcon(new ImageIcon(image4));
        //calculatebill.setMnemonic('B');
        calculatebill.addActionListener(this);
        //calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        master.add(calculatebill);
        
        JMenu info = new JMenu("Information");
        info.setForeground(Color.RED);
        
        
        JMenuItem updateinformation = new JMenuItem("Update Information");
        updateinformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        updateinformation.setBackground(Color.WHITE);
        //ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        //Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        //updateinformation.setIcon(new ImageIcon(image5));
        //updateinformation.setMnemonic('P');
        updateinformation.addActionListener(this);
        //updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        info.add(updateinformation);
        
        JMenuItem viewinformation = new JMenuItem("View Information");
        viewinformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        viewinformation.setBackground(Color.WHITE);
        //ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        //Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        //viewinformation.setIcon(new ImageIcon(image6));
        //viewinformation.setMnemonic('L');
        viewinformation.addActionListener(this);
        //viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        info.add(viewinformation);
        
        JMenu user = new JMenu("User");
        user.setForeground(Color.BLUE);
        
        
        /*JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced", Font.PLAIN, 12));
        paybill.setBackground(Color.WHITE);
        //ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        //Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        //paybill.setIcon(new ImageIcon(image7));
        //paybill.setMnemonic('R');
        paybill.addActionListener(this);
        //paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        user.add(paybill);*/
        
        
        
        JMenu report = new JMenu("Report");
        report.setForeground(Color.RED);
        
        
        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
        generatebill.setBackground(Color.WHITE);
        //ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        //Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        //generatebill.setIcon(new ImageIcon(image9));
        //generatebill.setMnemonic('G');
        generatebill.addActionListener(this);
        //generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generatebill);
        
        
        
        
        
        JMenu mexit = new JMenu("Exit");
        mexit.setForeground(Color.RED);
        
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced", Font.PLAIN, 12));
        exit.setBackground(Color.WHITE);
        //ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        //Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        //exit.setIcon(new ImageIcon(image12));
        //exit.setMnemonic('W');
        exit.addActionListener(this);
        //exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        mexit.add(exit);
        
        if (atype.equals("Admin")) {
            mb.add(master);
        } else {
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        
    
        mb.add(mexit);
        
        setLayout(new FlowLayout());
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
        String msg = ae.getActionCommand();
        if (msg.equals("New Customer")) {
            new NewCustomer();
        }  else if (msg.equals("Calculate Bill")) {
            new CalculateBill();
        } else if (msg.equals("View Information")) {
            new ViewInformation(meter);
        } else if (msg.equals("Update Information")) {
            new UpdateInformation(meter);
        }
         /*else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } */ else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Pay Bill")) {
            new PayBill(meter);
        } else if (msg.equals("Generate Bill")) {
            new GenerateBill(meter);
        }
    }

    public static void main(String[] args) 
    {
        new Project("", "");
    }
}