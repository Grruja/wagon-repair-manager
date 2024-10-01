package application.wagonrepairmanager.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.Objects;

public class TabPaneController
{
    @FXML
    private BorderPane dashboardPane;
    @FXML
    private BorderPane addRepairPane;

    @FXML
    private void dashboard() throws IOException { loadFile("repairs-list", dashboardPane); }

    @FXML
    private void addRepair() throws IOException { loadFile("add-repair-form", addRepairPane); }

    private void loadFile(String fileName, BorderPane pane) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/application/wagonrepairmanager/views/" + fileName + ".fxml")));
        pane.setTop(root);
    }
}
