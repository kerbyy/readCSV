package ru.vsu;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Realization of the class used to read csv files
 */
public class myCSVReader {
    /**
     * column separator
     */
    char separator;
    /**
     * file name
     */
    String fileName;
    /**
     * source
     */
    CSVReader reader = null;
    /**
     * List of people read from a cvs file
     */
    CreateDictionary listOfPeopleFromCsv = null;

    /**
     * Constructor - creating a new object
     * @param fileName the name of the csv file from which we will read the information
     * @param separator column separator
     */
    public myCSVReader(String fileName, char separator) {
        this.fileName = fileName;
        this.separator = separator;
    }
    /**
     * Constructor - creating a new object with an already created dictionary
     */
    public myCSVReader(String fileName, char separator, CreateDictionary listOfPeopleFromCsv) {
        this.fileName = fileName;
        this.separator = separator;
        this.listOfPeopleFromCsv = listOfPeopleFromCsv;
    }

    /**
     * Opens the file, namely fills in the field {@link myCSVReader#reader}
     * @throws FileNotFoundException An exception that is
     * triggered when there is no file with that name
     */
    @SuppressWarnings("deprecation")
    private void openFile() throws FileNotFoundException {
        InputStream in = getClass().getClassLoader().getResourceAsStream(fileName);
        reader = in == null ? null : new CSVReader(new InputStreamReader(in), separator);
        if (reader == null) {
            throw new FileNotFoundException(fileName);
        }
    }

    /**
     * The basic procedure for reading a file
     * @return csv file strings in the dictionary whose
     * keys correspond to the header fields from the file
     */
    public List<Map<String, Object>> readCSV() {
        ArrayList<Map<String, Object>> csvList = new ArrayList<>();
        try {
            if (reader == null)
                openFile();

            String[] Line = reader.readNext(); // csv header
            if (Line == null)
                throw new IOException("File is empty!");

            if (listOfPeopleFromCsv == null)
                listOfPeopleFromCsv = new CreateDictionary(Line);

            while ((Line = reader.readNext()) != null) {
                try {
                    csvList.add(listOfPeopleFromCsv.createNewNode(Line));
                }
                catch (IllegalArgumentException exception){
                    System.out.println("Wrong format!");
                    break;
                }
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return csvList;
    }
}