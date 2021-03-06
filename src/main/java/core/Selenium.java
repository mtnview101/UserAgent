package core;
//BEGIN
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Selenium {
	public static void main(String[] args) {
		
		String text_case_id = "TC-001.02";
		String url = "http://www.learn2test.net/";
		String title_expected = "Dmitry is Java developer";
		

		WebDriver driver = new FirefoxDriver();    // Version 1.1 :: Firefox

        // UserAgent RegEx: (?:Mozilla/5.0)\s(?:.*\))\s(?:Gecko/\d{8})\s(\w+)/(\d+.\d+)
        String useragentregex = "(?:Mozilla/5.0)\\s(?:\\(.*\\))\\s(?:Gecko/\\d{8})\\s(\\w+)/(\\d+.\\d+)";

        String useragent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
        Matcher m_browser = Pattern.compile(useragentregex).matcher(useragent);m_browser.find();

        
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();

		if (title_expected.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
		}
		System.out.println("\nUserAgent: \t\t" + (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"));
		driver.quit();
	}
}
//END
