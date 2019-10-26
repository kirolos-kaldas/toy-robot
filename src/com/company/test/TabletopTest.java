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
        assertNotNull(table.getTableOccupancyGrid());
    }

    @Test
    public void testTabletopGrid() {
        Tabletop table = new Tabletop(5, 5);
        // Check if number of rows is correct
        assertTrue(table.getTableOccupancyGrid().length == 5);
        // Check if number of columns per row is correct
        for (int i = 0; i < 5; i++) {
            assertTrue(table.getTableOccupancyGrid()[i].length == 5);
        }
    }

    @Test
    public void testChangeOccupancy() {
        Tabletop table = new Tabletop(5, 5);
        assertFalse(table.getTableOccupancyGrid()[0][1]);

        table.changeOccupancy(0,1, true);
        assertTrue(table.getTableOccupancyGrid()[0][1]);
    }
}
