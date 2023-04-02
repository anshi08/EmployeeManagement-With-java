import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Employee
{
JFrame f;
JLabel l;
JMenuBar mb;
JMenu m1,m2,m3,m4,m6;
JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi8;
Font f2;
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
Employee()
{
f = new JFrame("Employee Home Page");
f.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e)
{
f.dispose();
}
});
l = new JLabel();
l.setIcon(new ImageIcon("off.jpg"));
f2 = new Font("Arial", 1 , 18);
mb = new JMenuBar();
m1 = new JMenu("Profile");
m2 = new JMenu("Manage");
m3 = new JMenu("Details");
m4 = new JMenu("Leave");
m6 = new JMenu("Delete");

mi1 = new JMenuItem("ADD NEW PROFILE");
mi1.addActionListener(e ->{
Add a = new Add();
});
mi2 = new JMenuItem("VIEW PROFILE");
mi2.addActionListener(e ->{
View v = new View();
});
mi3 = new JMenuItem("UPDATE DETAILS");
mi3.addActionListener(e ->{
Update u = new Update();
});
mi4 = new JMenuItem("SHOW EMP");
mi4.addActionListener(e ->{
Display d = new Display();
});
mi5 = new JMenuItem("APPLY LEAVE");
mi5.addActionListener(e ->{
Leave l = new Leave();
});
mi6 = new JMenuItem("SHOW LEAVE");
mi6.addActionListener(e ->{
Showleave sl = new Showleave();
});
mi8 = new JMenuItem("DELETE EMP");
mi8.addActionListener(e ->{
delete dl = new delete();
});
m1.add(mi1);
m1.add(mi2);
m2.add(mi3);
m3.add(mi4);
m4.add(mi5);
m4.add(mi6);
m6.add(mi8);
mb.add(m1);
mb.add(m2);
mb.add(m3);
mb.add(m4);
mb.add(m6);
//mb.add(m7);
f.add(l);
f.setJMenuBar(mb);
f.setVisible(true);
f.setSize(1000,1000);
}

}