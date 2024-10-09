package application.wagonrepairmanager.validations.rules;

import application.wagonrepairmanager.validations.ValidationRule;

public class IntegerRule implements ValidationRule
{
    private String errorMessage;

    @Override
    public boolean validate(String value)
    {
        try {
            Integer.parseInt(value);
            return true;

        } catch (NumberFormatException e) {
            errorMessage = " field must be an integer.";
            return false;
        }
    }

    @Override
    public String getErrorMessage(String fieldName) { return fieldName + errorMessage; }
}
