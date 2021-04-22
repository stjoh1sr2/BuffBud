# BuffBud - Your Virtual Workout Buddy
## Introduction
Welcome to the world of BuffBud, where you can use a virtual pet to help you stay in shape! Our program was created to help encourage activity during the COVID-19 pandemic, where most people are spending their days sitting at an office in virtual meetings. This README document contains:
* Installation procedures
* How to run BuffBud
** How to access BuffBud's source code
* File list
* Program usage
* Technologies and libraries used
* Special acknowledgements

## How to Install
Downloading the BuffBud app is straightforward. The best way is to download the BuffBud.jar file and BuffBudFX.zip, which includes the entire Java project folder from the Eclipse IDE. From there, no installation is necessary. Because BuffBud.jar was not created by a trusted company, web browsers may attempt to block the download. However, as there is no malicious software attached to this app, it is acceptable (and necessary to complete installation) to bypass these warnings.

## How to Run
### Using BuffBud.jar
To run the program using BuffBud.jar, you can simply double click on the .jar file or right click and press "open". If the .jar file will not run, there is likely a permissions error, as BuffBud requires the creation of folders in the user's home directory and the creation of a text file. If this is the case, then running the program as an administrator may resolve the issue. Note: this program requires Java to be installed in order to run.

### Running from Eclipse IDE
A less convienient way to run the BuffBud application is through the Eclipse IDE. First, you must import the program into the IDE, and secondly, you must resolve any issues and run the main method (application.Launcher).

#### Importing into Eclipse
1. Unzip the downloaded BuffBudFX.zip file.
2. Open up Eclipse and navigate to the "Package Explorer" tab. 
3. Right click in an empty area and choose "Import" from the selection menu. 
4. On the import wizard, expand the folder "Maven" and select "Existing Maven Projects". 
5. For the root directory, find the unzipped folder and select the folder within titled "BuffBudFX2". 
6. Click "finished" and the project will appear under the Package Explorer. 

Depending on your Eclipse setup, there may be errors regarding the use of lambda expressions in the IntroWindow and NotificationApp classes. In the case of these errors:
1. Navigate to one of the errors.
2. Hover over the error and select "Change project compliance and JRE to 1.8". 
This will ensure that Eclipse can run this program with the lambda expressions.

#### Running
1. After setting up the project in Eclipse, right click the Project and select Run As -> Java Application. 
2. For the main class, select Launcher.java. 

BuffBud should launch without issue. 

**NOTE**: while it may be possible to run the program using the Main class, the Launcher class is designated as the main class of the program for ease of exporting to a .jar file. It is advisable to use the Launcher.java class as the main class even in Eclipse.

Alternatively, you could just open up the Launcher class and click "Run".

## File List
The Java classes that make up the project include:
* application.Corgi.java
* application.GameLoop.java
* application.GameWindow.java
* application.IntroWindow.java
* application.Launcher.java
* application.Main.java
* application.NotificationApp.java
* application.Pet.java
* application.Utility.java

## Usage
The primary purpose of the BuffBud application is to create a workout buddy to help you stay in shape while working in-doors. The recommendation is that a user has the BuffBud application open whenever they intend to be sitting on their computer for an extended amount of time. CONTINUE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1

## Technologies/Libraries Used
The main tools used in this program are:
* *JavaFX*: a GUI library instrumental to creating a working Graphical User Interface.
* *Maven*: an application-packaging tool in Eclipse that allowed the program to package JavaFX runtime components as dependencies, which allowed the program to be exported as an executable .jar file.

## Acknowledgements
!!!!!!!!!!!!!!!!!!!!!!!!!!! TODO
