package application;

import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationApp {

	private static Timer notificationTimer = new Timer();
	
	static SystemTray tray = SystemTray.getSystemTray();
	
	static Image image = Toolkit.getDefaultToolkit().createImage("testCorgi.png");
	
	static TrayIcon trayIcon = new TrayIcon(image, "Push Notification");
	
	static long minutes;
	
	//using this for testing purposes
    private static DateFormat timeFormat = SimpleDateFormat.getTimeInstance();
	
    
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter how many minutes you want in between workouts: ");
		
		minutes = sc.nextLong();
		
			try {
				pushNotification(minutes);
			}catch(AWTException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();}
	}
	
	public static void pushNotification(long number) throws AWTException, IOException{
		
	//notificationTimer.schedule(TimerTask, long delay, long period)
	//delay: when you click run, it will take delay milliseconds to start
	//period: milliseconds after first run when notification pops up
			
	//number = minutes entered
	//convert from minutes to millisecond by multiplying input with 60000
			if(number > 0)
				number = number*60000;
			else
				System.out.println("Error: Invalid Input");
		long millisecond = number;
		
	try {
		notificationTimer.schedule(		
			new TimerTask() {
                @Override
                public void run() {
					trayIcon.setImageAutoSize(true);
					trayIcon.setToolTip("Notification Demo");
					
                	javax.swing.SwingUtilities.invokeLater(() ->
						trayIcon.displayMessage("Time to exercise!", 
								//need to get rid of timeFormat 
								"Your pet is waiting for your next workout!" + timeFormat.format(new Date()), 
								TrayIcon.MessageType.INFO) ); }
		}, millisecond, millisecond);
			tray.add(trayIcon);
	}catch (java.awt.AWTException e) {
		System.out.println("Unable to init system tray");
		e.printStackTrace(); } }	
	
}
