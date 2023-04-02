import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;

class delete
{
Frame f;
Label l1;
TextField t1;
JButton b1;
Connection getConnection()
{
Connection cn = null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
cn=DriverManager.getConnection("jdbc:mysql://localhost/management?user=root&password=08003");
}
catch(Exception e)
{
System.out.println("Error:"+e.getMessage());
}
return cn;
}
delete()
{
f = new Frame("Delete");
f.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e)
{
f.dispose();
}
});
l1 = new Label("Employee Id:");
t1 = new TextField();
b1 = new JButton("Delete Emp");
b1.setBackground(Color.red);
b1.setForeground(Color.white);
b1.addActionListener(e->{
if(t1.getText().isEmpty())
{
javax.swing.JOptionPane.showMessageDialog(null,"Please fill the field");
t1.setText("");
}
else
{
try
{
String query = "delete from employee where id=?";
Connection cn = getConnection();
PreparedStatement stmt = cn.prepareStatement(query);
stmt.setInt(1,Integer.parseInt(t1.getText()));
stmt.executeUpdate();
cn.close();
javax.swing.JOptionPane.showMessageDialog(null,"Data Deleted");
t1.setText("");
}
catch(Exception ex)
{
System.out.println("Error:"+ex.getMessage());
}
}
});
f.setLayout(null);
l1.setBounds(100,115,100,33);
t1.setBounds(200,115,100,40);
b1.setBounds(120,190,153,30);
f.add(l1);
f.add(t1);
f.add(b1);
f.setVisible(true);
f.setSize(400,400);
}
}