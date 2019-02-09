package usps;

public class Location 
{
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	
	
	public Location(String n, String a, String c, 
					String s, String z)
	{
		name = n;
		address = a;
		city = c;
		state = s;
		zip = z;
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
	
	@Override
	public String toString()
	{
		return (name + "\n" + address + "\n" + city +
				", " + state + " " + zip + "\n");
	}
	
	

}
