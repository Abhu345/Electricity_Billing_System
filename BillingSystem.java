
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
public class BillingSystem extends JFrame implements Runnable{
    Thread t;
    BillingSystem(){
        super("Electricity Billing System");
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/pxfuel.jpg")); //use to get image from system
       Image i2=i1.getImage().getScaledInstance(1900, 1050, Image.SCALE_DEFAULT);  // use to scale/resize image
       ImageIcon i3=new ImageIcon(i2); //we can't pass object of Image in JLabel directly this is why we are creating an object of ImageIcon
        JLabel image=new JLabel(i3);
        add(image);
        
        setVisible(true);
        int x=1;
        for(int i=2;i<1080;i=i+4,x=x+1){// for(int i=2;i<900;i=i+4,x=x+1)
           setSize(i+x,i);//   setSize(i+x,i)
      
       setLocation(660-((i+x)/2),550-(i/2));
       try{
           Thread.sleep(5);
       }catch(Exception e){
           e.printStackTrace();
       }
    }
      t=new Thread(this);
      t.start();
      
      setVisible(true);
     
    }
    public void run(){
        try{
            Thread.sleep(3000);
           // setVisible(false);
            
            new Login();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[]args){
        BillingSystem s=new BillingSystem();
        
    }
}
