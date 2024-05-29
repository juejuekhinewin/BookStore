import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DeleteBook 
{
	public DeleteBook() throws SQLException
	{
		DComponents();
		
	}
	
	DBConn Db= new DBConn();
	String cagdata[]= Db.getCag();
	String idData[]= Db.getID();
	
	public void DComponents() throws SQLException
	{
		JFrame f= new JFrame("Book Store");
		JLabel title= new JLabel("Delete Book Sale");
		title.setBounds(200,10,200,30);
		JLabel lcag= new JLabel("Choose Cagtegories");
		JLabel lid= new JLabel("Choose ID");
		
		lcag.setBounds(50,100,150,40);
		lid.setBounds(50,170,150,40);
		
		
		
		JComboBox cy= new JComboBox(cagdata);
		cy.setBounds(200,100,200,40);
		
		
		JComboBox cr= new JComboBox(idData);
		cr.setBounds(200,170,200,40);
		
		
		JButton del= new JButton("Delete");
		del.setBounds(50,250,100,50);
		
		JButton close= new JButton("Close");
		close.setBounds(250,250,100,50);
		
		f.add(title);
		f.add(lcag);
		f.add(cy);
		f.add(lid);
		f.add(cr);
		f.add(del);
		f.add(close);
		
		del.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				String cag=String.valueOf(cy.getSelectedItem());
				String id=String.valueOf(cr.getSelectedItem());
				
				SaleList sl = new SaleList();
				sl.setCag(cag);
				sl.setID(id);
				
				try 
				{
					Db.Delete(sl);
				
				} catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				
			}
			
		});
		
		close.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				f.dispose();
				
			}
			
			
		});
		
		
		
		f.setSize(500,400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
