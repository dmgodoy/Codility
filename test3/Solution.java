package test3;

import java.util.Comparator;
import java.util.PriorityQueue;

// How many filters needed to reduce total pollution in half? Every filter reduces pollution of that factory in half
class Solution {
    public int solution(int[] A) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        double pollutionSum = 0;
        for (int e : A){
            maxHeap.add(Double.valueOf(e));
            pollutionSum += e;
        }
        double reducedPollution = 0;
        int filters = 0;
        while(reducedPollution < pollutionSum / 2.0){
            double e = maxHeap.poll();
            reducedPollution += e/2.0;
            maxHeap.add(e/2);
            filters++;
        }
        return filters;
        

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1,0,1}));
        
    }
}
