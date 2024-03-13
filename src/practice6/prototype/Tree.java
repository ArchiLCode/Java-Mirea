package practice6.prototype;

import lombok.Getter;

@Getter
public abstract class Tree {

    protected double mass;
    protected double height;
    protected int[] position;

    public void setPosition(int[] position) {
        this.position = position;
    }
    public abstract Tree copy();
}