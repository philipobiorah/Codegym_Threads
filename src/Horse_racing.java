/**
 * Task
 * Figure out what the program does.
 * Implement the calculateHorsesFinished method.
 * It must:
 * 1. Calculate and return the number of horses that have finished. Use the isFinished() method.
 * 2. If a horse has not yet crossed the finish line (!IsFinished()), then:
 * 2.1. Display "Waiting for " + horse.getName().
 * 2.2. Wait until it finishes the race. Think about what method you need to use to do this.
 * 2.3. Not treat such a horse as finished.
 */



import java.util.ArrayList;
import java.util.List;

public class Horse_racing {

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart(10);
        while (calculateHorsesFinished(horses) != horses.size()) {
        }
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int finishedCount = 0;
        //write your code here
        for (Horse horse : horses) {
            if (horse.isFinished())
                finishedCount++;
            else {
                System.out.println("Waiting for " + horse.getName());
                horse.join();
            }
        }
        return finishedCount;
    }

    public static List<Horse> prepareHorsesAndStart(int horseCount) {
        List<Horse> horses = new ArrayList<>(horseCount);
        String number;
        for (int i = 1; i < horseCount + 1; i++) {
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Horse_" + number));
        }

        for (int i = 0; i < horseCount; i++) {
            horses.get(i).start();
        }
        return horses;
    }

    public static class Horse extends Thread {

        private boolean isFinished;

        public Horse(String name) {
            super(name);
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void run() {
            String s = "";
            for (int i = 0; i < 1001; i++) {   // Delay
                s += "" + i;
                if (i == 1000) {
                    s = " has finished the race!";
                    System.out.println(getName() + s);
                    isFinished = true;
                }
            }
        }
    }
}


