package lab1_2;

public class Examination {
    public static long concurrentMemory1, concurrentMemory2;
 
    public static void start() {
    	System.out.println("Here is the memory consumption testing");
    	System.out.println("-------------------------------\n");
        //�õ���������С�����ʼִ��ʱjvm��ռ�õ��ڴ档
        Runtime runtime = Runtime.getRuntime();
        concurrentMemory1 = runtime.totalMemory()-runtime.freeMemory();
    }
    public static void end() {
        //�õ���������С���Ҫ���Ե�ִ�д���ִ�����ʱjvm��ռ�õ��ڴ棨byte����
        Runtime runtime = Runtime.getRuntime();
        concurrentMemory2 = runtime.totalMemory()-runtime.freeMemory();
        String memory = String.valueOf((double)(concurrentMemory2-concurrentMemory1)/1024);
        System.out.println("The memory consumption is "+memory+" KB");
        System.out.println("\nTest end-------------------------------");
    }
}