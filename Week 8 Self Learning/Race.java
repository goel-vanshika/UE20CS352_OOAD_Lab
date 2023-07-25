import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Race {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Runners in this Race: ");
        int n = sc.nextInt();

        List<Runner> runners = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            runners.add(new Runner("Runner " + (i+1)));
        }
        for (Runner runner : runners) {
            runner.start();
        }
        try {
            for (Runner runner : runners) {
                runner.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------");
        Collections.sort(runners);
        System.out.println("Top 3 Runners:");
        for (int i = 0; i < 3; i++) {
            System.out.println((i+1)+". "+runners.get(i));
        }
    }
}

class Runner extends Thread implements Comparable<Runner> {
    private String name;
    private int distance;
    private Random rand;

    public Runner(String name) {
        this.name = name;
        this.distance = 0;
        this.rand = new Random();
    }

    public void run() {
        while (distance <= 1000) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int distanceCovered = rand.nextInt(6) + 5;
            distance += distanceCovered;
            System.out.println(name + " ran " + distance + " m.");
        }
    }

    public int compareTo(Runner other) {
        return Integer.compare(other.distance, this.distance);
    }

    public String toString() {
        return name + " ran distance: " + distance;
    }
}
