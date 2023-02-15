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
import static tests.pages.MainPage.TEXT;

@Epic("Diploma project")
@Story("Testing web astondevs")
public class PressButtonsOnMainPageTest extends TestBase {
MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Test button clicability")
    public void ClickButtonPrice() {

        step("Открыть страницу", () -> mainPage.openPage());
        step("Кликнуть на кнопку 'Расчитать стоимость'", MainPage::clickOnPrice);
        step("Проверить переход на страницу расчета", ()-> $(withText(TEXT)).should(Condition.exist));
    }
}
