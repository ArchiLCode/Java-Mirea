package practice6.prototype;

public class Main {
    public static void main(String[] args) {

        final int[] position = new int[]{1, 2, 3};
        final int[] otherPosition = new int[]{4, 5, 6};

        PlasticTree plasticTree = new PlasticTree(123, 234.23);
        plasticTree.setPosition(position);

        PlasticTree anotherPlasticTree = (PlasticTree) plasticTree.copy();

        System.out.println(position == plasticTree.getPosition());
        System.out.println(otherPosition == anotherPlasticTree.getPosition());
        System.out.println(plasticTree == anotherPlasticTree);
    }
}