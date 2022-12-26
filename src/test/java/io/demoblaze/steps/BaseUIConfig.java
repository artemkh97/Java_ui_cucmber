package io.demoblaze.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.demoblaze.utils.config.Config;
import io.demoblaze.utils.config.Project;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseUIConfig {
    @Before
    public void setBrowser() {
        System.out.println("Config before \"Ui\" test group");
        Configuration.screenshots = true;
        Configuration.timeout = 30000;

        Configuration.browser = Project.config.browser();
        Configuration.browserSize = Project.config.browserSize();
        Configuration.baseUrl = Config.getServiceConfig().projectUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--lang=en-en");

        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = Project.config.remoteDriverUrl();
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }

    @After
    public void close() {
        Selenide.closeWebDriver();
    }
}
