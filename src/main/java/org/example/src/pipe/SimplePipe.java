package org.example.src.pipe;

import java.util.ArrayList;
import java.util.List;

public class SimplePipe {
    private List<String> buffer;
    
    public SimplePipe() {
        buffer = new ArrayList<>();
    }
    
    public synchronized void putData(String data) {
        buffer.add(data);
        notify();
    }
    
    public synchronized String getData() {
        while (buffer.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return buffer.remove(0);
    }
} 