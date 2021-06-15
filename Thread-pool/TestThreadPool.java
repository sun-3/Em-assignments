
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.Queue;

//TestThreadPool class to validate thread pool
public  class TestThreadPool{
    public static void main(String[] args) 
    throws InterruptedException
    {
        ThreadPool threadPool = new ThreadPool(3, 4);
        for(int taskNumber = 1;taskNumber <=7;taskNumber++){
            TestTask task = new TestTask(taskNumber);
            threadPool.submitTask(task); 
        }
    }
}
//ThreadPool class
 class ThreadPool {
    BlockingQueue<Runnable> queue;
    public ThreadPool(int queueSize,int nthread){
        queue = new BlockingQueue<Runnable>(queueSize);
            String threadName = null;
            TaskExecutor task = null;
            for(int count = 0;count < nthread;count++){
                threadName = "Thread-"+count;
                task = new TaskExecutor(queue);
                Thread thread = new Thread(task,threadName);
                thread.start();
            }
        }
        public void submitTask(Runnable task) throws InterruptedException{
            queue.enqueue(task);
    }
}



//TaskExecutor class
 class TaskExecutor implements Runnable{
    BlockingQueue<Runnable> queue;
    public TaskExecutor(BlockingQueue<Runnable> queue){
        this.queue = queue;
    }
    @Override
    public void run(){
        try{
            while(true){
                String name = Thread.currentThread().getName();
                Runnable task = queue.dequeue();
                System.out.println("Task Started by Thread :" + name);
                task.run();
                System.out.println("Task finished by thread" + name);
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

//BlockingQueue class to implement thread pool
 class BlockingQueue<Type>{
    private Queue<Type> queue = new LinkedList<Type>();
    private int EMPTY = 0;
    private int MaxTaskinQueue = -1;
    
    
    public BlockingQueue(int size){
        this.MaxTaskinQueue = size;
    } 
    public synchronized void enqueue(Type task) throws InterruptedException {
        while(this.queue.size() == this.MaxTaskinQueue){
            wait();
        }
        if(this.queue.size() == EMPTY){
            notifyAll();
        }
        this.queue.offer(task);
    }
    public synchronized Type dequeue() throws InterruptedException{
        while(this.queue.size() == this.EMPTY){
            wait();
        }
        if(this.queue.size() == this.MaxTaskinQueue){
            notifyAll();
        }
        return this.queue.poll();
    }
}

//TestTask Class (To test thread pool)
 class TestTask implements Runnable{
    private int number ;
    public TestTask(int number){
        this.number = number;
    }
    @Override
    public void run(){
        System.out.println("Start Executing of Task Number" + number);
        try {
            Thread.sleep(500);
        }
         catch (InterruptedException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("End of executing task");
    }
    
}





    




