package view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class ViewTest {

    ViewGeneral viewGeneral = mock(ViewGeneral.class);

    @Test
    void viewMainTest () {
        viewGeneral.viewMain();
        verify(viewGeneral, times(1)).viewMain();
    }
    @Test
    void exitMenuTest () {
        try {
            Method method = ViewGeneral.class.getDeclaredMethod("exitMenu", int.class);
            method.setAccessible(true);
            method.invoke(viewGeneral, 2);
        } catch (NoSuchMethodException
                 | InvocationTargetException
                 | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void dialogContinue () {
        try {
            Method dialogContinue = ViewGeneral.class.getDeclaredMethod("dialogContinue");
            dialogContinue.setAccessible(true);
            String consoleOutPut;
            PrintStream originOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);
            dialogContinue.invoke(viewGeneral);
            capture.flush();
            consoleOutPut = outputStream.toString();
            System.setOut(originOut);
            assertEquals("Чтобы выйти из меню, нажмите 2:\n"
                    + "Или 1, чтобы продолжить. \r\n", consoleOutPut);
        } catch (NoSuchMethodException
                 | InvocationTargetException
                 | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void inputEnterTest () throws NumberFormatException {
        boolean exeptionThrow = false;
        try {
            Method inputEnter = ViewGeneral.class.getDeclaredMethod("inputMenu", int.class, int.class, int.class);
            inputEnter.setAccessible(true);
            int itemMenu = Integer.parseInt("afsdf");
            inputEnter.invoke(viewGeneral, 0, 2, itemMenu);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            exeptionThrow = true;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        assertTrue(exeptionThrow);
    }

    @Test
    void inputMenuTest () {
        try {
            Method inputEnter = ViewGeneral.class.getDeclaredMethod("inputMenu", int.class, int.class, int.class);
            inputEnter.setAccessible(true);
            assertEquals(1, inputEnter.invoke(viewGeneral, 0, 2, 1));
            int itemMenu = Integer.parseInt("1");
            assertEquals(1, inputEnter.invoke(viewGeneral, 0, 2, itemMenu));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}