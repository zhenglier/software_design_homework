package org.example.src.kwic.output;

import org.example.src.pipe.SimplePipe;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KWICOutput extends Thread {
    private SimplePipe input;
    private SimplePipe output;
    private List<String> lines;

    public KWICOutput(SimplePipe input, SimplePipe output) {
        this.input = input;
        this.output = output;
        this.lines = new ArrayList<>();
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            String line;
            while ((line = input.getData()) != null) {
                lines.add(line);
            }
            Collections.sort(lines);
            for (String sortedLine : lines) {
                writer.println(sortedLine);
                System.out.println(sortedLine);  // 同时在控制台显示
                output.putData(sortedLine);
            }
            output.putData(null);  // 发送结束标记
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}