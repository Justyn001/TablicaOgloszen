package pl.polsl.justyn.rojkowski.tablicaogloszen.model;

/**
 * Represents a message (advertisement) in the system.
 *
 * @version 1.0
 * @author Justyn Rojkowski
 */
public class MessageModel {

    /**
     * The content of the message.
     */
    private String message;

    /**
     * Constructs a MessageModel with the specified content.
     *
     * @param message the content of the message
     */
    public MessageModel(String message) {
        this.message = message;
    }

    /**
     * Sets the message content.
     *
     * @param message the new content of the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Retrieves the message content.
     *
     * @return the content of the message
     */
    public String getMessage() {
        return message;
    }
}