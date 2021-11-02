import java.io.File;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        CustomerReader csvReader = new CustomerReader() {
            @Override
            public Customer consume(String line) throws IncorrectCustomerFormatException {
                System.out.println(line);
                String[] fields = line.split(",");
                String id = fields[0];
                String name = fields[1];
                String date = fields[2];
                return new Customer(id, name, new Date(date));
            }
        };
        System.out.println("a");
        File file;
        try {
            file = new File("D:\\CODE\\amdocs_customerreader\\amdoc\\customers.xlsx");
            csvReader.consumeCustomerFile(file);
            for(Customer c : csvReader.getCustomers()) {
                System.out.println(c);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println(csvReader.getCustomers().size());
        System.out.println("b");
    }
}
