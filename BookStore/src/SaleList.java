
public class SaleList 
{
	private String uid,uname,bname,cag,auth;
	private int price,qty,total;
	public SaleList()
	{
		
	}
	
	public void setID(String id)
	{
		uid= id;
		
	}
	public void setUname(String unam)
	{
		uname= unam;
		
	}
	
	public void setBname(String bnam)
	{
		bname= bnam;
		
	}
	
	public void setCag(String cg)
	{
		cag= cg;
		
	}
	
	public void setAuth(String aut)
	{
		auth= aut;
		
	}
	
	public void setPrice(int pri)
	{
		price= pri;
		
	}
	
	public void setQty(int qt)
	{
		qty= qt;
		
	}
	
	public void setTotal(int tot)
	{
		total= tot;
	}
	
	public String getID()
	{
		return uid;
	}
	
	public String getUname()
	{
		return uname;
	}
	
	public String getBname()
	{
		return bname;
	}
	
	public String getCag()
	{
		return cag;
	}
	
	public String getAuth()
	{
		return auth;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public int getQty()
	{
		return qty;
	}
	
	public int getTotal()
	{
		return total;
	}

}
