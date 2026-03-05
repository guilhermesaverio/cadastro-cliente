package test;

import dao.ClienteDAO;
import model.Cliente;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ClienteDAO dao = new ClienteDAO();
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n--- SISTEMA DE CADASTRO DE CLIENTES ---");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Deletar");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");

            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    Cliente novo = new Cliente();
                    System.out.print("Nome: ");
                    novo.setNome(leitor.nextLine());
                    System.out.print("Email: ");
                    novo.setEmail(leitor.nextLine());
                    System.out.print("Idade: ");
                    novo.setIdade(leitor.nextInt());
                    dao.salvar(novo);
                    break;

                case 2:
                    List<Cliente> lista = dao.listarTodos();
                    System.out.println("\n--- LISTAGEM ---");
                    for (Cliente c : lista) {
                        System.out.println(c.getId() + " | " + c.getNome() + " | " + c.getEmail() + " | "+ c.getIdade());
                    }
                    break;

                case 3:
                    System.out.print("ID do cliente a editar: ");
                    int idEdit = leitor.nextInt();
                    leitor.nextLine();

                    Cliente edit = new Cliente();
                    edit.setId(idEdit);
                    System.out.print("Novo Nome: ");
                    edit.setNome(leitor.nextLine());
                    System.out.print("Novo Email: ");
                    edit.setEmail(leitor.nextLine());
                    System.out.print("Nova Idade: ");
                    edit.setIdade(leitor.nextInt());

                    dao.atualizar(edit);
                    break;

                case 4:
                    System.out.print("ID para deletar: ");
                    int idDel = leitor.nextInt();
                    dao.deletarPorId(idDel);
                    break;

                case 5:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        leitor.close();
    }
}