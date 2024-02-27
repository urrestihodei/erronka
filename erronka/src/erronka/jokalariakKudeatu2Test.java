package erronka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

class jokalariakKudeatu2Test {

    jokalaria jokalari;

    @BeforeEach
    void objetua() {
        jokalari = new jokalaria("12345678D", "jurgi", "leunda", new Date(2002, 12, 30), "ikaztegieta", 8, "jurgi", "jurgi");
    }

    @Test 
    void testGetNan() {
        assertEquals("12345678D", jokalari.getNan());
    }

    @Test
    void testGetIzena() {
        assertEquals("jurgi", jokalari.getIzena());
    }

    @Test
    void testGetAbizena() {
        assertEquals("leunda", jokalari.getAbizena());
    }

    @Test
    void testGetJaiotze_data() {
        assertEquals(new Date(2002, 12, 30), jokalari.getJaiotze_data());
    }

    @Test
    void testGetTituluak() {
        assertEquals(8, jokalari.getTituluak());
    }

    @Test
    void testGetErabiltzailea() {
        assertEquals("jurgi", jokalari.getErabiltzailea());
    }

    @Test
    void testGetPasahitza() {
        assertEquals("jurgi", jokalari.getPasahitza());
    }

    @Test
    void testGetHerrialdea() {
        assertEquals("ikaztegieta", jokalari.getHerrialdea());
    }
}

