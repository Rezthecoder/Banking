import java.util.ArrayList;

public class Branch {

  private String name;
  ArrayList<Customer> customers;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean newCustomer(String name, double intialAmount) {
    if (findCustomer(name) == null) {
      this.customers.add(new Customer(name, intialAmount));
      return true;
    }
    return false;
  }

  public boolean addCustomerTransation(String name, double amount) {
    Customer existingCustomer = findCustomer(name);
    if (existingCustomer != null) {
      existingCustomer.addTransaction(amount);
      return true;
    }
    return false;
  }

  private Customer findCustomer(String name) {
    for (int i = 0; i < this.customers.size(); i++) {
      Customer customer = this.customers.get(i);
      if (customer.getName().equals(name)) {
        return customer;
      }
    }
    return null;
  }
}
