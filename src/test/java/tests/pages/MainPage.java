package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private static final SelenideElement AstonLogo = $("#Header-module--logoWrap");
    private static SelenideElement PriceButton = $("#Button-module--themeHeader--WhpKM");
    public static String TEXT = "Запросить оценку стоимости ИT-проекта";
    private static String TITLE = "ИТ-решения для развития бизнеса";

    public MainPage openPage() {
        open("https://astondevs.ru/");
        $(".TitleWith-module--title--bojgT").shouldHave(text(TITLE));
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");
//        executeJavaScript("$('#jivo_close_button').click");
        return this;
    }

    @Step("Click on header logo")
    public static void clickOnAstonLogo() {
        AstonLogo.click();
    }

    @Step("Click on header button price")
    public static void clickOnPrice() {
        PriceButton.click();

    }
}
