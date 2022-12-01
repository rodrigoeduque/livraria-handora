package br.com.rodrigoeduque.livraria.model;

import javax.persistence.*;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 120)
    private String nome;
    @Column(nullable = false, length = 120)
    private String email;
    @Column(nullable = false, length = 2500)
    @Lob
    private String descrição;
    @Column(nullable = false)
    private String cpf;

    public Autor(String nome, String email, String descrição, String cpf) {
        this.nome = nome;
        this.email = email;
        this.descrição = descrição;
        this.cpf = cpf;
    }

    public Autor() {
    }

    public Long getId() {
        return id;
    }
}
