package pl.training;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForecastPage {

    @FindBy(id = "pl.training.runkeeper:id/city_name_edit")
    public WebElement cityEdit;
    @FindBy(id ="pl.training.runkeeper:id/check_button")
    public WebElement checkButton;
    @FindBy(id = "pl.training.runkeeper:id/city_name_text")
    public WebElement city;

    public void enterCityName(String cityName) {
        cityEdit.sendKeys(cityName);
    }

    public void checkWeather() {
        checkButton.click();
    }

}
