package pwr.edu;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import tools.jackson.databind.ObjectMapper;

/**
 * Entry point of the project.
 */
public final class Main {
  /**
   * Entry point of the project.
   *
   * @param args arguments for the main function
   */
  public static void main(String[] args) {
    System.out.println("#########");
    System.out.println("# Start #");
    System.out.println("#########");
    try {
      AppConfig config = AppConfig.getInstance();

      Path orderPath = Path.of(config.getFileDataPath());

      // Checking if the directory exists
      if (!Files.exists(orderPath) || !Files.isDirectory(orderPath)) {
        System.out.println("Katalog nie istnieje: " + orderPath);
      }

      File[] jsonFiles = orderPath.toFile().listFiles((dir, name)
              -> name.toLowerCase().endsWith(".json"));

      // Checking if there are any .json files
      if (jsonFiles == null || jsonFiles.length == 0) {
        System.out.println("Nie ma plikow .json w katalogu");
        return;
      }

      System.out.println("Liczba plikow z rozszerzeniem .json: " + jsonFiles.length);

      ObjectMapper objectMapper = new ObjectMapper();

      // Deserialize and printing
      for (File file : jsonFiles) {
        System.out.println("===============================================");
        System.out.println("Odczytywanie pliku: " + file.getName());

        // Deserialize
        Order order = objectMapper.readValue(file, Order.class);

        // Generating orderNumber
        final String orderNumber = order.generateOrderNumber();

        // Printing
        System.out.println("Zamawiajacy: " + order.getCustomer().getFirstName() + " "
                + order.getCustomer().getLastName());
        System.out.println("Email: " + order.getCustomer().getEmail());
        System.out.println("Numer telefonu: " + order.getCustomer().getPhoneNumber());

        System.out.println("--------");
        System.out.println("Liczba pozycji w zamowieniu: " + order.getProducts().size());
        System.out.println("Produkty: ");

        // Outputting every item of and order
        for (Product product : order.getProducts()) {
          System.out.println("Kod: " + product.getProductCode() + " | Ilosc: "
                  + product.getQuantity() + " | Jednostka miary: " + product.getUnit());
        }

        System.out.println("Wygenerowany Numer Zamowienia: " + orderNumber);
      }

    } catch (Exception exception) {
      System.out.println("Cos poszlo nie tak...\n" + exception.getMessage());
      exception.printStackTrace();
      System.exit(1);
    }

  }

  /**
   * Private constructor to hide the implicit public one for utility/main class.
   */
  private Main() {}
}
