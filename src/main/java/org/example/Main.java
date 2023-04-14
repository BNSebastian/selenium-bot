package org.example;

import org.example.POM.JobPage;
import org.example.POM.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, AWTException {
        // set browser driver location
        System.setProperty("webdriver.chrome.driver","D:\\Proiecte\\java\\selenium-tutorial\\src\\main\\resources\\chromedriver112.exe");
        // start browser driver
        RandomUserAgent agent = new RandomUserAgent();
        WebDriver driver = new ChromeDriver(agent.getRandomChromeAgent());
        Actions action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // modify viewport
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);"); // scroll to the top of the page
        js.executeScript("window.innerWidth = 800;"); // set viewport width
        js.executeScript("window.innerHeight = 600;"); // set viewport height

        // open browser
        driver.get("https://www.bestjobs.eu/en/login");

        LoginPage loginPage = new LoginPage(driver);
        JobPage jobPage = new JobPage(driver);

        loginPage.acceptCookies();
        loginPage.fillUsername();
        loginPage.fillPassword();

        jobPage.clickJobCard();
        jobPage.dismissAssistant();
        ArrayList<String> preferredJobs = new ArrayList<>(Arrays.asList("java", "backend", "qa", "quality"));
        while (true) {
            String currentJob = jobPage.getJobTitle().toLowerCase();
            for (String job : preferredJobs) {
                if (currentJob.contains(job)) {
                    jobPage.applyForCurrentJob();
                    System.out.println("found a job: " + currentJob);
                }
            }
            jobPage.getNextJob();
        }
    }
}