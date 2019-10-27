package com.company.model;

public class Tabletop {

    private TableObject[][] grid;

    public Tabletop(int x, int y) {
        this.grid = new TableObject[x][y];
    }

    public TableObject[][] getGrid() {
        return this.grid;
    }
}
