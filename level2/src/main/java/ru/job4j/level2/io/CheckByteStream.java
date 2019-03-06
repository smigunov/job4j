package ru.job4j.level2.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CheckByteStream {
    public boolean isNumber(InputStream in) {
        boolean result = false;
        if (in instanceof ByteArrayInputStream) {
            try (ByteArrayInputStream bs = (ByteArrayInputStream)in) {
                int b = bs.read();
                while(b != -1){
                    if (b % 2 == 0) {
                        result = true;
                        break;
                    }
                    b = bs.read();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
