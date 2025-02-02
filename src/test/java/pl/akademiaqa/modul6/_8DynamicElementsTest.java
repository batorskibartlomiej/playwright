package pl.akademiaqa.modul6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class _8DynamicElementsTest extends BaseTest {

    @Test
    void dynamicElementTest1() {
        page.navigate("http://localhost:7080/dynamic_loading/1");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        assertThat(text).not().isVisible();

        Locator start = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start"));
        start.click();
        assertThat(text).isVisible();

    }

    @Test
    void dynamicElementTest2() {
        page.navigate("http://localhost:7080/dynamic_loading/2");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        assertThat(text).not().isVisible();

        Locator start = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start"));
        start.click();
        assertThat(text).isVisible();
    }

    @Test
    void dynamicControlsTest1(){
        page.navigate("http://localhost:7080/dynamic_controls");
        Locator checkobx = page.locator("#checkbox");
        assertThat(checkobx).isVisible();
        Locator removeBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove"));
        removeBtn.click();
        assertThat(removeBtn).not().isVisible();
        assertThat(page.getByText("it's gone")).isVisible();
    }

    @Test
    void dynamicControlsTest2(){
        page.navigate("http://localhost:7080/dynamic_controls");
        Locator input = page.locator("#input-example input[type=text]");
        assertThat(input).isDisabled();
        Locator enableBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enable"));
        enableBtn.click();
        assertThat(enableBtn).not().isVisible();
        assertThat(page.getByText("it's enabled")).isVisible();


    }



}
