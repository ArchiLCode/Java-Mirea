package practice6.prototype;

import lombok.Getter;

@Getter
public class PineTree extends Tree {
    public PineTree(double mass, double height) {
        this.mass = mass;
        this.height = height;
    }

    @Override
    public Tree copy() {
        PineTree pineTreeClone = new PineTree(mass, height);
        pineTreeClone.setPosition(position);
        return pineTreeClone;
    }
}