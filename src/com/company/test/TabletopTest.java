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
    public void testTabletopGridY() {
        Tabletop table = new Tabletop(5, 5);
        assertTrue(table.getGrid().length == 5);
    }

    @Test
    public void testTabletopGridX() {
        Tabletop table = new Tabletop(5, 5);
        for (int i = 0; i < 5; i++) {
            assertTrue(table.getGrid()[i].length == 5);
        }
    }
}
