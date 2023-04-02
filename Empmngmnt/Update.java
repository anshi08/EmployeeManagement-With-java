import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Update
{
Frame f;
Label l1,l2,l3;
TextField t1,t2,t3;
Font f4;
JButton b1;
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
Update()
{
f4 = new Font("Palatino Linotype" , 1,14);
f = new Frame("UPDATE EMPLOYEE");
f.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e)
{
f.dispose();
}
});
l1 = new Label("ID:");
l2 = new Label("NAME:");
l3 = new Label("SALARY:");
t1 = new TextField();
t1.setFont(f4);
t2 = new TextField();
t2.setFont(f4);
t3 = new TextField();
t3.setFont(f4);
b1 = new JButton("Update Details");
b1.addActionListener(e->{
try
{
String query = "update employee set name=?,sal=? where id=?";
Connection cn = getConnection();
PreparedStatement stmt = cn.prepareStatement(query);
stmt.setString(1,t2.getText());
stmt.setInt(2,Integer.parseInt(t3.getText()));
stmt.setInt(3,Integer.parseInt(t1.getText()));
stmt.executeUpdate();
cn.close();
javax.swing.JOptionPane.showMessageDialog(null,"Data Updated");
t1.setText("");
t2.setText("");
t3.setText("");
}
catch(Exception ex)
{
System.out.println("Error:" + ex.getMessage());
}

});
f.setLayout(new GridLayout(7,1));
f.add(l1);
f.add(t1);
f.add(l2);
f.add(t2);
f.add(l3);
f.add(t3);
f.add(b1);
f.setVisible(true);
f.setSize(400,400);
}
}

