package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class ConnectionFactory {
    public static Connection getConnection() {
        try {
            Properties props = new Properties();
            InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            throw new RuntimeException("❌ Erro ao conectar com o banco", e);
        }
    }
}
