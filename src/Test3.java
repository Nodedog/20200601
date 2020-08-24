
/*
*               创建线程的方法
*
* */
public class Test3 {

    static class Myrunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }


    public static void main(String[] args) {
        //1.显式继承Thread


        //2.通过匿名内部类继承Thread类
//        Thread t = new Thread(){
//            @Override
//            public void run() {
//
//            }
//        }
//        t.start();



        //3.显式创建一个类,实现Runnable接口然后把这个Runnable的实例关联到Thread上
//        Thread t = new Thread(new Myrunnable());
//        t.start();



        //4.通过匿名内部类来实现Runnable接口
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("线程");
//            }
//        };
//        Thread t = new Thread(runnable);
//        t.start();



        //5.使用lambda表达式来指定线程执行内容
        Thread t = new Thread(() ->{
            System.out.println("线程");
        });
        t.start();

    }
}
