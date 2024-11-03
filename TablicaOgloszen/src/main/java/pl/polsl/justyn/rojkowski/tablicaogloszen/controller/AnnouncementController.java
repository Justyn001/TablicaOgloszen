package pl.polsl.justyn.rojkowski.tablicaogloszen.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.polsl.justyn.rojkowski.tablicaogloszen.model.TableModel;

/**
 * The controller for adding new announcements.
 */
public class AnnouncementController {

    @FXML
    private TextField announcementTextField;

    private TableModel tableModel; // Reference to TableModel

    /**
     * Sets the TableModel for this controller.
     *
     * @param tableModel the model to set
     */
    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    /**
     * Handles the action for the confirm button.
     * Adds the new announcement to the model and closes the dialog.
     */
    @FXML
    public void handleConfirmButton() {
        String newAnnouncement = announcementTextField.getText();

        // Add to the array T
        if (!newAnnouncement.isEmpty()) { // Check if the field is not empty
            tableModel.addMessage(newAnnouncement); // Add new message to the model
            // Close the dialog window
            Stage stage = (Stage) announcementTextField.getScene().getWindow();
            stage.close();
        }
    }
}