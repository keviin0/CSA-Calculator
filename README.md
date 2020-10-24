# CSA-Calculator
A Calculator for CSA


<<<<<<< HEAD
--------Student Self Evaluations and Reflections:

- Kevin
This week I focused one building a skeleton of MVC which was a big learning target for this week. This can be seen in how I structure my contributions which distinctly separated functional code from any code dealing with UI. This will help me in the long term when working between the UI and functional code.
Contributions:
Anime.java
APIRequest.java

- Sean

- Siddhant

I believe that I should get a 5/5 on my self-grade. I spent extra time outside of class searching for specific information for my code outside the resources provided to us in class, which included me going to the library to get a book on Java. I had learned from my last project that I should research the types of syntax and concepts I need and to plan out my code before just writing code and trying to learn along the way. I was able to overcome many issues on Intellij. Initially, I could not even commit my changes to my code. One time, an attempted commit ended up deleting my entire code. However, that may have been a good thing because I realized I could find a more efficient method to create my card deck for my War Card Game. Eventually, with the help of my team, I was able to create and push my code properly. However, when it came to creating a button that would appear on the main menu screen for the actual running of this project, I used the same style of text to create a button my team did, and I tried altering many parts of my code, but a button on the main menu screen still does not appear and IntelliJ pushed a certain part of my code in the wrong place in github. I commented on my original code and commit to show what my intended code was supposed to be. This is an issue I plan on resolving this weekend and in the beginning of next week. Otherwise, I believe I most likely created a functioning card deck, but I commented out my final changes because I wasn't entirely sure if they were correct, and I did not want to create any "rubber chickens" in the code that would hurt my group.  

- Aditya

For my self grade, I believe that I should get a 5/5. I set a goal for myself to finish a TicTacToe mini game by the end of the week, which I accomplished. It was no easy task, though. Since I'm still learning IntelliJ, I had to spend a lot of time playing with the IDE to get it to work with my code. I have also never used JPanel in Java, so I had to climb a steep learning curve for that as well. I faced many syntactical, as well as logical errors, but I was able to problem solve to get to my end result. I watched many videos, and I also used a Java book that I found at home to teach myself these concepts. Additionally, this week, I changed my method of typing my code for these projects; instead of diving straight into it, I decided to plan out my code first, so that I could conduct any research that would be necessary in order to successfully complete my code. This method was a lot more efficient than my method for the previous weeks. One problem that I haven't solved yet is getting my mini game to appear on the Main Menu, which a few other people in our group are having. We will look into this problem over the weekend as well as the beginning of next week. Overall, I think I contributed quite a lot to the team, since I made a whole mini game for our project.

- Jacob

--------Explanation for Each Lab:

- Calculator UI

- Thai21

- TicTacToe

This UI TicTacToe game simulates an actual game of TicTacToe. The game requires that there are two people, obviously, so there are two different symbols that the players can choose from, either a X or an O. The player who chooses X is told that they are first; in order to choose a spot to place their symbol, the player uses their mouse to click near the center of one of the nine boxes. Their spot has been selected, so now it's time for the second player to select a spot, following the same procedure with the mouse that the first player did. This process continues until a player wins, which is when they place three of their symbols in a row, column, or diagonal. The UI will notify the players when one of them has won. If neither player wins, the UI will notify the players that it's a draw.

- WarCardGame
The UI WarCardGame code is the beginning of a code that is meant to simulate a game of the card game war. So far, a potential card deck has been created to store a typical set of cards. Later on, the order of the cards will be randomized and half the cards will be dealt to the player and the other half to the computer. When prompted, the player will draw a random card, which will signal to the computer to draw a random card. There will then be a set of conditions stating that if the player has a higher card than the computer, the player will get a certain number of points. This works the same way if the computer has the higher card. This process will continue until the both the player and the computer have run of cards. At this point, the program will print the final scores of the player and the computer. It will then read the final scores of the player and the computer, do a comparison to decide which score is higher, and then declare the winner.

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

MVC BlueJ Model (as of 10/23/2020):
![](images/MVC.png)
>>>>>>> origin/main