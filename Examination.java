package lab1_2;

public class Examination {
    public static long concurrentMemory1, concurrentMemory2;
 
    public static void start() {
    	System.out.println("Here is the memory consumption testing");
    	System.out.println("-------------------------------\n");
        //得到虚拟机运行、程序开始执行时jvm所占用的内存。
        Runtime runtime = Runtime.getRuntime();
        concurrentMemory1 = runtime.totalMemory()-runtime.freeMemory();
    }
    public static void end() {
        //得到虚拟机运行、所要测试的执行代码执行完毕时jvm所占用的内存（byte）。
        Runtime runtime = Runtime.getRuntime();
        concurrentMemory2 = runtime.totalMemory()-runtime.freeMemory();
        String memory = String.valueOf((double)(concurrentMemory2-concurrentMemory1)/1024);
        System.out.println("The memory consumption is "+memory+" KB");
        System.out.println("\nTest end-------------------------------");
    }
}