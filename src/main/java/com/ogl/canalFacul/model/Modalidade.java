package com.ogl.canalFacul.model;

public enum Modalidade {
    AO_VIVO("Ao Vivo"),
    EAD("EAD"),
    FLEX("Flex"),
    PRESENCIAL("Presencial"),
    SEMI_PRESENCIAL("Semi-presencial");

    private final String modalidade;

    Modalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getModalidade() {
        return modalidade;
    }

    @Override
    public String toString() {
        return modalidade;
    }
}
