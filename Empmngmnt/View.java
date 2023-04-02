import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class View
{
Frame f;
Label l1;
TextField t1;
JButton b1;
static int id;
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
View()
{
f = new Frame("View");
f.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e)
{
f.dispose();
}
});
l1 = new Label("Employee Id:");
t1 = new TextField();
b1 = new JButton("Search");
b1.addActionListener(e->{
if(t1.getText().isEmpty())
{
javax.swing.JOptionPane.showMessageDialog(null,"Enter Id");
}
else
{
try
{
id = Integer.parseInt(t1.getText());

profile p = new profile();

}
catch(Exception ex)
{
System.out.println("Error : " +ex.getMessage());
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