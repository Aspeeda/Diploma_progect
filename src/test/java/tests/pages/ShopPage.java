package tests.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class ShopPage {

    private static String TITLE = "Интернет-магазин";


    public void checkTitle() {
        $$(".menu-item").first().shouldHave(text(TITLE));
    }
}
