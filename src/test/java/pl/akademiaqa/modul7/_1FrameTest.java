package pl.akademiaqa.modul7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

public class _1FrameTest extends BaseTest {

    @Test
    void should_enter_the_text_into_the_iframe(){
        page.navigate("http://localhost:7080/iframe");
        //jezeli nie ma nazwy to uzywamy frameLocator
        page.frameLocator("#mce_0_ifr").locator("#tinymce").fill("test");

    }

    @Test
    void should_enter_the_text_into_the_iframe2(){
        page.navigate("http://localhost:7080/nested_frames");
        //jezeli jest nazwa iframe to wetdy page.frame
        PlaywrightAssertions.assertThat(page.frame("frame-middle").locator("#content")).hasText("MIDDLE");

    }


}
