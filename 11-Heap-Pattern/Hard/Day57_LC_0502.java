import java.util.*;

public class Day57_LC_0502 {
    public static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public static int findMaximizedCapital(int k, int w, int profits[], int capital[]) {
        Project projects[] = new Project[profits.length];

        for (int i = 0; i < profits.length; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        Arrays.sort(projects, (a, b) -> a.capital - b.capital);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int idx = 0;

        while (k-- > 0) {
            while (idx < profits.length && projects[idx].capital <= w) {
                pq.add(projects[idx].profit);
                idx++;
            }

            if (pq.isEmpty()) {
                break;
            }

            w += pq.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        int profits[] = {1, 2, 3, 5};
        int capital[] = {0, 1, 2, 3};
        int k = 3;
        int w = 0;

        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
}