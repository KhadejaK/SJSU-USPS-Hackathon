import usps.*;
import java.util.Scanner;

class projTest{

    static Scanner reader = new Scanner(System.in);

    public static int taskChoice() {

        char taskMenuChoice;

        System.out.println("\n\nWhat are you doing today?");
        System.out.println("1. Passport");
        System.out.println("2. Send Mail");
        System.out.println("3. Pickup Package/Mail");
        System.out.println("4. Other");

        taskMenuChoice = reader.next().charAt(0);

        if (taskMenuChoice == '1') {
            return 20;
        }
        else if (taskMenuChoice == '2') {
            return 2;
        }
        else if (taskMenuChoice == '3') {
            return 5;
        }
        else {
            return 5;
        }

    }


    public static Customer checkIn(CustomerHTHandler cusHT) {

        String userName;
        String userContact;
        int userTaskTime;
        int numCustomer = 1;
        
        Scanner reader = new Scanner(System.in);
        System.out.println("\n\nEnter name: ");
        userName = reader.nextLine();
        System.out.println("Enter phone or email: ");
        userContact = reader.nextLine();
        userTaskTime = taskChoice();

        Customer newCustomer = new Customer(userName, userContact, 
            userTaskTime, numCustomer);

        cusHT.addCustomer(newCustomer, cusHT);
        numCustomer++;

        return newCustomer;
    }


    public static void notifyCustomer(CustomerHTHandler cusHT, Location demo) {

        System.out.println("\n\n");
        for (String name: cusHT.getCHT().keySet())
        {
            System.out.println(name);
        }

        System.out.println("Which user are you notifying?");
        reader.nextLine();
        String custName = reader.nextLine();

        System.out.println("\n\nHi " + custName + ", make your way back to "
            + demo.getName() + " Post Office, you will be helped soon!");

        return;
    }

    public static int checkOut(CustomerHTHandler cusHT) {
        int processTime;

        System.out.println("\n");
        for (String name: cusHT.getCHT().keySet())
        {
            System.out.println(name);
        }
        System.out.println("Which user is done being helped?");
        reader.nextLine();
        String custName = reader.nextLine();

        System.out.println(custName + " is done being helped.");

        processTime = cusHT.removeCustomer(custName);

        return processTime;
    } 

    public static char validateUserChoice(char userChoice) {
        while (userChoice != '1' && userChoice != '2' && userChoice != '3' 
            && userChoice != '4' && userChoice != '5')
        {
            printMenu();
            System.out.println("Please select either option 1 2 3 4 or 5");
            userChoice = reader.next().charAt(0);
        }

        return userChoice;
    }

    public static void printMenu() {
        System.out.println("\n1. Check Customer In");
        System.out.println("2. Email/Text Next Customer");
        System.out.println("3. Remove Processed Customer");
        System.out.println("4. Check Current Wait");
        System.out.println("5. Quit");
    }   

    public static void displayCurrentWait(Location demoLocation) {
        System.out.println("\nCurrent Wait Time: " 
            + demoLocation.getLocalWait().getWaitTime());
    }

    public static void main(String[] args) {
        char menuChoice;
        int waitTime;
        int processTime;

        System.out.println("\n\nWe're at the Foothill Post Office");
        Location demoLocation = new Location("FOOTHILL", "1085 MCGINNESS AVE",
            "SAN JOSE", "CA", "95127");


        CustomerHTHandler hh = new CustomerHTHandler(); 


        printMenu();
        menuChoice = reader.next().charAt(0);
        validateUserChoice(menuChoice);

        while (menuChoice != '5') {
            if (menuChoice == '1') {
                waitTime = checkIn(hh).getTaskTime();
                demoLocation.getLocalWait().addWaitTime(waitTime);
            }
            else if (menuChoice == '2') {
                notifyCustomer(hh, demoLocation);
            }
            else if (menuChoice == '3') {
                processTime = checkOut(hh);
                demoLocation.getLocalWait().subtractWaitTime(processTime);
            }
            else if (menuChoice == '4') {
                displayCurrentWait(demoLocation);
            }

            printMenu();
            menuChoice = reader.next().charAt(0);
            validateUserChoice(menuChoice);
        }

    }
}
