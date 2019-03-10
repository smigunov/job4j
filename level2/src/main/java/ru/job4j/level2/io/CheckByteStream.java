package ru.job4j.level2.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CheckByteStream {
    public boolean isNumber(InputStream in) {
        boolean result = false;
        try (InputStreamReader r = new InputStreamReader(in)) {
            int b = r.read();
            while (b != -1){
                if (b >= 48 && b <= 57) {
                    int val = Integer.parseInt(String.valueOf(b));
                    if (val % 2 == 0) {
                        result = true;
                    } else {
                        result = false;
                    }
                } else {
                    result = false;
                    break;
                }
                b = r.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        int wordStart = 0;
        String word;
        HashMap<String, String> abuseMap = new HashMap<String, String>();
        for (String s : abuse) {
            abuseMap.put(s, s);
        }
        try (BufferedReader br  = new BufferedReader(new InputStreamReader(in));
            OutputStreamWriter writer = new OutputStreamWriter(out)) {
            word = br.readLine();
            while (word != null) {
                if(!abuseMap.containsKey(word)) {
                    writer.write(word);
                    writer.write("\n");
                }
                word = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
