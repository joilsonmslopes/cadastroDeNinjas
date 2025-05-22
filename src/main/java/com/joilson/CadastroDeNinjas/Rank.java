package com.joilson.CadastroDeNinjas;

public enum Rank {
    S("Rank S", "Missão secreta de altíssimo risco, com ameaça internacional."),
    A("Rank A", "Operação perigosa, confronto com ninjas de elite."),
    B("Rank B", "Infiltração ou escolta sob risco moderado."),
    C("Rank C", "Proteção local ou captura de criminosos menores."),
    D("Rank D", "Tarefas simples, como resgatar animais ou ajudar civis.");

    private String name;
    private String description;
    private Rank(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
