package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnvironmentManager1 {
 private WebDriver driver;
 public Properties prop;
 

public  void  DevEnvironment() throws IOException {
	prop = new Properties();
	   
    String filepath = System.getProperty("user.dir")+"\\Resources\\Dev.properties";
    FileInputStream file = new FileInputStream(filepath);
    prop.load(file);
}
public void TestEnvironment() throws IOException {
	prop = new Properties();
	   
    String filepath = System.getProperty("user.dir")+"\\Resources\\Prod.properties";
    FileInputStream file = new FileInputStream(filepath);
    prop.load(file);
	
	
}
public void ProdEnvironment() throws IOException {
	prop = new Properties();
	   
    String filepath = System.getProperty("user.dir")+"\\Resources\\Test.properties";
    FileInputStream file = new FileInputStream(filepath);
    prop.load(file);
}
public static void main(String[] args) {
	EnvironmentManager1 myInstance = new EnvironmentManager1();
	
}

String[] methodNames = {"DevEnvironment","TestEnvironment","ProdEnvironment"};
{
for(String methodName :methodNames) {
	try {
		Method method = EnvironmentManager1.class.getMethod(methodName);
	} catch (NoSuchMethodException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}}}