import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationTest {

    class StorageException extends Exception {
        public StorageException(String mesage, Exception e) {
            super(mesage, e);
        }
    };

    class SectionStore {
        public List<String> retrieveSection(String sectionName) throws StorageException {
           try {
               FileInputStream stream = new FileInputStream(sectionName);
               stream.close();
           } catch (FileNotFoundException e) {
               throw new StorageException("retrieval error", e);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
            return new ArrayList<String>();
        }
    }

    @Test(expected = StorageException.class)
    public void retrieveSectionShouldThrowOnInvalidFilename() throws StorageException {
        SectionStore sectionStore = new SectionStore();
        sectionStore.retrieveSection("invalid - name");
    }
}