package excelPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadingFile {

	static Properties prop;

	@Test
	public void read() {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\File\\FirstFile.properties";
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		String first = prop.getProperty("firstName");
		String last = prop.getProperty("lastName");
		String empID = prop.getProperty("empID");

		System.out.println(first);
		System.out.println(last);
		System.out.println(empID);

	}

}
