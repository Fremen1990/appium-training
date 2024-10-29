const AndroidTestConfig = require('./AndroidTestConfig');

async function runTest() {
    //AndroidTestConfig.startServer();
    const testConfig = new AndroidTestConfig();
    try {
        await testConfig.initDriver();
        const driver = testConfig.getDriver();
        const cityEdit = await driver.$("id:pl.training.runkeeper:id/city_name_edit");
        await cityEdit.addValue("gdynia");
        const checkButton = await driver.$("id:pl.training.runkeeper:id/check_button");
        await checkButton.click();
        const city = await driver.$("id:pl.training.runkeeper:id/city_name_text");
        await city.waitForDisplayed({timeout: 5000});
    } catch (error) {
        console.error('Error during testing:', error);
    } finally {
        await testConfig.releaseDriver();
        // AndroidTestConfig.stopServer();
    }
}

runTest().catch(console.error);

