import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner; 
import usps.Location;

public class LocationFinderAndTester 
{
	public static ArrayList<Location> fileReader() throws FileNotFoundException
	{
		File locations = new File("USPS_Locations.txt");
		Scanner s = new Scanner(locations);
		
		ArrayList<Location> ls = new ArrayList<Location>();
		
		while (s.hasNextLine()) 
		{
			String name = s.nextLine().trim();
			String address = s.nextLine().trim();
			String cityStateZip = s.nextLine();
			String[] split1 = cityStateZip.split(", ");
			String city = split1[0];
			String[] split2  = split1[1].split(" ");
			String state = split2[0];
			String zip = split2[1];
			s.nextLine();
			
			ls.add(new Location(name, address, city, state, zip));
		}
		
		s.close();
		
		return ls;
	}
	
	public static Location locationFinder(ArrayList<Location> ls, String input)
	{
		Scanner s = new Scanner(System.in);
		
		for (Location x: ls)
		{		
			if(x.getName().equalsIgnoreCase(input))
			{
				System.out.println(x.toString());
				System.out.print("Is this the correct location? (Y/N): ");
				String confirm = s.next().charAt(0);
				
				if (confirm == 'y' || confirm == 'Y')
				{
					s.close();
					return x;
				}
				else
				{
					s.close();
					return null;
				}
			}
			else if(x.getCity().equalsIgnoreCase(input))
			{
				System.out.println(x.toString());
			}
			else if(x.getZip().equalsIgnoreCase(input))
			{
				System.out.println(x.toString());
			}
		}
		
		s.close();
		return null;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{ 
		ArrayList<Location> locations = fileReader();
		
		System.out.println("Please enter name, city, or zip");
		//Note: Only put the correct name
		
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		
		System.out.println();
		Location location = locationFinder(locations, input);
		
		while(location == null)
		{
			System.out.print("Please enter name of office: " );	
			input = s.nextLine(); //This bitch don't work idk why kill me
			location = locationFinder(locations, input);
		}
		s.close();
				
		if(location != null)
			System.out.println(location.toString());
	}
		
}
