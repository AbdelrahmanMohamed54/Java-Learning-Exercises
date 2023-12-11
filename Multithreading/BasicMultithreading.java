package Multithreading;

public class BasicMultithreading {
    public static void main(String[] args) {
        // Create and start two threads
        Thread thread1 = new Thread(() -> printNumbers("Thread 1"));
        Thread thread2 = new Thread(() -> printNumbers("Thread 2"));

        thread1.start();
        thread2.start();
    }

    private static void printNumbers(String threadName) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": " + i);
            try {
                // Introduce a short delay for demonstration purposes
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

