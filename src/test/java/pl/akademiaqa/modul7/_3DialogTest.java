package pl.akademiaqa.modul7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

public class _3DialogTest extends BaseTest {

    @Test
    void dialogAlertTest(){
        page.navigate("http://localhost:7080/javascript_alerts");
        //HANDLER ZAWSZE PRZED KLIKNIECIEM!!!
        page.onDialog(dialog-> {
            page.waitForTimeout(3000);
            dialog.accept();
        });

        page.locator("text='Click for JS Alert'").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You successfuly clicked an alert\n" +
                "\n");

    }

    @Test
    void dialogConfirmTest(){//jesli dwie operacje na dialogach to wtedy onceDialog
        page.navigate("http://localhost:7080/javascript_alerts");


        page.onceDialog(dialog-> {
            page.waitForTimeout(3000);
            dialog.accept();
        });
        page.locator("text=Click for JS Confirm").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Ok");

        page.onceDialog(dialog-> {
            page.waitForTimeout(3000);
            dialog.dismiss();
        });

        page.locator("text=Click for JS Confirm").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Cancel");


    }

    @Test
    void dialogPromptTest(){
        page.navigate("http://localhost:7080/javascript_alerts");

        page.onceDialog(dialog-> {
            page.waitForTimeout(3000);
            dialog.accept("Test");
        });

        page.locator("text=Click for JS Prompt").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You entered: Test\n" +
                "\n");

    }


}
