package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe responsavel por representar uma pessoa eleitora.
 */
public class PessoaEleitora extends Pessoa {

  private String cpf;

  PessoaEleitora(String nome, String cpf) {
    this.cpf = cpf;
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  @Override
  public String getNome() {
    return this.nome;
  }

  @Override
  public void setNome(String nome) {
    this.nome = nome;
  }
}
