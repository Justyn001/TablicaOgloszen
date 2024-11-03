package pl.polsl.justyn.rojkowski.tablicaogloszen.controller;

import pl.polsl.justyn.rojkowski.tablicaogloszen.model.TableModel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * The controller for the main application view.
 */
public class MainController {

    private TableModel tableModel;

    @FXML
    private ListView<String> announcementsListView;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button exitButton;

    /**
     * Initializes the controller after its root element has been processed.
     * Sets tooltips for buttons.
     */
    @FXML
    public void initialize() {
        // Setting tooltips for buttons
        addButton.setTooltip(new Tooltip("Dodaj nowe ogłoszenie do listy."));
        removeButton.setTooltip(new Tooltip("Usuń wybrane ogłoszenie z listy."));
        exitButton.setTooltip(new Tooltip("Zakończ działanie aplikacji."));
    }

    /**
     * Exits the application.
     */
    @FXML
    public void exitProgram() {
        Platform.exit();
    }

    /**
     * Sets the TableModel for this controller.
     *
     * @param tableModel the model to set
     */
    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    /**
     * Handles the action for the add button.
     * Opens a dialog to add a new announcement.
     */
    @FXML
    public void handleAddButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/polsl/justyn/rojkowski/tablicaogloszen/view/AddAnnouncement.fxml"));
            Parent root = loader.load();

            AnnouncementController controller = loader.getController();
            controller.setTableModel(tableModel);

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Dodaj ogłoszenie");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setScene(new Scene(root));
            dialogStage.showAndWait();

            announcementsListView.getItems().setAll(tableModel.getArray());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action for the remove button.
     * Opens a dialog to remove an existing announcement.
     */
    @FXML
    public void handleRemoveButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/polsl/justyn/rojkowski/tablicaogloszen/view/RemoveAnnouncement.fxml"));
            Parent root = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Usuń ogłoszenie");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setScene(new Scene(root));

            RemoveAnnouncementController controller = loader.getController();
            controller.setTableModel(tableModel);

            dialogStage.showAndWait();
            announcementsListView.getItems().clear();
            announcementsListView.getItems().addAll(tableModel.getArray());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}