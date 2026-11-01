package pwr.edu.module;

/**
 * Product that can be represented with product code, quantity
 * and unit of measurement.
 */
public final class Product {
  private String productCode;
  private double quantity;
  private String unit;

  /**
   * Defualt constructor.
   */
  public Product() {
  }

  /**
   * Public constructor that sets all class members variables.
   *
   * @param productCode Code of the product
   * @param quantity    quantity of product
   * @param unit        unit of measurement
   */
  public Product(String productCode, double quantity, String unit) {
    this.productCode = productCode;
    this.quantity = quantity;
    this.unit = unit;
  }

  /**
   * Getter for productCode.
   *
   * @return code of the product
   */
  public String getProductCode() {
    return productCode;
  }

  /**
   * Setter for productCode.
   *
   * @param productCode product Code
   */
  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  /**
   * Getter for quantity.
   *
   * @return quantity of the product
   */
  public double getQuantity() {
    return quantity;
  }

  /**
   * Setter for quantity.
   *
   * @param quantity quantity
   */
  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  /**
   * Getter for unit of measurement.
   *
   * @return product's unit of measurement
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Setter for unit of measurement.
   *
   * @param unit unit of measurement
   */
  public void setUnit(String unit) {
    this.unit = unit;
  }
}
