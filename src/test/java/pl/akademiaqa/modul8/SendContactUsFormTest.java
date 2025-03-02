package pl.akademiaqa.modul8;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;
import pl.akademiaqa.modul8.pages.ContactUsPage;
import pl.akademiaqa.modul8.pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class SendContactUsFormTest extends BaseTest {


    @Test
    void should_show_an_error_when_trying_to_send_empty_form_test(){
        page.navigate("http://www.automationpractice.pl");
        HomePage homePage= new HomePage(page);
        ContactUsPage contactUsPage = new ContactUsPage(page);

        homePage.getTopMenuSection().clickOnContactUsLink();
        contactUsPage.getContactUsFormSection().clickOnSendButton();
        assertThat(contactUsPage.getContactUsFormSection().getErrorMessage()).isVisible();

    }
}
