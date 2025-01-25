package pl.akademiaqa.modul6;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

public class _2PageTest extends BaseTest {

    @Test
    void inputTest(){
        page.navigate("http://localhost:7080/login");
        page.fill("#username", "bartek");//wkleja caly teskt
        page.type("#password", "123456");//wpisuje znak po znaku

        page.fill(" ", "wartosc", new Page.FillOptions().setForce(true));//jesli element jest rpzysloniety innym polem

    }

}
