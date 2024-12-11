package org.example;

import org.example.src.factory.KWICFactoryProducer;
import org.example.src.factory.interfaces.DataSource;
import org.example.src.filter.impl.ShiftFilter;
import org.example.src.kwic.input.KWICInput;
import org.example.src.kwic.output.KWICOutput;
import org.example.src.pipe.SimplePipe;

public class Main {
    public static void main(String[] args) {
        // 创建管道
        SimplePipe inputPipe = new SimplePipe();
        SimplePipe shiftPipe = new SimplePipe();
        SimplePipe outputPipe = new SimplePipe();

        // 创建过滤器
        KWICInput input = new KWICInput(inputPipe);
        ShiftFilter shifter = new ShiftFilter(inputPipe, shiftPipe);
        KWICOutput output = new KWICOutput(shiftPipe, outputPipe);

        // 获取数据源（这里使用文件系统作为示例）
        DataSource dataSource = KWICFactoryProducer.getFactory("FILE").createDataSource();
        
        // 设置输入数据
        input.setDataSource(dataSource);

        // 启动处理流程
        input.start();
        shifter.start();
        output.start();
    }
}