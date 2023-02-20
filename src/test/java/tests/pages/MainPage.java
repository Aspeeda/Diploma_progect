package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private static final SelenideElement search = $(".header-search-link");
    public static SelenideElement inputSearch = $(".digi-search-form__input");
    private final SelenideElement title = $(".main-page-home-slider-content-title-big");

    public static String LICENSE = "© 2022 REDMOND™";
    private static String TITLE = "На страже чистоты!";


    public static String COPYRIGHT = ".text-white copyright";
    public static String SHOP = ".menu-item";

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
//    @Step("Click on header button price")
//    public static void clickOnPrice() {
//        priceButton.click();
//    }
}