
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{
    JButton Back,create;
    Choice accountType;
    JTextField meter,username,name,password;
    Signup(){
        setBounds(450,150,700,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel=new JPanel();
        panel.setBounds(30,30,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);
        
        JLabel heading=new JLabel("Create Account");
        heading.setBounds(100,50,140,20);
        panel.add(heading);
        
        accountType=new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
        panel.add(accountType);
        
        JLabel lblmeter=new JLabel("Meter Number");
        lblmeter.setBounds(100,90,140,20);
        lblmeter.setVisible(false);
        panel.add(lblmeter);
        
        meter=new JTextField();
        meter.setBounds(260,90,150,20);
        meter.setVisible(false);
        panel.add(meter);
        
       
        
        JLabel lblusername=new JLabel("User Name");
        lblusername.setBounds(100,130,140,20);
        panel.add(lblusername);
        
        username=new JTextField();
        username.setBounds(260,130,150,20);
        panel.add(username);
        
        JLabel lblname=new JLabel(" Name");
        lblname.setBounds(100,170,140,20);
        panel.add(lblname);
        
        name=new JTextField();
        name.setBounds(260,170,150,20);
        panel.add(name);
        
         meter.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe){}
            
              @Override
            public void focusLost(FocusEvent fe){
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select *from login where meter_no='"+meter.getText()+"'");
                while(rs.next()){
                    name.setText(rs.getString("name"));
                }
            }catch(Exception e){
                e.printStackTrace();
                
            }
            
            }
        });
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(100,210,140,20);
        panel.add(lblpassword);
        
       password=new JTextField();
        password.setBounds(260,210,150,20);
        panel.add(password);
        
        accountType.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                String user=accountType.getSelectedItem();
                if(user.equals("Customer")){
                 lblmeter.setVisible(true);
                 meter.setVisible(true);
                 name.setEditable(false);
                }else{
                 lblmeter.setVisible(false);
                 meter.setVisible(false);
                 name.setEditable(true);
                }
            }
            
        });
        
        create =new JButton("Create");
        create.setBounds(160,260,120,25);
        create.addActionListener(this);
        panel.add(create);
        
         Back =new JButton("Back");
        Back.setBounds(320,260,120,25);
        Back.addActionListener(this);
        panel.add(Back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupimage.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(410,30,250,250);
        panel.add(image);
        
       
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Back){
            setVisible(false);
            new Login();
        }else if(ae.getSource()==create){
          String atype=accountType.getSelectedItem();
          String susername=username.getText();
          String sname=name.getText();
          String spassword=password.getText();
          String smeter=meter.getText();
          try{
             Conn c=new Conn();
             
             String query=null;
             if(atype.equals("Admin")){
                 
             
                   query ="insert into login values('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+atype+"')";
          }else{
                 query="update Login set username='"+susername+"',password='"+spassword+"',user='"+atype+"'where meter_no='"+smeter+"'";
             }
             c.s.executeUpdate(query);
             
             JOptionPane.showMessageDialog(null, "Account Created Successfully");
             
             setVisible(false);
             new Login();
          }catch(Exception e){
              e.printStackTrace();
          }
        }
    }
    
  public static void main(String[]args){
      new Signup();
  }  
}
