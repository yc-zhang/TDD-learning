package lesson2;

import lesson2.model.LengthValue;

public class LengthCalculator {
    public static LengthValue lengthAdd(LengthValue value1, LengthValue value2) {
        return new LengthValue(value1.getValue() + value2.getValue());
    }

    public static LengthValue lengthSub(LengthValue value1, LengthValue value2) {
        return new LengthValue(value1.getValue() - value2.getValue());
    }

    public static LengthValue lengthMultiply(LengthValue value1, double value2) {
        return new LengthValue(value1.getValue() * value2);
    }

    public static LengthValue lengthDivide(LengthValue value1, double value2) {
        return new LengthValue(value1.getValue() / value2);
    }
}
