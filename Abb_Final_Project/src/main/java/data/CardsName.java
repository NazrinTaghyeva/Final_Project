package data;

public enum CardsName {
    CARD1("TamKart MasterCard Debet"),
    CARD2("TamKart VISA Classic Debet"),
    CARD3("TamGənc VISA Debet");
     private final String name;
    CardsName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
