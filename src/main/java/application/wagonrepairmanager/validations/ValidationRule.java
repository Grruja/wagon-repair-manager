package application.wagonrepairmanager.validations;

public interface ValidationRule
{
    public boolean validate(String value);
    public String getErrorMessage(String fieldName);
}
