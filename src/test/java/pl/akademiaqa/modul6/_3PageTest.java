package pl.akademiaqa.modul6;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

public class _3PageTest extends BaseTest {

    @Test
    void textTest(){

        page.navigate("http://localhost:7080/notification_message_rendered");

        //1. innerHTML() - tags + text
        //System.out.println(page.innerHTML("#content"));

        //2. innerText()=text-najczesciej bedzie uzywany
        //System.out.println(page.innerText("#content"));

        //3.textContent() - text, ale widoczny i niewidoczny(np: <span display:none>hidden)
        //System.out.println(page.textContent("#content"));

        //4.getAttribute() - atrybuty elemntu html
        System.out.println(page.getAttribute("div img", "alt"));

    }
}
