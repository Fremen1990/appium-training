package pl.training.common.gestures;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

public class GestureImporter {

    private final ObjectMapper mapper;
    private final AndroidDriver driver;

    public GestureImporter(ObjectMapper mapper, AndroidDriver driver) {
        this.mapper = mapper;
        this.driver = driver;
    }

    public GestureImporter(AndroidDriver driver) {
        this.mapper = new ObjectMapper();
        this.driver = driver;
    }

    public List<Sequence> importGestures(String fileName) throws IOException {
        var gesture = mapper.readValue(new File(fileName), Gesture.class);
        var windowSize = driver.manage().window().getSize();

        var result = new ArrayList<Sequence>();
        var actions = gesture.getActions();
        for (int index = 0; index < actions.size(); index++) {
            var pointer = new PointerInput(TOUCH, "pointer" + index);
            var sequence = new Sequence(pointer, 1);
            var ticks = gesture.getActions().get(index).getTicks();
            for (Tick tick : ticks) {
                switch (tick.getType()) {
                    case "pointerMove":
                        sequence.addAction(pointer.createPointerMove(ofMillis(tick.getDuration()), Origin.viewport(),
                                (tick.getX().intValue() * windowSize.width) / 100,
                                (tick.getY().intValue() * windowSize.height) / 100));
                        if (tick.getDuration() == 0) {
                            sequence.addAction(new Pause(pointer, ofMillis(1_000)));
                        }
                        break;
                    case "pointerDown":
                        sequence.addAction(pointer.createPointerDown(LEFT.asArg()));
                        break;
                    case "pointerUp":
                        sequence.addAction(pointer.createPointerUp(LEFT.asArg()));
                        break;
                }
            }
            result.add(sequence);
        }
        return result;
    }

}
