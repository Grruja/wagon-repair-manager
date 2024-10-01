package application.wagonrepairmanager.models;

import application.wagonrepairmanager.Database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

abstract public class Model
{
    protected abstract String getTableName();
    protected abstract String[] getFillable();

    public void create(Map<String, Object> data)
    {
        String tableName = getTableName();
        int numberOfColumns = data.size();

        StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");

        for (String columnName : data.keySet()) {
            sql.append(columnName).append(", ");
        }
        sql.append("created_at) VALUES (");

        for (int i = 1; i <= numberOfColumns; i++) {
            sql.append("?, ");
        }
        sql.append("?)");

        prepareStatement(sql.toString(), data);
    }

    private void prepareStatement(String sql, Map<String, Object> data)
    {
        try {
            PreparedStatement stmt = Database.connect().prepareStatement(sql);

            int currentColumn = 1;

            for (Object value : data.values()) {
                stmt.setObject(currentColumn, value);
                currentColumn++;
            }

            stmt.setDate(currentColumn, Date.valueOf(LocalDate.now()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database.disconnect();
        }
    }
}
