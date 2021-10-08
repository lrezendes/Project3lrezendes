import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 * Class Store
 */
public class Store {

  //
  // Fields
  //

  private ArrayList<Order> Orders;
  private ArrayList<Customer> Customers;
  
  //
  // Constructors
  //
  public Store () {
    Orders = new ArrayList<Order>();
    Customers = new ArrayList<Customer>();
  };
  
  //
  // Methods
  //



  /**
   * @param        args
   */
  public static void main(String[] args) throws IOException
  {
    var comp152Inc = new Store();
    comp152Inc.runStore();

  }

  /**
   */
  public void runStore() throws IOException
  {
    var inputReader = new Scanner(System.in);
    loadStartingCustomers(inputReader);
    while(true){ //the main run loop
      printMainMenu();
      var userChoice = inputReader.nextInt();
      switch (userChoice){
        case 1:
          addCustomer(inputReader);
          break;
        case 2:
          var selectedCustomer =selectCustomer(inputReader);
          if(selectedCustomer.isPresent())
            manageCustomer(selectedCustomer.get());
          break;
        case 3:
          System.exit(0);
        default:
          System.out.println("\n%%%%%%Invalid selection, please choose one of the options from the menu%%%%%%\n");
      }
    }
  }

  private static void printMainMenu() {
    System.out.println("*****************************************************************************");
    System.out.println("Welcome to the the 1980s Comp152 Store interface, what would you like to do?");
    System.out.println("   [1] Add Customer");
    System.out.println("   [2] Select Customer");
    System.out.println("   [3] Exit the program");
    System.out.println("*****************************************************************************");
    System.out.print("Enter the number of your choice:");
  }




  private void loadStartingCustomers(Scanner inputReader) throws IOException {
    Path fullPathName;
    String filename;
    while(true) { //this is for some error checking. It was not required by the assignment
      System.out.print("Enter the name of the file to load customers:");
      filename = inputReader.nextLine();
      fullPathName = Paths.get(filename);
      if (!Files.exists(fullPathName)){ //these three lines checks to see if the file exists, if not go
        System.out.println("No file with that name, please try again....");//do the loop again
        continue;
      }
      else
        break;
    }
    //if we got here the file must be real
    var allLines = Files.readAllLines(fullPathName);
    // now create customers for all of the lines in the file
    for(var line: allLines){
      var splitLine = line.split(",");
      var currentCustomer = new Customer(splitLine[0], Integer.parseInt(splitLine[1]));
      Customers.add(currentCustomer);
    }
  }


  /**
   * @param        address
   * @param        cust
   */
  public void makeOrder(ShippingAddress address, Customer cust)
  {
  }



  /**
   */
  public void addCustomer(Scanner inputReader)
  {
    //because we just came from a nextInt, there is an orphaned \n on the input stream eat it
    inputReader.nextLine();
    System.out.println("Adding Customer........");
    System.out.print("Enter the new Customers name:");
    var newName = inputReader.nextLine();
    var newCustomer = new Customer(newName);
    Customers.add(newCustomer);
    System.out.println(".....Finished adding new Customer Record");
  }


  /**
   * @return       Customer
   * the original UML called for returning a Customer Object rather than an Optional
   * since I didn't know when I designed this if we would hit optional by then or not
   * but I invited anyone who asked to use Optional if they wanted to
   * either way is perfectly fine
   */
  public Optional<Customer> selectCustomer(Scanner reader)
  {
    System.out.print("Enter the ID of the customer to select:");
    var enteredID = reader.nextInt();
    for(var currentCustomer: Customers){
      if(currentCustomer.getCustomerID()==enteredID)
        return Optional.of(currentCustomer);
    }
    //If we looked through the whole list and didn't find that customer tell the user
    System.out.println("==========================> No customer with customer ID:"+enteredID);
    return Optional.empty();
  }


  /**
   * @param        selectedCustomer
   */
  public void manageCustomer(Customer selectedCustomer)
  {
  }


}
