package application.wagonrepairmanager.validations;

import application.wagonrepairmanager.models.RepairModel;
import application.wagonrepairmanager.validations.rules.*;
import javafx.scene.control.Label;
import java.util.Arrays;
import java.util.Map;

public class RepairValidations
{
    private final Label WAGON_ID_ERROR;
    private final Label PROBLEM_DETECTED_ERROR;
    private final Label USER_ID_ERROR;
    private final Label REPAIR_DATE_ERROR;
    private final Label REPAIR_STATUS_ERROR;

    public RepairValidations(Label wagonIdError, Label problemDetectedError, Label userIdError, Label repairDateError, Label repairStatusError)
    {
        this.WAGON_ID_ERROR = wagonIdError;
        this.PROBLEM_DETECTED_ERROR = problemDetectedError;
        this.USER_ID_ERROR = userIdError;
        this.REPAIR_DATE_ERROR = repairDateError;
        this.REPAIR_STATUS_ERROR = repairStatusError;
    }

    public boolean validateForm(Map<String, Object> formData)
    {
        if ( !wagonIdValidation(formData.get("wagon_id")) ) return false;
        if ( !problemDetectedValidation(formData.get("problem_detected")) ) return false;
        if ( !userIdValidation(formData.get("repaired_by_user_id")) ) return false;
        if ( !repairDateValidation(formData.get("repair_date")) ) return false;
        if ( !repairStatusValidation(formData.get("repair_status")) ) return false;

        return true;
    }

    private boolean wagonIdValidation(Object wagonIdObject)
    {
        ValidationContext context = new ValidationContext(
                Arrays.asList(
                        new RequiredRule(),
                        new IntegerRule(),
                        new LengthRule(4)
                ),
                "Wagon ID"
        );
        return context.validate(wagonIdObject.toString(), WAGON_ID_ERROR);
    }

    private boolean problemDetectedValidation(Object problemDetectedObject)
    {
        ValidationContext context = new ValidationContext(
                Arrays.asList(
                        new RequiredRule(),
                        new MaxLengthRule(255)
                ),
                "Problem detected"
        );
        return context.validate(problemDetectedObject.toString(), PROBLEM_DETECTED_ERROR);
    }

    private boolean userIdValidation(Object userIdObject)
    {
        ValidationContext context = new ValidationContext(
                Arrays.asList(
                        new RequiredRule(),
                        new IntegerRule(),
                        new LengthRule(4)
                ),
                "User ID"
        );
        return context.validate(userIdObject.toString(), USER_ID_ERROR);
    }

    private boolean repairDateValidation(Object repairDateObject)
    {
        if (repairDateObject == null) repairDateObject = "";

        ValidationContext context = new ValidationContext(
                Arrays.asList(
                        new RequiredRule(),
                        new DateRule()
                ),
                "Repair date"
        );
        return context.validate(repairDateObject.toString(), REPAIR_DATE_ERROR);
    }

    private boolean repairStatusValidation(Object repairStatusObject)
    {
        if (repairStatusObject == null) repairStatusObject = "";

        ValidationContext context = new ValidationContext(
                Arrays.asList(
                        new RequiredRule(),
                        new MatchesOptionRule(RepairModel.REPAIR_STATUS_OPTIONS)
                ),
                "Repair status"
        );
        return context.validate(repairStatusObject.toString(), REPAIR_STATUS_ERROR);
    }
}
