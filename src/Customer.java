import java.util.Date;
import java.util.regex.Pattern;

public class Customer {
    String name;
    String id;
    Date createDate;
    
    public Customer(String name, String id, Date createDate) throws IncorrectCustomerFormatException {
        if(!name.matches("[a-zA-Z0-9\\s]+")) {
            throw new IncorrectCustomerFormatException("Customer name must match [a-zA-Z0-9\\s]+");
        }
        this.name = name;
        this.id = id;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        String s = "";
        s += "id: " + this.id + "\n"
        + "name: " + this.name + "\n"
        + "date: " + this.createDate;
        return s;
    }
}
