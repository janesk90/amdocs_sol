import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The idea with this class is that you use it like you would an anonymous
 * comparator in sorting. So you'd instantiate it like:
 * 
 * 
 * CustomerReader cr = new CustomerReader(){ Override public Customer
 * consume(String line) { ... } }
 * 
 * And fill in consume with your implementation.
 */
public class CustomerReader {
    List<Customer> customers;

    public CustomerReader() {
        this.customers = new ArrayList<Customer>();
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void consumeCustomerFile(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            boolean isFirst = true;
            String line = "";
            while (null != (line = bufferedReader.readLine())) {
                if (isFirst) {
                    isFirst = false;
                    continue;
                }
                try {
                    Customer customer = this.consume(line);
                    this.customers.add(customer);
                } catch (IncorrectCustomerFormatException ex) { // catch Customer validation issues here and handle them appropriately
                    System.out.println("Something went wrong");
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            // pass
        }
    }

    public Customer consume(String line) throws IncorrectCustomerFormatException {
        throw new UnsupportedOperationException(
                "The consume operation for this customer consumer has not been implemented.");
    }
}
