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
//It allows us to see the values of the object. Converts to Entity.Item@7b9a4292 to Item{index=9, weight=6.76, cost=64}
    @Override
    public String toString() {
        return "Item{" +
                "index=" + index +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
