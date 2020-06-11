package com.example.lab_1.service;

import com.example.lab_1.model.Actor;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.util.ArrayList;

public class JSoupActorService extends JSoupService {

    public static ArrayList<Actor> getTUZTheaterActorsList(Document doc, String url) {

        ArrayList<Actor> actors = new ArrayList<>();
        Element actorsInfo = doc.getElementsByClass("t_user").first();
        for (Element actorInfo : actorsInfo.getElementsByAttributeValueStarting("class", "td")){
            actors.add(new Actor(actorInfo.getElementsByTag("p").get(1)
                    .getElementsByTag("a")
                    .text(),
                    url + actorInfo.getElementsByTag("img").attr("src")));
        }
        return actors;
    }
    public static ArrayList<Actor> getDramaTheaterActorsList(Document doc, String url) {

        ArrayList<Actor> actors = new ArrayList<>();
        Element actorsInfo = doc.getElementsByClass("t_person_list").first();
        for (Element actorInfo : actorsInfo.getElementsByAttributeValueStarting("href", "/person/")){
            Element info = actorInfo.getElementsByTag("img").first();
            if (info != null) actors.add(new Actor(info.attr("alt"),
                    url + info.attr("src")));
        }
        return actors;
    }


    public static ArrayList<Actor> getDollTheaterActorsList(Document doc, String url) {
        ArrayList<Actor> act = new ArrayList<>();
        return act;

    }

}
