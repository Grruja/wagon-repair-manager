package application.wagonrepairmanager.controllers;

import application.wagonrepairmanager.models.RepairModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class RepairController implements Initializable
{
    @FXML
    private TextField wagonIdField;
    @FXML
    private TextField problemDetectedField;
    @FXML
    private TextField userIdField;
    @FXML
    private DatePicker repairDatePicker;
    @FXML
    private ComboBox<String> repairStatusCombo;

    @FXML
    private Label wagonIdError;
    @FXML
    private Label problemDetectedError;
    @FXML
    private Label userIdError;
    @FXML
    private Label repairDateError;
    @FXML
    private Label repairStatusError;

    private static final String[] REPAIR_STATUS_OPTIONS = {"completed", "in progress"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        repairStatusCombo.setItems(FXCollections.observableArrayList(REPAIR_STATUS_OPTIONS));
    }

    @FXML
    private void createRepair()
    {
        RepairModel.saveRepair(formData());
    }

    private Map<String, Object> formData()
    {
        Map<String, Object> formData = new LinkedHashMap<>();
        formData.put("wagonId", wagonIdField.getText());
        formData.put("problemDetected", problemDetectedField.getText());
        formData.put("userId", userIdField.getText());
        formData.put("repairDate", repairDatePicker.getValue());
        formData.put("repairStatus", repairStatusCombo.getValue());

        return formData;
    }
}
