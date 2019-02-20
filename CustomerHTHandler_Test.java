import usps.Customer;
import usps.CustomerHTHandler;
import java.util.Scanner;

public class CustomerHTHandler_Test {
    public static void main(String[] args) {
        String endOfDay = "SomeTypePassword"; // when entered, signals no more customers
        // boolean stillOpen = true;

        String userName;
        String userContact;
        int userTaskTime;
        int numCustomer = 1;

        CustomerHTHandler hh = new CustomerHTHandler(); 

        while (true) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter name: ");
            userName = reader.nextLine();
            System.out.println("Enter phone or email: ");
            userContact = reader.nextLine();
            System.out.println("Choose your task (add # minutes for now): ");
            userTaskTime = reader.nextInt();
            reader.close();

            if (userName == "SomeTypePassword")
            {
                break;
            }

            Customer newCustomer = new Customer(userName, userContact, 
                userTaskTime, numCustomer);

            hh.addCustomer(newCustomer, hh);
            numCustomer++;
        }

    }
}