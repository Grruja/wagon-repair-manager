package application.wagonrepairmanager.validations.rules;

import application.wagonrepairmanager.validations.ValidationRule;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateRule implements ValidationRule
{
    private String errorMessage;

    @Override
    public boolean validate(String value)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate.parse(value, formatter);
            return true;

        } catch (DateTimeParseException e) {
            errorMessage = " field must be a date.";
            return false;
        }
    }

    @Override
    public String getErrorMessage(String fieldName) { return fieldName + errorMessage; }
}
