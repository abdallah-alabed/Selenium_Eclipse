package co.pet;

import java.sql.Array;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {
	WebDriver driver;
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver","C:\\CHROME_DRIVER\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://petclincqpros.herokuapp.com");
			VerifyImage();
			Vetranians();
			FindOwners();
			OwnerPet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void VerifyImage() {
		String HomeImage = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/img")).getAttribute("src");
		System.out.println("Question 1:   ");
		System.out.println("Image Link Is:   "+ HomeImage);
	}
	public void Vetranians() {
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a")).click();
		WebElement Vets = driver.findElement(By.xpath("/html/body/div/div/table"));
		List<WebElement> rows = Vets.findElements(By.tagName("tr"));
		System.out.println("Question 2:   ");
		for (int i = 1; i< rows.size(); i++) {
			var link=String.format("/html/body/div/div/table/tbody/tr[%d]/td[1]", i);
			WebElement Names = driver.findElement(By.xpath(link));
			System.out.println("Vetranian " + i +":  " + Names.getText());
			}
	}
	public void FindOwners() {
//		This method is used to find the owners list from the website 
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button")).click();
		WebElement Owners = driver.findElement(By.xpath("/html/body/div/div/table"));
		List<WebElement> rows = Owners.findElements(By.tagName("tr"));
		System.out.println("Question 3:   " );
		for (int i = 1; i< rows.size(); i++) {
			var link=String.format("/html/body/div/div/table/tbody/tr[%d]/td[1]", i);
			WebElement Names = driver.findElement(By.xpath(link));
			if (Names.getText() != null) {
				System.out.println("Owner" + i +":  " + Names.getText());
			}
			}
	}
	
	public void OwnerPet() {
		// This Part Is To Send The Data To The Forms And Create A New Owner And A New Pet (Question 4) 
		// if we want to change data more quickly we create an array and take the data from it
		String[] OwnerData = {"Abdallah","Alabed","SportCity","Amman","0790001112"};
		String[] PetData = {"BESO","2021-12-21","snake"};
		try {
			driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[1]/div/div/input")).sendKeys(OwnerData[0]);
			driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[2]/div/div/input")).sendKeys(OwnerData[1]);
			driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[3]/div/div/input")).sendKeys(OwnerData[2]);
			driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[4]/div/div/input")).sendKeys(OwnerData[3]);
			driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[5]/div/div/input")).sendKeys(OwnerData[4]);
			driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
			driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[2]/div/div/input")).sendKeys(PetData[0]);
			driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[3]/div/div/input")).sendKeys(PetData[1]);
			driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[4]/div/select")).sendKeys(PetData[2]);
			driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button")).click();
			System.out.println("Question 4: ");
			System.out.println("All Data Was Submitted Successfully!");
		} catch (Exception e) {
			System.out.println("An Error Happened During Filling The Informations of the a new owner or a new pet.");
			e.printStackTrace();
		}
		// This Part Is To Check The Data In The Form And Compare It With The Data I Sent (Question 5)
		System.out.println("Question 5: ");
		// Owner Data From The Website
		WebElement FName = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td"));
		WebElement Address = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td"));
		WebElement City = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[3]/td"));
		WebElement Tele = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[4]/td"));
		
		String FullName = FName.getText();
		String CityName = City.getText();
		String AddressName = Address.getText();
		String TelephoneNumber = Tele.getText();
		
		// Pet Data From The Website
		WebElement P_Name = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[1]"));
		WebElement P_Birth = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[2]"));
		WebElement P_Type = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[3]"));
		
		
		String PetName = P_Name.getText();
		String PetBirth = P_Birth.getText();
		String PetType = P_Type.getText();

		// We Have To Compare The Data From The Website With The Data From The Array To Check If They Match
		if ( 
			  (OwnerData[0]+" "+OwnerData[1]).compareTo(FullName)== 0 &&
			  OwnerData[2].compareTo(AddressName) == 0 && 
			  OwnerData[3].compareTo(CityName)== 0 &&
			  OwnerData[4].compareTo(TelephoneNumber)==0 &&
			  PetData[0].compareTo(PetName) == 0 &&
			  PetData[1].compareTo(PetBirth)==0 &&
			  PetData[2].compareTo(PetType)==0
			  ) {
			System.out.println("Verification Done Successfully, All Data Are Matched!");
		} else {
			System.out.println("Verification Was Not Successful, Data Doesn't Match!");
		}
	}

	
	public static void main(String[] args) {
		Day1 myObj = new Day1();
		myObj.invokeBrowser();

	}

}
