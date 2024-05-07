package com.ms.hotel;

public class Quarto {
    private Long id;
    private String tipo;
    private int capacidade;
    private boolean disponivel;

    public Quarto(Long id, String tipo, int capacidade, boolean disponivel) {
        this.id = id;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.disponivel = disponivel;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}