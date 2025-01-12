package Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PersonTest {

    @Test
    public void getIdFromPersonTest() {
        Person person = new Person(1, "Ion", "Popescu") {
            @Override
            public void displayInfo() {
            }
        };
        assertEquals(1, person.getId());
    }

    @Test
    public void checkBugIfPersonIdIsIncorrectTest() {
        Person person = new Person(1, "Ion", "Popescu") {
            @Override
            public void displayInfo() {
            }
        };
        assertNotEquals(2, person.getId());
    }

    @Test
    public void getFirstNameFromPersonTest() {
        Person person = new Person(1, "Ion", "Popescu") {
            @Override
            public void displayInfo() {
            }
        };
        assertEquals("Ion", person.getFirstName());
    }

    @Test
    public void checkBugIfPersonFirstNameIsIncorrectTest() {
        Person person = new Person(1, "Ion", "Popescu") {
            @Override
            public void displayInfo() {
            }
        };
        assertNotEquals("Jane", person.getFirstName());
    }

    @Test
    public void getLastNameFromPersonTest() {
        Person person = new Person(1, "Ion", "Popescu") {
            @Override
            public void displayInfo() {
            }
        };
        assertEquals("Popescu", person.getLastName());
    }

    @Test
    public void checkBugIfPersonLastNameIsIncorrectTest() {
        Person person = new Person(1, "Ion", "Popescu") {
            @Override
            public void displayInfo() {
            }
        };
        assertNotEquals("Smith", person.getLastName());
    }

    @Test
    public void setIdForPersonTest() {
        Person person = new Person(1, "Ion", "Popescu") {
            @Override
            public void displayInfo() {
            }
        };
        person.setId(2);
        assertEquals(2, person.getId());
    }

    @Test
    public void setFirstNameForPersonTest() {
        Person person = new Person(1, "Ion", "Popescu") {
            @Override
            public void displayInfo() {
            }
        };
        person.setFirstName("Jane");
        assertEquals("Jane", person.getFirstName());
    }

    @Test
    public void setLastNameForPersonTest() {
        Person person = new Person(1, "Ion", "Popescu") {
            @Override
            public void displayInfo() {
            }
        };
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName());
    }
}