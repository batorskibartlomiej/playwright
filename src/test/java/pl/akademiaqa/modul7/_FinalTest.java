package pl.akademiaqa.modul7;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.nio.file.Paths;

public class _FinalTest extends BaseTest {

    @Test
    void contact_form_test_fail() {
        page.navigate("http://www.automationpractice.pl");
        //page.pause();
        page.locator("#contact-link").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send")).click();
        PlaywrightAssertions.assertThat(page.getByText("There is 1 error")).isVisible();
        PlaywrightAssertions.assertThat(page.getByText("Invalid email address.")).isVisible();
        page.locator("//*[@class='alert alert-danger']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots/send.jpeg")));

    }

    @Test
    void contact_form_test_pass() {
        page.navigate("http://www.automationpractice.pl");
        //page.pause();
        page.locator("#contact-link").click();
        page.selectOption("#id_contact", "2");
        page.fill("#email", "test@wp.pl");
        page.fill("#id_order", "test");
        page.setInputFiles("#fileUpload", Paths.get("uploads/upload-file.txt"));
        page.type("#message", "terefere");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send")).click();
        PlaywrightAssertions.assertThat(page.getByText("Your message has been successfully sent to our team")).isVisible();
        //mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args=”show-trace traces/trace_contact_form_test_pass_2025-03-01_13-18-35.zip"





    }


}
