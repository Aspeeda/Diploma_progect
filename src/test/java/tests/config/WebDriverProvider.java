package tests.config;

import com.codeborne.selenide.Configuration;

import org.aeonbits.owner.ConfigFactory;


public class WebDriverProvider {

    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void configuration() {
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowser().toString();
        Configuration.browserSize = config.getBrowserSize();
        String remoteUrl = String.valueOf(config.getRemoteURL());
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
        }
    }
}