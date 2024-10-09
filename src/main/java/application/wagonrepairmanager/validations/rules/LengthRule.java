package application.wagonrepairmanager.validations.rules;

import application.wagonrepairmanager.validations.ValidationRule;

public class LengthRule implements ValidationRule
{
    private final int LENGTH;
    private String errorMessage;

    public LengthRule(int length) { this.LENGTH = length; }

    @Override
    public boolean validate(String value)
    {
        if (value.length() != LENGTH) {
            errorMessage = " field must have " + LENGTH + " characters.";
            return false;
        }

        return true;
    }

    @Override
    public String getErrorMessage(String fieldName) { return fieldName + errorMessage; }
}
