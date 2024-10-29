package pl.training.common.gestures;

import java.util.List;

public class Action {

    private String name;
    private List<Tick> ticks;
    private String color;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tick> getTicks() {
        return ticks;
    }

    public void setTicks(List<Tick> ticks) {
        this.ticks = ticks;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}