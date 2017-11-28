# project-multinational-corps

Milestone 3
----------------------------------------------------------------------------------------------------------
HOW TO RUN THE PROGRAM:
- Run the code as a java application
- Go to "Menu" and add features that you desire.
- Remove any features from the same menu.
- Add training examples via the add button at the bottom left of the GUI
- Add unsolved examples vai the add button on the bottom right, for any unknown feature values simply enter "?".
- Edit or remove any by clicking on that particular example and clicking the respective button.
- Once all examples are entered, press solve and enter the desired k value.

Checkpoint 1

Redesigned everything from scratch starting with:
- The UML to make it look like the MVC architecture.
- Updated the Feature classes: Cartesian, Boolean, Number to make it more generalised
- Made a feature collection classes that holds all the features to be used : model
- Made a new kNN class which works with the Solver to gives us kNN values.
- Made a Solver class that uses the Feature collection in coordinance with the GUI : controller
- Built a new GUI that allows user to input values: view
- GUI interface refinement

Checkpoint 2

- Discussed about current program with TA and made adjustments to UML
- UML now includes a Metric interface that contains: Feature - Cartesian, Boolean, Number with Feature equation - BooleanCompare, AbsoluteDifference, Eucidian, Difference.
- Cartesian is also a complex feature which contains a list of finite Number feature.
- Entity Class is refactored/renamed to Example and Example is part of ExampleCollection
- Made some changes to classes (rebustment, loose couple)


Model: ExampleCollection
  HOlds a list of examples
  Examples hold a list of features.
  Two Example Collections are created, one from Training, one for Unsolved examples.
  A list holding the names of all features is used so we know what features are created with each example.
  
  
Controller: Solver
  Holds all action listeners and deals with all button presses from the GUI
  Creation of features and all examples are dealt with in this function.
  
View: GUI
  THe view of the program. 
  The functionality of the GUI includes:
    -Add and remove indivdual features
    -Create examples for both training and unsolved example lists
    -Edit both lists
    -remove examples from either list
    -Examples in the unsolved list can be entered with an unknown variable. Only 1 per example however.
    -Features are created with metrics attached, these metrics can be chosen from drop down menu.
    -Solve button currently ask for what value of k to be used.
    
    THINGS TO DO FOR GUI
     -WHen a cartesian feature is added do not allow other features of the same type to have more elements,
     -Add a pop up menu that displays resaults after solve button is pressed.


Authors + Contribution:

Andrew Nguyen - UML refinement, kNN and build more on solver class, Read Me doc, model and controller refinement
Adam Staples - UML refinement, Solver implementation, GUI implementation, MVC Implementation for whole architecture
Eric Morrissette - UML refinement, Interface classes including classes implementing it
Mohammad Sunny - UML refinement, Unit testing, algorithm solver

Roadmap: Flexibility for Feature to Feature implementations.



