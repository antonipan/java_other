package lesson4.hotel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {

    @Test
    void testHotelBooking () {
        HotelService hsMock = mock(HotelService.class);

        when(hsMock.isRoomAvailable(anyInt())).thenReturn(true);

        BookingService bookingService = new BookingService(hsMock);
        assertTrue(bookingService.bookRoom(404));
    }
}