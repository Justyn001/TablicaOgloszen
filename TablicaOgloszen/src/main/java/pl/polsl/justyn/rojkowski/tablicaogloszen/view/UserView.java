package pl.polsl.justyn.rojkowski.tablicaogloszen.view;

import pl.polsl.justyn.rojkowski.tablicaogloszen.model.TableModel;

/**
 * Represents the user interface for displaying messages and menu options.
 *
 * @version 1.0
 * @author Justyn Rojkowski
 */
public class UserView {

    /**
     * Displays the list of messages (advertisements).
     *
     * @param table the TableModel containing the list of messages
     */
//    public void showArray(TableModel table) {
//        System.out.println("\t\tMESSAGE BOARD");
//        if (table.getArray().isEmpty()) {
//            System.out.println("The board is empty. Add a message!");
//        } else {
//            for (int i = 0; i < table.getArray().size(); i++) {
//                System.out.println((i + 1) + ". " + table.getArray().get(i).getMessage());
//            }
//        }
//    }

    /**
     * Displays the menu options to the user.
     */
    public void showMenu() {
        System.out.println("What would you like to do?");
        System.out.println("Press 0 to exit.");
        System.out.println("Press 1 to add a message.");
        System.out.println("Press 2 to remove a message.");
    }

    /**
     * Prompts the user to enter the content of a message to add.
     */
    public void messageToAdd() {
        System.out.println("Enter the message content: ");
    }

    /**
     * Prompts the user to specify the number of the message to remove.
     */
    public void messageToRemove() {
        System.out.println("Enter the number of the message to remove: ");
    }
}