package Entity;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
public class FileParser {

    public static String solve(String input) throws Exception {
        //We converted it to array starting from : expression
        String[] parts = input.split(":");
        if (parts.length != 2) throw new IllegalArgumentException("Invalid line format");
        //We accept the first line as maximum.
        double maxWeight = Double.parseDouble(parts[0].trim());
        if (maxWeight > 100) throw new IllegalArgumentException("Max package weight exceeded");
        List<Item> items = parseItems(parts[1]);
        if (items.size() > 15) throw new IllegalArgumentException("Too many items");
        return findBestCombination(items,maxWeight);
    }
    private static List<Item> parseItems(String itemsString) throws IllegalArgumentException {
        List<Item> items = new ArrayList<>();
        //Matcher checks if the string conforms to a certain format.
        //for example that format:5,30.18,€9
        Matcher matcher = Pattern.compile("\\((\\d+),(\\d+(\\.\\d+)?),€(\\d+)\\)").matcher(itemsString);
        while (matcher.find()) {
            int index = Integer.parseInt(matcher.group(1));
            double weight = Double.parseDouble(matcher.group(2));
            int cost = Integer.parseInt(matcher.group(4));
            if (weight > 100 || cost > 100)
                throw new IllegalArgumentException("Item constraint violated");
            items.add(new Item(index, weight, cost));
        }
        return items;
    }
    private static String findBestCombination(List<Item> items, double maxWeight) {
        int n = items.size();
        //initial bestWeight and bestCost
        double bestWeight = Double.MAX_VALUE;
        int bestCost = -1;
        List<Integer> bestCombination = new ArrayList<>();
        //It is a loop used to try all possible combinations using bitmask technique in Java.
        //n: Number of items (e.g. if there are 3 items, n = 3).
        //(1 << n): means 2ⁿ. That is, 1 is shifted left by n bits in binary.
        //Example: 1 << 3 = 8 → because 2³ = 8
        //i: goes from 1 to 2ⁿ - 1 (all subsets).
        //0 is not included because we don't want the empty set.
        //----------- For example 1000 = 8
        //(1 << n) -> n is the number of possible combinations
        for (int i = 1; i < (1 << n); i++) {
            //initial totalWeight and totalCost
            double totalWeight = 0;
            int totalCost = 0;
            List<Integer> current = new ArrayList<>();
            //This checks which items are in the combination for each i.
            for (int j = 0; j < n; j++) {
                //Here j is the index used to check each item.
                //For example it is true for (2 & (2) >)
                if ((i & (1 << j)) > 0) {
                    Item item = items.get(j);
                    totalWeight += item.getWeight();
                    totalCost += item.getCost();
                    current.add(item.getIndex());
                }
            }
            if (totalWeight <= maxWeight) {
                //If the cost of the current combination (totalCost) is higher than the best combination found so far (bestCost), then this combination is better → Update.
                if (totalCost > bestCost || (totalCost == bestCost && totalWeight < bestWeight)) {
                    bestCost = totalCost;
                    bestWeight = totalWeight;
                    bestCombination = current;
                }
            }
        }
       // Collections.sort(bestCombination);
        // bestCombination → List<Integer> consisting of the best found item indexes.
        //This line sorts this list from smallest to largest.
        //        Ex: [5, 1, 3] → [1, 3, 5]
        //2️⃣ bestCombination.stream()
       // Converts the list to a stream structure, so it can be processed.
        //3️⃣ .map(String::valueOf)
       // Converts each Integer value to String.
       // Ex: 1 → "1"
        //4️⃣ .collect(Collectors.joining(","))
        //Concatenates each string with a comma to form a single string.
       //         Ex: ["1", "3", "5"] → "1,3,5"
        if (bestCombination.isEmpty()) return "-";
        Collections.sort(bestCombination);
        return bestCombination.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
