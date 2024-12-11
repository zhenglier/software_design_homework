package org.example.src.kwic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KWICProcessor {
    private List<String> lines;
    private List<String> shiftedLines;

    public KWICProcessor() {
        this.lines = new ArrayList<>();
        this.shiftedLines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public void process() {
        // 对每一行进行循环移位
        for (String line : lines) {
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                StringBuilder shifted = new StringBuilder();
                // 从i开始重新组合单词
                for (int j = i; j < words.length + i; j++) {
                    shifted.append(words[j % words.length]).append(" ");
                }
                shiftedLines.add(shifted.toString().trim());
            }
        }
        // 按字母顺序排序
        Collections.sort(shiftedLines);
    }

    public List<String> getShiftedLines() {
        return shiftedLines;
    }
} 