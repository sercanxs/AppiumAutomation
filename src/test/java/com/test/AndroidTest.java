package com.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;


import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

    public class AndroidTest {


    @Test
    public void androidLaunchTest() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("Pixel_34");

        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");



        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.findElement(AppiumBy.accessibilityId("open menu")).click();

         /*new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(e->e.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]")));*/





        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]"))
                .click();

        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("wfwdfg");
        driver.quit();


    }
    @Test
    public void tap() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("Pixel_34");



        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");


        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        WebElement openMenu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        tap(driver, openMenu);
        //Assertion
    }

    private void tap(AndroidDriver driver, WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point centerOfElement = getCenterOfElement(location, size);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    private Point getCenterOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth() / 2,
                location.getY() + size.getHeight() / 2);
    }

        @Test
        public void doubleTap() throws MalformedURLException, InterruptedException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android"); //optional
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
            options.setDeviceName("Pixel_34");
            options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            WebElement openMenu = driver.findElement(AppiumBy.accessibilityId("open menu"));
            doubleTap(driver, openMenu);
            //Assertion
        }
        private void doubleTap(AndroidDriver driver, WebElement element) {
            Point location = element.getLocation();
            Dimension size = element.getSize();

            Point centerOfElement = getCenterOfElement(location, size);

            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence sequence = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(100)))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(100)))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(100)))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(sequence));
        }

        @Test
       public void longPress() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android"); //optional
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
            options.setDeviceName("Pixel_34");
            options.setApp(System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

            driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();
            driver.findElement(AppiumBy.xpath(".//*[@text='Expandable Lists']")).click();
            driver.findElement(AppiumBy.xpath(".//*[@text='1. Custom Adapter']")).click();
            WebElement element = driver.findElement(AppiumBy.xpath(".//*[@text='People Names']"));
            longPress(driver, element);
            //new Actions(driver).clickAndHold(element).perform();
            //Assertion
        }
        private void longPress(AndroidDriver driver, WebElement element) {
            Point location = element.getLocation();
            Dimension size = element.getSize();

            Point centerOfElement = getCenterOfElement(location, size);

            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence sequence = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(sequence));
        }



        @Test
        public void zoom() throws MalformedURLException, InterruptedException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android"); //optional
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
            options.setDeviceName("Pixel_34");
            options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            driver.findElement(AppiumBy.accessibilityId("open menu")).click();
            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item drawing\"]"))
                    .click();
            WebElement element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drawing screen\"]"));
            Point centerOfElement = getCenterOfElement(element.getLocation(), element.getSize());

            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
            Sequence sequence = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(200)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(200),
                            PointerInput.Origin.viewport(), centerOfElement.getX() + 100,
                            centerOfElement.getY() - 100))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            Sequence sequence2 = new Sequence(finger2, 1)
                    .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                    .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger2, Duration.ofMillis(200)))
                    .addAction(finger2.createPointerMove(Duration.ofMillis(200),
                            PointerInput.Origin.viewport(), centerOfElement.getX() - 100,
                            centerOfElement.getY() + 100))
                    .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(sequence, sequence2));

            //Assertion
        }

        @Test
       public void swipeOrScroll() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android"); //optional
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
            options.setDeviceName("Pixel_34");
            options.setApp(System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

            driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();

            Dimension size = driver.manage().window().getSize();
            int startX = size.getWidth() / 2;
            int startY = size.getHeight() / 2;
            int endX = startX;
            int endY = (int) (size.getHeight() * 0.25);
            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence sequence = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(200)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(sequence));
            //Assertion
        }


        @Test
        public void dragAndDrop() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android"); //optional
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
            options.setDeviceName("Pixel_34");
            options.setApp(System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

            driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();
            driver.findElement(AppiumBy.xpath(".//*[@text='Drag and Drop']")).click();

           WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
           WebElement target = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));

           Point sourceElementCenter = getCenterOfElement(source.getLocation(), source.getSize());
           Point targetElementCenter = getCenterOfElement(target.getLocation(), target.getSize());

           PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence sequence = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(500)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), targetElementCenter))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


            driver.perform(Collections.singletonList(sequence));

        }


        @Test
        public void saucelabs() throws MalformedURLException, InterruptedException {

            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:app", "storage:filename=Android-MyDemoAppRN.1.3.0.build-244.apk");  // The filename of the mobile app
            caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
            caps.setCapability("appium:deviceOrientation", "portrait");
            caps.setCapability("appium:platformVersion", "12.0");
            caps.setCapability("appium:automationName", AutomationName.ANDROID_UIAUTOMATOR2);
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", "sercanxs");
            sauceOptions.setCapability("accessKey", "165399da-5ced-4795-b37e-f58f5d19d8cd");
            sauceOptions.setCapability("build", "appium-build-SZLSN");
            sauceOptions.setCapability("name", "<your test name>");
            caps.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            AndroidDriver driver = new AndroidDriver(url, caps);

            WebElement openMenu = driver.findElement(AppiumBy.accessibilityId("open menu"));
            tap(driver, openMenu);

            driver.quit();
            //Assertion

    }

        @Test
        public void saucelabs123() throws MalformedURLException, InterruptedException {

            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:app", "storage:filename=iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");  // The filename of the mobile app
            caps.setCapability("appium:deviceName", "iPhone XS Simulator");
            caps.setCapability("appium:deviceOrientation", "portrait");
            caps.setCapability("appium:platformVersion", "13.2");
            caps.setCapability("appium:automationName", "XCUITest");
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", "sercanxs");
            sauceOptions.setCapability("accessKey", "165399da-5ced-4795-b37e-f58f5d19d8cd");
            sauceOptions.setCapability("build", "appium-build-SZLSN");
            sauceOptions.setCapability("name", "<your test name>");
            caps.setCapability("sauce:options", sauceOptions);


            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            IOSDriver driver = new IOSDriver(url, caps);

            driver.quit();





        }
        @Test
        public void saucelabsBrowser() throws MalformedURLException, InterruptedException {

            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", "iOS");
            caps.setCapability("browserName", "Safari");
            caps.setCapability("appium:deviceName", "iPhone XS Simulator");
            caps.setCapability("appium:deviceOrientation", "portrait");
            caps.setCapability("appium:platformVersion", "13.2");
            caps.setCapability("appium:automationName", "XCUITest");
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", "sercanxs");
            sauceOptions.setCapability("accessKey", "165399da-5ced-4795-b37e-f58f5d19d8cd");
            sauceOptions.setCapability("build", "appium-build-SZLSN");
            sauceOptions.setCapability("name", "<your test name>");
            caps.setCapability("sauce:options", sauceOptions);


            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            IOSDriver driver = new IOSDriver(url, caps);

            driver.get("https://www.cybertekschool.com");



            Thread.sleep(2000);

            driver.quit();





        }



//test




    }
