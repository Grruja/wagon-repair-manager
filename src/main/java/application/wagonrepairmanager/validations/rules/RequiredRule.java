package application.wagonrepairmanager.validations.rules;

import application.wagonrepairmanager.validations.ValidationRule;

public class RequiredRule implements ValidationRule
{
    private String errorMessage;

    @Override
    public boolean validate(String value)
    {
        if (value == null || value.isEmpty()) {
            errorMessage = " field is required.";
            return false;
        }

        return true;
    }

    @Override
    public String getErrorMessage(String fieldName) { return fieldName + errorMessage; }
}

