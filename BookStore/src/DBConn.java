import java.sql.*;
import java.util.ArrayList;

public class DBConn 
{
	public static Connection con;
	private static Statement st;
	private ResultSet rs;

	public static void connection() throws SQLException
	{
		String dburl= "jdbc:ucanaccess://E://bookdbase.accdb";
		
		try 
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con= DriverManager.getConnection(dburl);
			System.out.println("Connection Success");
			st=con.createStatement();
			
		} catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
			System.out.println("Connection Fail");
		}
		
		
	}

	
	public static void register(SaleList sl) throws SQLException 
	{
		String id= sl.getID();
		String bname= sl.getBname();
		String uname= sl.getUname();
		String cag= sl.getCag();
		String auth= sl.getAuth();
		int price= sl.getPrice();
		int qty= sl.getQty();
		int total= sl.getTotal();
		connection();
		
		String info= "insert into book "+" (ID,CustomerName,BookName,Cagtegories,Author,Price,Quantity,TotalCost)"+
					"values ('"+id+"','"+bname+"','"+uname+"','"+cag+"','"+auth+"','"+price+"','"+qty+"','"+total+"')";
		st.execute(info);
		System.out.println("Insert SuccessFull");
		con.close();
		
	}




	public String[][]getData (String cagt) throws SQLException
	{
		connection();
		ArrayList<SaleList> list=new ArrayList<SaleList>();
		String str="select * from book where Cagtegories='"+cagt+"'";
		rs= st.executeQuery(str);
		
		while(rs.next())
		{
			SaleList sl= new SaleList();
			sl.setID(rs.getString(1));
			sl.setUname(rs.getString(2));
			sl.setBname(rs.getString(3));
			sl.setCag(rs.getString(4));
			sl.setAuth(rs.getString(5));
			sl.setPrice(rs.getInt(6));
			sl.setQty(rs.getInt(7));
			sl.setTotal(rs.getInt(8));
			list.add(sl);
		}
		
		String[][] data=new String[list.size()][8];
		for(int i=0;i<list.size();i++)
		 {
			 SaleList sl=list.get(i);
			 data[i][0]=sl.getID();
			 data[i][1]=sl.getUname();
			 data[i][2]=sl.getBname();
			 data[i][3]=sl.getCag();
			 data[i][4]=sl.getAuth();
			 data[i][5]=String.valueOf(sl.getPrice());
			 data[i][6]=String.valueOf(sl.getQty());
			 data[i][7]=String.valueOf(sl.getTotal());
			 
		 }
		 
		 
		 return data;
	}
	
	public void Update(SaleList sl) throws SQLException 
	{
		connection();
		String id=sl.getID();
		String cag=sl.getCag();
		String bnam=sl.getBname();
		
		String sql="update book set BookName='"+bnam+"' where ID='"+id+"' and Cagtegories='"+cag+"'";
		st.execute(sql);
		System.out.println("Updated Book Successfully");
		
		
	}




	public String[] getCag() throws SQLException 
	{
		connection();
		ArrayList<String> list=new ArrayList<String>();
		String sql="select distinct (Cagtegories) from book";
		rs=st.executeQuery(sql);
		while(rs.next())
		{
			list.add(rs.getString("Cagtegories"));
			
		}
		String[] Cagtegories =list.toArray(new String[list.size()]);
		con.close();
		return Cagtegories;
		
		
	}




	public String[] getID() throws SQLException 
	{
		connection();
		ArrayList<String> list=new ArrayList<String>();
		String sql="select ID from book";
		rs=st.executeQuery(sql);
		while(rs.next())
		{
			list.add(rs.getString("ID"));
			
		}
		String[] ID =list.toArray(new String[list.size()]);
		con.close();
		return ID;
		
		
	}




	public void Delete(SaleList sl) throws SQLException 
	{
		connection();
		String cag=sl.getCag();
		String id=String.valueOf(sl.getID());
		
		String query="delete * from book where Cagtegories='"+cag+"' and ID='"+id+"'";
		st.executeUpdate(query);
		System.out.println("Deleted Book Sale Successfully");
		
		con.close();
		
	}




	
	


}
