package TestSuite;

import org.testng.AssertJUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParametersWithXML {
	
	WebDriver driver;
    @Test
    @Parameters({"Author","SearchKey"})
    public void testParameterWithXML( @Optional("Abc") String Author,String SearchKey)
    		throws InterruptedException{
        driver = new FirefoxDriver();
        driver.get("https://google.com");

        WebElement searchText = driver.findElement(By.name("q"));
        //Searching text in google text box
        searchText.sendKeys(SearchKey);

        System.out.println("Welcome ->"+Author+" Your search key is->"+SearchKey);
        System.out.println("Thread will sleep now");
        Thread.sleep(3000);
        System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+SearchKey);
        //verifying the value in google search box
        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(SearchKey));
        driver.close();

}
}

