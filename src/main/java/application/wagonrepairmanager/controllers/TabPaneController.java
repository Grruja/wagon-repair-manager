package application.wagonrepairmanager.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.Objects;

public class TabPaneController
{
    @FXML
    private Tab dashboardTab;
    @FXML
    private Tab addRepairTab;
    @FXML
    private BorderPane dashboardPane;
    @FXML
    private BorderPane addRepairPane;

    @FXML
    private void dashboard() throws IOException {
        if (!dashboardTab.isSelected()) return;

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/application/wagonrepairmanager/views/repairs-list.fxml")));
        dashboardPane.setTop(root);
    }

    @FXML
    private void addRepair() throws IOException
    {
        if (!addRepairTab.isSelected()) return;

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/application/wagonrepairmanager/views/add-repair-form.fxml")));
        addRepairPane.setTop(root);
    }
}
