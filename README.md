# **TIC TAC TOE**

### `Feature Description`

Its a two player game who positions X's and O's alternativey on a 3X3 square matrix. The player whose marks will be posotioned first vertically, horizontally or diagnolly wins the game.

### `Rules`

- Positioning of X always goes first
- X's and O's should be positioned alternatively by two players
- Filled square/position can't be taken to position again
- Players alternate placing X’s and O’s on the board until either:
  * One player has three in a row, horizontally, vertically or diagonally
  * All nine squares are filled
- Player who able to position either three X's or three O's vertically, horizontally or diagnolly will win
- If none of the player is able to position X's or O's vertically, horizontally or diagnolly and the all the squares are filled then the game is a draw

### `Assumptions`

- It's a 3X3 matrix TicTacToe Board
- Player1 who positions X
- Player2 who positions O
- Player 1 starts first and alternatively positioning will be done by both the players

### `How to execute the application` 
- Make sure the initial setup is done to run the MAVEN application like MAVEN_HOME and environment variable
- Make sure git home setup is done
- Checkout the MAVEN project from the below git repository
   https://github.com/2019SOWDEV016/TicTacToe
- Build the application using the below MAVEN command
  - mvn clean install
- Run the main method class "TicTacToeGame" to start the game

#### `Additional info`
 `Main method JAVA class test case results will be shown in the console everytime with the expected results`