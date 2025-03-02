package pl.akademiaqa.modul8.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TopMenuSection {

    private Page page;
    private Locator contactUsLink;

    public TopMenuSection(Page page) {
        this.page = page;
        this.contactUsLink = page.locator("#contact-link");
    }

    public void clickOnContactUsLink(){
        contactUsLink.click();


    }
}
