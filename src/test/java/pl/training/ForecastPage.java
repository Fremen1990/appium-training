package pl.training;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForecastPage {

    @FindBy(id = "pl.training.runkeeper:id/city_name_edit")
    WebElement cityEdit;
    @FindBy(id ="pl.training.runkeeper:id/check_button")
    WebElement checkButton;
    @FindBy(id = "pl.training.runkeeper:id/city_name_text")
    WebElement city;

}
