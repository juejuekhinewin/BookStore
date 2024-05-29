import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UpdateBook 
{
	public UpdateBook() throws SQLException
	{
		UComponents();
		
	}
	
	DBConn Db= new DBConn();
	String cagdata[]= Db.getCag();
	String idData[]= Db.getID();
	
	public void UComponents() throws SQLException
	{
		JFrame f= new JFrame("Book Store");
		JLabel title= new JLabel("Update Book");
		JLabel lcag= new JLabel("Choose Cagetories");
		JLabel lid= new JLabel("Choose ID");
		JLabel lbnam= new JLabel("Book Name");
		
		title.setBounds(200,10,200,30);
		lcag.setBounds(50,100,150,40);
		lid.setBounds(50,170,150,40);
		lbnam.setBounds(50,240,150,40);
		
		
		JComboBox cy= new JComboBox(cagdata);
		cy.setBounds(200,100,200,40);
		
		
		JComboBox cr= new JComboBox(idData);
		cr.setBounds(200,170,200,40);
		
		
		JTextField tbnam= new JTextField();
		tbnam.setBounds(200,240,200,40);
		
		JButton upd= new JButton("Update");
		upd.setBounds(80,350,100,50);
		
		JButton can= new JButton("Cancel");
		can.setBounds(220,350,100,50);
		
		JButton close= new JButton("Close");
		close.setBounds(360,350,100,50);
		
		
		f.add(title);
		f.add(lid);
		f.add(lcag);
		f.add(lbnam);
		f.add(cy);
		f.add(cr);
		f.add(tbnam);
		
		f.add(upd);
		f.add(can);
		f.add(close);
		
		upd.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				
				String bname=tbnam.getText();
				String cag= String.valueOf(cy.getSelectedItem());
				String id=String.valueOf(cr.getSelectedItem());
						 
						 
				SaleList sl=new SaleList();
				sl.setID(id);
				sl.setCag(cag);
				sl.setBname(bname);
						 
				try 
				{
					Db.Update(sl);
						
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
				
				tbnam.setText("");
				cy.setSelectedItem("");
				
			}
			
			
		});
		
		close.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				f.dispose();
				
			}
			
			
		});
		
		
		f.setSize(600,500);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
