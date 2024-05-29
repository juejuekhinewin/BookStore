import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegisterBook 
{
	public RegisterBook()
	{
		RComponents();
		
	}
	
	public void RComponents()
	{
		JFrame f= new JFrame("Book Store");
		JLabel title= new JLabel("Book Registration Form");
		title.setBounds(200,10,200,30);
		
		JLabel lid= new JLabel("Customer ID");
		lid.setBounds(50,70,150,40);
		
		JLabel lun= new JLabel("Customer Name");
		lun.setBounds(50,130,150,40);
		
		JLabel lname= new JLabel("Book Name");
		lname.setBounds(50,190,150,40);
		
		JLabel lauth= new JLabel("Author");
		lauth.setBounds(50,310,150,40);
		
		JLabel lprice= new JLabel("Price");
		lprice.setBounds(50,370,150,40);
		
		JLabel lqty= new JLabel("Quantity");
		lqty.setBounds(50,430,150,40);
		
		JLabel lcost= new JLabel("Total Cost");
		lcost.setBounds(50,490,150,40);
		
		
		
		JTextField tid= new JTextField();
		tid.setBounds(200,70,200,40);
		
		JTextField tunam= new JTextField();
		tunam.setBounds(200,130,200,40);
		
		JTextField tbnam= new JTextField();
		tbnam.setBounds(200,190,200,40);
		
		JTextField tauth= new JTextField();
		tauth.setBounds(200,310,200,40);
		
		JTextField tprice= new JTextField();
		tprice.setBounds(200,370,200,40);
		
		JTextField tqty= new JTextField();
		tqty.setBounds(200,430,200,40);
		
		JTextField tcost= new JTextField();
		tcost.setBounds(200,490,200,40);
		
		JLabel lcag= new JLabel("Categories");
		lcag.setBounds(50,250,150,40);
		
		String st[]= {"Programming","Design","Foods", "Education"};
		JComboBox cy= new JComboBox(st);
		cy.setBounds(200,250,200,40);
		
		JButton reg= new JButton("Register");
		reg.setBounds(80,550,100,50);
		
		JButton can= new JButton("Cancel");
		can.setBounds(220,550,100,50);
		
		JButton close= new JButton("Close");
		close.setBounds(360,550,100,50);
		
		
		
		
		f.add(title);
		f.add(lid);
		f.add(lun);
		f.add(lname);
		f.add(lauth);
		f.add(lcag);
		f.add(lprice);
		f.add(lqty);
		f.add(lcost);
		
		
		f.add(tid);
		f.add(tunam);
		f.add(tbnam);
		f.add(cy);
		f.add(tauth);
		f.add(tprice);
		f.add(tqty);
		f.add(tcost);
		
		
		f.add(reg);
		f.add(can);
		f.add(close);
		
		reg.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				DBConn Db= new DBConn();
				String id,uname,bname,auth;
				int price,qty,total;
				id=tid.getText();
				uname=tunam.getText();
				bname=tbnam.getText();
				auth=tauth.getText();
				String cag=String.valueOf(cy.getSelectedItem());
				price=Integer.parseInt(tprice.getText());
				qty=Integer.parseInt(tqty.getText());
				total= price * qty;
				tcost.setText(String.valueOf(total));
				
				
				SaleList sl= new SaleList();
				sl.setID(id);
				sl.setUname(uname);
				sl.setBname(bname);
				sl.setCag(cag);
				sl.setAuth(auth);
				sl.setPrice(price);
				sl.setQty(qty);
				sl.setTotal(total);
				
				
				try 
				{
					Db.register(sl);
				
				} catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				
				
				
			}
			
		});
		
		
		can.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				String id,uname,bname,auth,price,qty,total;
				tid.setText("");
				tunam.setText("");
				tbnam.setText("");
				tauth.setText("");
				tprice.setText("");
				tqty.setText("");
				tcost.setText("");
				
				
				
				
			}
			
			
		});
		
		close.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				f.dispose();
				
			}
			
			
		});
		
		f.setSize(600,700);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}


