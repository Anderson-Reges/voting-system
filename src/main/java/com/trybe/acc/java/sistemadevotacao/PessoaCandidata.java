package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe responsavel por representar uma pessoa candidata.
 */
public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  @Override
  public String getNome() {
    return nome;
  }

  @Override
  public void setNome(String nome) {
    this.nome = nome;
  }

  public void receberVoto() {
    this.votos++;
  }

}
