import java.util.ArrayList;

public class TaxExemptCustomer extends Customer{
    public TaxExemptCustomer(String custName) {
        super(custName);
    }

    public double PayForOrder (ArrayList<MerchandiseItem> itemsInOrder) {
        return 0;
        //fix this
    }
        public void arrangeDelivery(){
            System.out.println("Please contact"+this.getName()+"on day of delivery.");

    }
}
