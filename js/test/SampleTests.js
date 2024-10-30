const assert = require('assert');
const AndroidTestConfig = require('./AndroidTestConfig');
const SamplePage = require('./SamplePage');

describe.only('Sample', function () {

    this.timeout(180 * 1000);

    let testConfig;
    let samplePage;

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
        samplePage = new SamplePage(driver);
    });

    afterEach(async function () {
        await testConfig.releaseDriver();
    });

    it('login as standard user', async function () {
        const standardUser = await samplePage.standardUser()
        await standardUser.click()
        await samplePage.clickOnLoginButton()
        await samplePage.scrollUntilFindText("Sauce Labs Onesie")
        await samplePage.clickOnAddToCart()
        await samplePage.clickOnCartTab()
        await samplePage.checkIfOnCartScreen()
        await samplePage.checkIfAddedProductIsInTheCart()
        await samplePage.goToContinueShopping()
        await samplePage.checkIfProductsScreen()

    });


});
