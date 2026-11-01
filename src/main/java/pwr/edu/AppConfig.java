package pwr.edu;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * Singleton class that manages configuration of the App
 */
public final class AppConfig {
    private static final String FILE_APPSETTINGS_PATH = "appsettings.properties";
    private static final String FILE_ORDERS_KEY =  "data.dir";

    private static AppConfig instance;

    private static String fileDataPath;

    /**
     * Private constructor that prevents instantiation so there is only one instance of the class
     * @throws ConfigurationException
     */
    private AppConfig() throws ConfigurationException {
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName(FILE_APPSETTINGS_PATH));

        Configuration config = builder.getConfiguration();

        fileDataPath = config.getString(FILE_ORDERS_KEY);
        System.out.println("Plik z zamowieniami znajduje sie w katalogu: " + fileDataPath);
    }

    public static synchronized AppConfig getInstance() throws ConfigurationException {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    /**
     * Getter for fileDataPath
     * @return directory of the data path
     */
    public String getFileDataPath() {
        return fileDataPath;
    }
}
