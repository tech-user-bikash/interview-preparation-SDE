package com.lld.singleton;

public class JudgeAnalytics {
    // 1. Eager loading which is thread safe
//    private static final JudgeAnalytics INSTANCE = new JudgeAnalytics();

    // To restrict object creation from outside
    private JudgeAnalytics(){}

//    public static JudgeAnalytics getInstance(){
//        return INSTANCE;
//    }

    // 2. Lazy loading, not thread safe
//    private static JudgeAnalytics INSTANCE;
//    public static JudgeAnalytics getInstance(){
//        if(INSTANCE == null) {
//            INSTANCE = new JudgeAnalytics();
//        }
//        return INSTANCE;
//    }

    // 3. Thread safety
//    private static JudgeAnalytics INSTANCE;

    // Problem while accessing 2 threads
//    public static JudgeAnalytics getInstance() throws InterruptedException {
//        if(INSTANCE == null) {
//            Thread.sleep(1000);
//            INSTANCE = new JudgeAnalytics();
//        }
//        return INSTANCE;
//    }

    // Thread safe but performance degrade
//    public static synchronized JudgeAnalytics getInstance() throws InterruptedException {
//        if(INSTANCE == null) {
//            Thread.sleep(1000);
//            INSTANCE = new JudgeAnalytics();
//        }
//        return INSTANCE;
//    }

    // 4. double-checked approach
    private static volatile JudgeAnalytics INSTANCE;
    public static JudgeAnalytics getInstance() throws InterruptedException {

//        if(INSTANCE == null) {
//            synchronized (JudgeAnalytics.class){
//                System.out.println("-----synchronized BLOCK-----");
//                if(INSTANCE == null) {
//                    System.out.println(INSTANCE);
//                    INSTANCE = new JudgeAnalytics();
//                }
//            }
//        }
//        return INSTANCE;

        JudgeAnalytics result = INSTANCE;
        if (result != null) {
            System.out.println("---result---"+result);
            return result;
        }
        synchronized(JudgeAnalytics.class) {
            System.out.println("---"+INSTANCE);
            if (INSTANCE == null) {
                System.out.println(INSTANCE);
                INSTANCE = new JudgeAnalytics();
            }
            return INSTANCE;
        }
    }




}
