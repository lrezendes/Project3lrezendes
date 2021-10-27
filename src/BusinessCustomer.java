import java.util.ArrayList;

public class BusinessCustomer extends Customer{
    public BusinessCustomer(String custName) {
        super(custName);
    }

    private double purchaseOrderBalance(){
        return 0;
        //fix this
    }
    public double payForOrder (ArrayList<MerchandiseItem> itemsInOrder){
        System.out.println("");

}

    @Override
    public double PayForOrder(ArrayList<MerchandiseItem> itemsInOrder) {
        return 0;
    }
}
