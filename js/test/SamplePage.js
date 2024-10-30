class SamplePage {

    constructor(driver) {
        this.driver = driver;
    }

    async standardUser() {
        return await this.driver.$("//android.widget.TextView[@text=\"standard_user\"]");
    }

    async clickOnLoginButton() {
        const button = await this.driver.$("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
        await button.click()
    }

    async scrollUntilFindText(text) {
        return await this.driver.$(
            `android=new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView("${text}")`
        );
    };

    async clickOnAddToCart() {
        const button = await this.driver.$("(//android.widget.TextView[@text=\"ADD TO CART\"])[3]")
        await button.click()
    }

    async clickOnCartTab() {
        const button = await this.driver.$("//android.widget.TextView[@text=\"1\"]")
        await button.click()
    }

    async checkIfOnCartScreen() {
        await (await this.driver.$("//android.widget.TextView[@text=\"YOUR CART\"]")).waitForExist();
    }

    async checkIfAddedProductIsInTheCart() {
        await (await this.driver.$("//android.widget.TextView[@text=\"Sauce Labs Onesie\"]")).waitForExist();
    }

    async goToContinueShopping() {
        const button = await this.driver.$("//android.view.ViewGroup[@content-desc=\"test-CONTINUE SHOPPING\"]")
        await button.click()
    }

    async checkIfProductsScreen() {
        await (await this.driver.$("//android.widget.TextView[@text=\"PRODUCTS\"]")).waitForExist();
    }

}

module.exports = SamplePage;