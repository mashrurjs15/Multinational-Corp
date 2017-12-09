# project-multinational-corps
2017
Milestone 4
Author: Adam Staples, Andrew Nguyen, Eric Morrissette, Mohammad Sunny
----------------------------------------------------------------------------------------------------------
HOW TO RUN THE PROGRAM:
- Run the code as a java application
- Go to "Menu" and add features that you desire.
- Remove any features from the same menu.
- Add training examples via the add button at the bottom left of the GUI
- Add unsolved examples vai the add button on the bottom right, for any unknown feature values simply enter "?".
- Edit or remove any by clicking on that particular example and clicking the respective button.
- Once all examples are entered, press solve and enter the desired k value.

There are still some bug and conflicts with some of the features:
Number and Boolean should work perfectly fine.
Color works if it is filled, but cant find empty feature "UNKNOWN" for the test example.
Cartesian works if it is filled, but can't find the coordinates for the test example
PercentDamage does not work, has not been implemented fully.

PercentDamage, "?" for Cartesian and "UNKNOWN" for Color will not work fully.

Steps/Examples to try:
Add Feature> Choose any besides PercentDamage
Add to training List> Input accordingly as instructed. (Boolean should only be 1 or 0)
  -Input as many training List as you want
Add to unsloved List> Input accordingly as isntructed. Make sure to have one with "?"
Menu> Solve Examples> Input value no more than the amount of training examples
A new frame should pop up a list of results for the order of Testing Example (Left to Right)


FINAL UPDATES:
We are aware that it is not in 100% working condition.
- GUI has been updated and checks error
- Documentation added for classes
- Added two new features (PercentDamage and Color)
- kNN step through to see how it works (May not work fully but there's step to show how it was proceeded)
- Added new Metrics and features
- Fixed some bugs
- Implemented more Test cases using JUnit
- Save and Load works
- Make sure to start a new list if program has been changed. Load will not work since the program has been changed.
- UML updated
- Classes updated/patched to java standard structure
- Resolve github issues

Checkpoints:

- Continuation from miletone#3
- Changed the unit tests into a package of its own with working tests
- UML updated to provide a whole summary of the project and classes
- Added to new features to the project:
- Damage% and Colour classes
- Update on the GUI to take in the new classes and implementaiton of the classes


<<<<<<< HEAD
-
Authors + Contribution:

Andrew Nguyen - UML refinement, kNN and build more on solver class, Read Me doc, model and controller refinement
Adam Staples - UML refinement, Solver refinement, GUI refinement, MVC Implementation for whole architecture
Eric Morrissette - UML refinement, Interface classes including classes implementing it
Mohammad Sunny - UML refinement, Unit testing, algorithm solver

Roadmap: Flexibility for Feature to Feature implementations.
=======


Model: ExampleCollection
  - Holds a list of examples
  - Examples hold a list of features.
  - Two Example Collections are created, one from Training, one for Unsolved examples.
  - A list holding the names of all features is used so we know what features are created with each example.
  
  
Controller: Solver
  - Holds all action listeners and deals with all button presses from the GUI
  - Creation of features and all examples are dealt with in this function.
  
View: GUI
  - The view of the program. 
  - The functionality of the GUI includes:
    - Add and remove indivdual features
    - Create examples for both training and unsolved example lists
    - Edit both lists
    - remove examples from either list
    - Examples in the unsolved list can be entered with an unknown variable. Only 1 per example however.
    - Features are created with metrics attached, these metrics can be chosen from drop down menu.
    - Solve button currently ask for what value of k to be used.
    
    THINGS TO DO FOR GUI
     - WHen a cartesian feature is added do not allow other features of the same type to have more elements,
     - Add a pop up menu that displays resaults after solve button is pressed.

Interface: Feature
  - 3 possible features currently integrated
    - Boolean (True/False)
    - Cartesian (list of coordinates)
    - Number
    
Interface: Metric
  - getDistance method implemented for all possible metrics. (currently 4 possible metrics)
    - BooleanCompare ( this compares 2 boolean values, if they are the same we return 0, else we return 1)
    - Difference ( compares 2 number values, returns the difference of the 2 )
    - AbsoluteDifference ( compares 2 number values, returns the absolute difference of the 2 )
    - Euclidian ( compares 2 cartesian values, returns the result of the distance between the 2 points)

Authors + Contribution:

Andrew Nguyen - UML refinement, kNN and build more on solver class, Read Me doc, model and controller refinement
Adam Staples - UML refinement, Solver implementation, GUI implementation, MVC Implementation for whole architecture
Eric Morrissette - UML refinement, Interface classes including classes implementing it
Mohammad Sunny - UML refinement, Unit testing, algorithm solver

Roadmap: Flexibility for Feature to Feature implementations.



>>>>>>> branch 'Milestone4' of https://github.com/SYSC3110/project-multinational-corps
