package lesson4.database;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DataProcessorTest {

    @Test
    void testDatabase() {
        Database database = mock(Database.class);
        List <String> faveData = new ArrayList<>();
        faveData.add("data1");
        faveData.add("data2");
        faveData.add("data3");

        when(database.query(anyString())).thenReturn(Arrays.asList("data1", "data2", "data3"));


    }
}