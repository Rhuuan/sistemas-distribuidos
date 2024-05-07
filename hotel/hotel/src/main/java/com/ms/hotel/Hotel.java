package com.ms.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private Long id;
    private String nome;
    private String localizacao;
    private List<Long> quartosIds; // Lista de IDs de quartos disponíveis neste hotel

    public Hotel(Long id, String nome, String localizacao) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.quartosIds = new ArrayList<>();
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<Long> getQuartosIds() {
        return quartosIds;
    }

    public void setQuartosIds(List<Long> quartosIds) {
        this.quartosIds = quartosIds;
    }

    public void addQuarto(Long quartoId) {
        this.quartosIds.add(quartoId);
    }
}
