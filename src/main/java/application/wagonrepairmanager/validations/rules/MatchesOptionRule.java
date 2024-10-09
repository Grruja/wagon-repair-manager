package application.wagonrepairmanager.validations.rules;

import application.wagonrepairmanager.validations.ValidationRule;

public class MatchesOptionRule implements ValidationRule
{
    private final String[] OPTIONS;
    private String errorMessage;

    public MatchesOptionRule(String[] options) { this.OPTIONS = options; }

    @Override
    public boolean validate(String value)
    {
        for (String option : OPTIONS) {
            if (option.equals(value)) return true;
        }

        errorMessage = " field must match one of the valid options.";
        return false;
    }

    @Override
    public String getErrorMessage(String fieldName) { return fieldName + errorMessage; }
}
