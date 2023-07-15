import java.util.Date;
import java.text.SimpleDateFormat;

public class Cell {
    private Object value;
    private Color color = Color.WHITE;
    private Type type = Type.NOT_SET;


    void setValue(Object obj){

        if(obj instanceof Integer) {
            value = obj;
            type = Type.INTEGER;
            return;
        }
        else {
            if(obj instanceof Double) {
                value = obj;
                type = Type.DOUBLE;
            }
            else {
                try {
                    value = new SimpleDateFormat("dd.MM.yyyy").parse(obj.toString());
                    type = Type.DATE;
                }
                catch(Exception e){
                    return;
                }
            }
            return;
        }
    }
    Object getValue() {
        try {
            return value;
        }
        catch(NullPointerException npe) {
            return "-";
        }
    }
    Type getType() {
        return type;
    }
    void setColor(Color col) {
        color = col;
    }
    Color getColor() {
        return color;
    }
    void reset() {
        value = null;
        color = Color.WHITE;
        type = Type.NOT_SET;
    }

}

enum Color {
    RED,
    GREEN,
    YELLOW,
    WHITE
}

enum Type {
    INTEGER,
    DOUBLE,
    DATE,
    NOT_SET
}