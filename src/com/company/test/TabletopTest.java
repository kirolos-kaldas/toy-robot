package com.company.test;

import com.company.model.Tabletop;
import static org.junit.Assert.*;
import org.junit.Test;

public class TabletopTest {

    @Test
    public void testInitTabletop() {
        Tabletop table = new Tabletop(5, 5);
        assertNotNull(table);
    }

    @Test
    public void testGetTableOccupancyGrid() {
        Tabletop table = new Tabletop(5, 5);
        assertNotNull(table.getGrid());
    }

    @Test
    public void testTabletopGrid() {
        Tabletop table = new Tabletop(5, 5);
        // Check if number of rows is correct
        assertTrue(table.getGrid().length == 5);
        // Check if number of columns per row is correct
        for (int i = 0; i < 5; i++) {
            assertTrue(table.getGrid()[i].length == 5);
        }
    }
}
