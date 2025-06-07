package Entity;

public class Item {
    private final int index;
    private final double weight;
    private final int cost;

    public Item(int index, double weight, int cost) {
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    public int getIndex() { return index; }
    public double getWeight() { return weight; }
    public int getCost() { return cost; }

    @Override
    public String toString() {
        return String.format("Item(%d, %.2f, €%d)", index, weight, cost);
    }
}
