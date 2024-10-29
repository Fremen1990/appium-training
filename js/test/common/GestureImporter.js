const fs = require('fs').promises;
const { ActionSequence, Origin, WebDriver } = require('webdriverio');

class GestureImporter {
    constructor(driver) {
        this.driver = driver;
    }

    async import(fileName) {
        const data = await fs.readFile(fileName, 'utf-8');
        const gesture = JSON.parse(data);
        const windowSize = await this.driver.getWindowSize();
        const result = [];
        const actions = gesture.actions;

        for (let index = 0; index < actions.length; index++) {
            const pointer = {
                id:  "pointer" + index,
                type: 'pointer',
                parameters: { pointerType: 'touch' },
                actions: []
            };
            for (const tick of actions[index].ticks) {
                console.log(tick);
                switch (tick.type) {
                    case 'pointerMove':
                        pointer.actions.push({
                            type: 'pointerMove',
                            duration: tick.duration,
                            x: (tick.x * windowSize.width) / 100,
                            y: (tick.y * windowSize.height) / 100,
                            origin: "viewport"
                        });
                        if (tick.duration === 0) {
                            pointer.actions.push({type: 'pause', duration: 1000});
                        }
                        break;
                    case 'pointerDown':
                        pointer.actions.push({ type: 'pointerDown', button: 0 });
                        break;
                    case 'pointerUp':
                        pointer.actions.push({ type: 'pointerUp', button: 0 });
                        break;
                }
            }
            result.push(pointer);
        }
        return result;
    }

}

module.exports = GestureImporter;
