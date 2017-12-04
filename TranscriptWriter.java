
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Алена on 02.05.2017.
 */
public class TranscriptWriter extends FileWriter {

    private HashMap<String, String> MyHashMap;

    public TranscriptWriter(String fileName) throws IOException {
        super(fileName);
        MyHashMap = new HashMap<String, String>();
    }

    public void add(String source, String data) {
        MyHashMap.put(source, data);
    }

    @Override
    public void write(String s) throws IOException {
        String c = "";
        for(int i = 0; i < s.length(); i++) {
            if((c = MyHashMap.get(String.valueOf(s.charAt(i)))) != null)
                super.write(c);
            else
                super.write(s.charAt(i));
            super.flush();
        }
    }
}
