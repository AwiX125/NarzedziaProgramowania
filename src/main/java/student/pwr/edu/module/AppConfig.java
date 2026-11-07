package student.pwr.edu.module;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * Singleton class that manages configuration of the App.
 */
public final class AppConfig {
  private static String FILE_APPSETTINGS_PATH = "appsettings.properties";
  private static final String FILE_ORDERS_KEY = "data.dir";

  private static AppConfig instance;

  private static String fileDataPath;

  /**
   * Private constructor that prevents instantiation so there is only one instance of the class.
   *
   * @throws ConfigurationException if settings cannot be loaded properly.
   */
  private AppConfig() throws ConfigurationException {
    Dotenv dotenv = Dotenv.load();
    String ENV_FILE_APPSETTINGS_PATH = dotenv.get("DATA_DIRECTORY");

    Parameters params = new Parameters();
    FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
            new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                    .configure(params.properties()
                            .setFileName(FILE_APPSETTINGS_PATH));

    Configuration config = builder.getConfiguration();

    if (ENV_FILE_APPSETTINGS_PATH != null && !ENV_FILE_APPSETTINGS_PATH.trim().isEmpty()) {
      fileDataPath = ENV_FILE_APPSETTINGS_PATH;
      System.out.println("Ścieżka wczytana ze zmiennej środowiskowej (.env): " + fileDataPath);
    } else {
      fileDataPath = config.getString(FILE_ORDERS_KEY);
      System.out.println("Ścieżka wczytana z pliku appsettings.properties: " + fileDataPath);
    }
  }

  /**
   * Prevents class from having more than one instance.
   *
   * @return instance of a class
   * @throws ConfigurationException if settings cannot be loaded properly.
   */
  public static synchronized AppConfig getInstance() throws ConfigurationException {
    if (instance == null) {
      instance = new AppConfig();
    }
    return instance;
  }

  /**
   * Getter for fileDataPath.
   *
   * @return directory of the data path
   */
  public String getFileDataPath() {
    return fileDataPath;
  }
}
