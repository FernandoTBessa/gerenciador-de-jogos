package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;
    private String status;

    // Construtor vazio (obrigatório para o Spring)
    public Game() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    // --- Adicionados ---
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}