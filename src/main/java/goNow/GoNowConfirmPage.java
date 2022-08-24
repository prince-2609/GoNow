package goNow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import utilities.QaBrowser;
import utilities.QaExtentReport;

public class GoNowConfirmPage 
{
	public static void confirmpageFlight()
	{
		WebElement getT = QaBrowser.driver.findElement(By.xpath("/html/body/div/div[2]/div/div/section/div/div/div/div[1]/div/div/div[1]/h1"));
		String getTxt = getT.getText();
		String getTxt1[]= getTxt.split(" ");
		String number = getTxt1[2];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>"+number);
		
		WebElement getT1 = QaBrowser.driver.findElement(By.xpath("/html/body/div/div[2]/div/div/section/div/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/p"));
		String getTxt2 = getT1.getText();
		String getTxt3[]= getTxt2.split(" ");
		String number1 = getTxt3[0];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>"+number1);
		
			String text = QaBrowser.driver.findElement (By.xpath("/html/body/div/div[2]/div/div/section/div/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/p/span[1]")).getText();
			
			if(text.equalsIgnoreCase("UnConfirmed"))
			{
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Fail </i></b>");
			}
			else
			{
				WebElement getT2 = QaBrowser.driver.findElement(By.xpath("/html/body/div/div[2]/div/div/section/div/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/p"));
				String getTxt4 = getT2.getText();
				String getTxt5[]= getTxt4.split(" ");
				String number2 = getTxt5[2];
				QaExtentReport.test.log(Status.INFO, "<b><i>Confirming Status Number is </i></b>"+number2);
			}
	}
	
	public static void confirmpageHotel()
	{
		WebElement getT = QaBrowser.driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/section/div[2]/div/div[1]/div[1]/h2"));
		String getTxt = getT.getText();
		String getTxt1[]= getTxt.split(" ");
		String number = getTxt1[1];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Id Is </i></b>"+number);
		
		WebElement getT1 = QaBrowser.driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/section/div[2]/div/div[1]/div[3]/div/div[1]/div[2]/p"));
		String getTxt2 = getT1.getText();
		String getTxt3[]= getTxt2.split(" ");
		String number1 = getTxt3[0];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>"+number1);
		
			String text = QaBrowser.driver.findElement (By.xpath("/html/body/form/div[4]/div[2]/section/div[2]/div/div[1]/div[3]/div/div[1]/div[2]/p/span[1]")).getText();
			
			if(text.equalsIgnoreCase("UnConfirmed"))
			{
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Fail </i></b>");
			}
			else
			{
				WebElement getT2 = QaBrowser.driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/section/div[2]/div/div[1]/div[3]/div/div[1]/div[2]/p"));
				String getTxt4 = getT2.getText();
				String getTxt5[]= getTxt4.split(" ");
				String number2 = getTxt5[2];
				QaExtentReport.test.log(Status.INFO, "<b><i>Confirming Status Number is </i></b>"+number2);
			}
	}
	
	public static void confirmpageFlight_Hotel()
	{
		WebElement getT = QaBrowser.driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/section/div[2]/div/div[1]/div[1]/h2"));
		String getTxt = getT.getText();
		String getTxt1[]= getTxt.split(" ");
		String number = getTxt1[1];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Id Is </i></b>"+number);
		
		WebElement getT1 = QaBrowser.driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/section/div[2]/div/div[1]/div[3]/div[1]/div[1]/div[2]/p"));
		String getTxt2 = getT1.getText();
		String getTxt3[]= getTxt2.split(" ");
		String number1 = getTxt3[0];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>"+number1);
		
			String text = QaBrowser.driver.findElement (By.xpath("/html/body/form/div[4]/div[2]/section/div[2]/div/div[1]/div[3]/div[1]/div[1]/div[2]/p/span[1]")).getText();
			
			if(text.equalsIgnoreCase("UnConfirmed"))
			{
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Fail </i></b>");
			}
			else
			{
				WebElement getT2 = QaBrowser.driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/section/div[2]/div/div[1]/div[3]/div[1]/div[1]/div[2]/p"));
				String getTxt4 = getT2.getText();
				String getTxt5[]= getTxt4.split(" ");
				String number2 = getTxt5[2];
				QaExtentReport.test.log(Status.INFO, "<b><i>Confirming Status Number is </i></b>"+number2);
			}
	}
}
