package com.trax.testCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_GETRestAssureds {

	@Test()
	public void GETRestAssureds() throws MalformedURLException {
		
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", System.getenv("oauth-sharma.atulkumar29-3deed"));
		sauceOptions.setCapability("access_key", System.getenv("7daa122c-0473-443b-8763-beeadddfc4f9"));
		sauceOptions.setCapability("name", "Atul-API TCs");
		sauceOptions.setCapability("browserVersion", "105");
		sauceOptions.setCapability("PlatformName", "Windows 10");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("--disable-extenstions");
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("force-device-scale-factor=0.65");
		chromeOptions.addArguments("high-dpi-support=0.65");
		chromeOptions.addArguments("--ignore-ssl-errors=yes");
		chromeOptions.addArguments("--ignore-certificate-errors");
		chromeOptions.addArguments("--allow-insecure-localhost");
		chromeOptions.addArguments("--allow-running-insecure-content");
		chromeOptions.addArguments("--unsafely-treat-insecure-origin-as-secure");
		chromeOptions.setCapability("sauce:options", sauceOptions);

		//driver = new ChromeDriver(chromeOptions);
		//driver.get("https://yahoo.com");
		
		URL url = new URL("https://oauth-sharma.atulkumar29-3deed:7daa122c-0473-443b-8763-beeadddfc4f9@ondemand.us-west-1.saucelabs.com:443/wd/hub");
				RemoteWebDriver driver = new RemoteWebDriver(url, chromeOptions);
				
		driver.navigate().to("https://www.postman.com");

		System.out.println("Target URL of  application: " + driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		System.out.println("Started executing Test->'GETRestAssureds'");

		String apiURL = "https://swapi.dev/api/people/1/";

		// equal to - single matcher and has items - multiple matchers
		given().get(apiURL).then().statusCode(200).body("name", equalTo("Luke Skywalker"))
				.body("films", hasItems("https://swapi.dev/api/films/1/", "https://swapi.dev/api/films/6/")).and().log()
				.body();

		System.out.println("Successfully executed Test->'GETRestAssureds'");

	}
}