# CSA-Portfolio Project

**Standard SDK:** Adopt-OpenJ9-15

**Project Theme:** Games from the Decades

**How to Run our Code:**
- Our Project Standard SDK is Adopt-OpenJ9-15
- We have sent the link to our [Github Project](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim)
- Our three main games are Go Fish, UNO, and Minesweeper.
- Each of these should run individually, and the main code should run.
- On Configurations in IntelliJ, set the configuration to MainMenu. When running you will see a Home, AP Test, and Labs Button. The Labs Button leads to buttons for each of our code. The image below for MainMenu does not show Go Fish since the picture was added on 10/30 and Go Fish was added later, but when you run IntelliJ, it will show Go Fish with the rest of the game buttons in that Main Menu under Labs.
- The Home Button and AP Test Button do not work. Only the Labs Button Works. 
- Kevin and Sean worked on UNO and Jacob and Aditya worked on Minesweeper. Siddhant worked on Go Fish.

![](images/Snip1.png)

**TODOs/Team Goals Week 11:**
* Finalize our README.

* Finish all the mini labs.

* Create our videos.

**Pair/Trio Breakdowns:**

Sean / Kevin : UNO Game

Siddhant: Go Fish Game
 
Aditya / Jacob : MineSweeper Game

**TODOs/Individual Assignments Week 11:**

Sean: Fix ReadMe; Work on the view of UNO Game; Make final adjustments to View; Create video for final project.

Kevin: Fix ReadMe; Work on the control of UNO Game; Make final adjustments to Control; Create video for final project.

Siddhant: Fix ReadMe; Make final adjustments for GoFish; Create video for final project.

Jacob: Fix ReadMe; Make finishing touches to control of MineSweeper; Create video for final project.

Aditya: Fix ReadMe; Make finishing touches to model/view of MineSweeper; Create video for final project.

------------------------------------------------------------------------------------------------------------------------

**Contributions/Code/Key Concepts**

Siddhant Ranka - Created a functional computer simulation in java of the card game Go Fish and created a video demonstrating the game and its code. This game is fully functional and it works on the integrated Night at the Museum website. This is the code for the declaration of the variables, ArrayLists, and [UI components](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/ui/GoFish.java#L15-L34). The logic code for Go Fish is shown through this [link](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/ui/GoFish.java#L39-L129). It would be considered control code in an MVC format. The UI code for Go Fish is shown through the [link](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/ui/GoFish.java#L136-L168). If Go Fish was in a full MVC format, this code would be considered the view code of MVC.

Sean Tran - Uno: Co-Created a functional [Uno Game](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/ui/UnoUI.java) with special cards in java. The game includes use of MVC and features a [stack](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/util/Actions.java#L8-L29). Created and designed the [view](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/ui/UnoUI.java). Help debug and fix [model](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/util/SpecialActions.java) and [control](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/util/Actions.java). Created and edited the group final video. As, a side minilab, created [Thai 21](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/ui/Thai21.java).                 

**Peer Evaluations**

Siddhant Ranka: Overall was always present in class and was active on communication applications such as Slack, and text. Went to tutorial multiple times to ask questions to help the group. Most significant contribution to project was the creation of the [GoFish](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/util/GoFishCard.java) game. Something they should improve on is asking for help sooner than later so they do not lag behind the group.

Sean Tran: Overall was active in communication with group via Slack and text. Took initiative to ask other groups and Mr. Mortensen questions. Most significant contribution was the work done on Uno especially [view](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/ui/UnoUI.java) and work on [Thai 21](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/ui/Thai21.java). Something they can improve on is communicating with teammates when they push code to prevent problems with version control.

Kevin Hu: Overall was active in communicating with the group via class and Slack. Was good at introducing advanced programming concepts not taught in class. Most significant contribution was work done on Uno especially [model](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/util/SpecialActions.java) and [control](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/util/Actions.java). Something they should improve on is better communication with group in hours after class.

Aditya Surapaneni: Overall was active in communication via Slack and text. Was good at asking other groups questions and communicating with teammates to make sure we are all on page. Most significant contribution was work on [MineSweeper](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/ui/MineSweeperGame.java) and [Tic Tac Toe](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/ui/TicTacToe.java). Something they should impove on is contributing more to organizing code and writing comments.

Jacob Rozenkrants: Overall was active communicating during class. Did a good job keeping journal up to date and helped work on code whenever possible. Most significant contribution was work on [MineSweeper](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/ui/MineSweeperGame.java) and [Tic Tac Toe](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim/blob/main/src/ui/TicTacToe.java). Something they should improve on is being more active in Slack so others know when they contributed work.
--------Explanation for Each Lab:

- Calculator UI

Calculator UI is an advanced version of the sample calculator. The Calculator includes the standard adding, subtracting, multiply, and divide. The calculator also has a unique a hexadecimal converter. 
- UNO

A computer simulation of the Card Game UNO

- GoFish

A computer simulation in Java of the Card Game Go Fish.

* Minesweeper

A Java simulation of the 1989 video game Minesweeeper.

* Tic Tac toe

A computer simulation of the classic Tic Tac Toe

* 21 Flags

A computer simulation of the Thai 21 flag game


MVC BlueJ Model (as of 10/30/2020) no including Calculator or Go Fish:
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

---------------------------------------------------------------------------------------------------


