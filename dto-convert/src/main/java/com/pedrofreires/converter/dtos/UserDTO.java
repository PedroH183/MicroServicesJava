package com.pedrofreires.converter.dtos;

import java.util.Date;


public class UserDTO {
    // User Data Transfer Object

    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String telefone;
    private Date dataCadastro;

    public String getCpf() {
        return cpf;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public String getEmail() {
        return email;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
