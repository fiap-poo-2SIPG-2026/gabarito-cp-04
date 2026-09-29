package modelo_c;

import modelo_b.Estacao;

import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    public void menu() {
        int opcao;

        do {
            System.out.println("|============== Menu =============|");
            System.out.println("|  1. Cadastrar ficha de estoque  |");
            System.out.println("|  2. Listar estoque              |");
            System.out.println("|  0. Sair                        |");
            System.out.println("|=================================|");
            System.out.print(">>> ");
            opcao = sc.nextInt();

            switch(opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
            }
            System.out.println();
        } while(opcao != 0);
        System.out.println();
    }

    private void listar() {
        ItemEstoqueDAO dao = new ItemEstoqueDAO();
        List<ItemEstoque> lista = dao.listar();
        if(lista.size() == 0) {
            System.out.println("Não há produtos cadastrados");
        }
        else {
            System.out.println("==================== Estoque Registrado ====================");
            lista.forEach(System.out::println);
        }
    }

    private void cadastrar() {
        int id;
        String nome, fornecedor;
        double quantidade;
        ItemEstoqueDAO dao = new ItemEstoqueDAO();
        ItemEstoque item;

        // verifica se o ID já está cadastrado
        System.out.print("ID --> ");
        id = sc.nextInt();
        sc.nextLine();
        if(!dao.pesquisar(id)) {
            System.out.print("Nome do produto --> ");
            nome = sc.nextLine();
            System.out.print("Fornecedor --> ");
            fornecedor = sc.nextLine();
            System.out.print("Quantidade (Kg) --> ");
            quantidade = sc.nextDouble();
            item = new ItemEstoque(id, nome, fornecedor, quantidade);
            if(dao.inserir(item)) {
                System.out.println("Ficha de estoque cadastrada com sucesso!");
            }
        }
        else {
                System.out.println("Já existe uma ficha cadastrada com ID " + id);
                System.out.println("Registro não inserido");
        }
    }
}



