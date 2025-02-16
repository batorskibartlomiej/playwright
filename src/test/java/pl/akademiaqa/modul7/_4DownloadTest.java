package pl.akademiaqa.modul7;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.nio.file.Path;
import java.nio.file.Paths;

public class _4DownloadTest extends BaseTest {

    @Test
    void dolwloadWithHandlerTest(){
        page.navigate("http://localhost:7080/download");
        //HANDLER ZAWSZE PRZED KLIKNIECIEM
        page.onDownload(download -> download.saveAs(Paths.get("dowloads/some-file.txt")));

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("some-file.txt")).click();

    }

    @Test
    void dolwloadWithSaveTest(){
        page.navigate("http://localhost:7080/download");
        //KLIKAMY
        Download download = page.waitForDownload(() -> page.getByText("some-file.txt").click());
        //ZAPISUJEMY
        download.saveAs(Paths.get("dowloads/some-file2.txt"));

    }



}
