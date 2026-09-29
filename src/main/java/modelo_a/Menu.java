package modelo_a;

import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    public void menu() {
        int opcao;

        do {
            System.out.println("|======== Menu =========|");
            System.out.println("|  1. Cadastrar acervo  |");
            System.out.println("|  2. Listar            |");
            System.out.println("|  0. Sair              |");
            System.out.println("|=======================|");
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
        InstrumentoDAO dao = new InstrumentoDAO();
        List<Instrumento> lista = dao.listar();
        if(lista.size() == 0) {
            System.out.println("Não há instrumentos cadastrados");
        }
        else {
            System.out.println("==================== ACERVO DE INSTRUMENTOS ====================");
            lista.forEach(System.out::println);
        }
    }

    private void cadastrar() {
        int id;
        String nome, tipo, estado;
        InstrumentoDAO dao = new InstrumentoDAO();
        Instrumento instrumento;

        // verifica se o ID já está cadastrado
        System.out.print("ID --> ");
        id = sc.nextInt();
        sc.nextLine();
        if(!dao.pesquisar(id)) {
            System.out.print("Nome do instrumento --> ");
            nome = sc.nextLine();
            System.out.print("Tipo de instrumento --> ");
            tipo = sc.next();
            System.out.print("Estado de conservação --> ");
            estado = sc.next();
            instrumento = new Instrumento(id, nome, tipo, estado);
            if(dao.inserir(instrumento)) {
                System.out.println("Instrumento cadastrado com sucesso!");
            }
            }
        else {
                System.out.println("Já existe um instrumento cadastrado com o patrimônio " + id);
                System.out.println("Registro não inserido");
        }
    }
}



