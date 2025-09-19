import java.util.*;

class Spreadsheet {
    private final int rows;
    private final int[][] grid;

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.grid = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int c = cell.charAt(0) - 'A';
        int r = Integer.parseInt(cell.substring(1)) - 1;
        grid[r][c] = value;
    }

    public void resetCell(String cell) {
        int c = cell.charAt(0) - 'A';
        int r = Integer.parseInt(cell.substring(1)) - 1;
        grid[r][c] = 0;
    }

    public int getValue(String formula) {
        int plus = formula.indexOf('+');
        String a = formula.substring(1, plus);
        String b = formula.substring(plus + 1);
        return eval(a) + eval(b);
    }

    private int eval(String s) {
        char ch = s.charAt(0);
        if (ch >= '0' && ch <= '9') return Integer.parseInt(s);
        int c = ch - 'A';
        int r = Integer.parseInt(s.substring(1)) - 1;
        return grid[r][c];
    }
}