package edu.strathmore.dbit.ooens.controller;

import edu.strathmore.dbit.ooens.db.Database;
import edu.strathmore.dbit.ooens.utils.TimeStamp;
import edu.strathmore.dbit.ooens.utils.log.Log;
import java.util.UUID;

/**
 *
 * @author strategide
 */
public abstract class BaseController {

    final private String table;

    private Database db;

    public BaseController(String table) {
        this.table = table;
        init();
    }

    private void init() {
        db = Database.getInstance();
        check();
        
        v("Creating table...");
        db.createTable(getCreateQuery(getCreateColumns()));
    }

    protected String generateId() {
        return UUID.randomUUID().toString();
    }

    protected TimeStamp generateTimeStamp() {
        return new TimeStamp();
    }

    private void check() {
        if (db == null) {
            crash("Database was not initialized.");
        }

        if (table == null || table.trim().isEmpty()) {
            crash("Table name was not initialized.");
        }
    }
    
    protected abstract String[] getCreateColumns();

    protected String getCreateQuery(String[] columns) {
        final StringBuilder builder = new StringBuilder();
        builder.append(String.format("\nCREATE TABLE IF NOT EXISTS %s (\n", table));
        builder.append("\tid VARCHAR(50) PRIMARY KEY,\n");
        for (String column : columns) {
            if (column.isBlank()) {
                continue;
            }

            builder.append("\t").append(column).append(",\n");
        }

        builder
                .append("\tcreatedAt TIMESTAMP NOT NULL,\n")
                .append("\tupdatedAt TIMESTAMP\n");

        builder.append(");");

        return builder.toString();
    }

    protected void v(String message) {
        Log.v(message, this);
    }

    protected void d(String message) {
        Log.d(message, this);
    }

    protected void i(String message) {
        Log.i(message, this);
    }

    protected void w(String message) {
        Log.w(message, this);
    }

    protected void e(String message) {
        Log.e(message, this);
    }

    protected void r(String message) {
        Log.r(message);
    }

    protected void re(String message) {
        Log.re(message);
    }

    private void crash(String message) {
        e(message);
        throw new RuntimeException(message);
    }
}
