package pl.akademiaqa.modul7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class _5UploadTest extends BaseTest {


    @Test
    void uploadFileTest(){
        page.navigate("http://localhost:7080/upload");

        page.setInputFiles("#file-upload", Paths.get("uploads/upload-file.txt"));
        page.setInputFiles("#file-upload", new Path[0]);//zmieniamy zdanie usuwanie pliku
        page.setInputFiles("#file-upload", Paths.get("uploads/upload-file_1.txt"));
        page.locator("#file-submit").click();
        assertThat(page.locator("#content")).containsText("File Uploaded!");
        assertThat(page.getByText("FIle Uploaded")).isVisible();
    }

    @Test
    void uploadMultipleFileTest(){
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

        page.setInputFiles("#filesToUpload", new Path[]{
                Paths.get("uploads/upload-file.txt"),
                Paths.get("uploads/upload-file_1.txt")
        });
    }

}
