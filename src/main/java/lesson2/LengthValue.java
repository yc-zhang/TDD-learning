package lesson2;

import static lesson2.LengthUnit.mm;

public class LengthValue {
    private final LengthUnit lengthUnit;
    private final double value;

    public LengthValue(double value) {
        this.value = value;
        this.lengthUnit = mm;
    }

    public LengthValue(LengthUnit lengthUnit, double displayValue) {
        this.lengthUnit = lengthUnit;
        switch (lengthUnit) {
            case mm:
                this.value = displayValue;
                break;
            case cm:
                this.value = displayValue * 10;
                break;
            case m:
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

    public LengthValue add(LengthValue newValue) {
        return new LengthValue(value + newValue.getValue());
    }

    public LengthValue sub(LengthValue newValue) {
        return new LengthValue(value - newValue.getValue());
    }

    public LengthValue multiply(double value2) {
        return new LengthValue(value * value2);
    }

    public LengthValue divide(double value2) {
        return new LengthValue(value / value2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LengthValue value1 = (LengthValue) o;

        return Double.compare(value1.value, value) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = lengthUnit != null ? lengthUnit.hashCode() : 0;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return toString(this.lengthUnit);
    }

    public String toString(LengthUnit unit) {
        switch (unit) {
            case mm:
                return this.value + unit.toString();
            case cm:
                return this.value / 10 + unit.toString();
            case m:
                return this.value / 1000 + unit.toString();
            default:
                return this.value + unit.toString();
        }
    }
}
