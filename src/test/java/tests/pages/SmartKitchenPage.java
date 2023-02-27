package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class SmartKitchenPage {
    private static String TITLE = "Умная кухня";
    private SelenideElement title = $(".catalog-page-title");

    @Step("Проверить, что выведенные значения совпадают с введенными")
    public void verifyResult() {
        assertThat(title.getText()).isEqualTo(TITLE);
    }
}
