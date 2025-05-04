package data_management;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.data_management.DataStorage;
import com.data_management.PatientRecord;
import com.data_management.DataReader;  // ← make sure this import exists

import java.util.List;
import java.util.Collections;

class DataStorageTest {

    @Test
    void testAddAndGetRecords() {
        // Provide a dummy DataReader that returns empty data or mock behavior
        DataReader reader = new DataReader() {
            @Override
            public List<PatientRecord> readData() {
                return Collections.emptyList();  // return empty list for the test
            }
        };

        DataStorage storage = new DataStorage(reader);
        storage.addPatientData(1, 100.0, "WhiteBloodCells", 1714376789050L);
        storage.addPatientData(1, 200.0, "WhiteBloodCells", 1714376789051L);

        List<PatientRecord> records = storage.getRecords(1, 1714376789050L, 1714376789051L);
        assertEquals(2, records.size()); // Check if two records are retrieved
        assertEquals(100.0, records.get(0).getMeasurementValue()); // Validate first record
    }
}
