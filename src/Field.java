public class Field {

    private String definition;
    private int value;
    private int resetValue;
    private int width;

    public Field(String definition, int resetValue, int startBit, int width) {
        this.definition = definition;
        this.value = startBit;
        this.resetValue = resetValue;
        this.width = width;
    }

    public String getDefinition() {
        return definition;
    }

    public int getValue() {
        return value;
    }

    public int getResetValue() {
        return resetValue;
    }

    public int getWidth() {
        return width;
    }

    public void reset() {
        value = resetValue;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
