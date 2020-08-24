public class Test2 {
    //用下划线划分一个较大的数字,容易看清楚
    private static long count = 10_0000_0000L;


    public static void main(String[] args) {
        serial();//串行
        concurrency();//并发
    }

    private static void serial() {
        long beg = System.currentTimeMillis();//时间戳
        int a = 0;
        for (int i = 0; i < count; i++) {
            a++;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println("time" + (end - beg) + "ms");
    }

    private static void concurrency() {
        long beg = System.currentTimeMillis();//时间戳
        //匿名内部类 创建一个没有名字的类只知道继承Thread
        //{}是这个类的具体代码 同时也会new 出来这个类的一个实例
        Thread t1 = new Thread(){
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a++;
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                int b = 0;
                for (int i = 0; i < count; i++) {
                    b++;
                }
            }
        };
        t1.start();
        t2.start();


        //t1 t2 和main  线程之间都是并发进行的
        //调用t1.start和t2.start之后,两个线程就进行运算
        //与此同时主线程main也会同时执行,下面的end在t1.start和t2.start还没结束时就
        // 已经开始计算,但我们创建的时间戳是为了计算出 t1.start和t2.start两个线程所需的时间
        //所以还得try catch

        try {
            //线程等待,让主线程等待t1 t2执行完之后,再继续往下执行
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println("time" + (end - beg) + "ms");
    }
}
