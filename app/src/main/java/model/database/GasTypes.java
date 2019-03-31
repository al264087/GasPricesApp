package model.database;

public enum GasTypes {
    /*
    GPR (1, "Gasolina de protección"),
    G98 (3, "Gasolina 98"),
    G0A (4, "Gasóleo A habitual"),
    ANGO (5, "Gasoleo A habitual"),
    BGOB (6, "Nuevo Gasóleo"),
    CGOC (7," Gasóleo" ),
    BIO (8, "Gasóleo"),
    */

    G98 (3, "Gasolina 98"),
    GOA (4,"Gasóleo A habitual"),
    NGO (5,"Nuevo gasóleo A"),
    G95 (15, "Gasolina 95"),
    GLP (17, "Gases licuados del petróleo");

    public final int code;
    public final String name;

    GasTypes(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

}
