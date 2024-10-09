package application.wagonrepairmanager.validations;

import javafx.scene.control.Label;
import java.util.List;

public class ValidationContext
{
    private final List<ValidationRule> RULES;
    private final String FIELD_NAME;

    public ValidationContext(List<ValidationRule> rules, String fieldName)
    {
        this.RULES = rules;
        this.FIELD_NAME = fieldName;
    }

    public boolean validate(String value, Label errorMessage)
    {
        String trimmedValue = value.trim();

        for (ValidationRule rule : RULES) {
            if ( !rule.validate(trimmedValue)) {
                errorMessage.setText(rule.getErrorMessage(FIELD_NAME));
                return false;
            }
        }

        errorMessage.setText("");
        return true;
    }
}
