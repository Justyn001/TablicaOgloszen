package pl.polsl.justyn.rojkowski.tablicaogloszen.model;

import lombok.*;
import pl.polsl.justyn.rojkowski.tablicaogloszen.exceptions.InvalidInputException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Represents the model that stores messages (advertisements) in a list.
 *
 * @version 1.0
 * @author Justyn Rojkowski
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
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
        //lambda
        table = (ArrayList<String>) table.stream()
                .map(announcement -> announcement + ".") // Dodajemy kropkę na końcu każdego ogłoszenia
                .collect(Collectors.toList());
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

        // Pętla for-each do wypisania wszystkich wiadomości
        for (String msg : table) {
            msg.replace(".", "");
            //System.out.println(msg); 
        }
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

    // wykorzystanie strumieniowego przetwarzania danych zapisanych w kolekcjach z wykorzystaniem wyrażeń lambda.
    public void convertMessagesToUppercase() {
        table = (ArrayList<String>) table.stream()
                .map(String::toUpperCase) // Przekształcamy wszystkie ogłoszenia na wielkie litery
                .collect(Collectors.toList());
    }
}

