package lesson2;

import lesson2.model.LengthValue;

public class LengthUnitComparator {
    public static boolean equals(LengthValue lengthValue1, LengthValue lengthValue2) {
        return lengthValue1.getValue().equals(lengthValue2.getValue());
    }
}
