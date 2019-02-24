
package newpharmacy;


public class Record {
    
    DBConnection connect;
    
    private String item_name;
    private int amount;
    private float price;
    private String customer_name;
    
    public String getItemName(){
        return item_name;
    }
    public void setItemName(String item_name){
        this.item_name = item_name;
    }
    
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    
    public float getPrice(){
        return price;
    }
    public void setPrice(float price){
        this.price = price;
    }
    
    public String getCustomerName(){
        return customer_name;
    }
    public void setCustomerName(String customer_name){
        this.customer_name = customer_name;
    }
}
