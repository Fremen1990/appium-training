class ForecastPage {

    constructor(driver) {
        this.driver = driver;
    }

    async cityEdit() {
        return await this.driver.$("id:pl.training.runkeeper:id/city_name_edit");
    }

    async checkButton() {
        return await this.driver.$("id:pl.training.runkeeper:id/check_button");
    }

    async city() {
        return await this.driver.$("id:pl.training.runkeeper:id/city_name_text");
    }

    async enterCityName(cityName) {
        const element = await this.cityEdit();
        await element.addValue(cityName);
    }

    async checkWeather() {
        const element = await this.checkButton()
        await element.click();
    }

}

module.exports = ForecastPage;