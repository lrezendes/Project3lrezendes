public class MerchandiseItem {
    private ItemType TaxibleType;
    private String Name;
    private double Price;

    public MerchandiseItem(String Name, double Price, ItemType A){
        this.Name = Name;
        this.Price = Price;
        this.TaxibleType = A;
    }
    public String getName(){
        return Name;
    }
    public double getPrice(){
        return Price;
    }
    public ItemType getType(){
        return TaxibleType;
    }
}
