package ide;

public class ThreadExecuter extends Thread {

    String originalPath;

    public ThreadExecuter(String originalPath) {
        this.originalPath = originalPath;
    }

    @Override
    public void run() {
        File_Saver.copyFolder(originalPath);
    }
}
