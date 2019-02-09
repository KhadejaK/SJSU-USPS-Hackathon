import usps.Customer;

public class Customer_Test {
    public static void main(String[] args) {
        Customer john = new Customer("John", "555123456", 15, 27);

        System.out.println(john.getName());
        System.out.println(john.getContactInfo());
        System.out.println(john.getTaskTime());
        System.out.println(john.getWaitNumber());
    }
}