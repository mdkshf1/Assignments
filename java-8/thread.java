public class thread {
    public static void main(String[] args) {
        Runnable r= ()-> System.out.println("this is a thread");
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread().getPriority());
        Thread.yield();
        new Thread(r).start();


            }
    }