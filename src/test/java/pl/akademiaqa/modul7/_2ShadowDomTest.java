package pl.akademiaqa.modul7;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

public class _2ShadowDomTest extends BaseTest {


    @Test
    void shadowDOMTest(){
        page.navigate("http://localhost:7080/shadowdom");
        System.out.println(page.locator("span[slot=my-text]").innerText());
    }

    @Test
    void shadowDOMTest2(){
        page.navigate("https://bugs.chromium.org/p/chromium/issues/list");
        page.selectOption("#can", "New issues");
    }
}
