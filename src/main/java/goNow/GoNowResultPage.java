package goNow;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class GoNowResultPage 
{
	public static void ResultPageForFlight(String TripType,String Applyfilter,String FareType,String AirLine,String Trip) throws Exception
	{
		Thread.sleep(10000);
		QaRobot.ScreenshotMethod("ResultPage","<b><i>Screenshot for Result Page</i></b>");
		
		String url = QaBrowser.driver.getCurrentUrl();
		String[] uid = url.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		if(Applyfilter.equalsIgnoreCase("Yes"))
		{
			if(FareType.equalsIgnoreCase("All"))
			{
				QaRobot.ClickOnElement("Refundable");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ClickOnElement("NonRefundable");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(3000);
			}
			else if(FareType.equalsIgnoreCase("Refundable"))
			{
				QaRobot.ClickOnElement("Refundable");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(3000);
			}
			else if(FareType.equalsIgnoreCase("Non-Refundable"))
			{
				QaRobot.ClickOnElement("NonRefundable");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(3000);
			}
			
			List<WebElement> listOfAirLine = QaBrowser.driver.findElements(By.xpath("(//div[@id='tdContainerTblAirlines'])[2]//li//span"));
			
			for (WebElement autoAirline : listOfAirLine) 
			  {
				if (autoAirline.getText().equalsIgnoreCase(AirLine)) 
				{
					autoAirline.click();
					break;
				} 
				else 
				{
					
				}
			  }
			Thread.sleep(5000);
			QaRobot.ClickOnElement("GoToTop");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Apply filter");
			QaRobot.ScreenshotMethod("Applyfilter","<b><i>Screenshot for Apply filter</i></b>");
		}
		
		if (Trip.equalsIgnoreCase("Domestic"))
		{
			if(TripType.equalsIgnoreCase("OneWay"))
			{
				JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
				mo.executeScript("window.scrollBy(0,450)", "");
				Thread.sleep(3000);
				
				WebElement FlightItinerary = QaBrowser.driver.findElement(By.xpath("(//a[@class='flght-itnry ng-binding'])[1]"));
				JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
				js1.executeScript("arguments[0].click()", FlightItinerary);
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FlightItinerary</i></b>");
				Thread.sleep(5000);
				QaExtentReport.extentScreenshot("FlightItinerary");
				
				WebElement FareBreakup = QaBrowser.driver.findElement(By.xpath("(//a[@class='fare-brkp ng-binding'])[1]"));
				JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
				js2.executeScript("arguments[0].click()", FareBreakup);
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreakup</i></b>");
				Thread.sleep(5000);
				QaExtentReport.extentScreenshot("Fare Breakup");
				QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
				
				WebElement FareRules = QaBrowser.driver.findElement(By.xpath("(//a[@class='fare-rule ng-binding'])[1]"));
				JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
				js3.executeScript("arguments[0].click()", FareRules);
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareRules</i></b>");
				Thread.sleep(5000);
				QaExtentReport.extentScreenshot("Fare Rules");
				QaRobot.ScreenshotMethod("FareRules","<b><i>Screenshot for Fare Rules</i></b>");
				
				WebElement BaggegeInformation = QaBrowser.driver.findElement(By.xpath("(//a[@class='bgag-infrmtn ng-binding'])[1]"));
				JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
				js4.executeScript("arguments[0].click()", BaggegeInformation);
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on BaggegeInformation</i></b>");
				Thread.sleep(5000);
				QaExtentReport.extentScreenshot("Baggege Information");
				QaRobot.ScreenshotMethod("BaggegeInformation","<b><i>Screenshot for Baggege Information</i></b>");
				
				WebElement BookNow = QaBrowser.driver.findElement(By.xpath("(//input[@class='btn_smallyellow ng-scope'])[1]"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", BookNow);
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on BookNow</i></b>");
				Thread.sleep(30000);
			}
			else if(TripType.equalsIgnoreCase("RoundTrip"))
			{
				QaRobot.ClickOnElement("RDFareBreakup");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Fare Breakup");
				QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				QaRobot.ClickOnElement("RDFareBreakupClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Breakup Close</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow);
				
				QaRobot.ClickOnElement("RDRulesBaggage");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Rules Baggage</i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Rules Baggage");
				QaRobot.ScreenshotMethod("RulesBaggage","<b><i>Screenshot for Rules Baggage</i></b>");
				
				String ParentWindow1 = QaBrowser.driver.getWindowHandle();
				Set<String> handles1 = QaBrowser.driver.getWindowHandles();
				for (String childWindow1 : handles1) 
				{
					if (!childWindow1.equals(ParentWindow1))
						QaBrowser.driver.switchTo().window(childWindow1);
				}
				Thread.sleep(3000);
				
				QaRobot.ClickOnElement("RDBaggageInformation");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Baggage Information</i></b>");
				Thread.sleep(2000);
				QaExtentReport.extentScreenshot("Baggage Information");
				QaRobot.ScreenshotMethod("BaggageInformation","<b><i>Screenshot for Baggage Information</i></b>");
				
				QaRobot.ClickOnElement("RDRulesBaggageClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Rules Baggage Close</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow1);
				
				QaRobot.ClickOnElement("RDRFareBreakup");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Breakup</i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Fare Breakup");
				QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
				
				String ParentWindow2 = QaBrowser.driver.getWindowHandle();
				Set<String> handles2 = QaBrowser.driver.getWindowHandles();
				for (String childWindow2 : handles2) 
				{
					if (!childWindow2.equals(ParentWindow2))
						QaBrowser.driver.switchTo().window(childWindow2);
				}
				QaRobot.ClickOnElement("RDRFareBreakupClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Breakup Close</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow2);
				
				QaRobot.ClickOnElement("RDRRulesBaggage");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Rules Baggage</i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Rules Baggage");
				QaRobot.ScreenshotMethod("RulesBaggage","<b><i>Screenshot for Rules Baggage</i></b>");
				
				String ParentWindow3 = QaBrowser.driver.getWindowHandle();
				Set<String> handles3 = QaBrowser.driver.getWindowHandles();
				for (String childWindow3 : handles3) 
				{
					if (!childWindow3.equals(ParentWindow3))
						QaBrowser.driver.switchTo().window(childWindow3);
				}
				Thread.sleep(3000);
				
				QaRobot.ClickOnElement("RDRFareRules");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Rules</i></b>");
				Thread.sleep(2000);
				QaExtentReport.extentScreenshot("Fare Rules");
				QaRobot.ScreenshotMethod("FareRules","<b><i>Screenshot for Fare Rules</i></b>");
				
				QaRobot.ClickOnElement("RDRRulesBaggageClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Rules Baggage Close</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow);
				
				QaRobot.ClickOnElement("ContinueButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Continue Button</i></b>");
				Thread.sleep(50000);
			}
		}
		else if (Trip.equalsIgnoreCase("International"))
		{
			JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
			mo.executeScript("window.scrollBy(0,420)", "");
			Thread.sleep(3000);
			
			WebElement FlightItinerary = QaBrowser.driver.findElement(By.xpath("(//a[@class='flght-itnry ng-binding'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", FlightItinerary);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FlightItinerary</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("FlightItinerary");
			
			WebElement FareBreakup = QaBrowser.driver.findElement(By.xpath("(//a[@class='fare-brkp ng-binding'])[1]"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", FareBreakup);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreakup</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Fare Breakup");
			QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
			
			WebElement FareRules = QaBrowser.driver.findElement(By.xpath("(//a[@class='fare-rule ng-binding'])[1]"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", FareRules);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareRules</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Fare Rules");
			QaRobot.ScreenshotMethod("FareRules","<b><i>Screenshot for Fare Rules</i></b>");
			
			WebElement BaggegeInformation = QaBrowser.driver.findElement(By.xpath("(//a[@class='bgag-infrmtn ng-binding'])[1]"));
			JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
			js4.executeScript("arguments[0].click()", BaggegeInformation);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on BaggegeInformation</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Baggege Information");
			QaRobot.ScreenshotMethod("BaggegeInformation","<b><i>Screenshot for Baggege Information</i></b>");
			
			WebElement BookNow = QaBrowser.driver.findElement(By.xpath("(//input[@class='btn_smallyellow ng-scope'])[1]"));
			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
			js.executeScript("arguments[0].click()", BookNow);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on BookNow</i></b>");
			Thread.sleep(30000);
		}
		
		JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
		mo.executeScript("window.scrollBy(0,420)", "");
		
		QaRobot.ClickOnElement("FareBreakupF");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Checkout FareBreakup</i></b>");
		Thread.sleep(7000);
		QaExtentReport.extentScreenshot("Checkout FareBreakup");
		QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
		
		QaRobot.ClickOnElement("FareRulesF");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Checkout FareRules</i></b>");
		Thread.sleep(7000);
		QaExtentReport.extentScreenshot("Checkout FareRules");
		QaRobot.ScreenshotMethod("FareRules","<b><i>Screenshot for Fare Rules</i></b>");
		
		QaRobot.ClickOnElement("BaggegeInformationF");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Checkout BaggegeInformation</i></b>");
		Thread.sleep(7000);
		QaExtentReport.extentScreenshot("Baggege Information");
		QaRobot.ScreenshotMethod("BaggegeInformation","<b><i>Screenshot for Baggege Information</i></b>");
	}
	
	public static void ResultPageForHotel(String Usertype,String UserName,String Password,String Rooms,String ModifySearch,String ChangeTripLocation,String CityCodeM,String CityTitleM,
			String SearchHotelName,String HotelNameM,String ChangeTripDate,String CheckInDateM,String CheckOutDateM,String ChangeRooms,
			String RoomsM,String AdultM,String ChildM,String ChildAgeM,String ChangeCurrency,String CurrencyM,String ChangeStarRating,
			String StarRatingM) throws Exception
	{
		Thread.sleep(25000);
		
		String url = QaBrowser.driver.getCurrentUrl();
		String[] uid = url.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		String DateSelection[]= CheckInDateM.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		
		String DateSelection1[]= CheckOutDateM.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1= DateSelection1[0];
		
		if(ModifySearch.equalsIgnoreCase("Yes"))
		{
			QaRobot.ClickOnElement("ModifySearchMH");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modify Search</i></b>");
			
			if(ChangeTripLocation.equalsIgnoreCase("Yes"))
			{
				TestBase.listofautosuggestion5(By.xpath("//div[@id='ModifydivHTCity']/p"), CityCodeM, CityTitleM,By.xpath("//input[@id='txtHotelSearch']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Modified City Name : </i></b>"+CityCodeM+"-"+ CityTitleM);
				Thread.sleep(4000);
			}
			
			if(SearchHotelName.equalsIgnoreCase("Yes"))
			{
				QaRobot.PassValue("SearchHotelMH",HotelNameM);
				QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
			}
			
			if(ChangeTripDate.equalsIgnoreCase("Yes"))
			{
					QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[1]")).click();
					Thread.sleep(3000);
					
					selectDateInCalendarHotel(expDate,month,year,expDate1,month1,year1);
			}
			
			if(ChangeRooms.equalsIgnoreCase("Yes"))
			{
				int room=Integer.parseInt(RoomsM);
				String[] adultcount=AdultM.split(",");
				String[] childcount=ChildM.split(",");
				
				if(room>5)
				{
					throw new B2cExceptionClass("Invalid Number of Rooms provided "+" : "+room);
				}
				else
				{
					WebElement roomelement=QaBrowser.driver.findElement(By.xpath("//select[@id='HtlRooms']"));
					Select selectroom=new Select(roomelement);
					selectroom.selectByValue(RoomsM);
					Thread.sleep(2000);
					
					for(int i=1;i<=room;i++)
					{
						WebElement adultelement=QaBrowser.driver.findElement(By.xpath("//select[@id='htlsltadult"+i+"']"));
						Select selectadult=new Select(adultelement);
						selectadult.selectByValue(adultcount[i-1]);
						Thread.sleep(2000);
						
						WebElement childelement=QaBrowser.driver.findElement(By.xpath("//select[@id='HtlChildSlt"+i+"']"));
						Select selectchild=new Select(childelement);
						selectchild.selectByValue(childcount[i-1]);
						Thread.sleep(2000);
					}
					
					String[] ageofchild=ChildAgeM.split(",");
					for(String chd:childcount)
					{
						int chdcount=Integer.parseInt(chd);
						for(int i=1;i<=chdcount;i++)
						{
							String ac = ageofchild[i-1];
							int ac1 = Integer.parseInt(ac);
							
							if(ac1>17)
							{
								QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Age Selection</i></b>"+" : "+ac1);
								throw new B2cExceptionClass("Invalid Child Age Selection"+" : "+ac1);
							}
							else
							{
								WebElement childrenage=QaBrowser.driver.findElement(By.xpath("//select[@id='htl"+chdcount+"child"+i+"age']"));
								Select selectage=new Select(childrenage);
								selectage.selectByValue(ageofchild[i-1]);
								Thread.sleep(2000);
							}
						}
					} 
				}
			}
			
			if(ChangeCurrency.equalsIgnoreCase("Yes"))
			{
				QaRobot.selectValueFromDropdown("CurrencyMH", CurrencyM, "<b><i>Select Modified Currency for booking</i></b>");
				Thread.sleep(2000);
			}
			
			if(ChangeStarRating.equalsIgnoreCase("Yes"))
			{
				QaRobot.selectTextByLocator1("//select[@id='ddlstarRating']", StarRatingM, "<b><i>Select Star Rating for booking</i></b>");
				Thread.sleep(2000);
			}
			
			QaRobot.ClickOnElement("ModifiedSearchMH");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Search</i></b>");
		}
		Thread.sleep(10000);
		
		if(Usertype.equalsIgnoreCase("ResultPageLogIn"))
		{
			TestBase.listofautosuggestion2(By.xpath("//div[@id='divHTCity']/p"),HotelNameM,By.xpath("//input[@id='htlsearchhotel']"));
			
			QaRobot.ClickOnElement("SelectRoom");
			Thread.sleep(3000);
			String getT = QaBrowser.driver.findElement(By.xpath("//div[@id='nrm_box_1']/div[2]/label[1]/div[4]/p/span")).getText();
			System.out.println(getT);
			QaExtentReport.test.log(Status.INFO, "<b><i>Hotel Fare </i></b>"+getT);
			
			QaRobot.ClickOnElement("SignInMemberPrice");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Search</i></b>");
			
			QaRobot.PassValue("UsernameRL",UserName);
			QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
			
			QaRobot.PassValue("PasswordRL",Password);
			QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
			
			QaRobot.ClickOnElement("LogInRL");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Submit</i></b>");
			Thread.sleep(10000);
			
			TestBase.listofautosuggestion2(By.xpath("//div[@id='divHTCity']/p"),HotelNameM,By.xpath("//input[@id='htlsearchhotel']"));
		}
		Thread.sleep(5000);
		QaRobot.ClickOnElement("SelectRoom");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on SelectRoom</i></b>");
		Thread.sleep(3000);
		
		if(ModifySearch.equalsIgnoreCase("Yes"))
		{
			if (RoomsM.equalsIgnoreCase("1"))
			{
				String getT = QaBrowser.driver.findElement(By.xpath("//div[@id='nrm_box_1']/div[2]/label[1]/div[4]/p/span")).getText();
				System.out.println(getT);
				QaExtentReport.test.log(Status.INFO, "<b><i>Hotel Fare is </i></b>"+getT);
				
				QaRobot.ClickOnElement("CancellationPolicy");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicy</i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Cancellation Policy");
				QaRobot.ScreenshotMethod("CancellationPolicy","<b><i>Screenshot for Cancellation Policy</i></b>");
				
				String ParentWindow4 = QaBrowser.driver.getWindowHandle();
				Set<String> handles4 = QaBrowser.driver.getWindowHandles();
				for (String childWindow4 : handles4) 
				{
					if (!childWindow4.equals(ParentWindow4))
						QaBrowser.driver.switchTo().window(childWindow4);
				}
				
				QaRobot.ClickOnElement("CPClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicyClose</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow4);
				
				QaRobot.ClickOnElement("FareBreakup");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Fare Breakup");
				QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
				
				String ParentWindow5 = QaBrowser.driver.getWindowHandle();
				Set<String> handles5 = QaBrowser.driver.getWindowHandles();
				for (String childWindow5 : handles5) 
				{
					if (!childWindow5.equals(ParentWindow5))
						QaBrowser.driver.switchTo().window(childWindow5);
				}
				
				QaRobot.ClickOnElement("FareBreakupClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakupClose</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow5);
				
				QaRobot.ClickOnElement("Book");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
				Thread.sleep(20000);
			}
			else 
			{
				String getT = QaBrowser.driver.findElement(By.xpath("//div[@id='nrm_box_1']/div[2]/label[1]/div[3]/p/span")).getText();
				System.out.println(getT);
				QaExtentReport.test.log(Status.INFO, "<b><i>Hotel Fare is </i></b>"+getT);
				
				QaRobot.ClickOnElement("CancellationPolicy1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicy</i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Cancellation Policy");
				QaRobot.ScreenshotMethod("CancellationPolicy","<b><i>Screenshot for Cancellation Policy</i></b>");
				
				String ParentWindow4 = QaBrowser.driver.getWindowHandle();
				Set<String> handles4 = QaBrowser.driver.getWindowHandles();
				for (String childWindow4 : handles4) 
				{
					if (!childWindow4.equals(ParentWindow4))
						QaBrowser.driver.switchTo().window(childWindow4);
				}
				
				QaRobot.ClickOnElement("CPClose1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Cancellation Policy Close</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow4);
				
				QaRobot.ClickOnElement("FareBreakup1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Fare Breakup");
				QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
				
				String ParentWindow5 = QaBrowser.driver.getWindowHandle();
				Set<String> handles5 = QaBrowser.driver.getWindowHandles();
				for (String childWindow5 : handles5) 
				{
					if (!childWindow5.equals(ParentWindow5))
						QaBrowser.driver.switchTo().window(childWindow5);
				}
				
				QaRobot.ClickOnElement("FareBreakupClose1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup Close</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow5);
				
				QaRobot.ClickOnElement("Book1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
				Thread.sleep(20000);
			}
		}
		else
		{
			if (Rooms.equalsIgnoreCase("1"))
			{
				String getT = QaBrowser.driver.findElement(By.xpath("//div[@id='nrm_box_1']/div[2]/label[1]/div[4]/p/span")).getText();
				System.out.println(getT);
				QaExtentReport.test.log(Status.INFO, "<b><i>Hotel Fare is </i></b>"+getT);
				
				QaRobot.ClickOnElement("CancellationPolicy");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicy</i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Cancellation Policy");
				QaRobot.ScreenshotMethod("CancellationPolicy","<b><i>Screenshot for Cancellation Policy</i></b>");
				
				String ParentWindow4 = QaBrowser.driver.getWindowHandle();
				Set<String> handles4 = QaBrowser.driver.getWindowHandles();
				for (String childWindow4 : handles4) 
				{
					if (!childWindow4.equals(ParentWindow4))
						QaBrowser.driver.switchTo().window(childWindow4);
				}
				
				QaRobot.ClickOnElement("CPClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicyClose</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow4);
				
				QaRobot.ClickOnElement("FareBreakup");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Fare Breakup");
				QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
				
				String ParentWindow5 = QaBrowser.driver.getWindowHandle();
				Set<String> handles5 = QaBrowser.driver.getWindowHandles();
				for (String childWindow5 : handles5) 
				{
					if (!childWindow5.equals(ParentWindow5))
						QaBrowser.driver.switchTo().window(childWindow5);
				}
				
				QaRobot.ClickOnElement("FareBreakupClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakupClose</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow5);
				
				QaRobot.ClickOnElement("Book");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
				Thread.sleep(20000);
			}
			else 
			{
				String getT = QaBrowser.driver.findElement(By.xpath("//div[@id='nrm_box_1']/div[2]/label[1]/div[3]/p/span")).getText();
				System.out.println(getT);
				QaExtentReport.test.log(Status.INFO, "<b><i>Hotel Fare is </i></b>"+getT);
				
				QaRobot.ClickOnElement("CancellationPolicy1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicy</i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Cancellation Policy");
				QaRobot.ScreenshotMethod("CancellationPolicy","<b><i>Screenshot for Cancellation Policy</i></b>");
				
				String ParentWindow4 = QaBrowser.driver.getWindowHandle();
				Set<String> handles4 = QaBrowser.driver.getWindowHandles();
				for (String childWindow4 : handles4) 
				{
					if (!childWindow4.equals(ParentWindow4))
						QaBrowser.driver.switchTo().window(childWindow4);
				}
				
				QaRobot.ClickOnElement("CPClose1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Cancellation Policy Close</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow4);
				
				QaRobot.ClickOnElement("FareBreakup1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Fare Breakup");
				QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
				
				String ParentWindow5 = QaBrowser.driver.getWindowHandle();
				Set<String> handles5 = QaBrowser.driver.getWindowHandles();
				for (String childWindow5 : handles5) 
				{
					if (!childWindow5.equals(ParentWindow5))
						QaBrowser.driver.switchTo().window(childWindow5);
				}
				
				QaRobot.ClickOnElement("FareBreakupClose1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup Close</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow5);
				
				QaRobot.ClickOnElement("Book1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
				Thread.sleep(20000);
			}
		}
		QaExtentReport.extentScreenshot("Result Page");
		
		QaRobot.ClickOnElement("CFareBreakup");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Cancellation Policy</i></b>");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Cancellation Policy");
		QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
		
		String ParentWindow4 = QaBrowser.driver.getWindowHandle();
		Set<String> handles4 = QaBrowser.driver.getWindowHandles();
		for (String childWindow4 : handles4) 
		{
			if (!childWindow4.equals(ParentWindow4))
				QaBrowser.driver.switchTo().window(childWindow4);
		}
		
		QaRobot.ClickOnElement("CFareBreakupClose");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Cancellation Policy Close</i></b>");
		Thread.sleep(2000);
		QaBrowser.driver.switchTo().window(ParentWindow4);
		
		QaRobot.ClickOnElement("MoreDetails");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Fare Breakup");
		QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
		
		String ParentWindow5 = QaBrowser.driver.getWindowHandle();
		Set<String> handles5 = QaBrowser.driver.getWindowHandles();
		for (String childWindow5 : handles5) 
		{
			if (!childWindow5.equals(ParentWindow5))
				QaBrowser.driver.switchTo().window(childWindow5);
		}
		
		QaRobot.ClickOnElement("MoreDetailsClose");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Breakup Close</i></b>");
		Thread.sleep(2000);
		QaBrowser.driver.switchTo().window(ParentWindow5);
	}
	
	public static void ResultPageForFlight_Hotel(String Applyfilter,String StarRating,String PropertyType,String RateType,String ChooseAnotherFlight,
			String FlightFilter,String FareType,String AirLine) throws Exception
	{
		
		
		String url = QaBrowser.driver.getCurrentUrl();
		String[] uid = url.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		if(Applyfilter.equalsIgnoreCase("Yes"))
		{
			if(StarRating.equalsIgnoreCase("All"))
			{
				
			}
			else if(StarRating.equalsIgnoreCase("1 StarAndAbove"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			else if(StarRating.equalsIgnoreCase("2 StarAndAbove"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(StarRating.equalsIgnoreCase("3 StarAndAbove"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TwoStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Non Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(StarRating.equalsIgnoreCase("4 StarAndAbove"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TwoStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Non Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TreeStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(StarRating.equalsIgnoreCase("5 Star"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TwoStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Non Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TreeStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("FourStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(StarRating.equalsIgnoreCase("NotRatedStar"))
			{
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TwoStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Non Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TreeStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("FourStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("FiveStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			if(PropertyType.equalsIgnoreCase("All"))
			{
				
			}
			
			else if(PropertyType.equalsIgnoreCase("Hotel"))
			{
				QaRobot.ClickOnElement("Apartment");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(PropertyType.equalsIgnoreCase("Apartment"))
			{
				QaRobot.ClickOnElement("Hotel");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			if(RateType.equalsIgnoreCase("All"))
			{
				
			}
			
			else if(RateType.equalsIgnoreCase("RoomRate"))
			{
				QaRobot.ClickOnElement("PackageRate");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(RateType.equalsIgnoreCase("PackageRate"))
			{
				QaRobot.ClickOnElement("RoomRate");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
		}
		QaExtentReport.extentScreenshot("Apply filter");
		QaRobot.ScreenshotMethod("Applyfilter","<b><i>Screenshot for Apply filter</i></b>");
		
		if(ChooseAnotherFlight.equalsIgnoreCase("Yes"))
		{
			QaRobot.ClickOnElement("chooseAnotherFlight");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
			Thread.sleep(3000);
			
			if(FlightFilter.equalsIgnoreCase("Yes"))
			{
				if(FareType.equalsIgnoreCase("All"))
				{
					QaRobot.ClickOnElement("RefundableFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
					Thread.sleep(3000);
					
					QaRobot.ClickOnElement("NonRefundableFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Non Refundable</i></b>");
					Thread.sleep(3000);
				}
				else if(FareType.equalsIgnoreCase("Refundable"))
				{
					QaRobot.ClickOnElement("RefundableFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
					Thread.sleep(3000);
				}
				else if(FareType.equalsIgnoreCase("Non-Refundable"))
				{
					QaRobot.ClickOnElement("NonRefundableFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Non Refundable</i></b>");
					Thread.sleep(3000);
				}
				
				List<WebElement> listOfAirLine = QaBrowser.driver.findElements(By.xpath("//div[@id='tdContainerTblAirlines']//li//span"));
				
				for (WebElement autoAirline : listOfAirLine) 
				  {
					if (autoAirline.getText().equalsIgnoreCase(AirLine)) 
					{
						autoAirline.click();
						break;
					} 
					else 
					{
						
					}
				  }
			}
			QaExtentReport.extentScreenshot("Flight filter");
			QaRobot.ScreenshotMethod("FlightFilter","<b><i>Screenshot for Flight Filter</i></b>");
			
			WebElement FareRules = QaBrowser.driver.findElement(By.xpath("(//a[contains(@title,'Fare Rules')])[1]"));
			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
			js.executeScript("arguments[0].click()", FareRules);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareRules</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Fare Rules");
			QaRobot.ScreenshotMethod("FareRules","<b><i>Screenshot for Fare Rules</i></b>");
			
			String ParentWindow = QaBrowser.driver.getWindowHandle();
			Set<String> handles = QaBrowser.driver.getWindowHandles();
			for (String childWindow : handles) 
			{
				if (!childWindow.equals(ParentWindow))
					QaBrowser.driver.switchTo().window(childWindow);
			}
			
			QaRobot.ClickOnElement("FRBClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Rules Close</i></b>");
			Thread.sleep(2000);
			QaBrowser.driver.switchTo().window(ParentWindow);
			
			WebElement BaggegeInformation = QaBrowser.driver.findElement(By.xpath("(//a[@id='BaggageDetails_1'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", BaggegeInformation);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Baggege Information</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Baggege Information");
			QaRobot.ScreenshotMethod("BaggegeInformation","<b><i>Screenshot for Baggege Information</i></b>");
			
			String ParentWindow1 = QaBrowser.driver.getWindowHandle();
			Set<String> handles1 = QaBrowser.driver.getWindowHandles();
			for (String childWindow1 : handles1) 
			{
				if (!childWindow1.equals(ParentWindow1))
					QaBrowser.driver.switchTo().window(childWindow1);
			}
			
			QaRobot.ClickOnElement("FRBClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Baggege Information Close</i></b>");
			Thread.sleep(2000);
			QaBrowser.driver.switchTo().window(ParentWindow1);
			
			WebElement MoreDetails = QaBrowser.driver.findElement(By.xpath("(//a[@id='fl_1'])[1]"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", MoreDetails);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("More Details");
			QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
			
			WebElement BookNow = QaBrowser.driver.findElement(By.xpath("(//input[contains(@id,'Anchor_01UAP')])[1]"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", BookNow);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Book Flight</i></b>");
			Thread.sleep(50000);
		}
		
		else if(ChooseAnotherFlight.equalsIgnoreCase("No"))
		{
			QaRobot.ClickOnElement("FlightFareRule");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Rules</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Flight Fare Rule");
			QaRobot.ScreenshotMethod("FlightFareRule","<b><i>Screenshot for Flight Fare Rule</i></b>");
			
			QaRobot.ClickOnElement("FRBClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Rules Close</i></b>");
			Thread.sleep(2000);
			
			QaRobot.ClickOnElement("BaggegeDetails");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Baggege Information</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Baggege Information");
			QaRobot.ScreenshotMethod("BaggegeDetails","<b><i>Screenshot for Baggege Details</i></b>");
			
			QaRobot.ClickOnElement("FRBClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Baggege Information Close</i></b>");
			Thread.sleep(2000);
		}
		
		QaRobot.ClickOnElement("FHSelectRoom");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Select Room</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ClickOnElement("RoomCancellationPolicy");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Room Cancellation Policy</i></b>");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Cancellation Policy");
		QaRobot.ScreenshotMethod("RoomCancellationPolicy","<b><i>Screenshot for Room Cancellation Policy</i></b>");
		
		QaRobot.ClickOnElement("RoomCancellationPolicyClose");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Room Cancellation Policy Close</i></b>");
		Thread.sleep(2000);
		
		QaRobot.ClickOnElement("FHBook");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
		Thread.sleep(15000);
	}
	
	public static void selectDateInCalendarHotel(String Day,String Month,String Year,String Day1,String Month1,String Year1) throws InterruptedException, ParseException
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);
		
		String currentMonthNumber ="00";
		 if (Month.equalsIgnoreCase("Jan")) {
          currentMonthNumber = "01";
      } else if (Month.equalsIgnoreCase("Feb")) {
          currentMonthNumber = "02";
      } else if (Month.equalsIgnoreCase("Mar")) {
          currentMonthNumber = "03";
      } else if (Month.equalsIgnoreCase("Apr")) {
          currentMonthNumber = "04";
      } else if (Month.equalsIgnoreCase("May")) {
          currentMonthNumber = "05";
      } else if (Month.equalsIgnoreCase("Jun")) {
          currentMonthNumber = "06";
      } else if (Month.equalsIgnoreCase("Jul")) {
          currentMonthNumber = "07";
      } else if (Month.equalsIgnoreCase("Aug")) {
          currentMonthNumber = "08";
      } else if (Month.equalsIgnoreCase("Sep")) {
          currentMonthNumber = "09";
      } else if (Month.equalsIgnoreCase("Oct")) {
          currentMonthNumber = "10";
      } else if (Month.equalsIgnoreCase("Nov")) {
          currentMonthNumber = "11";
      } else if (Month.equalsIgnoreCase("Dec")) {
          currentMonthNumber = "12";
      }
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
		System.out.println(date2);
		
		String currentMonthNumber1 ="00";
		 if (Month1.equalsIgnoreCase("Jan")) {
         currentMonthNumber1 = "01";
     } else if (Month1.equalsIgnoreCase("Feb")) {
         currentMonthNumber1 = "02";
     } else if (Month1.equalsIgnoreCase("Mar")) {
         currentMonthNumber1 = "03";
     } else if (Month1.equalsIgnoreCase("Apr")) {
         currentMonthNumber1 = "04";
     } else if (Month1.equalsIgnoreCase("May")) {
         currentMonthNumber1 = "05";
     } else if (Month1.equalsIgnoreCase("Jun")) {
         currentMonthNumber1 = "06";
     } else if (Month1.equalsIgnoreCase("Jul")) {
         currentMonthNumber1 = "07";
     } else if (Month1.equalsIgnoreCase("Aug")) {
         currentMonthNumber1 = "08";
     } else if (Month1.equalsIgnoreCase("Sep")) {
         currentMonthNumber1 = "09";
     } else if (Month1.equalsIgnoreCase("Oct")) {
         currentMonthNumber1 = "10";
     } else if (Month1.equalsIgnoreCase("Nov")) {
         currentMonthNumber1 = "11";
     } else if (Month1.equalsIgnoreCase("Dec")) {
         currentMonthNumber1 = "12";
     }
		
		Date date3 = d.parse(Day1+"-"+Integer.parseInt(currentMonthNumber1)+"-"+Year1);
		System.out.println(date3);
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Check In Date  </i></b>"+Day+"-"+Month+"-"+Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Check Out Date  </i></b>"+Day1+"-"+Month1+"-"+Year1);
		
		if(Integer.parseInt(Day)>31)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day)>28)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Integer.parseInt(Day1)>31)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new B2cExceptionClass("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day1)>28)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new B2cExceptionClass("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		Thread.sleep(3000);
		String monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		
		String month = monthYear.split(" ")[0];
		
		String currentMonthNumber2 ="00";
		 if (month.equalsIgnoreCase("Jan")) {
			 currentMonthNumber2 = "01";
   } else if (month.equalsIgnoreCase("Feb")) {
 	  currentMonthNumber2 = "02";
   } else if (month.equalsIgnoreCase("Mar")) {
 	  currentMonthNumber2 = "03";
   } else if (month.equalsIgnoreCase("Apr")) {
 	  currentMonthNumber2 = "04";
   } else if (month.equalsIgnoreCase("May")) {
 	  currentMonthNumber2 = "05";
   } else if (month.equalsIgnoreCase("Jun")) {
 	  currentMonthNumber2 = "06";
   } else if (month.equalsIgnoreCase("Jul")) {
 	  currentMonthNumber2 = "07";
   } else if (month.equalsIgnoreCase("Aug")) {
 	  currentMonthNumber2 = "08";
   } else if (month.equalsIgnoreCase("Sep")) {
 	  currentMonthNumber2 = "09";
   } else if (month.equalsIgnoreCase("Oct")) {
 	  currentMonthNumber2 = "10";
   } else if (month.equalsIgnoreCase("Nov")) {
 	  currentMonthNumber2 = "11";
   } else if (month.equalsIgnoreCase("Dec")) {
 	  currentMonthNumber2 = "12";
   }
		String year = monthYear.split(" ")[1];
		
		if(date2.before(date1))
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		else
		{
			if(Integer.parseInt(currentMonthNumber)<Integer.parseInt(currentMonthNumber2)&& year.equals(Year))
			{
				while(!(month.equals(Month) && year.equals(Year)))
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[1]")).click();
					
					monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
					
					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}
			else
			{
				while(!(month.equals(Month) && year.equals(Year)))
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
					
					monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
					
					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}
			
				List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
				
				for(WebElement ele : allDates)
				{
					String dt = ele.getText();
					
					if(dt.equalsIgnoreCase(Day))
					{
						ele.click();
						break;
					}
				}
				
				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[2]")).click();
				Thread.sleep(3000);
				
				String monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
				
				String month1 = monthYear1.split(" ")[0];
				
				String currentMonthNumber3 ="00";
				 if (month1.equalsIgnoreCase("Jan")) {
					 currentMonthNumber3 = "01";
		    } else if (month1.equalsIgnoreCase("Feb")) {
		    	currentMonthNumber3 = "02";
		    } else if (month1.equalsIgnoreCase("Mar")) {
		    	currentMonthNumber3 = "03";
		    } else if (month1.equalsIgnoreCase("Apr")) {
		    	currentMonthNumber3 = "04";
		    } else if (month1.equalsIgnoreCase("May")) {
		    	currentMonthNumber3 = "05";
		    } else if (month1.equalsIgnoreCase("Jun")) {
		    	currentMonthNumber3 = "06";
		    } else if (month1.equalsIgnoreCase("Jul")) {
		    	currentMonthNumber3 = "07";
		    } else if (month1.equalsIgnoreCase("Aug")) {
		    	currentMonthNumber3 = "08";
		    } else if (month1.equalsIgnoreCase("Sep")) {
		    	currentMonthNumber3 = "09";
		    } else if (month1.equalsIgnoreCase("Oct")) {
		    	currentMonthNumber3 = "10";
		    } else if (month1.equalsIgnoreCase("Nov")) {
		    	currentMonthNumber3 = "11";
		    } else if (month1.equalsIgnoreCase("Dec")) {
		    	currentMonthNumber3 = "12";
		    }
				String year1 = monthYear1.split(" ")[1];
				
				if(date3.before(date2))
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Check out date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
					throw new B2cExceptionClass("Invalid Check out date provided "+Day1+"-"+Month1+"-"+Year1);
				}
				else
				{
					if(Integer.parseInt(currentMonthNumber)<Integer.parseInt(currentMonthNumber3)&& year.equals(Year))
					{
						while(!(month1.equals(Month1) && year1.equals(Year1)))
						{
							QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[1]")).click();
							
							monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
							
							month1 = monthYear1.split(" ")[0];
							year1 = monthYear1.split(" ")[1];
						}
					}
					else
					{
						while(!(month1.equals(Month1) && year1.equals(Year1)))
						{
							QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
							
							monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
							
							month1 = monthYear1.split(" ")[0];
							year1 = monthYear1.split(" ")[1];
						}
					}
					
						List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
						
						for(WebElement ele1 : allDates1)
						{
							String dt1 = ele1.getText();
							
							if(dt1.equalsIgnoreCase(Day1))
							{
								ele1.click();
								break;
							}
						}
				}
		}
	  }
}



























