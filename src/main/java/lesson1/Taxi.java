package lesson1;

public class Taxi {

    private static final Float BASE_FEE = 6F;
    private static final Float DELIVER_FEE_PER_KM = 0.8F;
    private static final Float BASE_DISTANCE = 2F;

    public Float calculateFee(Float distance) {
        Float deliver_fee = 0F;
        if (distance > BASE_DISTANCE) {
            deliver_fee = (distance - BASE_DISTANCE) * DELIVER_FEE_PER_KM;
        }
        return BASE_FEE + deliver_fee;
    }
}
