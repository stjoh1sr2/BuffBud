import java.sql.Date;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Simple demo that uses java.util.Timer to schedule a task 
 * to execute once 5 seconds have passed.
 */

public class Reminder {
    Timer timer;

    public Reminder() {
        
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.HOUR_OF_DAY, 19);
    	calendar.set(Calendar.MINUTE, 18);
    	calendar.set(Calendar.SECOND, 0);
    	java.util.Date time = calendar.getTime();

    	timer = new Timer();
    	timer.schedule(new RemindTask(), time);
    	
//    	timer = new Timer();
//        timer.schedule(new RemindTask(), seconds*1000);
	}

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time to get moving!");
            timer.cancel(); //Terminate the timer thread
           }
    }

    public static void main(String args[]) {
    	new Reminder();
        System.out.println("Task scheduled.");
    }	
	
}