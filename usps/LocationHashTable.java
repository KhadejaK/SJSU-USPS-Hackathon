package usps;
import java.util.*;
import usps.CustomerHTHandler;
import usps.Customer;

public class LocationHashTable {
  Map<String,CustomerHTHandler> locationTable = new Hashtable<>();

  public LocationHashTable(){
    locationTable = new Hashtable<>();
  }

    //puts customer to proper location
  public void addCustomer(String locationName, CustomerHTHandler cht){
    locationTable.put(locationName, cht);
  }

  public void removeLocation(String location){
    locationTable.remove(location);
  }

//Prints location table
  public Map<String,CustomerHTHandler> getLocationTable(){
    return locationTable;
  }

//Clears location table
  public void clearLocationTable(){
    locationTable.clear();
  }
}
