package application.wagonrepairmanager.controllers;

import application.wagonrepairmanager.models.RepairModel;
import application.wagonrepairmanager.validations.RepairValidations;
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

    private RepairValidations validator;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        repairStatusCombo.setItems(FXCollections.observableArrayList(RepairModel.REPAIR_STATUS_OPTIONS));
        validator = new RepairValidations(wagonIdError, problemDetectedError, userIdError, repairDateError, repairStatusError);
    }

    @FXML
    private void createRepair()
    {
        Map<String, Object> formData = formData();
        if (!validator.validateForm(formData)) return;
        new RepairModel().create(formData);
    }

    private Map<String, Object> formData()
    {
        Map<String, Object> formData = new LinkedHashMap<>();
        formData.put("wagon_id", wagonIdField.getText());
        formData.put("problem_detected", problemDetectedField.getText());
        formData.put("repaired_by_user_id", userIdField.getText());
        formData.put("repair_date", repairDatePicker.getValue());
        formData.put("repair_status", repairStatusCombo.getValue());

        return formData;
    }
}
