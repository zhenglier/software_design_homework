package org.example.src.filter.impl;

import org.example.src.pipe.SimplePipe;

public class ShiftFilter extends Thread {
    private SimplePipe input;
    private SimplePipe output;

    public ShiftFilter(SimplePipe input, SimplePipe output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        String line;
        while ((line = input.getData()) != null) {
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                StringBuilder shifted = new StringBuilder();
                for (int j = 0; j < words.length; j++) {
                    shifted.append(words[(i + j) % words.length]).append(" ");
                }
                output.putData(shifted.toString().trim());
            }
        }
        output.putData(null); // 结束标记
    }
} 