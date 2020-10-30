# CSA-Calculator

**Standard SDK:** adopt-openj9-15

**Team Goals Week 8:**

Fix our README to be more consice; reference actual code; add TODO:
establish an overall theme for the project; minilab; we are thinking about a game from two different bygone decades, and we need to
make sure we have no rubber chickens. Siddhant, Sean, and Kevin are working on UNO, Jacob and Aditya on Minesweeper.

**Individual Assignments Week 8:**

Sean: Fix Readme; work on the view of UNO game

Kevin: Fix Readme; work on control of UNO game

Siddhant: Fix Readme; work on view/model of UNO game

Jacob: Fix Readme; work on control of MineSweeper

Aditya: Fix Readme; work on view/model of MineSweeper

**Week 8 Progress Check**

Progress Check/Reflection for Week 8
------------------------------------------------
Kevin       
Hu          
            
-------------------------------------------------
Sean        
Tran        
            
-------------------------------------------------
Siddhant  
Ranka     
          
-------------------------------------------------
Aditya Surapaneni

-------------------------------------------------
Jacob Rozenkrantz

-------------------------------------------------
                
       

**How to run our code:**
- Our Project Standard SDK is adopt-openj9-15
- We have sent the link to our [Github project](https://github.com/keviin0/CSA-Portfolio-GroceryStoreSim)
- When pulling our code, we have a number of games. The two games from this week are UNO and Minesweeper
- Each of these should run individually and the main code should run.




--------Explanation for Each Lab:

- Calculator UI

Calculator UI is an advanced version of the sample calculator. The Calculator includes the standard adding, subtracting, multiply, and divide. The calculator also has a unique a hexadecimal converter. 
- UNO
A computer simulation of the Card Game UNo
-Minsweeper
A Java simulation of the 1989 video game Minesweeeper.



MVC BlueJ Model (as of 10/23/2020):
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



