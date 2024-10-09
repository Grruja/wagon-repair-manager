package application.wagonrepairmanager.validations.rules;

import application.wagonrepairmanager.validations.ValidationRule;

public class MaxLengthRule implements ValidationRule
{
    private final int MAX_CHARACTERS;
    private String errorMessage;

    public MaxLengthRule(int maxCharacters) { this.MAX_CHARACTERS = maxCharacters; }

    @Override
    public boolean validate(String value)
    {
        if (value.length() > MAX_CHARACTERS) {
            errorMessage = " field can't have more then " + MAX_CHARACTERS + " characters.";
            return false;
        }

        return true;
    }

    @Override
    public String getErrorMessage(String fieldName) { return fieldName + errorMessage; }
}
