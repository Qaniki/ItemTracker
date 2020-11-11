/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ItemTracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void pricecheck() {
        Item itemUnderTest = new Item.Builder("Common Project", "Shoe")
        .price(3000.0).year(2020).description("Original").build();
        assertEquals(3000, itemUnderTest.getPrice());
    }
    @Test void isIt() {
        System.out.println("is it running m9");
    }
}
