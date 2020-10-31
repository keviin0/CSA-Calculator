# CSA-Calculator

**Standard SDK:** adopt-openj9-15

**Project Theme:** Games from the Decades

**Team Goals Week 8:**
* make readme more concise

* reference actual code in progress check

* add TODO: to help keep collaboration organized

* establish overall theme for project 

* try to have no rubber chickens

**Pair / Trio breakdowns:**

Sean / Kevin / Siddhant : UNO game
 
Aditya / Jacob : MineSweeper

**Individual Assignments Week 8:**

Sean: Fix Readme; work on the view of UNO game

Kevin: Fix Readme; work on control of UNO game

Siddhant: Fix Readme; work on view/model of UNO game

Jacob: Fix Readme; work on control of MineSweeper

Aditya: Fix Readme; work on view/model of MineSweeper

**Week 8 Progress Check**

| *Contributor's <br> Name* | *Self <br> Grade (out <br> of 20)* | Reasoning | Scrum Master <br> Grade (out <br> of 5)
|---|:---:|---|---|
|Kevin Hu | 19/20 | Completed model and control segments of Uno with model found in [Actions.java](./util/Actions.java) and control in [Playfield.java](./util/Playfield.java). Created bridge between View and Model/Control with performAction() method in [UnoUI.java](./ui/UnoUI). All other work in helper files: [Card.java](./util/Card.java), [Deck.java](./util/Deck.java), [Player.java](./util/Player.java). Still need to add special card functionality in Actions.java for full game functionality.  | 5/5 Developed entirety of model/control for Uno |
|Sean Tran   |   |   | |
|  Aditya Surapaneni | 19/20  | I achieved my goals for this week. I helped with the creation of the Minesweeper mini game by working on the View and Model of the program, which included the creation of Grid.java, Square.java, and a few portions of MGame.java. Grid.java: https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/util/Grid.java
                                                                                                                                                                                                                                                                       Square.java: https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/util/Square.java
                                                                                                                                                                                                                                                                       MGame.java: https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/util/MGame.java|   |
 
|   |   |   |   |
|   |   |   |   |
                
       

**How to run our code:**
- Our Project Standard SDK is adopt-openj9-15
- We have sent the link to our [Github project](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim)
- When pulling our code, we have a number of games. The two games from this week are UNO and Minesweeper
- Each of these should run individually and the main code should run.
- The Home Button and AP Test Button do not work. Only the Labs Button Works. The two games from this weeek are UNO and Minesweep.
- Siddhant, Kevin, and Sean worked on UNO and Jacob and Aditya worked on Minesweeper.
- The place card button for the UNO game does not work and only 1 card can be drawn for the UNO game.
Note for the instructions: We added extra instructions so we hopefully will not waste any of your time for you trying to figure out how to run our code.




--------Explanation for Each Lab:

- Calculator UI

Calculator UI is an advanced version of the sample calculator. The Calculator includes the standard adding, subtracting, multiply, and divide. The calculator also has a unique a hexadecimal converter. 
- UNO
A computer simulation of the Card Game UNo
-Minsweeper
A Java simulation of the 1989 video game Minesweeeper.



MVC BlueJ Model (as of 10/30/2020) no including Calculator:
![](images/MVC.png)

--------MVC CALCULATOR DESIGN FOR PAIR/TRIO OF ADITYA, JACOB

Three Classes
- Model
- View
- Controller

The Model class is responsible for the calculations.
The View class draws the calculator, as well as the display.
The Controller class has two functions. One function is to pass the button clicks to the View class. The second function is to get the display value from the Model class so that it can be passed to the View class.

There will be a Button interface, where the Button instance includes:
- ID Numbers
- A Name
- Function

The Controller class would build a collection of Buttons, while the View class, as well as the Model class would use the buttons.

So, after this, the controller would:
- Pass Clicks to View
- Return Button ID to Model
- Get the display value from Model to pass to View



