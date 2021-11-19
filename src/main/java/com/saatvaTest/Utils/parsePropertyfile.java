package com.saatvaTest.Utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class parsePropertyfile {
	
	static Properties prop = new Properties(); //create object of Properties
	
	public static String getPropertyValueByKey(String key) throws Exception {
		
		//get filepath
		String propFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
		
		FileInputStream fis = new FileInputStream(propFilePath);
		prop.load(fis);
		
		//read data
		String value = prop.get(key).toString();
		
		if (StringUtils.isEmpty(value)) {
			throw new Exception("Value is not specified for " + key + "in properties file");
		}
		
		return value;
	}

}
