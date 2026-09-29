package modelo_b;

import modelo_a.Instrumento;
import modelo_a.InstrumentoDAO;

import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    public void menu() {
        int opcao;

        do {
            System.out.println("|========= Menu =========|");
            System.out.println("|  1. Cadastrar estação  |");
            System.out.println("|  2. Listar             |");
            System.out.println("|  0. Sair               |");
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
        EstacaoDAO dao = new EstacaoDAO();
        List<Estacao> lista = dao.listar();
        if(lista.size() == 0) {
            System.out.println("Não há estações cadastradas");
        }
        else {
            System.out.println("==================== Rede de Estações de Recarga ====================");
            lista.forEach(System.out::println);
        }
    }

    private void cadastrar() {
        int id;
        String sigla, cidade;
        double potencia;
        EstacaoDAO dao = new EstacaoDAO();
        Estacao estacao;

        // verifica se o ID já está cadastrado
        System.out.print("ID --> ");
        id = sc.nextInt();
        sc.nextLine();
        if(!dao.pesquisar(id)) {
            System.out.print("Sigla da estação --> ");
            sigla = sc.nextLine();
            System.out.print("Cidade --> ");
            cidade = sc.nextLine();
            System.out.print("Potência (Kw) --> ");
            potencia = sc.nextDouble();
            estacao = new Estacao(id, sigla, cidade, potencia);
            if(dao.inserir(estacao)) {
                System.out.println("Estação cadastrada com sucesso!");
            }
            }
        else {
                System.out.println("Já existe uma estação cadastrada com ID " + id);
                System.out.println("Registro não inserido");
        }
    }
}



