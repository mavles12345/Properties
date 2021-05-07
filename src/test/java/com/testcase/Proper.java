package com.testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Proper {

	public static void main(String[] args) throws IOException {

		Properties p = new Properties();
		//FileReader file = new FileReader("Configurarion.properties");
		
		FileInputStream file=new FileInputStream("Configurarion.properties");
		p.load(file);
		String location = p.getProperty("driverlocation");

		System.setProperty("webdriver.chrome.driver", location);
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys(p.getProperty("username"));
		driver.findElement(By.id("pass")).sendKeys(p.getProperty("password"));
		driver.findElement(By.name("login")).click();
		

	}

}
