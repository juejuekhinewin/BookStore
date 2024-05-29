import javax.swing.*;

import java.awt.event.*;
import java.sql.*;
import java.awt.Color;

public class BookRegisterForm 
{
	public BookRegisterForm()
	{
		Components();
	}
	
	
	private void Components() 
	{
		JFrame f= new JFrame("Online Book Store");
		f.getContentPane().setBackground(Color.pink);
		JPanel top= new JPanel();
		top.setBounds(0,0,700,60);
		top.setBackground(Color.white);
		
		JLabel l1= new JLabel("Welcome to Jue Book Shop");
		l1.setBounds(50,20,500,50);
		l1.setForeground(Color.black);
		
		JPanel bottom= new JPanel();
		bottom.setBounds(0,300,700,60);
		bottom.setBackground(Color.lightGray);
		
		JLabel l2= new JLabel("Developed By Jue");
		l2.setBounds(50,500,500,50);
		l2.setForeground(Color.black);
		
		JButton br= new JButton("Register");
		br.setBackground(Color.magenta);
		br.setBounds(200,100,100,50);
		
		
		JButton bv= new JButton("View");
		bv.setBackground(Color.green);
		bv.setBounds(400,100,100,50);

		
		JButton bu= new JButton("Update");
		bu.setBackground(Color.yellow);
		bu.setBounds(200,200,100,50);

		
		JButton bd= new JButton("Delete");
		bd.setBackground(Color.cyan);
		bd.setBounds(400,200,100,50);

		
		top.add(l1);
		bottom.add(l2);
		f.add(top);
		f.add(bottom);
		f.add(br);
		f.add(bv);
		f.add(bu);
		f.add(bd);
		
		br.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				RegisterBook r= new RegisterBook();
				
				
			}
			
		});
		
		bu.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					UpdateBook u= new UpdateBook();
				
				} catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
				
				
			}
			
		});
	
		bd.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					DeleteBook d= new DeleteBook();
				
				} catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				
				
			}			

		});
		
		bv.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				ViewBook v= new ViewBook();
								
			}
			
		});
		
		
		 		f.setSize(700,397);
				f.setLayout(null);
				f.setVisible(true);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	

	}
				


}
			
		
		
		


