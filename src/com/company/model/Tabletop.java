package com.company.model;

public class Tabletop {

    private TableObject[][] grid;

    public Tabletop(int rows, int columns) {
        this.grid = new TableObject[rows][columns];
    }

    public TableObject[][] getGrid() {
        return this.grid;
    }
}
