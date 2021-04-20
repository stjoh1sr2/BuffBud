# CPS240
hi

## How to Install
Downloading the BuffBud app is straightforward. The best way is to download the BuffBud.jar file and BuffBudFX.zip, which includes the entire Java project folder from the Eclipse IDE. From there, no installation is necessary. Because BuffBud.jar was not created by a trusted company, web browsers may attempt to block the download. However, as there is no malicious software attached to this app, it is acceptable (and necessary to complete installation) to bypass these warnings.

## How to Run
### Using BuffBud.jar
To run the program using BuffBud.jar, you can simply double click on the .jar file or right click and press "open". If the .jar file will not run, there is likely a permissions error, as BuffBud requires the creation of folders in the user's home directory and the creation of a text file. If this is the case, then running the program as an administrator may resolve the issue. Note: this program requires Java to be installed in order to run.

### Running from Eclipse IDE
A less convienient way to run the BuffBud application is through the Eclipse IDE. First, you must import the program into the IDE, and secondly, you must resolve any issues and run the main method (application.Launcher).

#### Importing into Eclipse
To import this project into Eclipse, first unzip the downloaded BuffBudFX.zip file. Open up Eclipse and navigate to the "Package Explorer" tab. After that, right click in an empty area and choose "Import" from the selection menu. On the import wizard, expand the folder "Maven" and select "Existing Maven Projects". For the root directory, find the unzipped folder and select the folder within titled "BuffBudFX2". Click "finished" and the project will appear under the Package Explorer. 

Depending on your Eclipse setup, there may be errors regarding the use of lambda expressions in the IntroWindow and NotificationApp classes. In the case of these errors, navigate to one of them, hover over the error, and select "Change project compliance and JRE to 1.8". This will ensure that Eclipse can run this program with the lambda expressions.

#### Running
After setting up the project in Eclipse, right click the Project and select Run As -> Java Application. For the main class, select Launcher.java. BuffBud should launch without issue. NOTE: while it may be possible to run the program using the Main class, the Launcher class is designated as the main class of the program for ease of exporting to a .jar file. It is advisable to use the Launcher.java class as the main class even in Eclipse.

Alternatively, you could just open up the Launcher class and click "Run".
