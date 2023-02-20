package tests.UItests.APItests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.MainPage;
import tests.pages.SearchPage;
import tests.pages.ShopPage;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static tests.pages.MainPage.*;

@Epic("Diploma project")
@Story("Testing web redmond")
public class PressButtonsOnMainPageTest extends TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Test
    @DisplayName("Test button search clickable")
    public void clickButtonSearch() {

        step("Открыть страницу", () -> mainPage.openPage());

        step("Кликнуть на кнопку поиска в шапке", MainPage::clickOnHeaderSearch);

        step("Проверить появление строки поиска", () -> inputSearch.shouldHave(Condition.exist));
    }

    @Test
    @DisplayName("Test enter text in search input")
    public void searchInputFilling() {

        step("Открыть страницу", () -> mainPage.openPage());

        step("Кликнуть на кнопку поиска в шапке и заполнить поле, нажать Enter", () -> {
            clickOnHeaderSearch();
            setText("мультиварка");
            inputSearch.pressEnter();
        });

        step("Проверить переход на страницу результатов поиска", () -> searchPage.verifyResult());
    }

    @Test
    @DisplayName("Scroll down and check license")
    public void scrollingDownCheckLicense() {

        step("Открыть страницу", () -> mainPage.openPage());
        step("Прокрутить до конца страницы", () -> $("footer").scrollTo()); // TODO: 20.02.2023 разобраться со скроллом
        step("Проверить наличие записи о защите прав", () -> $(withText(LICENSE)).shouldHave(Condition.exist));
    }

    @Test
    @DisplayName("Click logo on search page")
    public void clickOnLogo() {

        step("Открыть страницу", () -> mainPage.openPage());

        step("Кликнуть на кнопку поиска в шапке и заполнить поле, нажать Enter", () -> {
            clickOnHeaderSearch();
            setText("мультиварка");
            inputSearch.pressEnter();
        });

        step("Проверить переход на страницу результатов поиска", () -> searchPage.verifyResult());

        step("нажать на лого", SearchPage::clickOnHeaderLogo);

    }
    @Test
    @DisplayName("Test button search clickable")
    public void clickButtonShop() {
        ShopPage shopPage = new ShopPage();

        step("Открыть страницу", () -> mainPage.openPage());

        step("Кликнуть на кнопку поиска в шапке", MainPage::clickOnHeaderShop);

        step("Проверить появление строки поиска", () -> shopPage.checkTitle());
    }

    @Test
    @DisplayName("Test button search clickable")
    public void takeItemInBasket() {
        ShopPage shopPage = new ShopPage();

        step("Открыть страницу", () -> mainPage.openPage());

        step("Кликнуть на кнопку поиска в шапке", MainPage::clickOnHeaderShop);

        step("Проверить появление строки поиска", () -> shopPage.checkTitle());


    }

}
