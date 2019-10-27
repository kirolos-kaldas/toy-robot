package com.company.utility;

public class Validator {

    public static void validateBounds(int horizontalLimit, int verticalLimit, int x, int y) throws Exception {
        if (horizontalLimit <= x || verticalLimit <= y || x < 0 || y < 0) {
            throw new Exception("Validator.INVALID_TABLETOP_LOCATION");
        }
    }
}
