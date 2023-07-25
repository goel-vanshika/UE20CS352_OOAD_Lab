import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Runner implements Runnable {

    private String name;
    private int distanceCovered;

    public Runner(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (distanceCovered < 1000) {
            int distance = random.nextInt(6) + 5;
            distanceCovered += distance;
            System.out.println(name + " has covered " + distanceCovered + " meters.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }

    public String getName() {
        return name;
    }
}

public class RaceSimulator {

    public static void main(String[] args) throws InterruptedException {
        int numRunners = Integer.parseInt(args[0]);
        List<Thread> threads = new ArrayList<>();
        List<Runner> runners = new ArrayList<>();
        for (int i = 1; i <= numRunners; i++) {
            Runner runner = new Runner("Runner " + i);
            runners.add(runner);
            Thread thread = new Thread(runner);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        runners.sort((r1, r2) -> r2.getDistanceCovered() - r1.getDistanceCovered());
        System.out.println("The top 3 runners are:");
        for (int i = 0; i < 3 && i < runners.size(); i++) {
            System.out.println((i + 1) + ". " + runners.get(i).getName() + " with " + runners.get(i).getDistanceCovered() + " meters.");
        }
    }
}
