package application.wagonrepairmanager.models;

import application.wagonrepairmanager.Database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

abstract public class Model
{
    public static void prepareStatement(String sql, Map<String, Object> data)
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
