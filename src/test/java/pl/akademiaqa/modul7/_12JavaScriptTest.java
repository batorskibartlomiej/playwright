package pl.akademiaqa.modul7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

public class _12JavaScriptTest extends BaseTest {
    //wykonanie javascirpt
    @Test
    void evaluateTest() {
        page.navigate("http://localhost:7080");
        String window = (String) page.evaluate("()=> window.origin");
        System.out.println("windowInfo: " + window);
    }

    @Test
    void evalOnSelectorTest() {
        page.navigate("http://localhost:7080");
        PlaywrightAssertions.assertThat(page.locator("h1[class=heading]")).isVisible();
        page.evalOnSelector("h1[class=heading]", "e=> e.remove()");
        page.waitForTimeout(2000);
        PlaywrightAssertions.assertThat(page.locator("h1[class=page-heading]")).not().isVisible();

    }

    @Test
    void evalOnSelectorAllTest() {
        page.navigate("http://localhost:7080");
        Integer numberOfLinks = (Integer)page.evalOnSelectorAll("ul li", "e=> e.lenght");
        Assertions.assertThat(numberOfLinks).isEqualTo(44);

    }
}
