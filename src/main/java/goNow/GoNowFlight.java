package goNow;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class GoNowFlight
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("goNowFlight", "Sheet1");
	}
	
	@Test(dataProvider = "getexceldata")
	public static void v12Stagingforflight (String UserType,String Source,String URL,String Username,String Password,String TripType,String Trip,String OriginCityCode,
			String OriginLocation,String DestinationCityCode,String DestinationLocation,String DDate,String RDate,String adult,String child,String infant,
			String MoreOptions,String Currency,String Class,String PANumber,String PreferredAirlineSelect,String ShowDirectFlight,
			String Applyfilter,String FareType,String AirLine,String AdultTitle,String AdultName,String AdultDate,String AdultEmailAddress,
			String PhoneNumber,String AdultPassportNumber, String AdultPassportcountry,String AdultExpiryDate,String AdultNationality,String ChildTitle,String ChildName,
			String ChildPassportNumber,String ChildPassportcountry,String ChildPassportDate,String ChildNationality, String ChildDOBdate,String InfantTitle,String InfantName,
			String InfantDOBdate,String InfantTravellingwith,String InfantPassportNumber,String InfantPassportcountry,String InfantPassportDate,String InfantNationality,
			String CardType,String CreditCardNumber,String CardHolderName,String CardExpiryDate,String CVV,String BillingState,String CardCity) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on Booking For Flight");
	
		if (UserType.equalsIgnoreCase("LogIn"))
		{
			QaRobot.ClickOnElement("LogIn");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on SignIn</i></b>");
			
			QaRobot.PassValue("User_name",Username);
			QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
			
			QaRobot.PassValue("Password",Password);
			QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
			
			QaRobot.ClickOnElement("Submit");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Submit</i></b>");
			
			QaRobot.ClickOnElement("Flights");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Flights</i></b>");
			
			GoNowTripType.flightTriptype(TripType,Trip,OriginCityCode,OriginLocation,DestinationCityCode,DestinationLocation,DDate,RDate,adult,child,infant,MoreOptions,Currency,Class,
					PANumber,PreferredAirlineSelect,ShowDirectFlight);
			
			GoNowResultPage.ResultPageForFlight(TripType,Applyfilter,FareType,AirLine,Trip);
		}
		
		else if (UserType.equalsIgnoreCase("Guest"))
		{
			QaRobot.ClickOnElement("Flights");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Flight</i></b>");
			
			GoNowTripType.flightTriptype(TripType,Trip,OriginCityCode,OriginLocation,DestinationCityCode,DestinationLocation,DDate,RDate,adult,child,infant,MoreOptions,Currency,Class,
					PANumber,PreferredAirlineSelect,ShowDirectFlight);
			
			GoNowResultPage.ResultPageForFlight(TripType,Applyfilter,FareType,AirLine,Trip);
			
			GoNowCheckoutPage.GuestAdultCheckoutForFlight(adult,AdultTitle,AdultName,AdultDate,AdultEmailAddress,PhoneNumber,AdultPassportNumber,AdultPassportcountry,AdultExpiryDate,AdultNationality);
			
			GoNowCheckoutPage.GuestChildCheckoutForFlight(child,ChildTitle,ChildName,ChildPassportNumber,ChildPassportcountry,ChildPassportDate,ChildNationality,ChildDOBdate);
			
			GoNowCheckoutPage.GuestInfantCheckoutForFlight(infant,InfantTitle,InfantName,InfantDOBdate,InfantTravellingwith,InfantPassportNumber,InfantPassportcountry,InfantPassportDate,InfantNationality);
		
			QaRobot.ClickOnElement("confirmButton");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on confirm Button</i></b>");
			Thread.sleep(30000);
			
			GoNowPaymentPage.cardPayment(CardType,CreditCardNumber,CardHolderName,CardExpiryDate,CVV,BillingState,CardCity);
			Thread.sleep(30000);
			
			GoNowConfirmPage.confirmpageFlight();
		}
	}	
	
	@AfterMethod
	public static void afterMetod()
	{
		QaExtentReport.test.getExtent().flush();
	}
}
