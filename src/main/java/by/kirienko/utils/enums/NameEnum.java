package by.kirienko.utils.enums;

public enum NameEnum {
    ROMA("Roma"),
    VANYA("Vanya"),
    MAKS("Maks"),
    NIKITA("Nikita"),
    GLEB("Gleb"),
    EGOR("Egor"),
    DANIK("Danik"),
    DIMA("Dima");

    public final String name;

    NameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
