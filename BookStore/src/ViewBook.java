import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class ViewBook 
{
	public ViewBook()
	{
		VComponents();
		
		
	}
	
	
	public void VComponents()
	{
		JFrame f= new JFrame("Book Store");
		JRadioButton pg= new JRadioButton("Programming");
		pg.setBounds(40,15,140,30);
		
		JRadioButton de= new JRadioButton("Design");
		de.setBounds(400,15,90,30);
		
		JRadioButton fd= new JRadioButton("Foods");
		fd.setBounds(40,50,120,30);
		
		JRadioButton ed= new JRadioButton("Education");
		ed.setBounds(400,50,90,30);
		
		JTextArea txt = new JTextArea();
		txt.setBounds(30,100,700,300);
		
		JButton view= new JButton("View");
		view.setBounds(100,450,100,50);
		
		JButton clear= new JButton("Clear");
		clear.setBounds(330,450,100,50);
		
		JButton close= new JButton("Close");
		close.setBounds(550,450,100,50);
		
		
		
		f.add(pg);
		f.add(de);
		f.add(fd);
		f.add(ed);
		f.add(txt);
		f.add(view);
		f.add(clear);
		f.add(close);
		
		
		
		
		view.addActionListener(new ActionListener() 
		{

			

			public void actionPerformed(ActionEvent e) 
			{
				DBConn Db= new DBConn();

				String cagtegories="";
				if(pg.isSelected())
				 cagtegories="Programming";
				if(de.isSelected())
				 cagtegories="Design";
				if(fd.isSelected())
				 cagtegories="Foods";
				if(ed.isSelected())
				 cagtegories="Education";
				
				
				SaleList sl= new SaleList();
				if(cagtegories.equals("Programming"))
				{
					try 
					{
						String data[][]= Db.getData(cagtegories);
						for(int i=0;i<data.length;i++)
						{
							

							for(int j=0;j<data[i].length;j++)
							{
								
								txt.append(data[i][j]+"\t");
							
							}
							txt.append("\n");
						}
					
					} catch (SQLException e1) 
					{
						
						e1.printStackTrace();
					}
				}
				
					if(cagtegories.equals("Design"))
					{
						try 
						{
							String data[][]= Db.getData(cagtegories);
							for(int i=0;i<data.length;i++)
							{
								
	
								for(int j=0;j<data[i].length;j++)
								{
									
									txt.append(data[i][j]+"\t");
								
								}
								txt.append("\n");
							}
						
						} catch (SQLException e1) 
						{
							
							e1.printStackTrace();
						}
					}
					
					if(cagtegories.equals("Foods"))
					{
						try 
						{
							String data[][]= Db.getData(cagtegories);
							for(int i=0;i<data.length;i++)
							{
								
	
								for(int j=0;j<data[i].length;j++)
								{
									
									txt.append(data[i][j]+"\t");
								
								}
								txt.append("\n");
							}
						
						} catch (SQLException e1) 
						{
							
							e1.printStackTrace();
						}
					}
				
				if (cagtegories.equals("Education"))
				{
					try 
					{
						String data[][]= Db.getData(cagtegories);
						for(int i=0;i<data.length;i++)
						{
							

							for(int j=0;j<data[i].length;j++)
							{
								
								txt.append(data[i][j]+"\t");
							
							}
							txt.append("\n");
						}
					
					} catch (SQLException e1) 
					{
						
						e1.printStackTrace();
					}
				}
				
				
			}
				
			
		});
		
		clear.addActionListener(new ActionListener() 
		{

			
			public void actionPerformed(ActionEvent e) 
			{
				
				txt.setText("");
				
			}
			
		});
		
		
		
		
		close.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				f.dispose();
				
			}
			
			
		});
		
		
		
		
		f.setSize(850,550);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
