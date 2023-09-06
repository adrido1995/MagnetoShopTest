package pl.testeroprogramowania.tests;

import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class LogInTest extends BaseTest{
    @Test
    public void LogInTest() {
        new HomePage(driver)
                .LogIn()
                .fillLogInDetails("tester810@test.pl","p@ssword456");
    }
}
