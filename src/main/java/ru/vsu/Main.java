package ru.vsu;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CreateDictionary dictionaryFabric = new CreateMan();
        myCSVReader csvReader = new myCSVReader("foreign_names.csv",';', dictionaryFabric);
        List csvContent = csvReader.readCSV();

        for (Object rows: csvContent)
            System.out.println(rows);
    }
}