/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class JobPage {

    private final WebDriver driver;
    private final Actions action;
    private final Robot robot;
    private final int minLatency = 1000;
    private final int maxLatency = 2000;
    private final String jobCard;
    private final String assistant;
    private final String applyButton;
    private final String jobTitle;

    public JobPage(WebDriver driver) throws AWTException {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.action = new Actions(driver);
        this.robot = new Robot();
        this.jobCard = "/html/body/div[3]/div/div[1]/div[1]";
        this.assistant = "/html/body/div[9]/div/div[2]/div/div[1]/div/div[3]/button";
        this.applyButton = "text-truncate d-inline-block";
        this.jobTitle = "/html/body/div[9]/div/div[2]/div/div[2]/div/div[3]/div/h2/a";
    }

    public void clickJobCard() throws InterruptedException {
        Thread.sleep(new Random().nextInt(minLatency,maxLatency));
        action.moveToElement(driver.findElement(By.xpath(this.jobCard)))
                .click()
                .build()
                .perform();
    }

    public void dismissAssistant() throws InterruptedException {
        Thread.sleep(new Random().nextInt(minLatency,maxLatency));
        action.moveToElement(driver.findElement(By.xpath(this.assistant)))
                .click()
                .build()
                .perform();
    }

    public void getNextJob() throws InterruptedException {
        Thread.sleep(new Random().nextInt(minLatency,maxLatency));
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
    }

    public void applyForCurrentJob() throws InterruptedException {
        Thread.sleep(new Random().nextInt(minLatency,maxLatency));
        driver.findElement(By.className(this.applyButton)).click();
    }

    public String getJobTitle() throws InterruptedException {
        Thread.sleep(new Random().nextInt(minLatency,maxLatency));
        return driver.findElement(By.xpath(this.jobTitle)).getText();
    }
}
