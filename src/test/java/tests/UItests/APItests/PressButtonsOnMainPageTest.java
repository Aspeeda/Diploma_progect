package tests.UItests.APItests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.BaseTest;
import tests.pages.MainPage;
import tests.pages.SearchPage;
import tests.pages.ShopPage;
import tests.pages.SmartKitchenPage;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static tests.pages.MainPage.*;

@Epic("Diploma project")
@Story("Testing web redmond")
public class PressButtonsOnMainPageTest extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    SmartKitchenPage smartKitchenPage = new SmartKitchenPage();

    private final String TEXT_FOR_SEARCH = "мультиварка";

    @Test
    @DisplayName("Test button search clickable")
    public void clickButtonSearch() {

        step("Открыть страницу", () ->
                mainPage.openPage());

        step("Кликнуть на кнопку поиска в шапке", () ->
                mainPage.clickOnHeaderSearch());

        step("Проверить появление строки поиска", () ->
                mainPage.inputSearch.shouldHave(Condition.exist));
    }

    @Test
    @DisplayName("Test enter text in search input")
    public void searchInputFilling() {

        step("Открыть страницу", () ->
                mainPage.openPage());

        step("Кликнуть на кнопку поиска в шапке и заполнить поле, нажать Enter", () -> {
            mainPage.clickOnHeaderSearch();
            mainPage.setText("мультиварка");
            mainPage.inputSearch.pressEnter();
        });

        step("Проверить переход на страницу результатов поиска", () ->
                searchPage.verifyResult());
    }

    @Test
    @DisplayName("Scroll down and check license")
    public void scrollingDownCheckLicense() {

        step("Открыть страницу", () ->
                mainPage.openPage());

        step("Прокрутить до конца страницы", () ->
                mainPage.endOfPage.scrollTo());

        step("Проверить наличие записи о защите прав", () ->
                $(withText(TEXT_SUBSCRIBE)).shouldHave(Condition.exist));
    }

    @Test
    @DisplayName("Click logo on search page")
    public void clickOnLogo() {

        step("Открыть страницу", () -> mainPage.openPage());

        step("Кликнуть на кнопку поиска в шапке и заполнить поле, нажать Enter", () -> {
            mainPage.clickOnHeaderSearch();
            mainPage.setText(TEXT_FOR_SEARCH);
            mainPage.inputSearch.pressEnter();
        });

        step("Проверить переход на страницу результатов поиска", () -> {
            searchPage.verifyResult();
        });

        step("нажать на лого", SearchPage::clickOnHeaderLogo);

    }

    @Test
    @DisplayName("Test button search clickable")
    public void clickButtonShop() {
        ShopPage shopPage = new ShopPage();

        step("Открыть страницу", ()
                -> mainPage.openPage());

        step("Кликнуть на кнопку интернет-магазин", MainPage::clickOnHeaderShop);

        step("Проверить переход на страницу магазина", shopPage::checkTitle);
    }

    @Test
    @DisplayName("Test click on middle section")
    public void clickOnMiddleSection() {

        step("Открыть страницу", () -> mainPage.openPage());

        step("Скролл до средней панели и нажать на ссылку", () -> {
            mainPage.middleSection.scrollTo();
            $(LIST_ITEM).click();
        });

        step("Проверить переход на страницу", () -> {
            smartKitchenPage.verifyResult();
        });
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Test check footer is visible")
    public void checkFooterVisibility() {

        step("Открыть страницу", () -> mainPage.openPage());

        step("Прокрутить до конца страницы", () ->
                $("footer").scrollTo());

        step("Проверить наличие записи о защите прав", () ->
                $(withText(LICENSE)).shouldHave(Condition.exist));
    }

    @ValueSource(strings = {"Умная кухня", "Умный дом", "Роботы-пылесосы", "Мультиварки",
            "Мультикухни", "Мультипекари", "Грили", "Экотовары"})
    @ParameterizedTest(name = "\"{0}\"")
    @DisplayName("Test click on middle section")
    public void checkMiddleSectionTabs(String tabName) {

        step("Открыть страницу", () -> mainPage.openPage());

        step("Скролл до средней панели и нажать на ссылку", () -> {
            mainPage.middleSection.scrollIntoView(false);
        });

        step("Проверить видимость элементов в средней секции", () -> {
            $x("//div[contains(text(), '" + tabName + "')]").shouldBe(Condition.visible);
        });

    }
}
