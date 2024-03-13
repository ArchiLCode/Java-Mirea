package practice6.builder;

import lombok.Data;

@Data
public class Car {
    private String chassis;
    private String body;
    private String paint;
    private String interior;

    public Car(String chassis, String body, String paint, String interior) {
        this.chassis = chassis;
        this.body = body;
        this.paint = paint;
        this.interior = interior;
    }

    public boolean doQualityCheck() {
        return (chassis != null && !chassis.trim().isEmpty()) && (body != null && !body.trim().isEmpty()) &&
                (paint != null && !paint.trim().isEmpty()) && (interior != null && !interior.trim().isEmpty());
    }

    @Override
    public String toString() {
        return "Car [chassis=" + chassis + ", body=" + body + ", paint=" + paint;
    }
}
