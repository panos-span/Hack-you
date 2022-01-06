package game;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MenuTest {

    static Menu menu;

    @BeforeAll
    static void setUp() {
        menu = new Menu();
    }

    @Test
    void playMusic() {
        Assertions.assertTrue(Menu.musicIsPlaying());
    }

    @Test
    void stopMusic() {
        Assertions.assertFalse(Menu.checkMusic());
        Menu.stopMusic();
        Assertions.assertFalse(Menu.musicIsPlaying());
        Assertions.assertTrue(Menu.checkMusic());
    }

    @AfterAll
    static void tearDown() {
        menu = null;
    }
}