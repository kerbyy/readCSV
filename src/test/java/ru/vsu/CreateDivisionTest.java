package ru.vsu;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class CreateDivisionTest {

    @Test
    public void testId() {
        CreateDivision df = new CreateDivision();
        df.createNewDivision("A");
        df.createNewDivision("B");
        assertEquals((Integer)1, df.getId("A"));
        assertEquals((Integer)2, df.getId("B"));
        df.createNewDivision("A");
        assertEquals((Integer)1, df.getId("A"));
    }

    @Test
    public void testCreateNewDivision() {
        CreateDivision df = new CreateDivision();
        Map<String,Object> check = new HashMap<>();
        check.put("Letter","C");
        check.put("Id",3);
        assertEquals(check, df.createNewDivision("C"));
    }
}