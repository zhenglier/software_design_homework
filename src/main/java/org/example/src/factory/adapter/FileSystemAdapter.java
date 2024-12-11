package org.example.src.factory.adapter;

import org.example.src.factory.interfaces.TextReader;
import org.example.src.factory.interfaces.TextWriter;

public class FileSystemAdapter extends AbstractDataSource {
    private TextReader reader;
    private TextWriter writer;

    public FileSystemAdapter(TextReader reader, TextWriter writer) {
        this.reader = reader;
        this.writer = writer;
        System.out.println("创建文件系统适配器 -> 适配 TextReader 和 TextWriter 接口到 DataSource 接口");
    }

    @Override
    public String getType() {
        return "文件系统";
    }

    @Override
    public String readData() {
        System.out.println("文件系统适配器: 转换 read() 调用到 readData()");
        reader.read();
        String data = "文件数据";
        notifyDataRead(data);  // 通知观察者
        return data;
    }

    @Override
    public void writeData(String data) {
        System.out.println("文件系统适配器: 转换 writeData() 调用到 write()");
        System.out.println("准备写入数据: " + data);
        writer.write();
        notifyDataWrite(data);  // 通知观察者
    }

    @Override
    public TextReader getReader() {
        return reader;
    }

    @Override
    public TextWriter getWriter() {
        return writer;
    }
} 