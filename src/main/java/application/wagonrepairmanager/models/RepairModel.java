package application.wagonrepairmanager.models;

import java.util.Map;

public class RepairModel extends Model
{
    public static void saveRepair(Map<String, Object> formData)
    {
        prepareStatement(
        "INSERT INTO repairs " +
            "(wagon_id, problem_detected, repaired_by, repair_date, repair_status, created_at) " +
            "VALUES (?, ?, ?, ?, ?, ?)",
            formData
        );
    }
}
