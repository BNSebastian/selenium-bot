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
import java.util.Random;

public class LoginPage {

    private final WebDriver driver;
    private final Actions action;
    private final int minLatency = 1000;
    private final int maxLatency = 2000;
    private final String acceptCookies;
    private final String username;
    private final String password;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.action = new Actions(driver);
        this.acceptCookies = "/html/body/div[3]/div/div/div/div[3]/button";
        this.username = "//*[@id=\"login_form__username\"]";
        this.password = "//*[@id=\"login_form__password\"]";
    }

    public void acceptCookies() throws InterruptedException {
        Thread.sleep(new Random().nextInt(minLatency,maxLatency));
        action.moveToElement(driver.findElement(By.xpath(this.acceptCookies)))
                .click()
                .build()
                .perform();
    }

    public void fillUsername() throws InterruptedException {
        Thread.sleep(new Random().nextInt(minLatency,maxLatency));
        //driver.findElement(By.xpath(this.username)).sendKeys("loosh.protocol@protonmail.com");
        driver.findElement(By.xpath(this.username)).sendKeys("email");
    }

    public void fillPassword() throws InterruptedException {
        Thread.sleep(new Random().nextInt(minLatency,maxLatency));
        //driver.findElement(By.xpath(this.password)).sendKeys("mff5vmddvm5p232\n");
        driver.findElement(By.xpath(this.password)).sendKeys("password\n");
    }

}
