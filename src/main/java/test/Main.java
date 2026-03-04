package test;

import dao.ClienteDAO;
import model.Cliente;

public class Main {
    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.setNome("Guilherme");
        c.setEmail("guilherme@gmail.com");
        c.setIdade(20);


        ClienteDAO dao = new ClienteDAO();
        dao.salvar(c);




    }
}