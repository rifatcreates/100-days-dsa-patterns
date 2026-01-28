import java.util.*;

public class Day27_GFG_Meeting_Rooms2 {
    public static int minimumNumber(int start[], int end[]) {
        if (start.length == 1) {
            return 1;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int room = 0;
        int res = 0;

        while (i < start.length && j< end.length) {

            if (start[i] < end[j]) {
                room++;
                res = Math.max(res, room);
                i++;
            } else {
                room--;
                j++;
            }
        }

        return res;
    }

    public static void main(String args[]) {
        int start[] = {1, 10, 7}; 
        int end[] = {4, 15, 10};

        System.out.println(minimumNumber(start, end));
    }
}