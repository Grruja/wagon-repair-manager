package application.wagonrepairmanager.utilities;

import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class UIUtility
{
    public static void toastMessage(Label label)
    {
        label.setOpacity(1);

        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> label.setOpacity(0));

        pause.play();
    }
}
