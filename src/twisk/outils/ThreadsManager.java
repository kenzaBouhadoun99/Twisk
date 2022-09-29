package twisk.outils;

import com.sun.javafx.tk.Toolkit;
import javafx.concurrent.Task;

import java.util.ArrayList;

public class ThreadsManager  {
    private static ThreadsManager instance = new ThreadsManager();
    private final ArrayList<Thread> thd;

    /**
     * Constructeur de Thread Manager
     */
    public ThreadsManager(){
        thd =new ArrayList<>(11);
    }
    public static ThreadsManager getInstance(){
        return instance;
    }

    /**
     * La fonction qui permet de lancer les threads
     * @param t
     */
    public void lancer(Task t){
        Thread thr=new Thread(t);
        thd.add(thr);
        thr.start();

    }

    /**
     * La fonction qui permet de detruire les threads
     */
    public void detruireTout(){
        for(Thread th :thd){
            th.interrupt();
        }
        thd.clear();
    }
}
