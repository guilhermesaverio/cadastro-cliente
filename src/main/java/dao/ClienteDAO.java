package dao;

import factory.ConnectionFactory;
import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {


    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email, idade) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.criarConexao();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEmail());
            pstm.setInt(3, cliente.getIdade());
            pstm.execute();
            System.out.println("Salvo.");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public List<Cliente> listarTodos() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection conn = ConnectionFactory.criarConexao();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setIdade(rs.getInt("idade"));
                clientes.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, idade = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.criarConexao();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEmail());
            pstm.setInt(3, cliente.getIdade());
            pstm.setInt(4, cliente.getId());
            pstm.execute();
            System.out.println("Atualizado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarPorId(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection conn = ConnectionFactory.criarConexao();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Removido.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}