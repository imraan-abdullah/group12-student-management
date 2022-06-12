//Mariam Gallie- 219094837
// NameFactoryTest.java (factory test package)
// 11 June 2022

package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {

    @Test
    public void buildWithSuccess(){
        Name name = NameFactory.build("Sam","Rose","Gallie");
        System.out.println(name);
        assertNotNull(name);
    }

    @Test
    public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NameFactory
                .build(null,"Rose","Gallie"));

        String excptionMessage = exception.getMessage();
        assertSame("must have first name ",excptionMessage);

    }

}