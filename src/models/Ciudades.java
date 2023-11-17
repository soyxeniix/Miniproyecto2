package models;
public enum Ciudades {
    ALCALA, 
    ANDALUCIA, 
    ANSERMANUEVO, 
    ARGELIA, 
    BOLIVAR, 
    BUENAVENTURA, 
    BUGA, 
    BUGALAGRANDE, 
    CAICEDONIA, 
    CALI, 
    CALIMA_DARIEN, 
    CANDELARIA, 
    CARTAGO, 
    DAGUA, 
    EL_AGUILA, 
    EL_CAIRO, 
    EL_CERRITO, 
    EL_DOVIO, 
    FLORIDA, 
    GINEBRA, 
    GUACARI, 
    JAMUNDI, 
    LA_CUMBRE, 
    LA_UNION, 
    LA_VICTORIA, 
    OBANDO, 
    PALMIRA, 
    PRADERA, 
    RESTREPO, 
    ROLDANILLO, 
    RIOFRIO, 
    SAN_PEDRO, 
    SEVILLA, 
    TORO, 
    TRUJILLO, 
    TULUA, 
    ULLOA, 
    VERSALLES, 
    VIJES, 
    YOTOCO, 
    YUMBO, 
    ZARZAL;

    @Override
    public String toString() {
   
    return super.toString().replaceAll("_", " " );
    }
}
