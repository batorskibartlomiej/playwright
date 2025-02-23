package pl.akademiaqa.modul7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _9BasicAuthTest extends BaseTest {

    @Test
    void basicAuthTest(){
        page.navigate("http://localhost:7080/basic_auth");
        PlaywrightAssertions.assertThat(page.getByText("Congratulations! You must have the proper credentials.")).isVisible();

    }



}
