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


public class user {
	JLabel title=new JLabel("Foreign Trade System");
	JLabel title2=new JLabel("-User");
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
	JPanel pan3=new JPanel();
    JPanel pan4=new JPanel();
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
	
public user()
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
	pan3.setBackground(new Color(0,139,139));
	pan4.setBackground(new Color(0,139,139));
	pan5.setBackground(new Color(0,139,139));
	pan6.setBackground(new Color(0,139,139));
	ftslog();
	view();
	aut();
	autlist();
	payment();
	panelCont.setLayout(cl);
	panelFirst.setLayout(null);
	l1.setBounds(380, 180, 400, 50);
	l1.setFont(l1.getFont().deriveFont(24.0f));
	l1.setForeground(Color.white);
	panelFirst.add(l1);
	name.setFont(name.getFont().deriveFont(24.0f));
	name.setBounds(580, 180, 400, 50);
 	panelFirst.add(name);
 	l2.setFont(l2.getFont().deriveFont(24.0f));
 	l2.setBounds(380,280, 400, 50);
 	l2.setForeground(Color.white);
	panelFirst.add(l2);
	username.setFont(username.getFont().deriveFont(24.0f));
	username.setBounds(580, 280, 400, 50);
	panelFirst.add(username);
	l3.setFont(l3.getFont().deriveFont(24.0f));
	l3.setBounds(380, 380, 400, 50);
	l3.setForeground(Color.white);
	panelFirst.add(l3);
	password.setFont(password.getFont().deriveFont(24.0f));
	password.setBounds(580,380, 400, 50);
	panelFirst.add(password);
	reg.setFont(reg.getFont().deriveFont(24.0f));
    reg.setBounds(490,580, 400, 50);
	panelFirst.add(reg);
	reg.setBackground(new Color(205,92,92));
	reg.setForeground(Color.white);

    
	 JTabbedPane jtp = new JTabbedPane();
	jtp.setBounds(380, 180, 400, 50);
		jtp.setFont(jtp.getFont().deriveFont(24.0f));
	 jtp.addTab("Search",pan3);
     jtp.addTab("View",pan4);
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
	enter.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	try{
			
			
		String s3=pname.getText().trim();
		String q2="SELECT * FROM view WHERE pname= '"+s3+"'";
		System.out.println(q2);
		 r=s.executeQuery(q2);
		 while(r.next())
		 {
				pid.setText(r.getString(1));
				pname.setText(r.getString(2));
                pdetail.setText(r.getString(3));
				pdate.setText(r.getString(4));
				psource.setText(r.getString(5));
				pdest.setText(r.getString(6));
				ptax.setText(r.getString(7));
			String s4=ptax.getText();
			String s5="not paid";

			
			if(s4.equals(s5))
			{
				
				pay.setFont(pay.getFont().deriveFont(24.0f));
				pay.setBounds(740,680, 200, 50);
				enter.setBounds(540,680, 200, 50);
				pan3.add(pay);
			}
			else
			{
				
			pan3.remove(pay);
			
			}
		 }	
			}
			catch(Exception e)
			{}
			}
		
	});
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
	
	clear.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	try{
			
			
				
		ar.setText("");
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
				ar.append("  "+"Pid"+"\t"+"Pname"+"\t"+"Pdetail"+"\t"+"         "+"Pdate"+"\t\t"+"Psource"+"\t"+"Pdest"+"\t"+"Ptax"+"\n");
				while(r.next())
				{
					
				ar.append(""+"  "+r.getString("pid")+"\t"+r.getString("pname")+"\t"
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
				ar1.append("  "+"Pid"+"\t"+"Pname"+"\t"+"Pdetail"+"\t"+"         "+"Pdate"+"\t\t"+"Psource"+"\t"+"Pdest"+"\t"+"Ptax"+"\n");
				while(r.next())
				{
					
				ar1.append(""+"  "+r.getString("pid")+"\t"+r.getString("pname")+"\t"
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
	    l5.setForeground(Color.white);
	    l6.setForeground(Color.white);
		panelSecond.add(l5);
		name2.setFont(name2.getFont().deriveFont(24.0f));
		name2.setBounds(580, 180, 400, 50);
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
		panelSecond.add(signup);
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

		
		 void view() {
			
		
				pan3.setLayout(null);
				tid.setBounds(380, 180, 400, 50);
				tid.setFont(tid.getFont().deriveFont(24.0f));
				pan3.add(tid);
				tid.setForeground(Color.white);
				tname.setForeground(Color.white);
				tdetail.setForeground(Color.white);
				tdate.setForeground(Color.white);
				tsource.setForeground(Color.white);
				tdest.setForeground(Color.white);
				tax.setForeground(Color.white);
				pid.setFont(pid.getFont().deriveFont(24.0f));
				pid.setBounds(680, 180, 400, 50);
				pan3.add(pid);
				tname.setFont(tname.getFont().deriveFont(24.0f));
				tname.setBounds(380, 230, 400, 50);
				pan3.add(tname);
				pname.setFont(pname.getFont().deriveFont(24.0f));
				pname.setBounds(680,230, 400, 50);
				pan3.add(pname);
				tdetail.setFont(tdetail.getFont().deriveFont(24.0f));
				tdetail.setBounds(380, 280, 400, 50);
				pan3.add(tdetail);
				pdetail.setFont(pdetail.getFont().deriveFont(24.0f));
				pdetail.setBounds(680,280, 400, 50);
				pan3.add(pdetail);
				tdate.setFont(tdate.getFont().deriveFont(24.0f));
				tdate.setBounds(380, 330, 400, 50);
				pan3.add(tdate);
				pdate.setFont(pdate.getFont().deriveFont(24.0f));
				pdate.setBounds(680,330, 400, 50);
				pan3.add(pdate);
				tsource.setFont(tsource.getFont().deriveFont(24.0f));
				tsource.setBounds(380, 380, 400, 50);
				pan3.add(tsource);
				psource.setFont(psource.getFont().deriveFont(24.0f));
				psource.setBounds(680,380, 400, 50);
				pan3.add(psource);
				tdest.setFont(tdest.getFont().deriveFont(24.0f));
				tdest.setBounds(380, 430, 400, 50);
				pan3.add(tdest);
				pdest.setFont(pdest.getFont().deriveFont(24.0f));
				pdest.setBounds(680,430, 400, 50);
				pan3.add(pdest);
				tax.setFont(tax.getFont().deriveFont(24.0f));
				tax.setBounds(380, 480, 400, 50);
				pan3.add(tax);
				ptax.setFont(ptax.getFont().deriveFont(24.0f));
				ptax.setBounds(680,480, 400, 50);
				pan3.add(ptax);
				enter.setFont(enter.getFont().deriveFont(24.0f));
				enter.setBounds(540,680, 200, 50);
				pan3.add(enter);
				enter.setBackground(new Color(205,92,92));
				enter.setForeground(Color.white);
				back.setBounds(10,20,32,32);
				back.setBackground(new Color(0,139,139));
				pan3.add(back);
				
			
				
			
	// TODO Auto-generated method stub
	
}
		
	 void aut() {
			
		
			    pan4.setLayout(null);
			    ar.setFont(ar.getFont().deriveFont(24.0f));
			    ar.setBounds(105,10,1210,500);
			    pan4.add(ar);
			    enter1.setFont(enter1.getFont().deriveFont(24.0f));
				enter1.setBounds(480,580,200,50);
				pan4.add(enter1);
				enter1.setBackground(new Color(205,92,92));
				enter1.setForeground(Color.white);
				clear.setFont(clear.getFont().deriveFont(24.0f));
				clear.setBounds(780,580,200,50);
				pan4.add(clear);
				clear.setBackground(new Color(205,92,92));
				clear.setForeground(Color.white);
			
				
			
	// TODO Auto-generated method stub
	
}
		
	 void autlist() {
			
			
			pan5.setLayout(null);
			
		        ar1.setFont(ar1.getFont().deriveFont(24.0f));
			    ar1.setBounds(105,10,1210,500);
			    pan5.add(ar1);
			    enter2.setFont(enter2.getFont().deriveFont(24.0f));
				enter2.setBounds(480,580,200,50);
				enter2.setBackground(new Color(205,92,92));
				enter2.setForeground(Color.white);
			    pan5.add(enter2);
			    clear1.setFont(clear1.getFont().deriveFont(24.0f));
				clear1.setBounds(780,580,200,50);
				pan5.add(clear1);
				clear1.setBackground(new Color(205,92,92));
				clear1.setForeground(Color.white);
			
			
				
			
	// TODO Auto-generated method stub
	
}
	 void payment()
	 {
			
		
				pan6.setLayout(null);
				lcnum.setBounds(380, 180, 400, 50);
				lcnum.setFont(lcnum.getFont().deriveFont(24.0f));
				pan6.add(lcnum);
				lcnum.setForeground(Color.white);
				lcname.setForeground(Color.white);
				lcv.setForeground(Color.white);
				lamt.setForeground(Color.white);
				pcnum.setFont(pcnum.getFont().deriveFont(24.0f));
				pcnum.setBounds(680, 180, 400, 50);
				pan6.add(pcnum);
				lcname.setFont(lcname.getFont().deriveFont(24.0f));
				lcname.setBounds(380, 230, 400, 50);
				pan6.add(lcname);
				pcname.setFont(pcname.getFont().deriveFont(24.0f));
				pcname.setBounds(680,230, 400, 50);
				pan6.add(pcname);
				lcv.setFont(lcv.getFont().deriveFont(24.0f));
				lcv.setBounds(380, 280, 400, 50);
				pan6.add(lcv);
				pcv.setFont(pcv.getFont().deriveFont(24.0f));
				pcv.setBounds(680,280, 400, 50);
				pan6.add(pcv);
				lamt.setFont(lamt.getFont().deriveFont(24.0f));
				lamt.setBounds(380, 330, 400, 50);
				pan6.add(lamt);
				pamt.setFont(pamt.getFont().deriveFont(24.0f));
				pamt.setBounds(680,330, 400, 50);
				Random r=new Random();
				pamt.setText(String.valueOf(r.nextInt(1000)));
				pan6.add(pamt);
				cpay.setFont(cpay.getFont().deriveFont(24.0f));
				cpay.setBounds(540,680, 400, 50);
				pan6.add(cpay);	
				cpay.setBackground(new Color(205,92,92));
				cpay.setForeground(Color.white);
	 }
	 public static void main(String[] args) {
			user u=new user();
			
			
			}

}
