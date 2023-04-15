package Day14_040923;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class PlayWright {

        public static void main(String[] args) {
            try (Playwright playwright = Playwright.create()) {
                Browser browser = playwright.webkit().launch();
                Page page = browser.newPage();
                page.navigate("http://whatsmyuseragent.org/");
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

            }
        }
    }

