package goNow;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class GoNowTripType {
	public static void flightTriptype(String TripType, String Trip, String OriginCityCode, String OriginLocation,
			String DestinationCityCode, String DestinationLocation, String DepartureDate, String ReturnDate,
			String adult, String child, String infant, String MoreOptions, String Currency, String Class,
			String PANumber, String PreferredAirlineSelect, String ShowDirectFlight) throws Exception {
		String DateSelection[] = DepartureDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];

		String DateSelection1[] = ReturnDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];

		if (TripType.equalsIgnoreCase("OneWay")) {
			QaRobot.ClickOnElement("OneWay");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on OneWay</i></b>");

			TestBase.listofautosuggestion(By.xpath("//div[@id='divFLDepart']/p"), OriginCityCode, OriginLocation,
					By.xpath("//input[@id='fromcityAc']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure city : </i></b>" + OriginCityCode + " - " + OriginLocation);
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//div[@id='divFLArrival']/p"), DestinationCityCode,
					DestinationLocation, By.xpath("//input[@id='tocityAc']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival city : </i></b>" + DestinationCityCode + " - " + DestinationLocation);
			Thread.sleep(2000);

			QaBrowser.driver.findElement(By.xpath("//div[@class='pd-r1 add_cls col-md-12']//img")).click();
			Thread.sleep(2000);

			selectDateInCalendarOneWay(expDate, month, year);

//			QaRobot.ClickOnElement("Travellers");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Travellers</i></b>");
//			
//			QaRobot.selectValueFromDropdown("Adult", adult, "<b><i>Select adult for booking</i></b>"+" - "+adult);
//			Thread.sleep(2000);
//
//			QaRobot.selectValueFromDropdown("Child", child, "<b><i>Select child for booking</i></b>"+" - "+child);
//			Thread.sleep(2000);
//
//			QaRobot.selectValueFromDropdown("Infant", infant, "<b><i>Select infant for booking</i></b>"+" - "+infant);
//			Thread.sleep(2000);
//			
//			QaRobot.ClickOnElement("Travellers");

			if (MoreOptions.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("MoreOptions1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MoreOptions</i></b>");
				Thread.sleep(2000);

				QaRobot.selectValueFromDropdown("CurrencyF", Currency, "<b><i>Select Currency for booking</i></b>");
				Thread.sleep(2000);

				QaRobot.selectTextByLocator("//select[@id='ddl_class']", Class,
						"<b><i>Select Class for booking</i></b>");
				Thread.sleep(2000);

				QaRobot.ClickOnElement("PreferredAirline");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Preferred Airline</i></b>");
				Thread.sleep(2000);

				int pAS = Integer.parseInt(PANumber);
				for (int i = 1; i <= pAS; i++) {
					String[] tN = PreferredAirlineSelect.split(",");
					String b = tN[i - 1];
					TestBase.listofautosuggestion1(
							By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']/li"), b,
							By.xpath("//input[@placeholder='Search Airline']"));
				}

				if (ShowDirectFlight.equalsIgnoreCase("Yes")) {
					QaRobot.ClickOnElement("ShowDirectFlight");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Show Direct Flight</i></b>");
				}
			}
		}

		else if (TripType.equalsIgnoreCase("RoundTrip")) {
			QaRobot.ClickOnElement("RoundTrip");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Round Trip</i></b>");

			TestBase.listofautosuggestion(By.xpath("//div[@id='divFLDepart']/p"), OriginCityCode, OriginLocation,
					By.xpath("//input[@id='fromcityAc']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure city : </i></b>" + OriginCityCode + " - " + OriginLocation);
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//div[@id='divFLArrival']/p"), DestinationCityCode,
					DestinationLocation, By.xpath("//input[@id='tocityAc']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival city : </i></b>" + DestinationCityCode + " - " + DestinationLocation);
			Thread.sleep(2000);

			QaBrowser.driver
					.findElement(By.xpath("//div[@id='flight_tb1']/div[1]/div/div/div[3]/div/div[1]/span/span/img"))
					.click();
			Thread.sleep(2000);

			selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);

//			QaRobot.ClickOnElement("Travellers");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Travellers</i></b>");
//
//			QaRobot.selectValueFromDropdown("Adult", adult, "<b><i>Select adult for booking</i></b>" + " - " + adult);
//			Thread.sleep(2000);
//
//			QaRobot.selectValueFromDropdown("Child", child, "<b><i>Select child for booking</i></b>" + " - " + child);
//			Thread.sleep(2000);
//
//			QaRobot.selectValueFromDropdown("Infant", infant,
//					"<b><i>Select infant for booking</i></b>" + " - " + infant);
//			Thread.sleep(2000);
//
//			QaRobot.ClickOnElement("Travellers");

			if (MoreOptions.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("MoreOptions1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MoreOptions</i></b>");
				Thread.sleep(2000);

				QaRobot.selectValueFromDropdown("CurrencyF", Currency, "<b><i>Select Currency for booking</i></b>");
				Thread.sleep(2000);

				QaRobot.selectTextByLocator("//select[@id='ddl_class']", Class,
						"<b><i>Select Class for booking</i></b>");
				Thread.sleep(2000);

				QaRobot.ClickOnElement("PreferredAirline");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Preferred Airline</i></b>");
				Thread.sleep(2000);

				int pAS = Integer.parseInt(PANumber);
				for (int i = 1; i <= pAS; i++) {
					String[] tN = PreferredAirlineSelect.split(",");
					String b = tN[i - 1];
					TestBase.listofautosuggestion1(
							By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']/li"), b,
							By.xpath("//input[@placeholder='Search Airline']"));
				}

				if (ShowDirectFlight.equalsIgnoreCase("Yes")) {
					QaRobot.ClickOnElement("ShowDirectFlight");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on ShowDirectFlight</i></b>");
				}
			}
		}

		else if (TripType.equalsIgnoreCase("MultiCity")) {

		}
		try {
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("FinalSearchF");
			Thread.sleep(10000);
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FinalSearch</i></b>");
//			QaRobot.ScreenshotMethod("FlightTrip", "<b><i>Screenshot for Flight Trip</i></b>");
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void hotelTrip(String CityCode, String CityTitle, String CheckInDate, String CheckOutDate,
			String Rooms, String Adult, String Child, String ChildAge, String MoreOptions, String Nationality,
			String Currency, String StarRating) throws Exception {
		TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), CityCode, CityTitle,
				By.xpath("//input[@id='txtHTCity']"));
		QaExtentReport.test.log(Status.INFO, "<b><i>City Name : </i></b>" + CityCode + "-" + CityTitle);
		Thread.sleep(2000);

		QaBrowser.driver.findElement(By.xpath("//div[@id='hm_tab3']/div/div/div[1]/div/div/div[2]/span/span/img"))
				.click();
		Thread.sleep(2000);

		String DateSelection[] = CheckInDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];

		String DateSelection1[] = CheckOutDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];

		selectDateInCalendarHotel(expDate, month, year, expDate1, month1, year1);

//		int room = Integer.parseInt(Rooms);
//		String[] adultcount = Adult.split(",");
//		String[] childcount = Child.split(",");
//
//		if (room > 5) {
//			throw new B2cExceptionClass("Invalid Number of Rooms provided " + " : " + room);
//		} else {
//			for (int i = 1; i < room; i++) {
//				QaRobot.ClickOnElement("AddRoom");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on AddRoom</i></b>");
//			}
//
//			for (int i = 1; i <= room; i++) {
//				WebElement adultelement = QaBrowser.driver
//						.findElement(By.xpath("//select[@id='HtlSltAdult" + i + "']"));
//				Select selectadult = new Select(adultelement);
//				selectadult.selectByValue(adultcount[i - 1]);
//				Thread.sleep(2000);
//
//				WebElement childelement = QaBrowser.driver
//						.findElement(By.xpath("//select[@id='HtlChildSlt" + i + "']"));
//				Select selectchild = new Select(childelement);
//				selectchild.selectByValue(childcount[i - 1]);
//				Thread.sleep(2000);
//			}
//
//			String[] ageofchild = ChildAge.split(",");
//			for (String chd : childcount) {
//				int chdcount = Integer.parseInt(chd);
//				for (int i = 1; i <= chdcount; i++) {
//					String ac = ageofchild[i - 1];
//					int ac1 = Integer.parseInt(ac);
//
//					if (ac1 > 17) {
//						QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Age Selection</i></b>" + " : " + ac1);
//						throw new B2cExceptionClass("Invalid Child Age Selection" + " : " + ac1);
//					} else {
//						WebElement childrenage = QaBrowser.driver
//								.findElement(By.xpath("//select[@id='HtlChildAge" + chdcount + "_" + i + "']"));
//						Select selectage = new Select(childrenage);
//						selectage.selectByValue(ageofchild[i - 1]);
//						Thread.sleep(2000);
//					}
//				}
//			}
//		}

		if (MoreOptions.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("MoreOptions");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on More Options</i></b>");
			Thread.sleep(2000);

			QaRobot.selectTextFromDropdown("Nationality", Nationality, "<b><i>Select Nationality</i></b>");
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("CurrencyH", Currency, "<b><i>Select Currency for booking</i></b>");
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("StarRating", StarRating, "<b><i>Select Currency for booking</i></b>");
			Thread.sleep(2000);
		}

		try {
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Search Page");
//			QaRobot.ClickOnElement("FinalSearchH");
			QaRobot.ClickOnElement("FinalSearchH1");
			Thread.sleep(15000);
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FinalSearch</i></b>");
//			QaRobot.ScreenshotMethod("HotelTrip", "<b><i>Screenshot for Hotel Trip</i></b>");
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void flight_HotelTrip(String Trip, String OriginCityCode, String OriginLocation,
			String DestinationCityCode, String DestinationLocation, String DepartureDate, String ReturnDate,
			String Rooms, String Adult, String Child, String ChildAge, String Infant, String InfantAge,
			String MoreOptions, String Nationality, String Currency, String Class, String ShowDirectFlight,
			String MyHotelDiffenrentDate, String ChangeCheckIn, String ChangeCheckOut) throws Exception {
		String DateSelection[] = DepartureDate.split(",");
		String monthAndYear = DateSelection[1];
		String expDate = DateSelection[0];

		String DateSelection1[] = ReturnDate.split(",");
		String monthAndYear1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];

		if (Trip.equalsIgnoreCase("Domestic")) {
			TestBase.listofautosuggestion(By.xpath("//div[@id='div3']/p"), OriginCityCode, OriginLocation,
					By.xpath("//input[@id='txtFlightFromDynamic']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>" + OriginLocation);
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//div[@id='div7']/p"), DestinationCityCode, DestinationLocation,
					By.xpath("//input[@id='txtFlightToDynamic']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city : </i></b>" + DestinationLocation);
			Thread.sleep(2000);
		} else if (Trip.equalsIgnoreCase("International")) {
			TestBase.listofautosuggestion(By.xpath("//div[@id='div3']/p"), OriginCityCode, OriginLocation,
					By.xpath("//input[@id='txtFlightFromDynamic']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>" + OriginLocation);
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//div[@id='div7']/p"), DestinationCityCode, DestinationLocation,
					By.xpath("//input[@id='txtFlightToDynamic']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city : </i></b>" + DestinationLocation);
			Thread.sleep(2000);
		}

		QaBrowser.driver
				.findElement(By.xpath("//div[@id='hm_tab4']/div/div/div[1]/div/div/div[2]/div/div[1]/span/span/img"))
				.click();
		Thread.sleep(2000);

		while (true) {
			String text = QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div[1]/div")).getText();

			if (text.equalsIgnoreCase(monthAndYear)) {
				break;
			} else {
				QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[1]/a[3]")).click();
			}
		}

		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[8]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele : allDates) {
			String dt = ele.getText();

			if (dt.equalsIgnoreCase(expDate)) {
				ele.click();
				break;
			}
		}

		QaBrowser.driver
				.findElement(By.xpath("//div[@id='hm_tab4']/div/div/div[1]/div/div/div[2]/div/div[2]/span/span/img"))
				.click();
		Thread.sleep(2000);

		while (true) {
			String text1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div[1]/div")).getText();

			if (text1.equalsIgnoreCase(monthAndYear1)) {
				break;
			} else {
				QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[1]/a[3]")).click();
			}
		}

		List<WebElement> allDates1 = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[8]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele1 : allDates1) {
			String dt1 = ele1.getText();

			if (dt1.equalsIgnoreCase(expDate1)) {
				ele1.click();
				break;
			}
		}

//		int room = Integer.parseInt(Rooms);
//		String[] adultcount = Adult.split(",");
//		String[] childcount = Child.split(",");
//		String[] infantcount = Infant.split(",");
//
//		for (int i = 1; i < room; i++) {
//			QaRobot.ClickOnElement("AddRoomFH");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Add Room</i></b>");
//		}
//
//		for (int i = 1; i <= room; i++) {
//			WebElement adultelement = QaBrowser.driver
//					.findElement(By.xpath("//select[@id='Htl_fltSltAdult" + i + "']"));
//			Select selectadult = new Select(adultelement);
//			selectadult.selectByValue(adultcount[i - 1]);
//			Thread.sleep(2000);
//
//			WebElement childelement = QaBrowser.driver
//					.findElement(By.xpath("//select[@id='Htl_fltChildSlt" + i + "']"));
//			Select selectchild = new Select(childelement);
//			selectchild.selectByValue(childcount[i - 1]);
//			Thread.sleep(2000);
//
//			WebElement infantelement = QaBrowser.driver
//					.findElement(By.xpath("//select[@id='Htl_fltInfantSlt" + i + "']"));
//			Select selectinfant = new Select(infantelement);
//			selectinfant.selectByValue(infantcount[i - 1]);
//			Thread.sleep(2000);
//		}
//
//		String[] ageofchild = ChildAge.split(",");
//		for (String chd : childcount) {
//			int chdcount = Integer.parseInt(chd);
//			for (int i = 1; i <= chdcount; i++) {
//				WebElement childrenage = QaBrowser.driver
//						.findElement(By.xpath("//select[@id='Htl_fltChildAge" + chdcount + "_" + i + "']"));
//				Select selectage = new Select(childrenage);
//				selectage.selectByValue(ageofchild[i - 1]);
//				Thread.sleep(2000);
//			}
//		}
//
//		String[] ageofinfant = InfantAge.split(",");
//		for (String ift : infantcount) {
//			int iftcount = Integer.parseInt(ift);
//			for (int i = 1; i <= iftcount; i++) {
//				WebElement infantrenage = QaBrowser.driver
//						.findElement(By.xpath("//select[@id='Htl_fltInfantAge" + iftcount + "_" + i + "']"));
//				Select selectage = new Select(infantrenage);
//				selectage.selectByValue(ageofinfant[i - 1]);
//				Thread.sleep(2000);
//			}
//		}

		if (MoreOptions.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("MoreOptionsFH");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on More Options</i></b>");
			Thread.sleep(2000);

			QaRobot.selectTextFromDropdown("NationalityFH", Nationality, "<b><i>Select Nationality</i></b>");
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("CurrencyFH", Currency, "<b><i>Select Currency for booking</i></b>");
			Thread.sleep(2000);

			QaRobot.selectTextByLocator("//select[@id='dynamic_class']", Class,
					"<b><i>Select Class for booking</i></b>");
			Thread.sleep(2000);

			if (ShowDirectFlight.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("ShowDirectFlightsOnly");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Show Direct Flights Only</i></b>");
			}

			if (MyHotelDiffenrentDate.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("MyHotelCheckin");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on My Hotel Check In</i></b>");

				String DateSelectionFH[] = ChangeCheckIn.split(",");
				String monthAndYearFH = DateSelectionFH[1];
				String expDateFH = DateSelectionFH[0];

				String DateSelection1FH1[] = ChangeCheckOut.split(",");
				String monthAndYearFH1 = DateSelection1FH1[1];
				String expDateFH1 = DateSelection1FH1[0];

				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[13]")).click();
				Thread.sleep(2000);

				while (true) {
					String text = QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div"))
							.getText();

					if (text.equalsIgnoreCase(monthAndYearFH)) {
						break;
					} else {
						QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
					}
				}

				List<WebElement> allDatesFH = QaBrowser.driver
						.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));

				for (WebElement ele : allDatesFH) {
					String dt = ele.getText();

					if (dt.equalsIgnoreCase(expDateFH)) {
						ele.click();
						break;
					}
				}

				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[14]")).click();
				Thread.sleep(2000);

				while (true) {
					String text1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div"))
							.getText();

					if (text1.equalsIgnoreCase(monthAndYearFH1)) {
						break;
					} else {
						QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
					}
				}

				List<WebElement> allDatesFH1 = QaBrowser.driver
						.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));

				for (WebElement ele1 : allDatesFH1) {
					String dt1 = ele1.getText();

					if (dt1.equalsIgnoreCase(expDateFH1)) {
						ele1.click();
						break;
					}
				}
			}
		}
		QaExtentReport.extentScreenshot("Flight+Hotel Trip");
//		QaRobot.ScreenshotMethod("Flight_HotelTrip", "<b><i>Screenshot for Flight+Hotel Trip</i></b>");
//		QaRobot.ClickOnElement("FinalSearchFH");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("FinalSearchFH1");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Final Search</i></b>");
		Thread.sleep(10000);
	}

	public static void selectDateInCalendarOneWay(String Day, String Month, String Year) throws ParseException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("January")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("February")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("March")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("April")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("July")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("August")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("September")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("October")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("November")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("December")) {
			currentMonthNumber = "12";
		}

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Date  </i></b>" + Day + "-" + Month + "-" + Year);

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new B2cExceptionClass("Invalid date provided " + Day + "/" + Month + "/" + Year);
		}
		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/div")).getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[1]/a[3]")).click();

				monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/div")).getText();

				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}

			List<WebElement> allDates = QaBrowser.driver
					.findElements(By.xpath("/html/body/div[8]/div/div[2]/div/table/tbody/tr/td"));

			for (WebElement ele : allDates) {
				String dt = ele.getText();

				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
		}
	}

	public static void selectDateInCalendarRoundTrip(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws InterruptedException, ParseException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("January")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("February")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("March")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("April")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("July")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("August")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("September")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("October")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("November")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("December")) {
			currentMonthNumber = "12";
		}

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		String currentMonthNumber1 = "00";
		if (Month1.equalsIgnoreCase("January")) {
			currentMonthNumber1 = "01";
		} else if (Month1.equalsIgnoreCase("February")) {
			currentMonthNumber1 = "02";
		} else if (Month1.equalsIgnoreCase("March")) {
			currentMonthNumber1 = "03";
		} else if (Month1.equalsIgnoreCase("April")) {
			currentMonthNumber1 = "04";
		} else if (Month1.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month1.equalsIgnoreCase("Jun")) {
			currentMonthNumber1 = "06";
		} else if (Month1.equalsIgnoreCase("July")) {
			currentMonthNumber1 = "07";
		} else if (Month1.equalsIgnoreCase("August")) {
			currentMonthNumber1 = "08";
		} else if (Month1.equalsIgnoreCase("September")) {
			currentMonthNumber1 = "09";
		} else if (Month1.equalsIgnoreCase("October")) {
			currentMonthNumber1 = "10";
		} else if (Month1.equalsIgnoreCase("November")) {
			currentMonthNumber1 = "11";
		} else if (Month1.equalsIgnoreCase("December")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new B2cExceptionClass("Invalid date provided " + Day + "/" + Month + "/" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Integer.parseInt(Day1) > 31) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			throw new B2cExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day1) > 28) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			throw new B2cExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/div")).getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[1]/a[3]")).click();

				monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/div")).getText();

				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}

			List<WebElement> allDates = QaBrowser.driver
					.findElements(By.xpath("/html/body/div[8]/div/div[2]/div/table/tbody/tr/td"));

			for (WebElement ele : allDates) {
				String dt = ele.getText();

				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}

			QaBrowser.driver
					.findElement(By.xpath("//div[@id='flight_tb1']/div[1]/div/div/div[3]/div/div[2]/span/span/img"))
					.click();
			Thread.sleep(2000);

			String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/div"))
					.getText();

			String month1 = monthYear1.split(" ")[0];
			String year1 = monthYear1.split(" ")[1];

			if (date3.before(date2)) {
				QaExtentReport.test.log(Status.FAIL,
						"<b><i>Invalid Return date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
				throw new B2cExceptionClass("Invalid Return date provided " + Day1 + "-" + Month1 + "-" + Year1);
			} else {
				while (!(month1.equals(Month1) && year1.equals(Year1))) {
					QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[1]/a[3]")).click();

					monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/div"))
							.getText();

					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}

				List<WebElement> allDates1 = QaBrowser.driver
						.findElements(By.xpath("/html/body/div[8]/div/div[2]/div/table/tbody/tr/td"));

				for (WebElement ele1 : allDates1) {
					String dt1 = ele1.getText();

					if (dt1.equalsIgnoreCase(Day1)) {
						ele1.click();
						break;
					}
				}
			}
		}
	}

	public static void selectDateInCalendarHotel(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws InterruptedException, ParseException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("January")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("February")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("March")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("April")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("July")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("August")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("September")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("October")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("November")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("December")) {
			currentMonthNumber = "12";
		}

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		String currentMonthNumber1 = "00";
		if (Month1.equalsIgnoreCase("January")) {
			currentMonthNumber1 = "01";
		} else if (Month1.equalsIgnoreCase("February")) {
			currentMonthNumber1 = "02";
		} else if (Month1.equalsIgnoreCase("March")) {
			currentMonthNumber1 = "03";
		} else if (Month1.equalsIgnoreCase("April")) {
			currentMonthNumber1 = "04";
		} else if (Month1.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month1.equalsIgnoreCase("Jun")) {
			currentMonthNumber1 = "06";
		} else if (Month1.equalsIgnoreCase("July")) {
			currentMonthNumber1 = "07";
		} else if (Month1.equalsIgnoreCase("August")) {
			currentMonthNumber1 = "08";
		} else if (Month1.equalsIgnoreCase("September")) {
			currentMonthNumber1 = "09";
		} else if (Month1.equalsIgnoreCase("October")) {
			currentMonthNumber1 = "10";
		} else if (Month1.equalsIgnoreCase("November")) {
			currentMonthNumber1 = "11";
		} else if (Month1.equalsIgnoreCase("December")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Integer.parseInt(Day1) > 31) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			throw new B2cExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day1) > 28) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			throw new B2cExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/div")).getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[1]/a[3]")).click();

				monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/div")).getText();

				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}

			List<WebElement> allDates = QaBrowser.driver
					.findElements(By.xpath("/html/body/div[8]/div/div[2]/div/table/tbody/tr/td"));

			for (WebElement ele : allDates) {
				String dt = ele.getText();

				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}

			QaBrowser.driver.findElement(By.xpath("//div[@id='hm_tab3']/div/div/div[1]/div/div/div[3]/span/span/img"))
					.click();
			Thread.sleep(2000);

			String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/div"))
					.getText();

			String month1 = monthYear1.split(" ")[0];
			String year1 = monthYear1.split(" ")[1];

			if (date3.before(date2)) {
				QaExtentReport.test.log(Status.FAIL,
						"<b><i>Invalid Check out date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
				throw new B2cExceptionClass("Invalid Check out date provided " + Day1 + "-" + Month1 + "-" + Year1);
			} else {
				while (!(month1.equals(Month1) && year1.equals(Year1))) {
					QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[1]/a[3]")).click();

					monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/div"))
							.getText();

					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}

				List<WebElement> allDates1 = QaBrowser.driver
						.findElements(By.xpath("/html/body/div[8]/div/div[2]/div/table/tbody/tr/td"));

				for (WebElement ele1 : allDates1) {
					String dt1 = ele1.getText();

					if (dt1.equalsIgnoreCase(Day1)) {
						ele1.click();
						break;
					}
				}
			}
		}
	}
}
