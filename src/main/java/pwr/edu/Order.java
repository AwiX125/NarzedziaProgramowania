package pwr.edu;

import java.util.List;

public final class Order {
    private Customer customer;
    private List<Product> products;

    public Order(){}

    public Order(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    public String generateOrderNumber() {
        String orderNumber = customer.getFirstName() + customer.getLastName() + "{"
                + customer.getEmail() + "}" + "[" + customer.getPhoneNumber() + "]";
        for (Product product : products) {
            orderNumber += "_";
            orderNumber += product.getProductCode() + "[" +product.getQuantity() + "]" + product.getUnit();
        }

        return orderNumber;
    }
}
