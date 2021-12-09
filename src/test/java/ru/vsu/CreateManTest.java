package ru.vsu;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CreateManTest {

    @Test
    public void testCreateNewNode() {
        CreateDictionary df = new CreateDictionary(new String[]{"qwe","rty"});
        Map<String,Object> check = new HashMap<>();
        check.put("qwe","123");
        check.put("rty","456");
        assertEquals(check, df.createNewNode(new String[]{"123","456"}));

    }
}