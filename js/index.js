const {remote} = require('webdriverio');

const capabilities = {
    "platformName": "Android",
    "appium:deviceName": "sdk_gphone64_x86_64",
    "appium:udid": "emulator-5554",
    "appium:platformVersion": "15",
    "appium:automationName": "uiAutomator2",
    "appium:app": "C:\\Users\\admin\\Desktop\\apk\\runkeeper.apk",
    "appium:ensureWebviewsHavePages": true,
    "appium:nativeWebScreenshot": true,
    "appium:newCommandTimeout": 3600,
    "appium:connectHardwareKeyboard": true
}

const wdOpts = {
    hostname: process.env.APPIUM_HOST || 'localhost',
    port: parseInt(process.env.APPIUM_PORT, 10) || 4723,
    logLevel: 'info',
    capabilities,
};

async function runTest() {
    const driver = await remote(wdOpts);
    try {
        const cityEdit = await driver.$("id:pl.training.runkeeper:id/city_name_edit");
        await cityEdit.addValue("gdynia");
        const checkButton = await driver.$("id:pl.training.runkeeper:id/check_button");
        await checkButton.click();
    } finally {
        await driver.pause(1000);
        await driver.deleteSession();
    }
}

runTest().catch(console.error);

