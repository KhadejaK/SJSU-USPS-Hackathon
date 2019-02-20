package usps;
import usps.WaitTime;

public class Location 
{
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private WaitTime localWait;
	
	
	public Location(String n, String a, String c, 
					String s, String z)
	{
		name = n;
		address = a;
		city = c;
		state = s;
		zip = z;
		localWait = new WaitTime(0);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getZip()
	{
		return zip;
	}

	public WaitTime getLocalWait()
	{
		return localWait;
	}
	
	@Override
	public String toString()
	{
		return (name + "\n" + address + "\n" + city +
				", " + state + " " + zip + "\n");
	}
	
	

}
