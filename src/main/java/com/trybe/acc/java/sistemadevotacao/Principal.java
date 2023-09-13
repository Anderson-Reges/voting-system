package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe responsavel pelo sistema de votação.
 */
public class Principal {

  /**
   * Metodo responsavel por executar todo o sistema de votação.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    GerenciamentoVotacao gv = new GerenciamentoVotacao();

    short option;

    do {
      System.out.println("Cadastrar pessoa candidata?\n"
          + "1 - Sim\n"
          + "2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      option = scan.nextShort();

      if (option == 1) {
        menuCandidato(gv, scan);
      }

    } while (option != 2);

    do {
      System.out.println("Cadastrar pessoa eleitora?\n"
          + "1 - Sim\n"
          + "2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      option = scan.nextShort();

      if (option == 1) {
        menuEleitor(gv, scan);
      }

    } while (option != 2);

    do {
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Votar\n"
          + "2 - Resultado Parcial\n"
          + "3 - Finalizar Votação"
      );
      option = scan.nextShort();

      if (option == 1) {
        menuVotar(gv, scan);
      }

      if (option == 2) {
        resultado(gv);
      }

    } while (option != 3);

    resultado(gv);

    scan.close();
  }

  /**
   * Metodo responsavel por criar um menu de cadastro do candidato.
   */
  public static void menuCandidato(GerenciamentoVotacao gv, Scanner scan) {
    System.out.println("Entre com o nome da pessoa candidata:");
    String nome = scan.next();
    System.out.println("Entre com o número da pessoa candidata:");
    int num = scan.nextInt();
    gv.cadastrarPessoaCandidata(nome, num);
  }

  /**
   * Metodo responsavel por criar um menu de cadastro do eleitor.
   */
  public static void menuEleitor(GerenciamentoVotacao gv, Scanner scan) {
    System.out.println("Entre com o nome da pessoa eleitora:");
    String nome = scan.next();
    System.out.println("Entre com o cpf da pessoa eleitora:");
    String cpf = scan.next();
    gv.cadastrarPessoaEleitora(nome, cpf);
  }

  /**
   * Metodo responsavel por criar um menu de votação.
   */
  public static void menuVotar(GerenciamentoVotacao gv, Scanner scan) {
    System.out.println("Entre com o cpf da pessoa eleitora:");
    String cpf = scan.next();
    System.out.println("Entre com o número da pessoa candidata:");
    int num = scan.nextInt();
    gv.votar(cpf, num);
  }

  public static void resultado(GerenciamentoVotacao gv) {
    gv.mostrarResultado();
  }

}
