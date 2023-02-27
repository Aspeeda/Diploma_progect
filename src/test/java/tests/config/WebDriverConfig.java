package tests.config;
import com.codeborne.selenide.Browser;
import org.aeonbits.owner.Config;
import java.net.URL;

public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://redmond.company")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("remoteUrl")
    @DefaultValue("http://localhost:4444/wd/hub")
    URL getRemoteURL();

}