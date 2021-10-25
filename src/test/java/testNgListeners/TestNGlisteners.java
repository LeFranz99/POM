package testNgListeners;

import org.testng.*;

// //Listeners are required to generate logs or customize TestNG reports in Selenium Webdriver.
// ITestListener is an interface which implements testNG listeners.
public class TestNGlisteners implements ITestListener {

    // onTestStart(): An onTestStart() is invoked only when any test method gets started.
    @Override
    public void onTestStart(ITestResult context) {
        ITestListener.super.onTestStart(context);
        System.out.println("Test starts.... " + context.getName());
    }

    // onTestSuccess(): An onTestSuccess() method is executed on the success of a test method.
    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("Success of test cases and its details are: " + result.getName());
    }

    // onTestFailure(): An onTestFailure() method is invoked when test method fails.
    @Override
    public void onTestFailure(ITestResult result) {
        //ITestListener.super.onTestFailure(result);
        System.out.println("Failure of test cases and its details are: " + result.getName());
    }

    // onTestSkipped(): An onTestSkipped() run only when any test method has been skipped.
    @Override
    public void onTestSkipped(ITestResult result) {
        //ITestListener.super.onTestSkipped(result);
        System.out.println("Skip of test cases and its details are: " + result.getName());
    }

    // onTestFailedButWithinSuccessPercentage(): This method is invoked each time when the test method fails
    // but within success percentage.
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        System.out.println("Test failed but withing success percentage " + result.getName());
    }

    // onStart(): An onStart() method is executed on the start of any test method.
    @Override
    public void onStart(ITestContext context) {
        //ITestListener.super.onStart(context);
        System.out.println("onStart method started");
    }

    // onFinish(): An onFinish() is invoked when any test case finishes its execution.
    @Override
    public void onFinish(ITestContext context){
        //ITestListener.super.onFinish(context);
        System.out.println("onFinish method finished");
    }

    public class MySuiteListener implements ISuiteListener {

        // onStart: invoked before test suite execution starts
        @Override
        public void onStart(ISuite suite1) {
            System.out.println("Suite1 started");
        }

        // onFinish: invoked after test suite execution finishes.
        @Override
        public void onFinish(ISuite suite1) {
            System.out.println("Suite1 finished");
        }
    }
}
