package pl.polsl.justyn.rojkowski.tablicaogloszen;

import pl.polsl.justyn.rojkowski.tablicaogloszen.controller.GameController;
import pl.polsl.justyn.rojkowski.tablicaogloszen.controller.MainController;
import pl.polsl.justyn.rojkowski.tablicaogloszen.controller.UserController;
import pl.polsl.justyn.rojkowski.tablicaogloszen.model.MessageModel;
import pl.polsl.justyn.rojkowski.tablicaogloszen.model.TableModel;
import pl.polsl.justyn.rojkowski.tablicaogloszen.view.UserView;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class that initializes the program.
 * It accepts command-line arguments and starts the game in either interactive or command-line mode.
 *
 * @version 1.0
 * @author Justyn Rojkowski
 */
public class Main extends Application{

    /**
     * The start method for the JavaFX application.
     *
     * @param primaryStage the primary stage for this application
     * @throws Exception if any error occurs during the loading of the FXML
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creating the TableModel
        TableModel tableModel = new TableModel();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
        Parent root = loader.load();

        MainController mainController = loader.getController();
        mainController.setTableModel(tableModel); // Pass model to the main controller
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * The main method that launches the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        UserView userView = new UserView();
        TableModel tableModel = new TableModel();
        UserController userController = new UserController(tableModel);
        launch(args);
    }
}