package com.pintu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listener implements ITestListener {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initializeExtentReports() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());

        String reportFileName = "extent-report_" + timestamp + ".html";

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/" + reportFileName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void onStart(ITestContext context) {
        initializeExtentReports(); // Call your own method here
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName(), result.getMethod().getDescription());
        test.info("Test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Handle skipped tests if needed
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Handle tests failed within success percentage if needed
    }

    // Implement other methods as needed
}
