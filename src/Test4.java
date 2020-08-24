

public class Test4 {
    public static void main(String[] args) {
        Thread t = new Thread(() ->{
            System.out.println("我是一个线程");
        });
        t.start();
    }
}
