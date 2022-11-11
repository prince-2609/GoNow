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
public class GoNowHotel 
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("goNowHotel","Sheet2");
	}
	
	@Test(dataProvider = "getexceldata")

	public static void v12stagingforhotel(String TestCaseId,String TestCaseType,String TestScenario,String Usertype, String Source, String URL,String UserName,String Password,String CityCode,String CityTitle, 
			String CheckInDate,String CheckOutDate,String Rooms,String Adult,String Child,String ChildAge,String MoreOptions,String Nationality,String Currency,String StarRating,
			String ModifySearch,String ChangeTripLocation,String CityCodeM,String CityTitleM,String SearchHotelName,String HotelNameM,String ChangeTripDate,String CheckInDateM,
			String CheckOutDateM,String ChangeRooms,String RoomsM,String AdultM,String ChildM,String ChildAgeM,String ChangeCurrency,
			String CurrencyM,String ChangeStarRating,String StarRatingM,String Emailid,String AdultTitle,String AdultName,String Phone,String ChildTitle, String ChildName,String ChildDOBdate,String ChildDOBdateM,String Cardtype,String CardNumber,
			String CardName,String CardDate,String CVV,String BillingTitle,String BillingUserName,String BillingAddress,String BillingCountry,String BillingCity) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId);
		
		if(Usertype.equalsIgnoreCase("HomeLogin"))
		{
			QaRobot.ClickOnElement("LogIn");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
			
			QaRobot.PassValue("User_name",UserName);
			QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
			
			QaRobot.PassValue("Password",Password);
			QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
			
			QaExtentReport.extentScreenshot("LogIn Page");
			
			QaRobot.ClickOnElement("Submit");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
			Thread.sleep(5000);
			
			GoNowHotel.trip1( Usertype,UserName, Password,CityCode, CityTitle,  CheckInDate, CheckOutDate, Rooms, Adult,Child, ChildAge, MoreOptions, 
					Nationality, Currency, StarRating, ModifySearch,ChangeTripLocation, CityCodeM, CityTitleM, SearchHotelName,
					HotelNameM, ChangeTripDate, CheckInDateM, CheckOutDateM,ChangeRooms, RoomsM, AdultM, ChildM, ChildAgeM,
					ChangeCurrency, CurrencyM,ChangeStarRating, StarRatingM);
			
			GoNowHotel.trip2(Adult, Child,ModifySearch,AdultM,ChildM, Emailid, AdultTitle, AdultName, Phone, ChildTitle, ChildName,
			ChildDOBdate,ChildDOBdateM,Cardtype,CardNumber, CardName, CardDate, CVV, BillingTitle, BillingUserName, BillingAddress,
			BillingCountry, BillingCity);
		}
		
		else if (Usertype.equalsIgnoreCase("Guest"))
		{
			Thread.sleep(3000);
			QaRobot.ClickOnElement("CancelLogIn");
			
			GoNowHotel.trip1( Usertype,UserName, Password, CityCode, CityTitle,  CheckInDate, CheckOutDate, Rooms, Adult,Child, ChildAge, MoreOptions, 
					Nationality, Currency, StarRating, ModifySearch,ChangeTripLocation, CityCodeM, CityTitleM, SearchHotelName,
					HotelNameM, ChangeTripDate, CheckInDateM, CheckOutDateM,ChangeRooms, RoomsM, AdultM, ChildM, ChildAgeM,
					ChangeCurrency, CurrencyM,ChangeStarRating, StarRatingM);
			
			GoNowHotel.trip2(Adult, Child,ModifySearch,AdultM,ChildM, Emailid, AdultTitle, AdultName, Phone, ChildTitle, ChildName,
			ChildDOBdate,ChildDOBdateM,Cardtype,CardNumber, CardName, CardDate, CVV, BillingTitle, BillingUserName, BillingAddress,
			BillingCountry, BillingCity);
		}
		
		else if (Usertype.equalsIgnoreCase("ResultPageLogIn"))
		{
			Thread.sleep(3000);
			QaRobot.ClickOnElement("CancelLogIn");
			
			GoNowHotel.trip1( Usertype,UserName, Password,CityCode, CityTitle,  CheckInDate, CheckOutDate, Rooms, Adult,Child, ChildAge, MoreOptions, 
					Nationality, Currency, StarRating, ModifySearch,ChangeTripLocation, CityCodeM, CityTitleM, SearchHotelName,
					HotelNameM, ChangeTripDate, CheckInDateM, CheckOutDateM,ChangeRooms, RoomsM, AdultM, ChildM, ChildAgeM,
					ChangeCurrency, CurrencyM,ChangeStarRating, StarRatingM);
			
			GoNowHotel.trip2(Adult, Child,ModifySearch,AdultM,ChildM, Emailid, AdultTitle, AdultName, Phone, ChildTitle, ChildName,
			ChildDOBdate,ChildDOBdateM,Cardtype,CardNumber, CardName, CardDate, CVV, BillingTitle, BillingUserName, BillingAddress,
			BillingCountry, BillingCity);
		}
		else
		{
			Thread.sleep(3000);
			QaRobot.ClickOnElement("CancelLogIn");
			
			GoNowHotel.trip1( Usertype,UserName, Password,CityCode, CityTitle,  CheckInDate, CheckOutDate, Rooms, Adult,Child, ChildAge, MoreOptions, 
					Nationality, Currency, StarRating, ModifySearch,ChangeTripLocation, CityCodeM, CityTitleM, SearchHotelName,
					HotelNameM, ChangeTripDate, CheckInDateM, CheckOutDateM,ChangeRooms, RoomsM, AdultM, ChildM, ChildAgeM,
					ChangeCurrency, CurrencyM,ChangeStarRating, StarRatingM);
			
			if(Usertype.equalsIgnoreCase("CheckoutPageLogIn"))
			{
				QaRobot.ClickOnElement("OwnAccountCP");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on I have an Account</i></b>");
				
				QaRobot.PassValue("LoginEmailCP",UserName);
				QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
				
				QaRobot.PassValue("PasswordCP",Password);
				QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
				
				QaExtentReport.extentScreenshot("Checkout LogIn Page");
				
				QaRobot.ClickOnElement("SignInCP");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Submit</i></b>");
				Thread.sleep(7000);
			
				GoNowHotel.trip3(Adult, Child,ModifySearch,AdultM,ChildM, Emailid, AdultTitle, AdultName, Phone, ChildTitle, ChildName,ChildDOBdate,
				ChildDOBdateM,Cardtype,CardNumber, CardName, CardDate, CVV, BillingTitle, BillingUserName, BillingAddress, BillingCountry,BillingCity);
			}
		}
	}
	
	@AfterMethod
	public static void afterMetod()
	{
		QaExtentReport.test.getExtent().flush();
	}
	
	public static void trip1(String Usertype,String UserName,String Password,String CityCode,String CityTitle, String CheckInDate,String CheckOutDate,String Rooms,String Adult,
			String Child,String ChildAge,String MoreOptions,String Nationality,String Currency,String StarRating,String ModifySearch,
			String ChangeTripLocation,String CityCodeM,String CityTitleM,String SearchHotelName,String HotelNameM,String ChangeTripDate,String CheckInDateM,String CheckOutDateM,
			String ChangeRooms,String RoomsM,String AdultM,String ChildM,String ChildAgeM,String ChangeCurrency,String CurrencyM,
			String ChangeStarRating,String StarRatingM) throws Exception
	{
		QaRobot.ClickOnElement("Hotels");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Hotel</i></b>");
		
		GoNowTripType.hotelTrip(CityCode,CityTitle,CheckInDate,CheckOutDate,Rooms,Adult,Child,ChildAge,MoreOptions,Nationality,
				Currency,StarRating);
		
		GoNowResultPage.ResultPageForHotel( Usertype,UserName,Password,Rooms, ModifySearch, ChangeTripLocation, CityCodeM, CityTitleM,
				 SearchHotelName, HotelNameM, ChangeTripDate, CheckInDateM, CheckOutDateM, ChangeRooms,
				 RoomsM, AdultM, ChildM, ChildAgeM, ChangeCurrency, CurrencyM, ChangeStarRating,
				 StarRatingM);
	}
	
	public static void trip2(String Adult,String Child,String ModifySearch,String AdultM,String ChildM,String Emailid,String AdultTitle,
			String AdultName,String Phone,String ChildTitle, String ChildName,String ChildDOBdate,String ChildDOBdateM,String Cardtype,
			String CardNumber,String CardName,String CardDate,String CVV,String BillingTitle,String BillingUserName,String BillingAddress,
			String BillingCountry,String BillingCity) throws Exception
	{
		GoNowCheckoutPage.GuestAdultCheckoutForHotel(Emailid,Adult,ModifySearch,AdultM,AdultTitle,AdultName,Phone);
		
		GoNowCheckoutPage.GuestChildCheckoutForHotel(Child,ModifySearch,ChildM,ChildTitle,ChildName,ChildDOBdate,ChildDOBdateM);
		
		GoNowPaymentPage.cardPaymentForHotel(Cardtype,CardNumber,CardName,CardDate,CVV);
		
		GoNowCheckoutPage.GuestBillingDetailsCheckoutForHotel(BillingTitle,BillingUserName,BillingAddress,BillingCountry,BillingCity);
		
		GoNowConfirmPage.confirmpageHotel();
	}
	
	public static void trip3(String Adult,String Child,String ModifySearch,String AdultM,String ChildM,String Emailid,String AdultTitle,
			String AdultName,String Phone,String ChildTitle, String ChildName,String ChildDOBdate,String ChildDOBdateM,String Cardtype,
			String CardNumber,String CardName,String CardDate,String CVV,String BillingTitle,String BillingUserName,String BillingAddress,
			String BillingCountry,String BillingCity) throws Exception
	{
		GoNowCheckoutPage.adultCheckoutPageLoginForHotel(Adult,ModifySearch,AdultM,AdultTitle,AdultName);
		
		GoNowCheckoutPage.GuestChildCheckoutForHotel(Child,ModifySearch,ChildM,ChildTitle,ChildName,ChildDOBdate,ChildDOBdateM);
		
		GoNowPaymentPage.cardPaymentForHotel(Cardtype,CardNumber,CardName,CardDate,CVV);
		
		GoNowCheckoutPage.GuestBillingDetailsCheckoutForHotel(BillingTitle,BillingUserName,BillingAddress,BillingCountry,BillingCity);
		
		GoNowConfirmPage.confirmpageHotel();
	}
}
