import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
  }

  private void loadStartingCustomers(Scanner inputReader) throws IOException {
    Path fullPathName;
    String filename;
    while(true) { //this is for some error checking. It was not required by the assignment
      System.out.print("Enter the name of the file to load customers:");
      filename = inputReader.nextLine();
      fullPathName = Paths.get(filename);
      if (!Files.exists(fullPathName)){ //these three lines checks to see if the file exists, if not go do the loop
        System.out.println("No file with that name, please try again....");//again
        continue;
      }
      else
        break;
    }
    //if we got here the file must be real
    var allLines = Files.readAllLines(fullPathName);

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
  public void addCustomer()
  {
  }


  /**
   * @return       Customer
   */
  public Customer selectCustomer()
  {
  }


  /**
   * @param        selectedCustomer
   */
  public void manageCustomer(Customer selectedCustomer)
  {
  }


}
