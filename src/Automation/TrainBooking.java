package Automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class TrainBooking {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\FrugalTesting\\chromedriver_win32\\chromedriver.exe");
		
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			
			driver.get("https://www.makemytrip.com/railways/");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/label/span")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin ']/div/input")).sendKeys("Delhi");
			
			List<WebElement>dynamicList=driver.findElements(By.cssSelector("p[class='searchedResult font14 darkText']"));
			
			for(int i=0;i<dynamicList.size();i++) {
				String text = dynamicList.get(i).getText();
				System.out.println("Text is"+text);
				if(text.contains("Delhi")) {
					dynamicList.get(i).click();
					break;
				}
			}
			
			
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[2]/label/span")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input")).sendKeys("Lucknow");
			Thread.sleep(3000);
			
			List<WebElement>dynamicList2=driver.findElements(By.cssSelector("p[class='searchedResult font14 darkText']"));
			
			for(int i=0;i<dynamicList2.size();i++) {
				String text = dynamicList2.get(i).getText();
				System.out.println("Text is"+text);
				if(text.contains("Lucknow")) {
					dynamicList2.get(i).click();
					break;
				}
			}
			
			
			
			driver.findElement(By.xpath("//*[@id=\"travelDate\"]")).click();
			Thread.sleep(3000);
			
		
			
			List<WebElement>dateList=driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
			int count = dateList.size();

			for(int i=0;i<count;i++) {
				String text = dateList.get(i).getText();
				System.out.println("text is"+text);
				if(text.contains("20")) {
					dateList.get(i).click();
					break;
				}
			}
			
				
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[4]/label/span")).click();
			
			List<WebElement>classpicker=driver.findElements(By.xpath("//div[@class='rsw_inputBox travelFor inactiveWidget activeWidget']/ul/li"));
			Thread.sleep(3000);
			System.out.println(classpicker);
			for(int i=0;i<classpicker.size();i++) {
				String text = classpicker.get(i).getText();
				System.out.println("Text is"+text);
				if(text.contains("Third AC")) {
					classpicker.get(i).click();
					break;
				}
			}
			
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/p/a")).click();

			//driver.close();
	}

}
