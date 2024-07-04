package lesson4.hotel;

public class BookingService {
    private HotelService hotelService;

    public BookingService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public boolean bookRoom(int roomId) {
        // Код, который бронирует номер.
        // Логика бронирования комнаты
        // В реальном приложении здесь бы было больше кода
        // Номер не доступен
        return hotelService.isRoomAvailable(roomId); // Номер забронирован
    }

}
