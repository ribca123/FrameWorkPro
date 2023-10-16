package test;




import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.testng.annotations.BeforeTest;




import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;







public class reporting {

public static ExtentReports extent;

private static Logger logger=LogManager.getLogger(reporting.class);

@BeforeTest

    public static ExtentReports generateReports() {

        String filepath    =System.getProperty("user.dir")+"//reports//testreport.html";

         ExtentSparkReporter spark = new ExtentSparkReporter(filepath);

         spark.config().setDocumentTitle("sravanii");

         spark.config().setReportName("report");

//         spark.config().setCss("body {\r\n"

//                 + "    font-size: 14px;\r\n"

//                 + "    background-color: #082847;\r\n"

//                 + "    line-height: 1.5;\r\n"

//                 + "}");

         spark.config().setCss("body {\r\n"

                 + "    font-size: 14px;\r\n"

                 + "    background-color: #78e3eb;\r\n"

                 + "    line-height: 1.5;\r\n"

                 + "}");

         ExtentReports extent = new ExtentReports();

         extent.attachReporter(spark);

         ExtentTest test = extent.createTest("hi");

         test.info("heloooooo");

         test.pass("this on pass");

         test =extent.createTest("hey 2");

         test.info(";") ;

         test.fail("fail");

         extent.flush();

         test=extent.createTest("this is failed test case");

         test.info("hi good morning");

         test.fail("this is fail");

         return extent;    }




}
