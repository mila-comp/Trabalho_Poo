package calendario;

public enum Calendar {
    JANEIRO(1),
    FEVEREIRO(2),
    MARCO(3),
    ABRIL(4),
    MAIO(5),
    JUNHO(6),
    JULHO(7),
    AGOSTO(8),
    SETEMBRO(9),
    OUTUBRO(10),
    NOVEMBRO(11),
    DEZEMBRO(12);

    private final int numero;

    Calendar(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }

    public static Calendar fromString(String mes) {
        for (Calendar a : Calendar.values()) {
            if (a.name().equalsIgnoreCase(mes)) {
                return a;
            }
        }
        throw new IllegalArgumentException("Mês inválido: " + mes);
    }
}
