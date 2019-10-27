package com.company.utility;

public class Validator {

    public static void validateBounds(int rowLimit, int columnLimit, int rowTo, int columnTo) throws Exception {
        if (rowLimit <= rowTo || columnLimit <= columnTo) {
            throw new Exception("Validator.INVALID_TABLETOP_LOCATION");
        }
    }
}
