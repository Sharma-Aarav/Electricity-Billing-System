import java.awt.*;
//-------------------------------------------DONE--------------------------------------------------------
public class Splash extends Frame implements Runnable
{
    Thread t;
    Label l1,l2;
    Splash()
    {
        setLayout(null);
         setVisible(true);
         int x=1;
        for(int i=2;i<600;i+=4,x+=4)
        {
        setSize(i+x,i);
        setLocation(700-((i+x)/2),400-(i/2));
        try{
            Thread.sleep(1);
            
        }
        catch(Exception e)
        {

        }
        }
        
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);
        l1=new Label("LOADING");
        l1.setBounds(450,220,400,70);
        l1.setFont(new Font("Times New Roman",Font.BOLD,50));
        add(l1);
        l2=new Label("PLEASE WAIT....");
        l2.setBounds(450, 300, 450, 70);
        l2.setFont(new Font("Times New Roman",Font.BOLD,50));
        add(l2);
        t=new Thread(this);
        t.start();
    }
    public void run()
    {
        try {
            Thread.sleep(4000);
            setVisible(false);
            //login frame
            new Login();
        } catch (Exception e) {
            
        }
    }
    public static void main(String args[])
    {
        new Splash();
    }

   
}
