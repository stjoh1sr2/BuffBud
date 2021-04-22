# BuffBud - Your Virtual Workout Buddy
## Introduction
Welcome to the world of BuffBud, where you can use a virtual pet to help you stay in shape! Our program was created to help encourage activity during the COVID-19 pandemic, where most people are spending their days sitting at an office in virtual meetings. This README document contains:
* Installation procedures
* How to run BuffBud
** How to access BuffBud's source code
* File list & structure
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

## File List & Structure
The main structure of the BuffBudFX folder is:
* **.settings** directory
* **bin** directory: contains binary files for the classes and resources.
  * **application** directory: contains binary files for the Java classes for BuffBud.
  * **Images** directory: contains binary files for the Images directory for this application.
* **doc** directory: contains sub-directories and .html files relating to the JavaDoc documentation for this app.
* **resources** directory: contains Image files for this project.
  * **Images** directory: contains all miscellaneous images.
    * **Corgi** directory: contains all Corgi images.
* **src** directory
  * **application** package: contains all the Java code relevant to the application.
    * application.Corgi.java
    * application.GameLoop.java
    * application.GameWindow.java
    * application.IntroWindow.java
    * application.Launcher.java
    * application.Main.java
    * application.NotificationApp.java
    * application.Pet.java
    * application.Utility.java
* **target** directory: contains Maven information for this app.
* dependency-reduced-pom.xml: contains a Maven xml file without dependencies.
* pom.xml: contains a Maven xml file with JavaFX dependencies explicitly listed.

A file called Pet.txt is created within the user's home directory for the purpose of local saving. The program creates a directory BuffBud/Data where the Pet.txt file is saved.

## Usage
The primary purpose of the BuffBud application is to create a workout buddy to help you stay in shape while working in-doors. The recommendation is that a user has the BuffBud application open whenever they intend to be sitting on their computer for an extended amount of time. 

When you first open the program without any save data, you are greeted by an intro screen that gives you a pet to help you on your health journey. You are prompted to name the pet and press submit to launch the main program window.

In the main program window, your pet appears. Above them, there is a toolbar that holds different user buttons and information:
* Save & Exit Button: saves the current state of the pet and exits the program.
* Save Button: saves the current state of the pet without exiting the app.
* Exit & Reset Button: clears the pet save data and exits the program. This is the button to click if you would like a new pet.
* Health Level Label: shows the health level of the pet.

Below the pet, there is a dialogue box for communicating information to the user. This is where the application will ask you to exercise. When the application asks the user a question, "yes" and "no" options appear within the dialogue box for answering. Depending on your answer, the pet will react negatively or positively and either lose health or gain health.

### Pet States
In this app, your pet has several states:
* Normal: When your pet has a high enough health level, the pet will act normal.
* Happy: The pet will be happy right after you exercise.
* Exercising: In the BuffBud app, the pet exercises alongside you. For example, your Corgi might walk while you are supposed to be exercising.
* Sad: The pet reacts sadly when you decline to exercise.
* Ghost: The pet becomes a ghost if their health level is under a certain amount. You do not want to kill your pet, do you? The pet will come back to life after you exercise and bring its health level back above a predetermined amount.

## Technologies & Libraries Used
The main tools used in this program are:
* *JavaFX*: a GUI library instrumental to creating a working Graphical User Interface.
* *Maven*: an application-packaging tool in Eclipse that allowed the program to package JavaFX runtime components as dependencies, which allowed the program to be exported as an executable .jar file.

## Special Acknowledgements
Special thanks to user Miniyeti from AngryElk on the game development website itch.io for their Corgi sprite designs used in this project. They were the designer of all the Corgi animation bases used for BuffBud. For some specific areas (ghost, dying, and sad pet states), their work was edited to fit the needs of the BuffBud application, but much of the animation is their work unchanged and used under the Creative Commons License (CC BY 4.0). The license can be read [here](https://creativecommons.org/licenses/by/4.0/) and Miniyeti's user profile on itch.io can be reached [here](https://itch.io/profile/miniyeti).
