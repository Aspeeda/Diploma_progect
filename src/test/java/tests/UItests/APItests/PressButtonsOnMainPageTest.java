package tests.UItests.APItests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.MainPage;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static tests.pages.MainPage.*;

@Epic("Diploma project")
@Story("Testing web astondevs")
public class PressButtonsOnMainPageTest extends TestBase {
MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Test button price clicability")
    public void clickButtonPrice() {

        step("Открыть страницу", () -> mainPage.openPage());
        step("Кликнуть на кнопку 'Расчитать стоимость'", MainPage::clickOnPrice);
        step("Проверить переход на страницу расчета", ()-> $(withText(TEXT)).should(Condition.exist));
    }
    @Test
    @DisplayName("Test button request call clicability")
    public void clickRequestCall() {

        step("Открыть страницу", () -> mainPage.openPage());
        step("Кликнуть на кнопку 'Оставить заявку'", MainPage::clickOnSendApplication);
        step("Проверить переход на страницу расчета", ()-> $(withText(APPLICATION)).should(Condition.exist));
    }
    /**

     * 2. нажать отрасли, проверить все наименования (сделать модель данных по отраслям)
     * 3.нажать проекты - нажать лого - возврат на главную страницу
     * 4.нажать узнать стоимость (сделать API) - заполнить и нажать рассчитать - переход на заполнение контактов
     * 5.нажать компания - нажать запросить консультацию - переход на заполнение контактов
     */

    @Test
    @DisplayName("Scroll down and check phone number")
    public void scrollingDownCheckPhoneNumber() {

        step("Открыть страницу", () -> mainPage.openPage());
        step("Прокрутить до конца страницы", () -> $(FOOTER).scrollIntoView("{block:\"end\"}"));
        step("Проверить наличие записи о защите прав", ()-> $(withText(LICENSE)).should(Condition.exist));
    }
    @Test
    @DisplayName("Check industies tab")
    public void checkIndustries() {

        step("Открыть страницу", () -> mainPage.openPage());
        step("Кликнуть на вкладку 'Отрасли'", MainPage::clickOnIndustry);
        step("Проверить переход на страницу расчета", ()-> $(withText("eCommerce")).should(Condition.exist));
    }
}
