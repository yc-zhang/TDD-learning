package lesson2.model;

public class LengthValue extends FormularEntity {
    private final LengthUnit lengthUnit;
    private final Double displayValue;
    private final Double value;

    public LengthValue(LengthUnit lengthUnit, Double displayValue) {
        this.lengthUnit = lengthUnit;
        this.displayValue = displayValue;
        switch (lengthUnit) {
            case MM:
                this.value = displayValue;
                break;
            case CM:
                this.value = displayValue * 10;
                break;
            case M:
                this.value = displayValue * 1000;
                break;
            default:
                this.value = displayValue;
        }
    }

    public LengthUnit getLengthUnit() {
        return lengthUnit;
    }

    public Double getDisplayValue() {
        return displayValue;
    }

    public Double getValue() {
        return value;
    }
}
