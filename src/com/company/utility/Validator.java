package com.company.utility;

public class Validator {

    public static void validateBounds(int horizontalLimit, int verticalLimit, int x, int y) throws Exception {
        if (horizontalLimit <= x || verticalLimit <= y) {
            throw new Exception("Validator.INVALID_TABLETOP_LOCATION");
        }
    }
}
