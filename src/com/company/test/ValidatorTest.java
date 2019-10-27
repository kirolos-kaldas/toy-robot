package com.company.test;

import com.company.utility.Validator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Rule
    public ExpectedException ee = ExpectedException.none();

    @Test
    public void testValidateBoundsValid() throws Exception {
        Validator.validateBounds(5, 5, 0, 1);
    }

    @Test
    public void testValidateBoundsInvalidRow() throws Exception {
        ee.expect(Exception.class);
        ee.expectMessage("Validator.INVALID_TABLETOP_LOCATION");
        Validator.validateBounds(5, 5, 6, 1);
    }

    @Test
    public void testValidateBoundsInvalidColumn() throws Exception {
        ee.expect(Exception.class);
        ee.expectMessage("Validator.INVALID_TABLETOP_LOCATION");
        Validator.validateBounds(5, 5, 0, 6);
    }
}