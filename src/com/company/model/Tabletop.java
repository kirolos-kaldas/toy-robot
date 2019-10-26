package com.company.model;

public class Tabletop {

    private boolean[][] tableOccupancyGrid;

    public Tabletop(int row, int column) {
        tableOccupancyGrid = new boolean[row][column];
    }

    public boolean[][] getTableOccupancyGrid() {
        return tableOccupancyGrid;
    }

    public void changeOccupancy(int row, int column, boolean isOccupied) {
        this.tableOccupancyGrid[row][column] = isOccupied;
    }
}
