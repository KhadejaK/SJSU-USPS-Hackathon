package usps;

import java.util.*;
import usps.Customer;
import usps.WaitTime;

public class CustomerHTHandler {

    String keyCustomerID;
    int valTaskTime;
    Map<String, Integer> cht;

    public CustomerHTHandler() {
        Map<String, Integer> cht = new Hashtable<>();
    }

    public Map<String, Integer> getCHT() {
        return cht;
    }

    public int addCustomer(Customer nextCust) {
        cht.put(nextCust.getName(), nextCust.getTaskTime());
        return nextCust.getTaskTime();
    }

    public int removeCustomer(Customer processedCust) {
        cht.remove(processedCust.getName());
        return processedCust.getTaskTime();
    }

    public void endOfDay() {
        cht.clear();
    }

}