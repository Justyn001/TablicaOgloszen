package pl.polsl.justyn.rojkowski.tablicaogloszen.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.polsl.justyn.rojkowski.tablicaogloszen.exceptions.InvalidInputException;
import pl.polsl.justyn.rojkowski.tablicaogloszen.model.TableModel;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * The controller for removing announcements.
 */
public class RemoveAnnouncementController {

    @FXML
    private TextField indexTextField;

    private TableModel tableModel;

    /**
     * Sets the TableModel for this controller.
     *
     * @param tableModel the model to set
     */
    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    /**
     * Handles the action for the remove button.
     * Validates the input and removes the announcement from the model.
     */
    @FXML
    public void handleRemoveButton() {
        String indexText = indexTextField.getText();

        try {
            // Validate and remove announcement
            int index = Integer.parseInt(indexText);
            tableModel.validatedata(index); // Check if the index is valid
            tableModel.removeMessage(indexText); // Remove the announcement
            // Close the dialog window
            Stage stage = (Stage) indexTextField.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            showAlert("Błąd", "Indeks musi być liczbą całkowitą.");
        } catch (InvalidInputException e) {
            showAlert("Błąd", e.getMessage());
        }
    }

    /**
     * Handles the action for the cancel button.
     * Closes the dialog window.
     */
    @FXML
    public void handleCancelButton() {
        // Close the dialog window
        Stage stage = (Stage) indexTextField.getScene().getWindow();
        stage.close();
    }

    /**
     * Shows an alert with the specified title and message.
     *
     * @param title the title of the alert
     * @param message the message to display
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}