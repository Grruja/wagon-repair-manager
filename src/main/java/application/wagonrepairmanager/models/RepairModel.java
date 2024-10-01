package application.wagonrepairmanager.models;

public class RepairModel extends Model
{
    public static final String[] REPAIR_STATUS_OPTIONS = {"completed", "in progress"};

    @Override
    protected String getTableName() { return "repairs"; }

    @Override
    protected String[] getFillable() {
        return new String[]{
                "wagon_id",
                "problem_detected",
                "repaired_by",
                "repair_date",
                "repair_status",
        };
    }
}
