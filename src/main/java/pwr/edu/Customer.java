package pwr.edu;

/**
 * Customer that can be represented with first name,
 * last name, email and phone number.
 */
public final class Customer {
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;

  /**
   * Default constructor.
   */
  public Customer() {
  }

  /**
   * Public constructor that sets all class members variables.
   *
   * @param firstName   first name
   * @param lastName    last name
   * @param email       e-mail
   * @param phoneNumber Phone number
   */
  public Customer(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  /**
   * Getter for firstName.
   *
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Setter for firstName.
   *
   * @param firstName first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Getter for lastName.
   *
   * @return last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Setter for last name.
   *
   * @param lastName last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Getter for email.
   *
   * @return e-mail
   */
  public String getEmail() {
    return email;
  }

  /**
   * Setter for e-mail.
   *
   * @param email email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Getter for phoneNumber.
   *
   * @return phone number
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Setter for phone number.
   *
   * @param phoneNumber phone number
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
