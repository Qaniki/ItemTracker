/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ItemTracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        Item itemUnderTest = new Item("www", "www", 3.0 , 5, "Shoe");
        assertEquals(3.0, itemUnderTest.getPrice());
    }
    @Test void appHasAGreeting2() {
        System.out.println("is it running m9");
        //assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
