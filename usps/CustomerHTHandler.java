package usps;

import java.util.*;
import usps.Customer;
import usps.WaitTime;

public class CustomerHTHandler {

    String keyCustomerID;
    Integer valTaskTime;
    Map<String, Integer> cht = new Hashtable<>();

    public CustomerHTHandler() {
        Map<String, Integer> cht = new Hashtable<>();
    }

    public Map<String, Integer> getCHT() {
        return cht;
    }

    public int addCustomer(Customer nextCust, CustomerHTHandler hh) {
        keyCustomerID = nextCust.getName();
        valTaskTime = nextCust.getTaskTime();

        hh.cht.put(keyCustomerID, valTaskTime);
        return nextCust.getTaskTime();
    }

    public int removeCustomer(String processedCustName) {
        int processedTime = cht.get(processedCustName);
        cht.remove(processedCustName);
        return processedTime;
    }

    public void endOfDay() {
        cht.clear();
    }

}