import java.util.ArrayList;

public class CustomerBase {
    private final ArrayList<OrdinaryCustomer> ordinaryCustomers;
    private static CustomerBase customerBase;

    private CustomerBase() {
        ordinaryCustomers = new ArrayList<>();
    }

    public ArrayList<OrdinaryCustomer> getCustomers() {
        return ordinaryCustomers;
    }

    public static CustomerBase getInstance() {
        if (customerBase == null) customerBase = new CustomerBase();
        return customerBase;
    }

    public OrdinaryCustomer login(String name, String surname) {
        for (OrdinaryCustomer cust : ordinaryCustomers) {
            if (cust.getName().equals(name) && cust.getSurname().equals(surname)) {
                return cust;
            }
        }
        ordinaryCustomers.add(new OrdinaryCustomer(name, surname));
        return new OrdinaryCustomer(name, surname);
    }
}
