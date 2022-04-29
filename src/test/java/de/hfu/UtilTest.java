package de.hfu;

import static org.junit.Assert.*;
import org.junit.Test;

public class UtilTest {
    @Test
    public void istErstesHalbjahrTest(){
        assertTrue("Der Monat ist im ersten Halbjahr", Util.istErstesHalbjahr(7)==true);
        assertTrue("Der Monat ist im ersten Halbjahr", Util.istErstesHalbjahr(1)==true);
        // Fehler ? Weil Monat 7 ist zweite Halbjahr eig? Aber Definitionsfehler nur ? 
    }
}
