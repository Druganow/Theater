package com.example.lab_1;

import com.example.lab_1.model.Actor;
import com.example.lab_1.model.Theater;
import com.example.lab_1.service.JSoupActorService;
import com.example.lab_1.service.JSoupService;

import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws IOException {
        Document document= JSoupService.goToHref("https://kirovdramteatr.ru/truppa");
        ArrayList<Actor> actors = JSoupActorService.getDramaTheaterActorsList(document, "https://kirovdramteatr.ru");
        assertEquals(actors.get(1).getImgUrl(), "Смирнов Владимир Александрович");
    }
    @Test
    public void addition_isCorrect2() throws IOException {
        Document document= JSoupService.goToHref("https://ekvus-kirov.ru/truppa");
        ArrayList<Actor> actors = JSoupActorService.getTUZTheaterActorsList(document, "https://ekvus-kirov.ru/");
        assertEquals(actors.get(1).getName(), "Татьяна Махнёва");
    }

}


