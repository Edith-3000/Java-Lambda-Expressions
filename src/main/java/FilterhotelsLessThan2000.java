public class FilterhotelsLessThan2000 implements FilteringCondition {
    @Override
    public boolean test(Hotel hotel) {
        return hotel.getPricePerNight() <= 2000;
    }
}
