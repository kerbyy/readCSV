package ru.vsu;

import java.util.HashMap;
import java.util.Map;

/**
 * The creator of dictionaries, which can be called the essence of man.
 */
class CreateMan extends CreateDictionary {
    CreateDivision divisionList;

    /**
     * Constructor - creates keys and an empty list of divisions
     */
    public CreateMan() {
        super(new String[]{"id",
                "name",
                "gender",
                "BirtDate",
                "Division",
                "Salary"});
        divisionList = new CreateDivision();
    }

    @Override
    public Map<String, Object> createNewNode(String[] values) throws IllegalArgumentException {
        if (values.length != keys.length) throw new IllegalArgumentException();

        Map<String, Object> dictionary = new HashMap<>();

        for (int i = 0; i < keys.length; i++)
            if (!keys[i].equals("Division"))
                dictionary.put(keys[i], values[i]);
            else
                dictionary.put(keys[i], divisionList.createNewDivision(values[i]));

        return dictionary;
    }
}