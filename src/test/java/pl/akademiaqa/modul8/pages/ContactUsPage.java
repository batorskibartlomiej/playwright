package pl.akademiaqa.modul8.pages;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.modul8.pages.sections.ContactUsFormSection;

public class ContactUsPage {

    @Getter
    private ContactUsFormSection contactUsFormSection;


    public ContactUsPage(Page page) {

        this.contactUsFormSection =  new ContactUsFormSection(page);
    }




}
