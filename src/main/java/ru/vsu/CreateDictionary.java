package ru.vsu;

import java.util.HashMap;
import java.util.Map;
import java.lang.IllegalArgumentException;

/**
 * A class for creating HashMap dictionaries with String and Object types
 */
class CreateDictionary {
    String[] keys;

    /**
     * The constructor defines the keys of the created dictionaries
     * @param keys keys of the dictionaries being created
     */
    public CreateDictionary(String[] keys){
        this.keys = keys;
    }

    /**
     * Creating a map
     * @param values - values corresponding to the keys in the constructor
     * @return map of correspondences
     * @throws IllegalArgumentException is triggered when the number of values does not match the specified number of keys
     */
    public Map<String, Object> createNewNode(String[] values) throws IllegalArgumentException {
        if (values.length != keys.length) throw new IllegalArgumentException();

        Map<String, Object> dictionary = new HashMap<>();

        for (int i = 0; i < keys.length; i++)
            dictionary.put(keys[i], values[i]);

        return dictionary;
    }
}
