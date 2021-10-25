package testNgListeners;

import org.testng.*;

public class TestNGlisteners implements ITestListener {

    @Override
    public void onTestStart(ITestResult context) {
        ITestListener.super.onTestStart(context);
        System.out.println("Test starts.... " + context.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("Success of test cases and its details are: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //ITestListener.super.onTestFailure(result);
        System.out.println("Failure of test cases and its details are: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //ITestListener.super.onTestSkipped(result);
        System.out.println("Skip of test cases and its details are: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        System.out.println("Test failed but withing success percentage " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        //ITestListener.super.onStart(context);
        System.out.println("onStart method started");
    }

    @Override
    public void onFinish(ITestContext context){
        //ITestListener.super.onFinish(context);
        System.out.println("onFinish method finished");
    }
}
