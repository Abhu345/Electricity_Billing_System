
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    
    String atype,meter;
    Project(String atype,String meter){  
          this.atype=atype;
          this.meter=meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect2.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500, 850, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        JMenuBar mb=new JMenuBar();
         setJMenuBar(mb);
        JMenu Master=new JMenu("Master");
       Master.setFont(new Font("Serif", Font.PLAIN, 25));
          Master.setForeground(Color.black);
      //  mb.add(Master);
        
        JMenuItem newcustomer=new JMenuItem("New Customer");
      
        newcustomer.setMnemonic('D');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        Master.add(newcustomer);
        
        
        
        
        JMenuItem Customerdetails=new JMenuItem("Customer Details");
        Customerdetails.setMnemonic('E');
        Customerdetails.addActionListener(this);
        Customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        Master.add(Customerdetails);
        
        
        JMenuItem Depositdetails=new JMenuItem("Deposit Details");
        Depositdetails.setMnemonic('N');
        Depositdetails.addActionListener(this);
        Depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        Master.add(Depositdetails);
        
        JMenuItem CalculateBill=new JMenuItem("Calculate Bill");
//        ImageIcon Icon2=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
//        Image Image2=Icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
//        CalculateBill.setIcon(new ImageIcon(Image2));
       CalculateBill.setMnemonic('H');
       CalculateBill.addActionListener(this);
      CalculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
        Master.add(CalculateBill);
        
        
      JMenu Info=new JMenu("Information");
       Info.setFont(new Font("Serif", Font.PLAIN, 25));
      Info.setForeground(Color.black);
     // mb.add(Info);
      
      JMenuItem UpdateInfo=new JMenuItem("Update Information");
        UpdateInfo.setMnemonic('O');
          UpdateInfo.addActionListener(this);
       UpdateInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        Info.add(UpdateInfo);
        
        
         JMenuItem ViewInfo=new JMenuItem("View Information");
        ViewInfo.setMnemonic('I');
      ViewInfo.addActionListener(this);
       ViewInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
        Info.add(ViewInfo);
        
        JMenu User=new JMenu("User");
         User.setFont(new Font("Serif", Font.PLAIN, 25));
      User.setForeground(Color.black);
    //  mb.add(User);
      
      JMenuItem Pay_Bill=new JMenuItem("Pay Bill");
       Pay_Bill.setMnemonic('Q');
    Pay_Bill.addActionListener(this);
       Pay_Bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
        User.add(Pay_Bill);
        
        JMenuItem Bill_details=new JMenuItem("Bill Details");
       Bill_details.setMnemonic('L');
       Bill_details.addActionListener(this);
      Bill_details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        User.add(Bill_details);
        
         JMenu Report=new JMenu("Report");
          Report.setFont(new Font("Serif", Font.PLAIN, 25));
      Report.setForeground(Color.black);
      //mb.add(Report);
      
      JMenuItem Generate_Bill=new JMenuItem("Generate Bill");
       Generate_Bill.setMnemonic('Y');
       Generate_Bill.addActionListener(this);
     Generate_Bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
        Report.add(Generate_Bill);
        
        JMenu Utility=new JMenu("Utility");
         Utility.setFont(new Font("Serif", Font.PLAIN, 25));
      Utility.setForeground(Color.black);
     // mb.add(Utility);
      
      JMenuItem Notepad=new JMenuItem("Notepad");
      
       Notepad.setMnemonic('Z');
       Notepad.addActionListener(this);
       Notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
       Utility.add(Notepad);

         JMenuItem Calculator=new JMenuItem("Calculator");
      
        Calculator.setMnemonic('P');
        Calculator.addActionListener(this);
        Calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        Utility.add(Calculator);

        
        
         JMenu Exit=new JMenu("Logout ");
          Exit.setFont(new Font("Serif", Font.PLAIN, 25));
      Exit.setForeground(Color.black);
      //mb.add(Exit);
      
      JMenuItem exit=new JMenuItem("Exit");
       exit.setMnemonic('X');
       exit.addActionListener(this);
     exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        Exit.add(exit);

if(atype.equals("Admin")){
    mb.add(Master);
}else {
         mb.add(Info);
         mb.add(Report);
         mb.add(User);
}
       
       mb.add(Utility);
       mb.add(Exit);
        
         
        
        setLayout(new FlowLayout());
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    String msg=ae.getActionCommand();
    if(msg.equals("New Customer")){
       new NewCustomer(); 
    }else if(msg.equals("Customer Details")){
       new CustomerDetails();
    }else if(msg.equals("Deposit Details")){
       new DepositDetails();
    }else if(msg.equals("Calculate Bill")){
       new CalculateBill();
    }else if(msg.equals("View Information")){
        new ViewInformation("meter");
    }else if(msg.equals(("Update Information"))){
        new UpdateInformation(meter);
    }else if(msg.equals("Bill Details")){
        new BillDetails(meter);
    }else if(msg.equals("Notepad")){
        try{
            Runtime.getRuntime().exec("Notepad.exe");
        }catch(Exception e){
        e.printStackTrace();
    }
    }else if(msg.equals("Calculator")){
        try{
            Runtime.getRuntime().exec("calc.exe");
        }catch(Exception e){
        e.printStackTrace();
    }
    }else if(msg.equals("Exit")){
        setVisible(false);
        new Login();
    }else if(msg.equals("Pay Bill")){
        new PayBill(meter);
    }else if(msg.equals("Generate Bill")){
        new GenerateBill(meter);
    }
    }
    
    
    public static void main(String[]args){
       new Project("",""); 
    }
}
