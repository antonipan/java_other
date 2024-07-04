package lesson4.weather;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherReporterTest {

    @Test
    void TestWeatherServiceCurrentTemperature() {
        WeatherService wsMock = mock(WeatherService.class);
        when(wsMock.getCurrentTemperature()).thenReturn(25);

        WeatherReporter wrMock = new WeatherReporter(wsMock);
        assertEquals("Текущая температура: 25 градусов.", wrMock.generateReport());
    }
}