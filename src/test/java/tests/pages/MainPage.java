package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private static final SelenideElement search = $(".header-search-link");
    public static SelenideElement inputSearch = $(".digi-search-form__input");
    private final SelenideElement title = $(".main-page-home-slider-content-title-big");
    public static SelenideElement middleSection = $x("//div[contains(text(), 'Умная кухня')]"); // TODO: 26.02.2023 params
    public static SelenideElement endOfPage = $x("//a[contains(text(), 'Мы в соцсетях')]");

    public static String TEXT_SUBSCRIBE = "Подпишись на наши соцсети, участвуй в розыгрышах, следи за новостями и " +
            "получай промокоды на скидки в наших интернет-магазинах.";
    public static String LICENSE = "© 2022 REDMOND™";
    private static final String TITLE = "На страже чистоты!";
    public static String SHOP = ".menu-item";
    public static String LIST_ITEM = ".main-page-menu-list-item";

    public MainPage openPage() {
        open("https://redmond.company/");
        title.shouldHave(text(TITLE));
        $(".closeButton_e23c");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Click on header search")
    public static void clickOnHeaderSearch() {
        search.click();
    }

    @Step("Click on header shop")
    public static void clickOnHeaderShop() {
        $$(SHOP).first().click();
    }

    @Step("Fill input")
    public static void setText(String text) {
        inputSearch.setValue(text);
    }
}