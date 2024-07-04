package fileRedactor;

import fileRedactor.Model.CreaterFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private CreaterFile createrFile = new CreaterFile();
    private Map <Integer, String> formats = new HashMap<>();

    //1 - txt\n" + "2 - json\n" + "3 - doc\n" + "4 - pdf\n" + "5 - csv"
    public Controller () {
        formats.put(1, "txt");
        formats.put(2, "json");
        formats.put(3, "doc");
        formats.put(4, "pdf");
        formats.put(5, "csv");
    }

    public String getFormat (int format) {
        return formats.get(format);
    }

    public void FormatCreate (String name, int format) throws IOException {
       createrFile.formatCreater(name, getFormat(format));
    }







}
