package view;

import model.Mail;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderBD {
    public List<Mail> read() {
        List<Mail> emails = new ArrayList<>();
        String url = "jdbc:sqlite:Kata5.db";
        String sql = "SELECT * FROM EMAIL";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                emails.add(new Mail(rs.getString("Mail") + "\t"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return emails;
    }
}