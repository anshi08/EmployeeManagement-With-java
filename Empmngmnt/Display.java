import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class Display
{
JFrame f;
JTable table;
JScrollPane pane;
JTextField tf;
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
void fill()
{
try
{
String query = "select * from employee";
Connection cn =getConnection();
PreparedStatement stmt = cn.prepareStatement(query);
ResultSet result = stmt.executeQuery();
DefaultTableModel dt = new DefaultTableModel();
dt.addColumn("id");
dt.addColumn("Name");
dt.addColumn("Salary");
while(result.next())
{
String row[]={result.getString(1),result.getString(2),result.getString(3)};
dt.addRow(row);
}
table.setModel(dt);
cn.close();
}
catch(Exception ex)
{
System.out.println("Error:"+ ex.getMessage());
}
}
Display()
{
f = new JFrame();
f.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e)
{
f.dispose();
}
});
table = new JTable();
pane = new JScrollPane(table);
f.add(table);
//Method....
fill();
f.setVisible(true);
f.setSize(400,400);
}
}