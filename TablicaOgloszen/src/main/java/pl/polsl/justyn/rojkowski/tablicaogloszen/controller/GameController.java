package pl.polsl.justyn.rojkowski.tablicaogloszen.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.polsl.justyn.rojkowski.tablicaogloszen.model.TableModel;
import pl.polsl.justyn.rojkowski.tablicaogloszen.view.UserView;



/**
 * Manages the overall flow of the application, including game logic and user interactions.
 *
 * @version 1.0
 * @author Justyn Rojkowski
 */
public class GameController {

    private UserView userView;
    private UserController userController;
    private TableModel tableModel;
    private MainController mainController;

    /**
     * Constructs a GameController with the specified model, view, and user controller.
     *
     * @param tableModel the model that stores the messages
     * @param userView the view to interact with the user
     * @param userController the controller managing user actions
     */
    public GameController(TableModel tableModel, UserView userView, UserController userController) {
        this.tableModel = tableModel;
        this.userView = userView;
        this.userController = userController;

    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * Starts the game by setting the initial state with parameters and entering a loop
     * where the user can choose to add or remove messages.
     *
     * @param param1 the first parameter for the initial message
     * @param param2 the second parameter for the initial message
     */
    public void startGame(String param1, String param2) {
        boolean running = true;

        // Add the initial messages based on command-line parameters
        //userController.addFirstMessage(param1);
        //userController.addFirstMessage(param2);

        // Main game loop
        //while (running) {
            //userView.showArray(tableModel); // Show the current message board
            //userView.showMenu(); // Display the menu options
            //String choice = userController.userChoice(); // Get the user's choice

//            switch (choice) {
//                case "0":
//                    running = false; // Exit the program
//                    break;
//                case "1":
//                    userController.addMessage(); // Add a new message
//                    break;
//                case "2":
//                    userController.removeMessage(); // Remove a message
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");


           // }

        }
    }