import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserTest {

	@Test
    public void testGetFullname() {
        User user = new User("John Doe", 20, "SUV");
        assertEquals("John Doe", user.getFullname());
    }

    @Test
    public void testGetCarType() {
        User user = new User("John Doe", 20, "SUV");
        assertEquals("SUV", user.getCarType());
    }

    @Test
    public void testGetMaxWaitTime() {
        User user = new User("John Doe", 20, "SUV");
        assertEquals(20, user.getMaxWaitTime());
    }

    @Test
    public void testSetFullname() {
        User user = new User("John Doe", 20, "SUV");
        user.setFullname("Jane Smith");
        assertEquals("Jane Smith", user.getFullname());
    }

    @Test
    public void testSetCarType() {
        User user = new User("John Doe", 20, "SUV");
        user.setCarType("Sedan");
        assertEquals("Sedan", user.getCarType());
    }

    @Test
    public void testSetMaxWaitTime() {
        User user = new User("John Doe", 20, "SUV");
        user.setMaxWaitTime(30);
        assertEquals(30, user.getMaxWaitTime());
    }
}
