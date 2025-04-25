package heroku;

import org.testng.annotations.*;

public class Annotation {

        @BeforeSuite
        void beforeSuite() {
            System.out.println("Before Suite");
        }

        @BeforeTest
        void beforeTest() {
            System.out.println("Before Test");
        }
        @BeforeClass
        void beforeClass() {
            System.out.println("Before Class");
        }

        @BeforeMethod
        void beforeMethod() {
            System.out.println("Before Method");
        }

        @Test
        void testMethod1() {
            System.out.println("Test Method 1");
        }

        @Test
        void testMethod2() {
            System.out.println("Test Method 2");
        }

        @Test
        void testMethod3() {
            System.out.println("Test Method 3");
        }

        @Test
        void testMethod4() {
            System.out.println("Test Method 4");
        }

        @Test
        void testMethod5() {
            System.out.println("Test Method 5");
        }

        @AfterMethod
        void afterMethod() {
            System.out.println("After Method");
        }
        @AfterClass
        void afterClass() {
            System.out.println("After Class");
        }
        @AfterTest
        void afterTest() {
            System.out.println("After Test");
        }
        @AfterSuite
        void afterSuite() {
            System.out.println("After Suite");
        }


}
