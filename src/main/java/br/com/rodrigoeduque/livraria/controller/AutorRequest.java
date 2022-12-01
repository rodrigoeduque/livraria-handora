package br.com.rodrigoeduque.livraria.controller;

import br.com.rodrigoeduque.livraria.model.Autor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorRequest {

    @NotBlank
    @Length(max = 120)
    private String nome;

    @NotBlank
    @Email
    @Length(max = 120)
    private String email;


    @NotBlank
    @Length(max = 2500)
    private String descrição;

    @NotBlank
    @CPF
    private String cpf;

    public AutorRequest(String nome, String email, String descrição, String cpf) {
        this.nome = nome;
        this.email = email;
        this.descrição = descrição;
        this.cpf = cpf;
    }

    @Deprecated
    public AutorRequest() {
    }

    public Autor toAutor() {
        return new Autor(nome, email, descrição, cpf);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescrição() {
        return descrição;
    }

    public String getCpf() {
        return cpf;
    }
}
