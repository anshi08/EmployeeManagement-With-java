import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class login
{
Frame f;
Label l1,l2;
TextField tf1;
JPasswordField pw;
Font f1;
JButton b1,b2;
//-------CONNECTION METHOD---------
Connection getConnection()
{
Connection cn = null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
cn = DriverManager.getConnection("jdbc:mysql://localhost/management?user=root&password=08003");
}
catch(Exception e)
{
System.out.println("Error:-"+ e.getMessage());
}
return cn;
}
login()
{
f = new Frame("Login form");
f.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e)
{
f.dispose();
}
});

f1 = new Font("Arial", 1 , 18);
l1 = new Label("ID:");
l2 = new Label("Password:");
tf1 = new TextField();
tf1.setFont(f1);
pw =  new JPasswordField();
pw.setFont(f1);
b1 = new JButton("Login");
b2 = new JButton("Cancel");

b1.addActionListener(e ->{
if(tf1.getText().isEmpty() || pw.getText().isEmpty())
{
javax.swing.JOptionPane.showMessageDialog(null,"Please fill all the field");
tf1.setText("");
pw.setText("");
}
else
{
try
{
String id = tf1.getText();
Connection cn = getConnection();
String q = "select * from employee where id='"+id+"'";
PreparedStatement stmt = cn.prepareStatement(q);
ResultSet rs = stmt.executeQuery(q);
if(rs.next())
{
Employee em = new Employee();
tf1.setText("");
pw.setText("");
}
else
{
javax.swing.JOptionPane.showMessageDialog(null,"Login failed");
tf1.setText("");
pw.setText("");
}
}
catch(Exception ex)
{
System.out.println("Error : " +ex.getMessage());
}
}
});
b2.addActionListener(e -> {
tf1.setText("");
pw.setText("");
});
f.setLayout(new GridLayout(6,2));
f.add(l1);
f.add(tf1);
f.add(l2);
f.add(pw);
f.add(b1);
f.add(b2);
f.setVisible(true);
f.setSize(400,400);
}
public static void main(String ar[])
{
login l = new login();
} 
}