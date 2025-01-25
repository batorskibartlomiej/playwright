package pl.akademiaqa.modul4;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

public class LoginWithValidCredentials extends BaseTest {


    @Test
    void should_login_with_valid_credentials(){
        page.navigate("http://localhost:7080/login");
        page.getByLabel("Username").fill("tomsmith");
        page.getByLabel("Password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();



        PlaywrightAssertions.assertThat(page.getByText("text=You logged into a secure area!")).isVisible();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
        PlaywrightAssertions.assertThat(page.getByText("text=You logged out of the secure area!")).isVisible();




    }

}
