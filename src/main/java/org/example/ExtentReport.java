/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.time.LocalDate;

public class ExtentReport {

    private final ExtentReports extent;
    private final ExtentSparkReporter reporter;

    public ExtentReport(String filePath) {
        this.reporter = generateReporter(filePath);
        this.extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    public ExtentSparkReporter generateReporter(String filePath) {
        ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
        reporter.config().setReportName("test result: " + LocalDate.now());
        reporter.config().setDocumentTitle("Test results");
        return reporter;
    }

    public void setConfig(){
        this.extent.setSystemInfo("Tester", "Bucovala Sebastian");
    }

    public void startExtent() {
        ExtentTest test = this.extent.createTest("Test");
    }

    public void stopExtent() {
        this.extent.flush();
    }

}

