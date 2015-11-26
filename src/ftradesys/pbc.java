package ftradesys;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class pbc {
	JLabel title=new JLabel("Foreign Trade System");
	JLabel title2=new JLabel("-Public");
	JButton back=new JButton(new ImageIcon("C:/Users/home/Desktop/ar.png"));
	JFrame frame = new JFrame("fts");
	JLabel l1=new JLabel("Name");
	JLabel l2=new JLabel("UserName");
	JLabel l3=new JLabel("Password");
	JLabel l5=new JLabel("Username");
	JLabel l6=new JLabel("Password");
	JTextField name2=new JTextField();
	JPasswordField password2=new JPasswordField();
	JButton reg = new JButton("Register");
	JButton signup = new JButton("Sign Up");
	JButton login = new JButton("Log In");
	JButton view = new JButton("View");
	JTextField name=new JTextField();
	JTextField username=new JTextField();
	JPasswordField password=new JPasswordField();
	JPanel panelCont = new JPanel();
	JPanel panelFirst = new JPanel();
	JPanel panelSecond = new JPanel();
    JPanel pan5=new JPanel();
    JPanel pan6=new JPanel();
    JLabel lamt=new JLabel("Amount");
    
   JLabel tid=new JLabel("Product No");
   JLabel tname=new JLabel("Product Name");
   JLabel tdetail=new JLabel("Import/Export");
   JLabel tdate=new JLabel("Date of Import/Export");
   JLabel tsource=new JLabel("Source");
   JLabel tdest=new JLabel("Destination"); 
   JLabel tax=new JLabel("TaxDetail");
   JTextField pamt=new JTextField();
   JTextField pid=new JTextField();
   JTextField pname=new JTextField();
   JTextField pdetail=new JTextField();
   JTextField pdate=new JTextField();
   JTextField psource=new JTextField();
   JTextField pdest=new JTextField();
   JTextField ptax=new JTextField();
   JButton enter=new JButton("Search");
   JButton cpay=new JButton("Confirm Payment");
   JButton enter2=new JButton("View");
   JLabel tid1=new JLabel("Product No");
   JLabel tname1=new JLabel("Product Name");
   JLabel tdetail1=new JLabel("Import/Export");
   JLabel tdate1=new JLabel("Date of Import/Export");
   JLabel tsource1=new JLabel("Source");
   JLabel tdest1=new JLabel("Destination"); 
   JLabel tax1=new JLabel("TaxDetail");
   JLabel lcnum=new JLabel("Card Number");   
   JLabel lcname=new JLabel("Card Holder's Name");   
   JLabel lcv=new JLabel("CVV");
   JTextField pcnum=new JTextField(); 
   JTextField pcname=new JTextField(); 
   JTextField pcv=new JTextField();
   JTextField pid1=new JTextField();
   JTextField pname1=new JTextField();
   JTextField pdetail1=new JTextField();
   JTextField pdate1=new JTextField();
   JTextField psource1=new JTextField();
   JTextField pdest1=new JTextField();
   JTextField ptax1=new JTextField();
   JButton enter1=new JButton("View");
   JButton next=new JButton("Next");
   JButton pay=new JButton("Pay");
   JTextArea ar=new JTextArea();
   JTextArea ar1=new JTextArea();
	CardLayout cl = new CardLayout();
	JButton clear=new JButton("Clear");
	JButton clear1=new JButton("Clear");
	static Connection c;
	static ResultSet r;
	static Statement s;
	
public pbc()
{
	try
	{
		
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	c= DriverManager.getConnection("jdbc:odbc:ADB");
	s=c.createStatement();
	
	}
	catch(Exception e)
	{}
	panelCont.setBackground(new Color(0,139,139));
	panelFirst.setBackground(new Color(0,139,139));
	panelSecond.setBackground(new Color(0,139,139));
	ftslog();
    autlist();
	panelCont.setLayout(cl);
	panelFirst.setLayout(null);
	l1.setBounds(380, 180, 400, 50);
	l1.setFont(l1.getFont().deriveFont(24.0f));
	panelFirst.add(l1);
	name.setFont(name.getFont().deriveFont(24.0f));
	name.setBounds(580, 180, 400, 50);
 	panelFirst.add(name);
 	l2.setFont(l2.getFont().deriveFont(24.0f));
 	l2.setBounds(380,280, 400, 50);
	panelFirst.add(l2);
	l1.setForeground(Color.white);
	l2.setForeground(Color.white);
	l3.setForeground(Color.white);
	username.setFont(username.getFont().deriveFont(24.0f));
	username.setBounds(580, 280, 400, 50);
	panelFirst.add(username);
	l3.setFont(l3.getFont().deriveFont(24.0f));
	l3.setBounds(380, 380, 400, 50);
	panelFirst.add(l3);
	password.setFont(password.getFont().deriveFont(24.0f));
	password.setBounds(580,380, 400, 50);
	panelFirst.add(password);
	reg.setFont(reg.getFont().deriveFont(24.0f));
    reg.setBounds(490,580, 400, 50);
	panelFirst.add(reg);
	panelSecond.add(signup);
	reg.setBackground(new Color(205,92,92));
	reg.setForeground(Color.white);
    
	 JTabbedPane jtp = new JTabbedPane();
	jtp.setBounds(380, 180, 400, 50);
		jtp.setFont(jtp.getFont().deriveFont(24.0f));
     jtp.addTab("Auction List",pan5);
     
	panelCont.add(panelFirst, "1");
	panelCont.add(panelSecond, "2");
	panelCont.add(jtp,"3");
	panelCont.add(pan6,"4");
	cl.show(panelCont, "2");
	
	   
	signup.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cl.show(panelCont, "1");
		}
	});
	
	reg.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	try{
			
			if(arg0.getSource()==reg){
				
			String s1="INSERT INTO USER(name,username,password) VALUES('"+name.getText()+"','"+username.getText() + "','"+password.getText()+"')";
				System.out.println(s1);
				s.executeUpdate(s1);
				r=s.executeQuery("SELECT * FROM USER");
				cl.show(panelCont, "2");
				name.setText("");
      			username.setText("");
      			password.setText("");
			}
	}
			catch(Exception e)
			{}
			}
		
	});
	login.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	try{

			if(arg0.getSource()==login){
				
			String s1=name2.getText().trim();
			String s2=password2.getText().trim();
		     String q="SELECT * FROM USER WHERE username= '"+s1+"' and password='"+s2+"'";
    r=s.executeQuery(q);
    int count=0;
    while(r.next())
    {
    	count=count+1;
    }
    if(count==1)
    {
    	
    	JOptionPane.showMessageDialog(null,"Access Granted");
    	cl.show(panelCont, "3");
    }
    else
    {
    	JOptionPane.showMessageDialog(null,"Access Denied");
    }
		     name2.setText(r.getString(2));
			}
	}
			catch(Exception e)
			{}
			}
		
	});
	back.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	    	cl.show(panelCont, "2");
	    	name2.setText("");
	    	password2.setText("");
		}});
	
	pay.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	try{
				cl.show(panelCont, "4");
		
			}
	
			catch(Exception e)
			{}
			}
		
	});
	cpay.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	try{
			
			if(arg0.getSource()==cpay){
				String s5=pname.getText().trim();
				
			String s1="INSERT INTO card(pcnum,pcname,pcv) VALUES('"+pcnum.getText()+"','"+pcname.getText() + "','"+pcv.getText()+"')";
			String s2="UPDATE view SET ptax = 'paid' WHERE pname='"+s5+"' and ptax='not paid'";
			System.out.println(s1);

			System.out.println(s5);
				s.executeUpdate(s1);
				s.executeUpdate(s2);
				r=s.executeQuery("SELECT * FROM USER");
				
		    	JOptionPane.showMessageDialog(null,"Transaction Complete");
		    	cl.show(panelCont, "3");
			}
	}
			catch(Exception e)
			{}
			}
		
	});
	
	
	clear1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	try{
			
			
				
		ar1.setText("");
	}
			catch(Exception e)
			{}
			}
		
	});
	enter1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	try{
			
			
				
		String s1="SELECT * FROM view";
				System.out.println(s1);
				r=s.executeQuery(s1);
				ar.append("Pid"+"\t"+"Pname"+"\t"+"Pdetail"+"\t"+"         "+"Pdate"+"\t\t"+"Psource"+"\t"+"Pdest"+"\t"+"Ptax"+"\n");
				while(r.next())
				{
					
				ar.append(""+r.getString("pid")+"\t"+r.getString("pname")+"\t"
						+r.getString("pdetail")+"\t"+r.getString("pdate")+"\t"+r.getString("psource")+"\t"+r.getString("pdest")+"\t"+r.getString("ptax")+"\n");

			}
	}
			catch(Exception e)
			{}
			}
		
	});
	enter2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	try{
			
			
				
		String s1="SELECT * FROM view WHERE ptax='not paid'";
				System.out.println(s1);
				r=s.executeQuery(s1);
				ar1.append("Pid"+"\t"+"Pname"+"\t"+"Pdetail"+"\t"+"         "+"Pdate"+"\t\t"+"Psource"+"\t"+"Pdest"+"\t"+"Ptax"+"\n");
				while(r.next())
				{
					
				ar1.append(""+r.getString("pid")+"\t"+r.getString("pname")+"\t"
						+r.getString("pdetail")+"\t"+r.getString("pdate")+"\t"+r.getString("psource")+"\t"+r.getString("pdest")+"\t"+r.getString("ptax")+"\n");

			}
	}
			catch(Exception e)
			{}
			}
		
	});
	
	frame.add(panelCont);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setSize(1440,900);
	frame.setVisible(true);
	
}

void ftslog() {
	
		panelSecond.setLayout(null);
		l5.setBounds(380, 180, 400, 50);
		l5.setFont(l5.getFont().deriveFont(24.0f));
		panelSecond.add(l5);
		name2.setFont(name2.getFont().deriveFont(24.0f));
		name2.setBounds(580, 180, 400, 50);
		l5.setForeground(Color.white);
		l6.setForeground(Color.white);
     	panelSecond.add(name2);
		l6.setFont(l6.getFont().deriveFont(24.0f));
		l6.setBounds(380, 280, 400, 50);
		panelSecond.add(l6);
		password2.setFont(password2.getFont().deriveFont(24.0f));
		password2.setBounds(580,280, 400, 50);
		panelSecond.add(password2);
		login.setFont(login.getFont().deriveFont(24.0f));
		login.setBounds(450,480, 200, 50);
		panelSecond.add(login);
		login.setBackground(new Color(205,92,92));
		login.setForeground(Color.white);
		signup.setFont(signup.getFont().deriveFont(24.0f));
		signup.setBounds(720,480, 200, 50);
		signup.setBackground(new Color(205,92,92));
		signup.setForeground(Color.white);
		Font font = new Font("Harlow Solid Italic", Font.BOLD, 76);
		title.setBounds(200, 5, 1200,200);
		title.setFont(font);
		title.setForeground(Color.WHITE);
		panelSecond.add(title);
		title2.setBounds(1000,0, 1200,200);
		title2.setFont(font);
		title2.setForeground(new Color(205,92,92));
		panelSecond.add(title2);

		
	}

		
	
		
	 void autlist() {
			
			    pan5.setBackground(new Color(0,139,139));
			    pan5.setLayout(null);
			    ar1.setFont(ar1.getFont().deriveFont(24.0f));
			    ar1.setBounds(105,10,1210,500);
			    pan5.add(ar1);
			    enter2.setFont(enter2.getFont().deriveFont(24.0f));
				enter2.setBounds(480,580,200,50);
				pan5.add(enter2);
				clear1.setFont(clear1.getFont().deriveFont(24.0f));
				clear1.setBounds(780,580,200,50);
				pan5.add(clear1);
				back.setBounds(10,20,32,32);
				back.setBackground(new Color(0,139,139));
				pan5.add(back);
				enter2.setBackground(new Color(205,92,92));
				enter2.setForeground(Color.white);
				clear1.setBackground(new Color(205,92,92));
				clear1.setForeground(Color.white);
				
			
	// TODO Auto-generated method stub
	
}

	 public static void main(String[] args) {
			pbc u=new pbc();
	 }}