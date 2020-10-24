# CSA-Calculator
A Calculator for CSA


<<<<<<< HEAD
--------Student Self Evaluations and Reflections:

- Kevin

- Sean

- Siddhant

- Aditya

For my self grade, I believe that I should get a 5/5. I set a goal for myself to finish a TicTacToe mini game by the end of the week, which I accomplished. It was no easy task, though. Since I'm still learning IntelliJ, I had to spend a lot of time playing with the IDE to get it to work with my code. I have also never used JPanel in Java, so I had to climb a steep learning curve for that as well. I faced many syntactical, as well as logical errors, but I was able to problem solve to get to my end result. Overall, I think I contributed quite a lot to the team, since I made a whole mini game for our project.

- Jacob

--------Explanation for Each Lab:

- Calculator UI

- Thai21

- TicTacToe

This UI TicTacToe game simulates an actual game of TicTacToe. The game requires that there are two people, obviously, so there are two different symbols that the players can choose from, either a X or an O. The player who chooses X is told that they are first; in order to choose a spot to place their symbol, the player uses their mouse to click near the center of one of the nine boxes. Their spot has been selected, so now it's time for the second player to select a spot, following the same procedure with the mouse that the first player did. This process continues until a player wins, which is when they place three of their symbols in a row, column, or diagonal. The UI will notify the players when one of them has won. If neither player wins, the UI will notify the players that it's a draw.

- WarCardGame

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

So,after this, the controller would:
- Pass Clicks to View
- Return Button ID to Model
- Get the display value from Model to pass to View
>>>>>>> origin/main