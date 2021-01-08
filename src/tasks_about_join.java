
import java.util.ArrayList;
import java.util.List;

/*
join: at the right time in the right place

*/

public class tasks_about_join {

    public  static void main(String [] args) throws  InterruptedException{
        PrintListThread firstThread = new PrintListThread("firstThread");
        PrintListThread secondTread = new PrintListThread("secondThread");
        firstThread.start();
        firstThread.join();
        secondTread.start();
    }


    public  static void printList(List<String> list, String threadName){
        for(String item : list){
            System.out.println(String.format("%s : %s", threadName, item));
        }

    }

    public static List<String> getList(int n){
        List<String> result = new ArrayList<>();
        if (n < 1) return result;

        for (int i = 0; i < n; i++){
            result.add(String.format("String %d", (i + 1)));
        }
        return result;
    }

    public static class PrintListThread extends Thread{
        public PrintListThread(String name){
            super((name));
        }

        public void run(){
            printList(getList(20), getName());
        }
    }
}
