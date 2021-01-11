
/**
 * 1. Figure out what the program does.
 * 2. We need to be sure that Chump talks the most during the political debate.
 * 3. Think about what method you can call on the chump object to make Chump talk until all the available time has been taken.
 *
 * Requirements:
 * Call the join method on the necessary object.
 * The Politician class's toString method should display how many times the politician spoke, for example: "Chump spoke 35 times".
 * The program should create 3 Politician objects.
 * Don't change the methods that are responsible for screen output.
 * The program's output should indicate that Chump spoke the most during the political debate.
 *
 * **/



public class Chump {
    public static int totalSpeechCount = 200;
    public static int utterancesPerSpeech = 1000000;

    public static void main(String[] args) throws InterruptedException {
        Politician chump = new Politician("Chump");
        chump.join();
        Politician dustbin = new Politician("Dustbin");
        Politician schooner = new Politician("Schooner");

        while (chump.getSpeechCount() + dustbin.getSpeechCount() + schooner.getSpeechCount() < totalSpeechCount) {
        }

        System.out.println(chump);
        System.out.println(dustbin);
        System.out.println(schooner);
    }


    public static class Politician extends Thread {
        private volatile int utteranceCount;

        public Politician(String name) {
            super(name);
            start();
        }

        public void run() {
            while (utteranceCount < totalSpeechCount * utterancesPerSpeech) {
                utteranceCount++;
            }
        }

        public int getSpeechCount() {
            return utteranceCount / utterancesPerSpeech;
        }

        @Override
        public String toString() {
            return String.format("%s spoke %d times", getName(), getSpeechCount());
        }
    }
}
