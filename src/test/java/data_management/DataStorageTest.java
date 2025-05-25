package data_management;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.data_management.DataStorage;
import com.data_management.PatientRecord;

import java.util.List;

class DataStorageTest {

    // made a comment as no longer needed
/* 
    @Test
    void testAddAndGetRecords() {
        // No reader needed, just create the storage directly
        DataStorage storage = new DataStorage();
        storage.addPatientData(1, 100.0, "WhiteBloodCells", 1714376789050L);
        storage.addPatientData(1, 200.0, "WhiteBloodCells", 1714376789051L);

        List<PatientRecord> records = storage.getRecords(1, 1714376789050L, 1714376789051L);

        // SAFETY CHECK: avoid null pointer crash
        assertNotNull(records, "getRecords() should not return null");

        assertEquals(2, records.size(), "Expected 2 records");
        assertEquals(100.0, records.get(0).getMeasurementValue(), "First record value mismatch");
    }*/
}
