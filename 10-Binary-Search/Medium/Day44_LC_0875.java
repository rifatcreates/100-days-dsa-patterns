public class Day44_LC_0875 {
    public static long hours(int[] piles, int speed) {
        long h = 0;

        for (int i=0; i<piles.length; i++) {
            h = h + piles[i] / speed;
            if (piles[i] % speed != 0) {
                h++;
            }
        }

        return h;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;

        int high = 0;
        for (int i=0; i<piles.length; i++) {
            high = Math.max(piles[i], high);
        }

        int res = -1;

        while (low <= high) {
            int guess = (low + high) / 2;
            long hours = hours(piles, guess);

            if (hours > h) {
                low = guess+1;
            } else {
                res = guess;
                high = guess-1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int piles[] = {3, 6, 7, 11}; 
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }
}