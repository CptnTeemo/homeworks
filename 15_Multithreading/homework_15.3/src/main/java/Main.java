import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final String SOURCE = "https://skillbox.ru/";

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        WebSiteMapCreator webSiteMapCreator = new WebSiteMapCreator(SOURCE);
        pool.execute(webSiteMapCreator);
        do {
            System.out.print("******************************************\n");
            System.out.println("Task in progress");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.print("******************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!webSiteMapCreator.isDone());
        pool.shutdown();
        Set<String> results = webSiteMapCreator.join();
        WebSiteMapCreator.createWebSireMapFile(results, SOURCE);
        System.out.println("Task complete");

        System.out.println(System.currentTimeMillis() - start + " ms");

    }

}
