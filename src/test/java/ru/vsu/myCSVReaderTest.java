package ru.vsu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ExecutionException;

class myCSVReaderTest {

    @Test
    void TestReadCSVForTheCompletenessOfTheReadData() throws FileNotFoundException {
        myCSVReader csvReader = new myCSVReader("foreign_names.csv",';');
        List csvContent = csvReader.readCSV();
        assertEquals(25898 ,csvContent.size());
    }
}