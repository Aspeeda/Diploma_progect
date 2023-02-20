package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage {

    private static String TITLE = "Найдено в категориях";
    private SelenideElement title = $(".digi-title");
    private static final SelenideElement logo = $(".header-logo");


    @Step("Проверить, что выведенные значения совпадают с введенными")
    public void verifyResult() {
        assertThat(title.getText()).isEqualTo(TITLE);
    }

    @Step("Click on header logo")
    public static void clickOnHeaderLogo() {
        logo.click();
    }
}
