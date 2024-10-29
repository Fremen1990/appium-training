package pl.training.common.gestures;

public class Tick {

    private String id;
    private String type;
    private Double x;
    private Double y;
    private Integer duration;
    private Integer button;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getButton() {
        return button;
    }

    public void setButton(Integer button) {
        this.button = button;
    }

}