public class Test {
    static class MyThread extends Thread{
        //重写Thread类中的run方法
        @Override
        public void run() {
            //在方法里面指定要执行的指令
            System.out.println("hello world,我是一个线程");
        }
    }



    //这里面涉及两个线程 main是主线程 MyThread类中创建出的线程
    public static void main(String[] args) {
        //创建线程需要使用Thread类,来创建一个Thread实例
        //还需要给这个线程指定要执行哪些指令代码
        //指定指令的方式有很多种,先用最简单的 直接继承Thread类


        //当Thread对象被创建出来的时候,内核中并没有产生一个线程(PCB)
        Thread t = new MyThread();

        //当执行start方法时,才会创建出一个线程
        // 此时内核中才随之出现一个PCB,这个PCB就会让对应的CPU去处理run方法中的逻辑指令
        t.start();
    }
}
