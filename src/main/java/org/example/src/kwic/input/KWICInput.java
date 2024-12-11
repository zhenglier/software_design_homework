package org.example.src.kwic.input;

import org.example.src.factory.interfaces.DataSource;
import org.example.src.pipe.SimplePipe;

public class KWICInput extends Thread {
    private SimplePipe output;
    private DataSource dataSource;

    public KWICInput(SimplePipe output) {
        this.output = output;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run() {
        String line;
        while ((line = dataSource.readLine()) != null) {
            output.putData(line);
        }
        output.putData(null); // 结束标记
    }
}