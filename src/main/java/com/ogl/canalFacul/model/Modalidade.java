package com.ogl.canalFacul.model;

public enum Modalidade {
    AO_VIVO("ao vivo"),
    EAD("ead"),
    FLEX("flex"),
    PRESENCIAL("presencial"),
    SEMI_PRESENCIAL("semipresencial");

    private String modalidade;

    Modalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getModalidade() {
        return modalidade;
    }
}
