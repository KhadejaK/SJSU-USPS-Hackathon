package usps;
public class Customer 
{
    private String name;
    private String contactInfo;
    private int taskTime;
    private int waitNumber;

    public Customer(String n, String c, int t, int w) {
        name = n;
        contactInfo = c;
        taskTime = t;
        waitNumber = w;
    }
    public String getName() {
        return name;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public int getTaskTime() {
        return taskTime;
    }
    public int getWaitNumber() {
        return waitNumber;
    }
}
