import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

import pl.polsl.justyn.rojkowski.tablicaogloszen.exceptions.InvalidInputException;
import pl.polsl.justyn.rojkowski.tablicaogloszen.model.TableModel;

import java.util.ArrayList;

/**
 * Test suite for the TableModel class.
 * This suite includes parameterized tests and traditional unit tests
 * for validating the functionality of the TableModel class.
 */
public class TableModelTest {

    /**
     * The instance of TableModel used in the tests.
     */
    private TableModel tableModel;

    /**
     * Initializes the TableModel object before each test.
     * Ensures a clean state for every test case.
     */
    @BeforeEach
    public void setUp() {
        tableModel = new TableModel();
    }

    /**
     * Parameterized test for validating the addition of messages to the TableModel.
     * Ensures that the message is formatted correctly after being added.
     *
     * @param inputMessage   The input message to be added.
     * @param expectedOutput The expected formatted message.
     */
    @ParameterizedTest
    @CsvSource({
            "Pierwsza wiadomosc, 1. Pierwsza wiadomosc.",
            "Druga wiadomosc, 1. Druga wiadomosc.",
            "Hello World, 1. Hello World."
    })
    public void testAddMessage_WithDifferentMessages(String inputMessage, String expectedOutput) {
        tableModel.addMessage(inputMessage);

        ArrayList<String> messages = tableModel.getArray();
        assertEquals(1, messages.size());
        assertEquals(expectedOutput, messages.get(0));
    }

    /**
     * Parameterized test for validating the removal of messages from the TableModel.
     * Ensures the correct message is removed based on the provided index.
     *
     * @param initialMessages The semicolon-separated list of initial messages.
     * @param indexToRemove   The index of the message to remove.
     * @param expectedSize    The expected size of the list after removal.
     */
    @ParameterizedTest
    @CsvSource({
            "First message, 1, 0",
            "First message;Second message, 1, 1"
    })
    public void testRemoveMessage_WithDifferentInputs(String initialMessages, String indexToRemove, int expectedSize) {
        for (String message : initialMessages.split(";")) {
            tableModel.addMessage(message);
        }
        tableModel.removeMessage(indexToRemove);

        ArrayList<String> messages = tableModel.getArray();
        assertEquals(expectedSize, messages.size());
    }

    /**
     * Parameterized test for validating data indices.
     * Ensures valid indices pass validation, and invalid indices throw an exception.
     *
     * @param index   The index to validate.
     * @param isValid Whether the index is expected to be valid.
     */
    @ParameterizedTest
    @CsvSource({
            "1, true", // Valid index
            "2, false" // Invalid index
    })
    public void testValidateData(int index, boolean isValid) {
        tableModel.addMessage("First message");

        if (isValid) {
            assertDoesNotThrow(() -> tableModel.validatedata(index));
        } else {
            assertThrows(InvalidInputException.class, () -> tableModel.validatedata(index));
        }
    }

    /**
     * Parameterized test for converting messages to uppercase.
     * Ensures all messages are converted correctly while maintaining their format.
     *
     * @param firstMessage        The first message to add.
     * @param secondMessage       The second message to add.
     * @param expectedFirstMessage The expected formatted and uppercase first message.
     */
    @ParameterizedTest
    @CsvSource({
            "First message, SECOND MESSAGE, 1. FIRST MESSAGE.",
            "Another Message, Something Else, 1. ANOTHER MESSAGE."
    })
    public void testConvertMessagesToUppercase_WithDifferentMessages(String firstMessage, String secondMessage, String expectedFirstMessage) {
        tableModel.addMessage(firstMessage);
        tableModel.addMessage(secondMessage);

        tableModel.convertMessagesToUppercase();
        ArrayList<String> messages = tableModel.getArray();

        assertEquals(expectedFirstMessage, messages.get(0));
        assertTrue(messages.get(1).equals("2. " + secondMessage.toUpperCase() + "."));
    }

    /**
     * Validates that an exception is thrown when attempting to remove a message
     * with an invalid index (e.g., non-numeric or out-of-bounds).
     */
    @Test
    public void testRemoveMessage_InvalidIndex() {
        tableModel.addMessage("First message");

        assertThrows(NumberFormatException.class, () -> {
            tableModel.removeMessage("non-existent");
        });
    }
}