package dao;

import factory.ConnectionFactory;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO {
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email,idade) VALUES (?, ?, ?)";


        try (Connection conn = ConnectionFactory.criarConexao();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEmail());
            pstm.setInt(3, cliente.getIdade());

            pstm.execute();
            System.out.println("Dados salvos no banco!");

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
}
