package org.example.src.factory;

import org.example.src.factory.interfaces.DataSource;

public class BasicKWICFactory {
    private DataSource dataSource;

    public BasicKWICFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource createDataSource() {
        return dataSource;
    }
} 