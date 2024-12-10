package code.violationofencapsulation;

public class Data {
    private int[] values;

    public int[] getValues() {
        return values.clone(); // Return a copy to prevent modification
    }

    public void setValues(int[] values) {
        this.values = values.clone(); // Store a copy to ensure encapsulation
    }
}