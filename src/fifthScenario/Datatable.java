package fifthScenario;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datatable {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
	}

	@Test(priority = 1)
	// a.Fetch 1st 25 entries from the table.

	public void entries() throws InterruptedException {
		driver.get("https://datatables.net/");
		List<WebElement> entries = driver.findElements(By.xpath("//select[@name='example_length']/option"));
		System.out.println("total dropdown values " + entries.size());
		entries.get(1).click();
		System.out.println("clicked on dropdown and selected first 25 entries " + entries.get(1));

		// b. Do sort on Age column young to old
		driver.findElement(By.xpath("//table[@id='example']//th[4]")).click();
		System.out.println("25 entries sorted as per the age young to old");

		// printing first 25 entries on console which are sorted by age young to old
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='example']//tr"));
		String ColumnFirst = "//table[@id='example']//tr[";
		String Columnlast = "]//td";

		String Column;
		List<WebElement> Tablecolumns;

		for (int i = 1; i < tableRows.size() - 1; i++) {

			Column = ColumnFirst + i + Columnlast;

			Tablecolumns = driver.findElements(By.xpath(Column));
			System.out.println("for rows: " + i);

			for (int j = 0; j < Tablecolumns.size(); j++) {

				System.out.println(Tablecolumns.get(j).getText() + "   ");
			}
			System.out.println();

		}
		System.out.println("All 25 entries are printed on console First test executed");
	}

	@Test(priority = 2)
	// Fetch name, position, office, age and salary details of the Software
	// Engineers of below 30 years
	public void dataofSoftengg() {
		// clicking on dropdown to fetch all entries from datatable
		List<WebElement> entries1 = driver.findElements(By.xpath("//select[@name='example_length']/option"));

		entries1.get(3).click();
		System.out.println("clicked on dropdown and fetched all entries in one page " + entries1.get(3));
		System.out.println(
				"Start execution to fetch name, position, office, age and salary details of the Software Engineers of below 30 years");
		// find employee name from name column
		List<WebElement> Name = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
		Name.size();
		
		// find software engg position from postion column

		List<WebElement> Position = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		Position.size();
		String expectedposition = "Software Engineer";
		// find employee name from name column

		List<WebElement> Office = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		Office.size();
		// finding the Age of employeee
		List<WebElement> Age = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4]"));
		Age.size();

		for (int i = 0; i < Position.size(); i++) {
			if (Position.get(i).getText().equalsIgnoreCase(expectedposition)) {
				
				if (Integer.parseInt( Age.get(i).getText()) < 30)
				{	
				
				System.out.println("Employee Name:" + Name.get(i).getText() + " Position:" + Position.get(i).getText()
						+ " Officelocation:" + Office.get(i).getText() + " Age:" + Age.get(i).getText());
				
				}
			}
			
				
		}
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
