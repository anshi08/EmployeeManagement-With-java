import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Leave
{
Frame f;
Label l1,l2,l3;
TextField t5,t6;
JComboBox list;
JScrollPane pane;
Font f5;
JButton b1,b2;
//-----------CONNECTION------------
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
System.out.println("Error:" + e.getMessage());
}
return cn;
}
Leave()
{
f5 = new Font("Palatino Linotype" , 1,14);
f = new Frame("Leave");
f.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e)
{
f.dispose();
}
});
l1 = new Label("ID:");
l2 = new Label("NAME:");
l3 = new Label("LEAVE REASON:");
t5 = new TextField();
t5.setFont(f5);
t6 = new TextField();
t6.setFont(f5);
list = new JComboBox();
DefaultComboBoxModel model = new DefaultComboBoxModel();
//model.addElement(" Choose");
model.addElement(" I am not well today");
model.addElement(" Going out of town");
model.addElement(" Bad Health");
model.addElement("Stuck in traffic! What to do");
model.addElement("Bad Weather");
list.setModel(model);
pane = new JScrollPane(list);
b1 = new JButton("Check Id");
b2 = new JButton("SUBMIT");
b1.addActionListener(e->{
try
{
String id = t5.getText();
Connection cn = getConnection();
String q = "select * from employee where id='"+id+"'";
PreparedStatement stmt = cn.prepareStatement(q);
ResultSet rs = stmt.executeQuery(q);
while(rs.next())
{
t6.setText(rs.getString("name"));
}
}
catch(Exception ec)
{
System.out.println("Error:" + ec.getMessage());
}
});
b2.addActionListener(ev->{
String id = t5.getText();
String name = t6.getText();
String value =list.getSelectedItem().toString();
try
{
String query = "insert into leaves values('"+id+"','"+name+"','"+value+"') ";
Connection cni = getConnection();
PreparedStatement stm = cni.prepareStatement(query);
int aa = stm.executeUpdate();
if(aa == 1)
{
javax.swing.JOptionPane.showMessageDialog(null,"Submitted");
t5.setText("");
t6.setText("");
}
cni.close();
}
catch(Exception ex)
{
System.out.println("Error:" + ex.getMessage());
}
});
f.setLayout(new GridLayout(8,1));
f.add(l1);
f.add(t5);
f.add(l2);
f.add(t6);
f.add(l3);
f.add(pane);
f.add(b1);
f.add(b2);
f.setVisible(true);
f.setSize(400,400);
}
}