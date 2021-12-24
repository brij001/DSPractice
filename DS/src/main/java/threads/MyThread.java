package threads;

public class MyThread extends Thread{

    private boolean flag = true;
    @Override
    public void run() {
        while(flag){
            System.out.println("Running");

        }
    }

    public void shutdown(){
        System.out.println("SHudding down");
        flag = false;
    }
}
