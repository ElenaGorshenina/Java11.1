package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.CatalogMovie;
import ru.netology.manager.MovieManager;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void getLastLessLimitTest() {
        MovieManager manager = new MovieManager();
        CatalogMovie bloodshot = new CatalogMovie(1, 1, "Бладшот", "urlБладшот", "боевик", "12.03.2020");
        CatalogMovie onward = new CatalogMovie(2, 2, "Вперед", "urlВперед", "мультфильм", "05.03.2020");
        CatalogMovie hotelBelgrade = new CatalogMovie(3, 3, "Отель 'Белград'", "urlОтельБелград", "комедия", "05.03.2020");
        CatalogMovie theGentlemen = new CatalogMovie(4, 4, "Джентльмены", "urlДжентльмены", "боевик", "13.02.2020");
        CatalogMovie theInvisibleMan = new CatalogMovie(5, 5, "Человек-невидимка", "urlЧеловек-невидимка", "ужасы", "05.03.2020");
        CatalogMovie trollsWorldTour = new CatalogMovie(6, 6, "Тролли. Мировой тур", "urlТролли.Мировой_тур", "мультфильм", "12.03.2020");
        manager.add(bloodshot);
        manager.add(onward);
        manager.add(hotelBelgrade);
        manager.add(theGentlemen);
        manager.add(theInvisibleMan);
        manager.add(trollsWorldTour);

        CatalogMovie[] actual = manager.getLast();
        CatalogMovie[] expected = new CatalogMovie[]{trollsWorldTour, theInvisibleMan, theGentlemen, hotelBelgrade, onward, bloodshot};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastMoreLimitTest() {
        MovieManager manager = new MovieManager();
        CatalogMovie bloodshot = new CatalogMovie(1, 1, "Бладшот", "urlБладшот", "боевик", "12.03.2020");
        CatalogMovie onward = new CatalogMovie(2, 2, "Вперед", "urlВперед", "мультфильм", "05.03.2020");
        CatalogMovie hotelBelgrade = new CatalogMovie(3, 3, "Отель 'Белград'", "urlОтельБелград", "комедия", "05.03.2020");
        CatalogMovie theGentlemen = new CatalogMovie(4, 4, "Джентльмены", "urlДжентльмены", "боевик", "13.02.2020");
        CatalogMovie theInvisibleMan = new CatalogMovie(5, 5, "Человек-невидимка", "urlЧеловек-невидимка", "ужасы", "05.03.2020");
        CatalogMovie trollsWorldTour = new CatalogMovie(6, 6, "Тролли. Мировой тур", "urlТролли.Мировой_тур", "мультфильм", "12.03.2020");
        CatalogMovie numberOne = new CatalogMovie(7, 7, "Номер один", "urlНомер_один", "комедия", "19.03.2020");
        CatalogMovie fantasyIsland = new CatalogMovie(8, 8, "Остров фантазий", "urlОстров_фантазий", "фантастика", "05.03.2020");
        CatalogMovie oneBreath = new CatalogMovie(9, 9, "Один вдох'", "urlОдин_вдох", "драма", "05.03.2020");
        CatalogMovie happinessInAnEnvelope = new CatalogMovie(10, 10, "Счастье в конверте", "urlСчастье_в_конверте", "семейный", "12.03.2020");
        CatalogMovie misbehaviour = new CatalogMovie(11, 11, "Мисс Плохое поведение", "urlМисс_Плохое_поведение", "комедия", "09.07.2020");
        CatalogMovie founder = new CatalogMovie(12, 12, "Основатель", "urlОснователь", "драма", "23.07.2020");
        manager.add(bloodshot);
        manager.add(onward);
        manager.add(hotelBelgrade);
        manager.add(theGentlemen);
        manager.add(theInvisibleMan);
        manager.add(trollsWorldTour);
        manager.add(numberOne);
        manager.add(fantasyIsland);
        manager.add(oneBreath);
        manager.add(happinessInAnEnvelope);
        manager.add(misbehaviour);
        manager.add(founder);

        CatalogMovie[] actual = manager.getLast();
        CatalogMovie[] expected = new CatalogMovie[]{founder, misbehaviour, happinessInAnEnvelope, oneBreath, fantasyIsland, numberOne, trollsWorldTour, theInvisibleMan, theGentlemen, hotelBelgrade};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void setLessLimitTest() {
        MovieManager manager = new MovieManager(1);
        CatalogMovie bloodshot = new CatalogMovie(1, 1, "Бладшот", "urlБладшот", "боевик", "12.03.2020");
        CatalogMovie onward = new CatalogMovie(2, 2, "Вперед", "urlВперед", "мультфильм", "05.03.2020");
        CatalogMovie hotelBelgrade = new CatalogMovie(3, 3, "Отель 'Белград'", "urlОтельБелград", "комедия", "05.03.2020");
        manager.add(bloodshot);
        manager.add(onward);
        manager.add(hotelBelgrade);

        CatalogMovie[] actual = manager.getLast();
        CatalogMovie[] expected = new CatalogMovie[]{hotelBelgrade};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void setMoreLimitTest() {
        MovieManager manager = new MovieManager(12);
        CatalogMovie bloodshot = new CatalogMovie(1, 1, "Бладшот", "urlБладшот", "боевик", "12.03.2020");
        CatalogMovie onward = new CatalogMovie(2, 2, "Вперед", "urlВперед", "мультфильм", "05.03.2020");
        CatalogMovie hotelBelgrade = new CatalogMovie(3, 3, "Отель 'Белград'", "urlОтельБелград", "комедия", "05.03.2020");
        CatalogMovie theGentlemen = new CatalogMovie(4, 4, "Джентльмены", "urlДжентльмены", "боевик", "13.02.2020");
        CatalogMovie theInvisibleMan = new CatalogMovie(5, 5, "Человек-невидимка", "urlЧеловек-невидимка", "ужасы", "05.03.2020");
        CatalogMovie trollsWorldTour = new CatalogMovie(6, 6, "Тролли. Мировой тур", "urlТролли.Мировой_тур", "мультфильм", "12.03.2020");
        CatalogMovie numberOne = new CatalogMovie(7, 7, "Номер один", "urlНомер_один", "комедия", "19.03.2020");
        CatalogMovie fantasyIsland = new CatalogMovie(8, 8, "Остров фантазий", "urlОстров_фантазий", "фантастика", "05.03.2020");
        CatalogMovie oneBreath = new CatalogMovie(9, 9, "Один вдох'", "urlОдин_вдох", "драма", "05.03.2020");
        CatalogMovie happinessInAnEnvelope = new CatalogMovie(10, 10, "Счастье в конверте", "urlСчастье_в_конверте", "семейный", "12.03.2020");
        CatalogMovie misbehaviour = new CatalogMovie(11, 11, "Мисс Плохое поведение", "urlМисс_Плохое_поведение", "комедия", "09.07.2020");
        CatalogMovie founder = new CatalogMovie(12, 12, "Основатель", "urlОснователь", "драма", "23.07.2020");
        manager.add(bloodshot);
        manager.add(onward);
        manager.add(hotelBelgrade);
        manager.add(theGentlemen);
        manager.add(theInvisibleMan);
        manager.add(trollsWorldTour);
        manager.add(numberOne);
        manager.add(fantasyIsland);
        manager.add(oneBreath);
        manager.add(happinessInAnEnvelope);
        manager.add(misbehaviour);
        manager.add(founder);

        CatalogMovie[] actual = manager.getLast();
        CatalogMovie[] expected = new CatalogMovie[]{founder, misbehaviour, happinessInAnEnvelope, oneBreath, fantasyIsland, numberOne, trollsWorldTour, theInvisibleMan, theGentlemen, hotelBelgrade};

        assertArrayEquals(expected, actual);
    }

    /* @Test
    public void shouldRemoveIfExists() {
        MovieManager manager = new MovieManager();
        int idToRemove = 1;
        CatalogMovie bloodshot = new CatalogMovie(1, 1, "Бладшот", "urlБладшот", "боевик", "12.03.2020");
        CatalogMovie onward = new CatalogMovie(2, 2, "Вперед", "urlВперед", "мультфильм", "05.03.2020");
        CatalogMovie hotelBelgrade = new CatalogMovie(3, 3, "Отель 'Белград'", "urlОтельБелград", "комедия", "05.03.2020");
        manager.add(bloodshot);
        manager.add(onward);
        manager.add(hotelBelgrade);

        manager.removeById(idToRemove);

        CatalogMovie[] actual = manager.getAll();
        CatalogMovie[] expected = new CatalogMovie[]{hotelBelgrade, onward};

        assertArrayEquals(expected, actual);
    }*/
}