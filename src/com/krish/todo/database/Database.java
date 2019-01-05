package com.krish.todo.database;

import java.util.HashMap;

/**
 * Class created by Krish
 */

public class Database {

    protected static HashMap<String, String> database = new HashMap<>();

    static {
        database.put("Krish", "test");
    }

}
