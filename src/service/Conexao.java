package service; // ou bibliotecaPI, depende do pacote que você está usando

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "biblioteca"; // novo usuário que você criou
    private static final String PASSWORD = "1234";   // senha definida

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
