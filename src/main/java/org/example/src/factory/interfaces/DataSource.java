package org.example.src.factory.interfaces;

public interface DataSource {
    String readLine();
    void writeLine(String line);
    void close();
}