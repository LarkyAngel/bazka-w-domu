package skijumping;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        System.setProperty("java.awt.headless", "false");
        String database = args[0], username = args[1], password = args[2];
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost/" + database, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            //System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        StartFrame startFrame = new StartFrame();
        startFrame.startMainframe(connection);
    }
}
