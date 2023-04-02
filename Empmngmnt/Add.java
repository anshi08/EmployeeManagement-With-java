import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.sql.*;

class Add
{
Frame f;
Label l1,l2,l3,l4;
TextField t1,t2,t3,t4;
Font f3;
JButton b1;
Connection getConnection()
{
Connection cn = null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
cn= DriverManager.getConnection("jdbc:mysql://localhost/management?user=root&password=08003");
}
catch(Exception e)
{
System.out.println("Error:-" + e.getMessage());
}
return cn;
}
void add()
{
try
{
String query = "insert into employee values (?,?,?,?)";
Connection cn = getConnection();
PreparedStatement stmt = cn.prepareStatement(query);
stmt.setInt(1,Integer.parseInt(t1.getText()));
stmt.setString(2,t2.getText());
stmt.setInt(3,Integer.parseInt(t3.getText()));
stmt.setString(4,t4.getText());
stmt.executeUpdate();
cn.close();
javax.swing.JOptionPane.showMessageDialog(null,"Data Added");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
}
catch(Exception ex)
{
System.out.println("Error :" + ex.getMessage());
}
}
Add()
{
f3 = new Font("Palatino Linotype" , 1,14);
f = new Frame("ADD EMPLOYEE");
f.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e)
{
f.dispose();
}
});
l1 = new Label("ID:");
l2 = new Label("NAME:");
l3 = new Label("SALARY:");
l4 = new Label("LEAVES:");
t1 = new TextField();
t1.setFont(f3);
t2 = new TextField();
t2.setFont(f3);
t3 = new TextField();
t3.setFont(f3);
t4 = new TextField();
t4.setFont(f3);
b1 = new JButton("Save");
b1.addActionListener(e ->{
add();
});
b1.setBackground(Color.blue);
b1.setForeground(Color.green);
f.setLayout(new GridLayout(9,1));
f.add(l1);
f.add(t1);
f.add(l2);
f.add(t2);
f.add(l3);
f.add(t3);
f.add(l4);
f.add(t4);
f.add(b1);
f.setVisible(true);
f.setSize(400,400);
}
}