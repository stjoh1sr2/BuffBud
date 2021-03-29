package application;
import java.awt.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

//import Reminder.RemindTask;


public class PushNotification {
	
	private static Timer notificationTimer = new Timer();
//	private static double delay;
	
	public static void main(String[] args) {
		try {
			pushNotification();
		} catch (AWTException e) {
			e.printStackTrace();}
	}
	
	public static void pushNotification() throws AWTException{
        //notificationTime.schedule)(TimerTask, long delay, long period)
        //delay: delay in milliseconds before task is to be excecuted
        //time: between successive tasks
		
		notificationTimer.schedule(
			new TimerTask() {
				@Override
				public void run() {
					if(SystemTray.isSupported()) {
						
						SystemTray tray = SystemTray.getSystemTray();
							
						Image image = Toolkit.getDefaultToolkit().createImage("testCorgi.png");
							
						TrayIcon trayIcon = new TrayIcon(image, "Java AWT Push Notification");
							
						trayIcon.setImageAutoSize(true);
						
						trayIcon.setToolTip("Noficiation Demo");
							
							try {
								tray.add(trayIcon);
							} catch (AWTException e) {
								e.printStackTrace();
							}
							
							trayIcon.displayMessage("Time to exercise!", "Your animal is waiting for your next workout!", TrayIcon.MessageType.INFO);
					} else {
						System.err.println("SystemTray is not supported on this OS"); } }
				}, 5, 5 );	
	
} }
