package pl.training.common;

import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UIAssertions {

    public static void hasText(WebElement element, String text) {
        assertEquals(text, element.getText());
    }

}
