const { remote } = require('webdriverio');
const { execSync } = require('child_process');

const DEFAULT_APPIUM_URL = "http://127.0.0.1:4723";
const PLATFORM_NAME = "Android";
const AUTOMATION_NAME = "UiAutomator2";

class AndroidTestConfig {

    constructor() {
        this.driver = null;
    }

    static startServer() {
        try {
            execSync('appium', (error, stdout, stderr) => {
                if (error) {
                    console.error(`error: ${error.message}`);
                    return;
                }

                if (stderr) {
                    console.error(`stderr: ${stderr}`);
                    return;
                }
                console.log(`stdout:\n${stdout}`);
            });
            console.log('Appium server started.');
        } catch (error) {
            console.error('Error starting Appium server:', error);
        }
    }

    static stopServer() {
        try {
            execSync('pkill -f appium');
            console.log('Appium server stopped.');
        } catch (error) {
            console.error('Error stopping Appium server:', error);
        }
    }

    async initDriver() {
        try {
            const appiumUrl = process.env.APPIUM_URL || DEFAULT_APPIUM_URL;
            const url = new URL(appiumUrl);
            this.driver = await remote({
                hostname: url.hostname,
                port: +url.port,
                protocol: 'http',
                capabilities: this.getOptions(),
            });
        } catch (error) {
            throw new Error(`Failed to initialize Android driver: ${error.message}`);
        }
    }

    async releaseDriver() {
        if (this.driver) {
            await this.driver.deleteSession();
            this.driver = null;
            console.log('Android driver session ended.');
        }
    }

    getDriver() {
        return this.driver;
    }

    getOptions() {
        return {
            "platformName": PLATFORM_NAME,
            "appium:automationName": AUTOMATION_NAME,
            "appium:deviceName": process.env.APPIUM_DEVICE_NAME,
            "appium:udid": process.env.APPIUM_UDID,
            "appium:platformVersion": process.env.APPIUM_PLATFORM_VERSION,
            "appium:app": process.env.APPIUM_APP,
            "appium:fullReset": true,
        };
    }
}

module.exports = AndroidTestConfig;