package lesson2;

import lesson2.model.LengthValue;

public class LengthUnitComparator {
    public static boolean lengthEquals(LengthValue lengthValue1, LengthValue lengthValue2) {
        return lengthValue1.getValue() == lengthValue2.getValue();
    }
}
