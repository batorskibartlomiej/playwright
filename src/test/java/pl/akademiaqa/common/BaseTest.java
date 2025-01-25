package pl.akademiaqa.common;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class BaseTest {

    private static Playwright pw;
    private static Browser browser;

    private BrowserContext context;

    protected Page page;

    @BeforeAll
    static void beforeAll(){

        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }

    @BeforeEach
    void beforeEach(){
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void afterEach(){
        context.close();
    }

    @AfterAll
    static void afterAll(){
        pw.close();

    }

}
