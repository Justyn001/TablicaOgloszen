package pl.polsl.justyn.rojkowski.tablicaogloszen.controller;

import pl.polsl.justyn.rojkowski.tablicaogloszen.exceptions.InvalidInputException;
import pl.polsl.justyn.rojkowski.tablicaogloszen.model.TableModel;
import pl.polsl.justyn.rojkowski.tablicaogloszen.view.UserView;
import java.util.Scanner;

/**
 * Manages user interactions and actions such as adding or removing messages.
 *
 * @version 1.0
 * @author Justyn Rojkowski
 */
public class UserController {

    private TableModel tableModel;
    private UserView userView;

    /**
     * Constructs a UserController with the specified TableModel.
     *
     * @param tableModel the model that stores messages
     */
    public UserController(TableModel tableModel) {
        this.userView = new UserView();
        this.tableModel = tableModel;
    }

    /**
     * Prompts the user for their menu choice and returns it.
     *
     * @return the user's choice as a String
     */
    public String userChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Prompts the user to add a new message to the message board.
     */
    public void addMessage() {
        userView.messageToAdd();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        tableModel.addMessage(input);
    }

    /**
     * Prompts the user to remove a message from the board and validates the input.
     */
    public void removeMessage() {
        userView.messageToRemove();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            int index = Integer.parseInt(input);
            tableModel.validatedata(index);
            tableModel.removeMessage(String.valueOf(index));
            System.out.println("Message has been removed.");
        } catch (NumberFormatException e) {
            System.out.println("Error: The provided value is not a number.");
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds the first message to the board from the game parameters.
     *
     * @param message the content of the first message
     */
    public void addFirstMessage(String message) {
        tableModel.addMessage(message);
    }
}
