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
		return QaDataProvider.getTestdata("goNowFlight", "TestCases");
	}
	
	@Test(dataProvider = "getexceldata")
	public static void v12Stagingforflight (String TestCaseId,String TestCaseType,String TestScenario,String UserType,String Source,String URL,String Username,String Password,String TripType,String Trip,String OriginCityCode,
			String OriginLocation,String DestinationCityCode,String DestinationLocation,String DDate,String RDate,String adult,String child,String infant,
			String MoreOptions,String Currency,String Class,String PANumber,String PreferredAirlineSelect,String ShowDirectFlight,
			String Applyfilter,String FareType,String AirLine,String AdultTitle,String AdultName,String AdultDate,String AdultEmailAddress,
			String PhoneNumber,String AdultPassportNumber, String AdultPassportcountry,String AdultExpiryDate,String AdultNationality,String ChildTitle,String ChildName,
			String ChildPassportNumber,String ChildPassportcountry,String ChildPassportDate,String ChildNationality, String ChildDOBdate,String InfantTitle,String InfantName,
			String InfantDOBdate,String InfantTravellingwith,String InfantPassportNumber,String InfantPassportcountry,String InfantPassportDate,String InfantNationality,
			String CardType,String CreditCardNumber,String CardHolderName,String CardExpiryDate,String CVV,String BillingTitle,String BillingName,String Bemail,
			String BAddress,String BillingState,String CardCity,String ZipCode) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId);
	
		if (UserType.equalsIgnoreCase("HomeLogIn"))
		{
			QaRobot.PassValue("User_name",Username);
			QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
			
			QaRobot.PassValue("Password",Password);
			QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
			
			QaExtentReport.extentScreenshot("LogIn Page");
			
			QaRobot.ClickOnElement("Submit");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Submit</i></b>");
			Thread.sleep(10000);
			
			GoNowFlight.trip1(TripType, Trip, OriginCityCode, OriginLocation, DestinationCityCode, DestinationLocation, DDate, RDate,adult,child,
			infant,MoreOptions, Currency, Class, PANumber, PreferredAirlineSelect, ShowDirectFlight, PhoneNumber,AdultPassportNumber, Applyfilter,
			FareType, AirLine);
			
			GoNowFlight.trip2(adult,child,infant,PhoneNumber,AdultPassportNumber,AdultTitle,AdultName, AdultDate,AdultEmailAddress,AdultPassportcountry,
			AdultExpiryDate,AdultNationality,ChildTitle,ChildName,ChildPassportNumber,ChildPassportcountry,ChildPassportDate,ChildNationality,
			ChildDOBdate,InfantTitle,InfantName,InfantDOBdate,InfantTravellingwith,InfantPassportNumber,InfantPassportcountry,InfantPassportDate,
			InfantNationality,CardType,CreditCardNumber,CardHolderName,CardExpiryDate,CVV,BillingTitle,BillingName,Bemail,BAddress,BillingState,
			CardCity,ZipCode);
		}
		
		else if (UserType.equalsIgnoreCase("Guest"))
		{
			Thread.sleep(3000);
			QaRobot.ClickOnElement("CancelLogIn");
			
			GoNowFlight.trip1(TripType, Trip, OriginCityCode, OriginLocation, DestinationCityCode, DestinationLocation, DDate, RDate,adult,child,
			infant,MoreOptions, Currency, Class, PANumber, PreferredAirlineSelect, ShowDirectFlight, PhoneNumber,AdultPassportNumber, Applyfilter,
			FareType, AirLine);
					
			GoNowFlight.trip3(adult,child,infant,PhoneNumber,AdultPassportNumber,AdultTitle,AdultName, AdultDate,AdultEmailAddress,AdultPassportcountry,
			AdultExpiryDate,AdultNationality,ChildTitle,ChildName,ChildPassportNumber,ChildPassportcountry,ChildPassportDate,ChildNationality,
			ChildDOBdate,InfantTitle,InfantName,InfantDOBdate,InfantTravellingwith,InfantPassportNumber,InfantPassportcountry,InfantPassportDate,
			InfantNationality,CardType,CreditCardNumber,CardHolderName,CardExpiryDate,CVV,BillingTitle,BillingName,Bemail,BAddress,BillingState,
			CardCity,ZipCode);
		}
		
		else
		{
			Thread.sleep(3000);
			QaRobot.ClickOnElement("CancelLogIn");
			
			GoNowFlight.trip1(TripType, Trip, OriginCityCode, OriginLocation, DestinationCityCode, DestinationLocation, DDate, RDate,adult,child,
			infant,MoreOptions, Currency, Class, PANumber, PreferredAirlineSelect, ShowDirectFlight, PhoneNumber,AdultPassportNumber, Applyfilter,
			FareType, AirLine);
			
			if(UserType.equalsIgnoreCase("CheckoutPageLogIn"))
			{
				QaRobot.ClickOnElement("CLogInF");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on SignIn</i></b>");
				
				QaRobot.PassValue("CUser_nameF",Username);
				QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
				
				QaRobot.PassValue("CPasswordF",Password);
				QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
				
				QaExtentReport.extentScreenshot("Checkout LogIn Page");
				
				QaRobot.ClickOnElement("CSubmitF");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Submit</i></b>");
				Thread.sleep(5000);
				
				GoNowFlight.trip4(adult,child,infant,PhoneNumber,AdultPassportNumber,AdultTitle,AdultName, AdultDate,AdultEmailAddress,AdultPassportcountry,
				AdultExpiryDate,AdultNationality,ChildTitle,ChildName,ChildPassportNumber,ChildPassportcountry,ChildPassportDate,ChildNationality,
				ChildDOBdate,InfantTitle,InfantName,InfantDOBdate,InfantTravellingwith,InfantPassportNumber,InfantPassportcountry,InfantPassportDate,
				InfantNationality,CardType,CreditCardNumber,CardHolderName,CardExpiryDate,CVV,BillingTitle,BillingName,Bemail,BAddress,BillingState,
				CardCity,ZipCode);
			}
		}
	}
	
	@AfterMethod
	public static void afterMetod()
	{
		QaExtentReport.test.getExtent().flush();
	}
	
	public static void trip1(String TripType,String Trip,String OriginCityCode,String OriginLocation,String DestinationCityCode,
			String DestinationLocation,String DDate,String RDate,String adult,String child,String infant,String MoreOptions,String Currency,
			String Class,String PANumber,String PreferredAirlineSelect,String ShowDirectFlight,String PhoneNumber,String AdultPassportNumber,
			String Applyfilter,String FareType,String AirLine) throws Exception
	{
		QaRobot.ClickOnElement("Flights");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Flight</i></b>");
		
		GoNowTripType.flightTriptype(TripType,Trip,OriginCityCode,OriginLocation,DestinationCityCode,DestinationLocation,DDate,RDate,adult,child,infant,MoreOptions,Currency,Class,
				PANumber,PreferredAirlineSelect,ShowDirectFlight);
		
		GoNowResultPage.ResultPageForFlight(TripType,Applyfilter,FareType,AirLine,Trip);
	}
	
	public static void trip2(String adult,String child,String infant,String PhoneNumber,String AdultPassportNumber,String AdultTitle,String AdultName,String AdultDate,String AdultEmailAddress,
			String AdultPassportcountry,String AdultExpiryDate,String AdultNationality,String ChildTitle,String ChildName,String ChildPassportNumber,
			String ChildPassportcountry,String ChildPassportDate,String ChildNationality, String ChildDOBdate,String InfantTitle,String InfantName,
			String InfantDOBdate,String InfantTravellingwith,String InfantPassportNumber,String InfantPassportcountry,String InfantPassportDate,
			String InfantNationality,String CardType,String CreditCardNumber,String CardHolderName,String CardExpiryDate,String CVV,String BillingTitle,
			String BillingName,String Bemail,String BAddress,String BillingState,String CardCity,String ZipCode) throws Exception
	{
		GoNowCheckoutPage.adultCheckoutForFlight(adult,AdultTitle,AdultName,AdultDate,AdultEmailAddress,PhoneNumber,AdultPassportNumber,AdultPassportcountry,AdultExpiryDate,AdultNationality);
		
		GoNowCheckoutPage.GuestChildCheckoutForFlight(child,ChildTitle,ChildName,ChildPassportNumber,ChildPassportcountry,ChildPassportDate,ChildNationality,ChildDOBdate);
		
		GoNowCheckoutPage.GuestInfantCheckoutForFlight(infant,InfantTitle,InfantName,InfantDOBdate,InfantTravellingwith,InfantPassportNumber,InfantPassportcountry,InfantPassportDate,InfantNationality);
	
		QaRobot.ClickOnElement("confirmButton");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on confirm Button</i></b>");
		Thread.sleep(30000);
		
		GoNowPaymentPage.cardPayment(CardType,CreditCardNumber,CardHolderName,CardExpiryDate,CVV);
		
		GoNowPaymentPage.billingDetails(BillingTitle, BillingName, Bemail, BAddress, BillingState, CardCity, ZipCode);
		Thread.sleep(30000);
		
		GoNowConfirmPage.confirmpageFlight();
	}
	
	public static void trip3(String adult,String child,String infant,String PhoneNumber,String AdultPassportNumber,String AdultTitle,String AdultName,String AdultDate,String AdultEmailAddress,
			String AdultPassportcountry,String AdultExpiryDate,String AdultNationality,String ChildTitle,String ChildName,String ChildPassportNumber,
			String ChildPassportcountry,String ChildPassportDate,String ChildNationality, String ChildDOBdate,String InfantTitle,String InfantName,
			String InfantDOBdate,String InfantTravellingwith,String InfantPassportNumber,String InfantPassportcountry,String InfantPassportDate,
			String InfantNationality,String CardType,String CreditCardNumber,String CardHolderName,String CardExpiryDate,String CVV,String BillingTitle,
			String BillingName,String Bemail,String BAddress,String BillingState,String CardCity,String ZipCode) throws Exception
	{
		GoNowCheckoutPage.adultCheckoutForFlight(adult,AdultTitle,AdultName,AdultDate,AdultEmailAddress,PhoneNumber,AdultPassportNumber,AdultPassportcountry,AdultExpiryDate,AdultNationality);
		
		GoNowCheckoutPage.GuestChildCheckoutForFlight(child,ChildTitle,ChildName,ChildPassportNumber,ChildPassportcountry,ChildPassportDate,ChildNationality,ChildDOBdate);
		
		GoNowCheckoutPage.GuestInfantCheckoutForFlight(infant,InfantTitle,InfantName,InfantDOBdate,InfantTravellingwith,InfantPassportNumber,InfantPassportcountry,InfantPassportDate,InfantNationality);
	
		QaRobot.ClickOnElement("confirmButton");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on confirm Button</i></b>");
		Thread.sleep(30000);
		
		GoNowPaymentPage.cardPayment(CardType,CreditCardNumber,CardHolderName,CardExpiryDate,CVV);

		GoNowPaymentPage.billingDetailsForguest(BillingTitle,BillingState, CardCity);
		Thread.sleep(30000);
		
		GoNowConfirmPage.confirmpageFlight();
	}
	
	public static void trip4(String adult,String child,String infant,String PhoneNumber,String AdultPassportNumber,String AdultTitle,String AdultName,String AdultDate,String AdultEmailAddress,
			String AdultPassportcountry,String AdultExpiryDate,String AdultNationality,String ChildTitle,String ChildName,String ChildPassportNumber,
			String ChildPassportcountry,String ChildPassportDate,String ChildNationality, String ChildDOBdate,String InfantTitle,String InfantName,
			String InfantDOBdate,String InfantTravellingwith,String InfantPassportNumber,String InfantPassportcountry,String InfantPassportDate,
			String InfantNationality,String CardType,String CreditCardNumber,String CardHolderName,String CardExpiryDate,String CVV,String BillingTitle,
			String BillingName,String Bemail,String BAddress,String BillingState,String CardCity,String ZipCode) throws Exception
	{
		GoNowCheckoutPage.adultCheckoutLogInForFlight(adult,AdultTitle,AdultName,AdultDate,AdultEmailAddress,PhoneNumber,AdultPassportNumber,AdultPassportcountry,AdultExpiryDate,AdultNationality);
		
		GoNowCheckoutPage.GuestChildCheckoutForFlight(child,ChildTitle,ChildName,ChildPassportNumber,ChildPassportcountry,ChildPassportDate,ChildNationality,ChildDOBdate);
		
		GoNowCheckoutPage.GuestInfantCheckoutForFlight(infant,InfantTitle,InfantName,InfantDOBdate,InfantTravellingwith,InfantPassportNumber,InfantPassportcountry,InfantPassportDate,InfantNationality);
	
		QaRobot.ClickOnElement("confirmButton");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on confirm Button</i></b>");
		Thread.sleep(30000);
		
		GoNowPaymentPage.cardPayment(CardType,CreditCardNumber,CardHolderName,CardExpiryDate,CVV);

		GoNowPaymentPage.billingDetailsForCheckoutPage(BillingTitle, BAddress, BillingState, CardCity, ZipCode);
		Thread.sleep(30000);
		
		GoNowConfirmPage.confirmpageFlight();
	}
}
