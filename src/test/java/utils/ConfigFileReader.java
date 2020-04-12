package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private static Properties properties = new Properties();
	static ConfigFileReader config = new ConfigFileReader();

	String currentDirectory = System.getProperty("user.dir");
	private final String propertyFilePath = currentDirectory + "/configs/Configuartion.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			/*
			 * properties = new Properties();
			 */ try {
				ConfigFileReader.properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getURL() {
		String url = properties.getProperty("app.url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url is  not specified in the Configuration.properties file.");
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}
	public String getChromeDriverPath() {
		String driverPath = properties.getProperty("chromeDriverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}
		
	

	public String getfilePath() {
		String Path = properties.getProperty("propertyFilePath");
		if (Path != null)
			return Path;
		else
			throw new RuntimeException("Path  not specified in the Configuration.properties file.");
	}



	public String getTime() {
		String time = properties.getProperty("wait.explicit.seconds");
		if (time != null)
			return time;
		else
			throw new RuntimeException("Time  is  not specified in the Configuration.properties file.");
	}



}