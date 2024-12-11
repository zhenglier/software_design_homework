package org.example;

import org.example.src.factory.FactoryType;
import org.example.src.factory.KWICFactoryProducer;
import org.example.src.factory.interfaces.DataSource;
import org.example.src.factory.observer.LoggingObserver;
import org.example.src.factory.observer.MetricsObserver;
import org.example.src.kwic.KWICProcessor;
import org.example.src.kwic.input.KWICInput;
import org.example.src.kwic.output.KWICOutput;

public class Main {
    public static void main(String[] args) {
        // 创建KWIC处理器
        KWICProcessor processor = new KWICProcessor();

        // 创建数据源
        DataSource dataSource = KWICFactoryProducer.createDataSource(FactoryType.FILE);
        
        // 创建输入输出处理器
        KWICInput input = new KWICInput(dataSource.getReader(), processor);
        KWICOutput output = new KWICOutput(dataSource.getWriter(), processor);

        // 添加观察者
        LoggingObserver loggingObserver = new LoggingObserver();
        MetricsObserver metricsObserver = new MetricsObserver();
        dataSource.addObserver(loggingObserver);
        dataSource.addObserver(metricsObserver);

        // 处理示例数据
        String testInput = "The Day after Tomorrow\n" +
                          "Fast and Furious\n" +
                          "Man of Steel";
        
        System.out.println("=== 开始KWIC处理 ===\n");
        
        // 处理输入
        input.processInput(testInput);
        
        // 执行KWIC转换
        processor.process();
        
        // 输出结果
        output.writeOutput();
        
        System.out.println("\n=== KWIC处理完成 ===");
    }
}