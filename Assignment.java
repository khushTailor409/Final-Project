package org.khush;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
    public class Assignment {
        private String assignmentId;
        private String assignmentName;
        private double weight;
        private ArrayList<Integer> scores;
        private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("D%02d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    public double calcAssignmentAvg() {
        if (scores == null || scores.isEmpty()) return 0;

        double sum = 0;
        int count = 0;
        for (Integer score : scores) {
            if (score != null) {
                sum += score;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }
    public void generateRandomScore() {
    Random rand = new Random();

    int[][] ranges = {
            {0, 59},
            {60, 69},
            {60, 69},
            {70, 79},
            {70, 79},
            {80, 89},
            {80, 89},
            {80, 89},
            {80, 89},
            {90, 100},
            {90, 100}
    };

    for (int i = 0; i < scores.size(); i++) {
        int randomRange = rand.nextInt(11); // 0 to 10
        int min = ranges[randomRange][0];
        int max = ranges[randomRange][1];
        int score = min + rand.nextInt(max - min + 1); // random in range [min, max]
        scores.set(i, score);
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
