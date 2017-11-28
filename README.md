# project-multinational-corps

Milestone 3
----------------------------------------------------------------------------------------------------------

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
-


Authors + Contribution:

Andrew Nguyen - UML refinement, kNN and build more on solver class, Read Me doc, model and controller refinement
Adam Staples - UML refinement, Solver refinement, GUI refinement, MVC Implementation for whole architecture
Eric Morrissette - UML refinement, Interface classes including classes implementing it
Mohammad Sunny - UML refinement, Unit testing, algorithm solver

Roadmap: Flexibility for Feature to Feature implementations.
