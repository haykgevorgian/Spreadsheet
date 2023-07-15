class Spreadsheet {
    private Cell[][] cells;
    private int rows;
    private int columns;


    Spreadsheet(int row, int column) {
        rows = row;
        columns = column;
        cells = new Cell[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                cells[i][j] = new Cell();
            }
        }

    }
    Cell getCell(int row, int colums) {
        return cells[row][colums];
    }
    void setCell(int row, int column, Cell cell) {
        cells[row][column] = cell;
    }
    void addRow(int addRowIndex) {
        Cell[][] newCells = new Cell[rows + 1][columns];
        for(int i = 0; i < addRowIndex; i++) {
            for(int j = 0; j < columns; j++) {
                newCells[i][j] = cells[i][j];
            }
        }
        for(int j = 0; j < columns; j++) {
            newCells[addRowIndex][j] = new Cell();
        }
        for(int i = addRowIndex + 1; i < rows + 1; i++) {
            for(int j = 0; j < columns; j++) {
                newCells[i][j] = cells[i - 1][j];
            }
            System.out.println();
        }

        rows++;
        cells = newCells;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++){
                System.out.print("[" + i + "][" + j + "]\t");
            }
            System.out.println();
        }
    }
    void addColumn(int addColumnIndex) {
        Cell[][] newCells = new Cell[rows][columns + 1];
        for(int j = 0; j < addColumnIndex; j++) {
            for(int i = 0; i < rows; i++) {
                newCells[i][j] = cells[i][j];
            }
        }
        for(int i = 0; i < rows; i++) {
            newCells[i][addColumnIndex] = new Cell();
        }
        for(int j = addColumnIndex + 1; j < columns + 1; j++) {
            for(int i = 0; i < rows; i++) {
                newCells[i][j] = cells[i][j - 1];
            }
            System.out.println();
        }

        columns++;
        cells = newCells;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++){
                System.out.print("[" + i + "][" + j + "]\t");
            }
            System.out.println();
        }
    }

    void setValueAt(int row, int column, Object obj) {
        getCell(row,column).setValue(obj);
    }

    Object getValueAt(int row, int column) {
        return getCell(row,column).getValue();
    }

    Type getTypeAt(int row, int column) {
        return getCell(row,column).getType();
    }

    void setColorAt(int row, int column, Color col) {
        getCell(row,column).setColor(col);
    }

    Color getColorAt(int row, int column) {
        return getCell(row, column).getColor();
    }

    void reset() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                getCell(i, j).reset();
            }
        }
    }

    void resetCellAt(int row, int column) {
        getCell(row, column).reset();
    }

    double getColumnSum(int column) {
        double sum = 0;
        for(int i = 0; i < rows; i++) {
            switch (getTypeAt(i, column)) {
                case INTEGER -> sum += ((Integer) getValueAt(i, column)).doubleValue();
                case DOUBLE -> sum += (double) getValueAt(i, column);
                case DATE, NOT_SET -> {
                    System.out.println("Not compatible types, there is no sum!");
                    return 0;
                }
            }
        }
        return sum;
    }

    double getRowSum(int row) {
        double sum = 0;
        for(int i = 0; i < columns; i++) {
            switch (getTypeAt(row, i)) {
                case INTEGER -> sum += ((Integer) getValueAt(row, i)).doubleValue();
                case DOUBLE -> sum += (double) getValueAt(row, i);
                case DATE, NOT_SET -> {
                    System.out.println("Not compatible types, there is no sum!");
                    return 0;
                }
            }
        }
        return sum;
    }

    double getAreaSum(int rowStart, int columnStart, int rowEnd, int columnEnd) {
        double sum = 0;
        for(int i = rowStart; i <= rowEnd; i++) {
            for (int j = columnStart; j <= columnEnd; j++) {
                switch (getTypeAt(i, j)) {
                    case INTEGER -> sum += ((Integer) getValueAt(i, j)).doubleValue();
                    case DOUBLE -> sum += (double) getValueAt(i, j);
                    case DATE, NOT_SET -> {
                        System.out.println("Not compatible types, there is no sum!");
                        return 0;
                    }
                }
            }
        }
        return sum;
    }

    double getColumnAvarage(int column) {
        return getColumnSum(column)/rows;
    }

    double getRowAvarage(int row) {
        return getRowSum(row)/columns;
    }

    double getAreaAvarage(int rowStart, int columnStart, int rowEnd, int columnEnd) {
        return getAreaSum(rowStart, columnStart, rowEnd, columnEnd)/((rowEnd-rowStart)*(columnEnd-columnStart));
    }
}