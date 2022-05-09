package test2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// Minimum number of cars to carry everybody
class Solution {
    public int solution(int[] P, int[] S) {
        int totalPeople = 0;
        for (int peopleInCar : P)
            totalPeople += peopleInCar;
        int totalSeats = 0;
        int carsNeeded = 0;
        List<Integer> seats = Arrays.stream(S).boxed().collect(Collectors.toList());
        Collections.sort(seats, Collections.reverseOrder());
        for(int seatsInCar : seats){
            totalSeats += seatsInCar;
            carsNeeded++;
            if(totalSeats >= totalPeople)
                return carsNeeded;
        }
        return carsNeeded;
    }
}
