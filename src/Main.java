public class Main {
    public static void main(String[] args){
        Spreadsheet sp = new Spreadsheet( 5, 5);
        /*sp.addColumn(1);
        System.out.println(sp.getValueAt( 0, 2));
        System.out.println(sp.getTypeAt( 0, 2));
        sp.setColorAt(0, 2, Color.RED);
        System.out.println(sp.getColorAt(0, 2));
        sp.resetCellAt(0, 1);*/
        sp.setValueAt( 0, 0, 1.25);
        sp.setValueAt( 0, 1, 1);
        sp.setValueAt( 0, 2, 1);
        sp.setValueAt( 1, 0, 5.5);
        sp.setValueAt( 1, 1, 7);
        sp.setValueAt( 1, 2, 7.17);
        /*System.out.println(sp.getColorAt(0, 2));
        System.out.println(sp.getTypeAt(0, 2));
        System.out.println(sp.getColumnSum(2));
        System.out.println(sp.getRowSum(0));
        */
        System.out.println(sp.getAreaSum(0,0,1,2));
    }
}