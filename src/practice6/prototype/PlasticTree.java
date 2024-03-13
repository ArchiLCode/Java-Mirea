package practice6.prototype;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlasticTree extends Tree {
    public PlasticTree(double mass, double height) {
        this.mass = mass;
        this.height = height;
    }
    @Override
    public Tree copy() {
        return new PlasticTree(mass, height);
    }
}