package com.trybe.acc.java.sistemadevotacao;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GerenciamentoVotacao {

  private final ArrayList<PessoaCandidata> pessoasCandidatas;
  private final ArrayList<PessoaEleitora> pessoasEleitoras;
  private final ArrayList<String> cpfComputado;
  private int totalVotos;

  GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfComputado = new ArrayList<>();
  }

  public void cadastrarPessoaCandidata(String nome, int numero) {
    PessoaCandidata pc = new PessoaCandidata(nome, numero);
    this.pessoasCandidatas.add(pc);
  }

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    PessoaEleitora pl = new PessoaEleitora(nome, cpf);
    this.pessoasEleitoras.add(pl);
  }

  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (this.cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    }

    for (PessoaCandidata pc : getPessoasCandidatas()) {
      if (pc.getNumero() == numeroPessoaCandidata) {
        pc.receberVoto();
        this.setTotalVotos();
        break;
      }
    }

    this.cpfComputado.add(cpfPessoaEleitora);
  }

  public void mostrarResultado() {
    if (getCpfComputado().isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }

    for (int i = 0; i < getPessoasCandidatas().size(); i++) {
      PessoaCandidata pc = getPessoasCandidatas().get(i);

      String report = String.format(
          "Nome: %s - %d votos ( %s%% )",
          pc.getNome(),
          pc.getVotos(),
          calcularPorcentagemVotos(i)
      );

      System.out.println(report);
    }
    System.out.println("Total de votos: " + getTotalVotos());
  }

  private double calcularPorcentagemVotos(int index) {
    PessoaCandidata pc = getPessoasCandidatas().get(index);
    double pcVotos = pc.getVotos();
    return Math.round(pcVotos / getTotalVotos());
  }

  public ArrayList<PessoaCandidata> getPessoasCandidatas() {
    return pessoasCandidatas;
  }

  public ArrayList<PessoaEleitora> getPessoasEleitoras() {
    return pessoasEleitoras;
  }

  public ArrayList<String> getCpfComputado() {
    return cpfComputado;
  }

  public int getTotalVotos() {
    return totalVotos;
  }

  public void setTotalVotos() {
    this.totalVotos++;
  }
}
