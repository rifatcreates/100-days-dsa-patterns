import java.util.*;

public class Day11_LC_0904 {
    public static int totalFruits(int fruits[]) {
        int baskets = 2;
        int low = 0;
        int maxFruit = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int high=0; high<fruits.length; high++) {
            int hfruits = fruits[high];
            map.put(hfruits, map.getOrDefault(hfruits, 0) + 1);

            while (map.size() > baskets) {
                int lfruits = fruits[low];
                map.put(lfruits, map.get(lfruits) - 1);

                if (map.get(lfruits) == 0) {
                    map.remove(lfruits);
                }

                low++;
            }

            maxFruit = Math.max(maxFruit, high-low+1);
        }

        return maxFruit;
    }

    public static void main(String args[]) {
        int fruits[] = {1,2,1};

        System.out.println(totalFruits(fruits));
    }
}