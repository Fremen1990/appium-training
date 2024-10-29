const assert = require('assert');
const AndroidTestConfig = require('./common/AndroidTestConfig');
const ForecastPage = require('./ForecastPage');

describe('Forecast', function () {

    // this.timeout(60 * 1000);

    let testConfig;
    let forecastPage;

    before(function () {
        // AndroidTestConfig.startServer();
    });

    after(function () {
        // AndroidTestConfig.stopServer();
    });

    beforeEach(async function () {
        testConfig = new AndroidTestConfig();
        await testConfig.initDriver();
        const driver = testConfig.getDriver();
        forecastPage = new ForecastPage(driver);
    });

    afterEach(async function () {
        await testConfig.releaseDriver();
    });
    
    it('given city is provided when check forecast then should display the forecast', async function () {
        const cityName = "gdynia";
        await forecastPage.enterCityName(cityName);
        await forecastPage.checkWeather();
        const city = await forecastPage.city();
        await city.waitForDisplayed({timeout: 5000});
        assert.equal(cityName, await city.getText());
    });

});
