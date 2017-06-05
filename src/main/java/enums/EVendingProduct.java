package enums;

public enum EVendingProduct {
    COLA("Cola"),
    CHIPS("Chips"),
    CANDY("Candy");

    private final String name;

    EVendingProduct(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
