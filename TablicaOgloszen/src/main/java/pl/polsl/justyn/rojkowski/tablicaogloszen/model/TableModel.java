package pl.polsl.justyn.rojkowski.tablicaogloszen.model;

import pl.polsl.justyn.rojkowski.tablicaogloszen.exceptions.InvalidInputException;
import java.util.ArrayList;

/**
 * Represents the model that stores messages (advertisements) in a list.
 *
 * @version 1.0
 * @author Justyn Rojkowski
 */
public class TableModel {

    /**
     * The list of messages.
     */
    private ArrayList<String> table;
    private String message;

    /**
     * Constructs an empty TableModel.
     */
    public TableModel() {
        this.table = new ArrayList<>();
    }

    /**
     * Retrieves the list of messages.
     *
     * @return the list of messages
     */
    public ArrayList<String> getArray() {
        return table;
    }

    /**
     * Adds a message to the list.
     *
     * @param messageToAdd the content of the message to add
     */
    public void addMessage(String messageToAdd) {
        messageToAdd = table.size() + 1 +". " + messageToAdd;
        table.add(messageToAdd);
    }

    /**
     * Removes a message from the list by its index.
     *
     * @param messageToRemove the index of the message to remove
     */
    public void removeMessage(String messageToRemove) {
        this.table.remove(Integer.parseInt(messageToRemove) - 1);
    }

    /**
     * Validates if the specified index is within the valid range of the message list.
     *
     * @param index the index to validate
     * @throws InvalidInputException if the index is out of range
     */
    public void validatedata(int index) throws InvalidInputException {
        if (index < 1 || index > getArray().size()) {
            throw new InvalidInputException("Index out of range!");
        }
    }
}

