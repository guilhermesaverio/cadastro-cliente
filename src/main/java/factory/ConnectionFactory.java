package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String url = "jdbc:mysql://localhost:3306/cadastroCliente";
    private static final String usuario = "root";
    private static final String senha = "123456";

    public static Connection criarConexao() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url, usuario, senha);
    }
}