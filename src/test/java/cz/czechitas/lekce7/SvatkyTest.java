package cz.czechitas.lekce7;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        //TODO Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
        Svatky svatky = new Svatky();
        String jmenoJeVSeznamu = "Alexej";
        String jmenoNeniVSeznamu = "Adam";
        boolean resultJeVSeznamu = svatky.jeVSeznamu(jmenoJeVSeznamu);
        boolean resultNeniVSeznamu = svatky.jeVSeznamu(jmenoNeniVSeznamu);
        assertTrue(resultJeVSeznamu, "Očekávala jsem, že " + jmenoJeVSeznamu + " je v seznamu jmen.");
        assertTrue(resultNeniVSeznamu, "Očekávala jsem, že " + jmenoNeniVSeznamu + " není v seznamu jmen.");
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        //TODO Otestovat, že vrací počet jmen, která máme v seznamu
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
        assertNotEquals(39, svatky.getPocetJmen());
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        //TODO Zkontrolovat, že seznam jmen má správný počet položek.
        Svatky svatky = new Svatky();
        Set<String> seznamJmen = svatky.getSeznamJmen();
        assertEquals(37, seznamJmen.size());
        assertNotEquals(39, seznamJmen.size());
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridejSvatekDenMesicInt() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        String jmeno = "Hana";
        int Den = 15;
        int Mesic = 8;
        boolean resultPridejSvatek = svatky.jeVSeznamu(jmeno + Den + Mesic );
        assertTrue(resultPridejSvatek);
    }
    @Test
    void pridejSvatekDenMesicIntB() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Hana", 15, 8);
        assertTrue(svatky.jeVSeznamu("Hana"));
        assertEquals(MonthDay.of(8, 15), svatky.vratKdyMaSvatek("Hana"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridejSvatekDenMesicMonth() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        String jmeno = "Hedvika";
        int den = 17;
        Month mesic = Month.OCTOBER;
        svatky.pridejSvatek(jmeno, den, mesic);
        assertTrue(svatky.jeVSeznamu(jmeno));
        assertEquals(MonthDay.of(mesic, den), svatky.vratKdyMaSvatek(jmeno));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void prridejSvatekMonthDay() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        String jmeno = "Václav";
        MonthDay denMesic = MonthDay.of(9, 24);
        svatky.pridejSvatek(jmeno, denMesic);
        assertTrue(svatky.jeVSeznamu(jmeno));
        assertEquals(denMesic, svatky.vratKdyMaSvatek(jmeno));
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazSvatek() {
        //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
        Svatky svatky = new Svatky();
        int puvodniPocetJmen = svatky.getPocetJmen();
        svatky.smazSvatek("Klaudie");
        int novyPocetJmen = svatky.getPocetJmen();
        assertEquals(puvodniPocetJmen - 1, novyPocetJmen);
    }
}
