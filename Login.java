
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
     JButton Cancel,Signup,login;
     JTextField username,password;
     Choice logginin;
    Login(){
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername=new JLabel("username");
        lblusername.setBounds(300,20,100,20);
        add(lblusername);
        
        username=new JTextField();
        username.setBounds(400,20,150,20);
        add(username);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(300,60,150,20);
        add(lblpassword);
        
         password=new JTextField();
        password.setBounds(400,60,150,20);
        add(password);
        
        JLabel lbllogginginas=new JLabel("loggin in as");
        lbllogginginas.setBounds(300,60,100,100);
        add(lbllogginginas);
        
        logginin=new Choice();
       logginin.add("Admin");
       logginin.add("Customer");
       logginin.setBounds(400,100,150,20);
       add(logginin);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
       Image i2=i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        login=new JButton("Login",new ImageIcon(i2));
       login.setBounds(330,160,100,20);
       login.addActionListener(this);
       add(login);
        
       ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
       Image i4=i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
         Cancel=new JButton("Cancel",new ImageIcon(i4));
       Cancel.setBounds(450,160,100,20);
           Cancel.addActionListener(this);
       add(Cancel);
       
       ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
       Image i6=i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
         Signup=new JButton("Signup",new ImageIcon(i6));
       Signup.setBounds(380,200,100,20);
           Signup.addActionListener(this);
       add(Signup);
       
       ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/Second.jpg"));
       Image i8=i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
       ImageIcon i9=new ImageIcon(i8);
       JLabel image=new JLabel(i9);
       image.setBounds(0,0,250,250);
       add(image);
       
      setSize(640,300);
      setLocation(400,200);
      setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
           String susername=username.getText();
           String spassword=password.getText();
           String user=logginin.getSelectedItem();
           
           try{
               Conn c=new Conn();
               String query="select *from login where username='"+susername+"'and password='"+spassword+"'and user='"+user+"'";
               ResultSet rs=c.s.executeQuery(query);
             
               if(rs.next()){
                   String meter=rs.getString("meter_no");
                  setVisible(false);
                  new Project(user,meter);
               }else{
                   JOptionPane.showMessageDialog(null,"invalid login");
                   username.setText(" ");
                   password.setText(" ");
               }
               
               
           }catch(Exception e){
               e.printStackTrace();
           }
           
           
        }
        else if(ae.getSource() == Cancel){
           setVisible(false); 
        }
        else if(ae.getSource()==Signup){
           setVisible(false);
           new Signup();
        }
    }
    public static void main(String[]args){
        new Login();
    }
}
