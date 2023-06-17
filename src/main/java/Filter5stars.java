public class Filter5stars implements FilteringCondition {
    @Override
    public boolean test(Hotel hotel) {
        return hotel.getHotelType() == HotelType.FIVE_STAR;
    }
}
