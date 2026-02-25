import java.util.*;

public class Day55_LC_0295 {

    static class MedianFinder {

        static PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        static PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        public static void addNum(int num) {

            maxHeap.add(num);

            minHeap.add(maxHeap.poll());

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public static double findMedian() {

            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek()
                        + minHeap.peek()) / 2.0;
            }

            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {

        MedianFinder.addNum(1);
        System.out.println(MedianFinder.findMedian());

        MedianFinder.addNum(2);
        System.out.println(MedianFinder.findMedian());

        MedianFinder.addNum(3);
        System.out.println(MedianFinder.findMedian());

        MedianFinder.addNum(4);
        System.out.println(MedianFinder.findMedian());
    }
}