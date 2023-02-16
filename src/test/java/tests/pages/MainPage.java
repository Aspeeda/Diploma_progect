package tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private static final SelenideElement application = $(".TitleWith-module--button--FTFLX");
    private static SelenideElement priceButton = $(".Button-module--themeHeader--WhpKM");
    private static SelenideElement header = $("MainNav-module--list--X5WUN");
    private static SelenideElement industry = header.find(byText("Отрасли"));

    public static String TEXT = "Запросить оценку стоимости ИT-проекта";
    public static String APPLICATION = "Оставить заявку";
    public static String LICENSE = "Aston. Все права защищены.";
    private static String TITLE = "ИТ-решения для развития бизнеса";

    public static String FOOTER = ".Footer-module--footer--LZE0a";

    public MainPage openPage() {
        open("https://astondevs.ru/");
        $(".TitleWith-module--title--bojgT").shouldHave(text(TITLE));
        $(".closeButton_e23c");
        if ($(".CookiesPolicy-module").exists()) {
            $(".CookiesPolicy-module--button--JZrW1").click();
        }
        return this;
    }

    @Step("Click on send application")
    public static void clickOnSendApplication() {
        application.click();
    }

    @Step("Click on header button price")
    public static void clickOnPrice() {
        priceButton.click();
    }
    @Step("Click on header industry") // TODO: 16.02.2023 переделать
    public static void clickOnIndustry() {
//        $("div#wow").hover();
        $$(".MainNav-module--item--LBV7Q").find(Condition.attribute("tabindex")).find(withText("Отрасли")).click();
//        industry.click();
    }
}
