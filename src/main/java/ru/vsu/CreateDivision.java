package ru.vsu;

import java.util.HashMap;
import java.util.Map;

/**
 * Creator of dictionaries - divisions
 */
class CreateDivision extends CreateDictionary {
    static int divisionIdCounter = 1;
    Map<String,Integer> map;

    /**
     * Constructor - creating a new object
     * The map field is necessary to check the id
     * of the branches - if the branch has already been met
     * before, the same id will be used as the first time.
     */
    public CreateDivision(){
        super(new String[]{"Letter", "Id"});
        map = new HashMap<>();
    }

    /**
     * Creating a new division
     * @param letter The letter of the division
     * @return a card with the letter of the division and its id
     */
    public Map<String, Object> createNewDivision(String letter) {
        if (!map.containsKey(letter))
            map.put(letter, divisionIdCounter++);

        Map<String, Object> dictionary = new HashMap<>();
        dictionary.put("Letter", letter);
        dictionary.put("Id", map.get(letter));

        return dictionary;
    }

    /**
     * Getting the unit id
     * @param letter the letter of the division
     * @return division id
     */
    public Integer getId(String letter){
        return map.get(letter);
    }
}