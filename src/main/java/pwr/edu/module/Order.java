package pwr.edu.module;

import java.util.List;

/**
 * Order class that contains both customer and a list of products.
 * This class can also generate a random order
 * number by a deterministic algorithm
 */
public final class Order {
  private Customer customer;
  private List<Product> products;

  /**
   * Default constructor.
   */
  public Order() {
  }

  /**
   * Public constructor that sets all class members variables.
   *
   * @param customer customer
   * @param products list of products
   */
  public Order(Customer customer, List<Product> products) {
    this.customer = customer;
    this.products = products;
  }

  /**
   * Getter for customer.
   *
   * @return customer
   */
  public Customer getCustomer() {
    return customer;
  }

  /**
   * Sets the customer.
   *
   * @param customer customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  /**
   * Getter for Products.
   *
   * @return List of products
   */
  public List<Product> getProducts() {
    return products;
  }

  /**
   * Sets the Products.
   *
   * @param products List of products
   */
  public void setProducts(List<Product> products) {
    this.products = products;
  }

  /**
   * An algorithm used to generate a number of an order
   * in a deterministic way.
   *
   * @return number of the order
   */
  public String generateOrderNumber() {
    String orderNumber = customer.getFirstName() + customer.getLastName() + "{"
            + customer.getEmail() + "}" + "[" + customer.getPhoneNumber() + "]";
    for (Product product : products) {
      orderNumber += "_";
      orderNumber += product.getProductCode() + "["
              + product.getQuantity() + "]" + product.getUnit();
    }

    return orderNumber;
  }
}
