package pro.sky.botanimalshelter.serviceTest;

import org.junit.jupiter.api.Test;

import pro.sky.botanimalshelter.model.ListDocument;
import pro.sky.botanimalshelter.model.PetShelter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListDocumentServiceTest {

    @Test
    public void testGettersAndSetters() {
        PetShelter shelter = new PetShelter("Shelter1", "123-456-7890", "Monday-Friday 9:00-17:00", "path", "contacts", "story");
        ListDocument document = new ListDocument("Test Document", shelter);

        assertEquals("Test Document", document.getDocument());

        document.setDocument("Updated Document");
        assertEquals("Updated Document", document.getDocument());

        assertEquals(shelter, document.getShelter());

        PetShelter newShelter = new PetShelter("Shelter1", "123-456-7890", "Monday-Friday 9:00-17:00", "path", "contacts", "story");
        document.setShelter(newShelter);
        assertEquals(newShelter, document.getShelter());
    }

    @Test
    public void testEqualsAndHashCode() {
        PetShelter shelter1 = new PetShelter("Shelter1", "123-456-7890", "Monday-Friday 9:00-17:00", "path", "contacts", "story");
        ListDocument document1 = new ListDocument("Document 1", shelter1);
        document1.setId(1L);

        ListDocument document2 = new ListDocument("Document 2", shelter1);
        document2.setId(1L);

        assertEquals(document1, document2);
        assertEquals(document1.hashCode(), document2.hashCode());
    }

    @Test
    public void testToString() {
        PetShelter shelter = new PetShelter("Shelter1", "123-456-7890", "Monday-Friday 9:00-17:00", "path", "contacts", "story");
        ListDocument document = new ListDocument("Test Document", shelter);
        document.setId(1L);

        String expectedString = "ListDocument{id=1, document='Test Document', shelter=" + shelter + "}";
        assertEquals(expectedString, document.toString());
    }
}