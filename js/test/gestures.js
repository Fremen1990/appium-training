const assert = require('assert');
const AndroidTestConfig = require('./common/AndroidTestConfig');
const ForecastPage = require('./ForecastPage');
const GestureImporter = require('./common/GestureImporter');

describe('Gestures', function () {

    this.timeout(60000);

    let testConfig;

    beforeEach(async function () {
        testConfig = new AndroidTestConfig();
        await testConfig.initDriver();
    });

    afterEach(async function () {
        await testConfig.releaseDriver();
    });
    
    it('swipe', async function () {
        const driver = testConfig.getDriver();
        const loginButton = await driver.$('android=new UiSelector().className(\"android.widget.Button\")');
        await loginButton.click();
        await driver.pause(3000);
        await driver.$('android=new UiSelector().text("Vertical swiping")').click();
        await driver.pause(3000);

       /*
        const element = await driver.$('android=new UiSelector().className("android.view.ViewGroup").instance(2)');
        const params = {
            elementId: element,
            direction: "up",
            percent: 1.0
        };
        await driver.execute('mobile: swipeGesture', params);

        */

        const importer = new GestureImporter(driver);
        const gestures = await importer.import('../gesture-SwipeUp.json')
        await driver.performActions(gestures);
        await driver.pause(3000);
    });

});
