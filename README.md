# Chess Game

A classic chess game implementation in Java with a JavaFX graphical user interface. This project provides a complete chess game where two players can play against each other with full rule support and game management features.

## Features

- **Two-Player Gameplay**: Play chess between two local players
- **Full Chess Rules Implementation**: 
  - All standard chess piece movements (Pawn, Rook, Knight, Bishop, Queen, King)
  - Legal move validation
  - Check and checkmate detection
  - Piece capture mechanics
- **User Authentication**: Login screen for player identification
- **Graphical User Interface**: Built with JavaFX for a modern look and feel
- **Move Tracking**: Display current player turn and move count
- **Game Status Management**: Real-time game status updates
- **Responsive Design**: Resizable game board with intuitive piece interactions

## Tech Stack

- **Language**: Java 18
- **GUI Framework**: JavaFX 18.0.1
- **Build Tool**: Maven 3.x
- **Testing**: JUnit 5
- **IDE**: IntelliJ IDEA compatible

## Prerequisites

- **Java Development Kit (JDK)**: Version 18 or higher
- **Maven**: Version 3.6 or higher
- **Windows, macOS, or Linux** operating system
- **At least 4GB RAM**

## Installation & Setup

### Clone or Download the Project

```bash
git clone <repository-url>
cd ChessGame
```

### Build the Project

Using Maven:

```bash
mvn clean install
```

This will:
- Download all dependencies (JavaFX, JUnit, etc.)
- Compile the source code
- Build the project

## Running the Game

### Option 1: Using Maven

```bash
mvn clean javafx:run
```

### Option 2: Using IDE

1. Open the project in IntelliJ IDEA or Eclipse
2. Configure JavaFX library (if not already configured)
3. Run the `Application.java` class as a Java application

### Option 3: From Compiled JAR

After building, you can run the compiled classes directly through your IDE or terminal.

## Project Structure

```
ChessGame/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/group2/chessgame/
│   │   │       ├── Application.java          # Main entry point
│   │   │       ├── ChessBoard.java           # Board logic and state
│   │   │       ├── ChessPiece.java           # Base piece class
│   │   │       ├── Pawn.java                 # Pawn piece implementation
│   │   │       ├── Rook.java                 # Rook piece implementation
│   │   │       ├── Knight.java               # Knight piece implementation
│   │   │       ├── Bishop.java               # Bishop piece implementation
│   │   │       ├── Queen.java                # Queen piece implementation
│   │   │       ├── King.java                 # King piece implementation
│   │   │       ├── Player.java               # Player management
│   │   │       ├── PlayerPieces.java         # Player's piece collection
│   │   │       ├── GameManager.java          # Game orchestration
│   │   │       ├── GameStatus.java           # Game state enum
│   │   │       ├── Controller.java           # Main game scene controller
│   │   │       ├── ControllerLogin.java      # Login screen controller
│   │   │       ├── Position.java             # Board position representation
│   │   │       └── Movable.java              # Movement interface
│   │   └── resources/
│   │       └── com/group2/chessgame/
│   │           ├── gameScene.fxml            # Game UI layout
│   │           └── loginScreen.fxml          # Login UI layout
│   └── test/
│       └── [Test files]
├── pom.xml                                    # Maven configuration
├── ChessGame.iml                              # IDE configuration
└── README.md                                  # This file
```

## Game Rules

### Piece Movement

- **Pawn**: Moves forward one square (two squares on first move), captures diagonally
- **Rook**: Moves any number of squares horizontally or vertically
- **Knight**: Moves in an L-shape (2 squares in one direction, 1 square perpendicular)
- **Bishop**: Moves any number of squares diagonally
- **Queen**: Combines rook and bishop movements (any direction)
- **King**: Moves one square in any direction

### Game Mechanics

- Players alternate turns
- Capturing an opponent's piece removes it from the board
- **Check**: When the king is under attack (must move to safety)
- **Checkmate**: When the king is in check and has no legal moves (game ends)
- Only legal moves are allowed; the game validates all moves

## How to Play

1. **Start the Game**: Run the application
2. **Login**: Enter player names on the login screen
3. **Play**: 
   - Click on a piece to select it (legal moves will be highlighted)
   - Click on a destination square to move the piece
   - Players alternate turns
   - Game continues until checkmate is achieved
4. **Exit**: Click the close button or use the menu to exit

## Architecture & Design

### Design Patterns Used

- **Singleton Pattern**: GameManager for centralized game state
- **Observer Pattern**: UI controllers observe game state changes
- **MVC Pattern**: Separation of game logic (Model), UI (View), and controllers

### Key Classes

| Class | Purpose |
|-------|---------|
| `Application` | JavaFX application entry point |
| `GameManager` | Manages game state and player turns |
| `ChessBoard` | Represents the 8x8 board and piece positions |
| `ChessPiece` | Abstract base class for all pieces |
| `Player` | Represents each player and their pieces |
| `Controller` | Handles game scene interactions |
| `ControllerLogin` | Manages player login |

## Configuration

- **Board Size**: 8x8 squares (standard chess board)
- **Window Size**: 800x800 pixels (fixed, non-resizable for consistency)
- **Java Target Version**: 18

## Troubleshooting

### JavaFX Not Found
- Ensure JavaFX SDK is properly configured in your IDE
- Maven should handle this automatically; run `mvn clean install`

### Cannot Run the Application
- Verify Java 18+ is installed: `java -version`
- Check Maven is installed: `mvn -version`
- Try: `mvn clean install` followed by `mvn javafx:run`

### Compilation Errors
- Clean the build: `mvn clean`
- Rebuild: `mvn compile`
- Check that all files are in the correct package: `com.group2.chessgame`

## Building for Distribution

To create a standalone executable:

```bash
mvn clean package
```

This generates compiled classes in the `target/` directory.

## Future Enhancements

Potential features for future versions:
- Move history/replay functionality
- Save and load games
- AI opponent (single-player mode)
- Time controls
- Online multiplayer
- Piece promotion on pawn reaching end
- En passant and castling moves
- Undo/redo functionality

## License

This is a university project created for educational purposes.

## Contributors

Group 2 - University Project

## Contact & Support

For issues or questions about the project, please refer to the project documentation or contact the development team.

---

**Last Updated**: 2026  
**Java Version**: 18  
**JavaFX Version**: 18.0.1
