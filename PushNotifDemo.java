package application;
import java.awt.*;


public class PushNotifDemo {
	
	public static void main(String[] args) {
		try {
			pushNotification();
		} catch (AWTException e) {
			e.printStackTrace();}
	}
	
	public static void pushNotification() throws AWTException{
		if(SystemTray.isSupported())
		{
			SystemTray tray = SystemTray.getSystemTray();
			
			Image image = Toolkit.getDefaultToolkit().createImage("testCorgi.png");
			
			TrayIcon trayIcon = new TrayIcon(image, "Java AWT Push Notification");
			
			trayIcon.setImageAutoSize(true);

			trayIcon.setToolTip("Noficiation Demo");
			
			tray.add(trayIcon);
			
			trayIcon.displayMessage("Time to exercise!", "Java Push Noficiation Demo", TrayIcon.MessageType.INFO);
	} else {
		System.err.println("SystemTray is not supported on this OS");
	}
	
}
}
