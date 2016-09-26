package lesson2.model;

public class ConstantValue extends FormularEntity {
    private final Double value;

    public ConstantValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}
