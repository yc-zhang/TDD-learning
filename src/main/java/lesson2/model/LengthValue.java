package lesson2.model;

import static lesson2.model.LengthUnit.*;

public class LengthValue {
    private final LengthUnit lengthUnit;
    private final double value;

    public LengthValue(double value) {
        this.value = value;
        this.lengthUnit = MM;
    }

    public LengthValue(LengthUnit lengthUnit, double displayValue) {
        this.lengthUnit = lengthUnit;
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

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return toString(this.lengthUnit);
    }

    public String toString(LengthUnit unit) {
        switch (unit) {
            case MM:
                return this.value + unit.toString();
            case CM:
                return this.value / 10 + unit.toString();
            case M:
                return this.value / 1000 + unit.toString();
            default:
                return this.value + unit.toString();
        }
    }
}
