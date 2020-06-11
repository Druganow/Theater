package com.example.lab_1.service;


import com.example.lab_1.model.Actor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class JSoupService {

    public static Document goToHref(String url) throws IOException {
        return  Jsoup.connect(url).get();
    }



}
/*
package com.example.kirovtheaters.service;

import com.example.kirovtheaters.model.Theatre;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

abstract class JSoupService {

    protected Document document;
    protected String url;

    protected JSoupService(Theatre theatre) throws IOException {
        document = Jsoup.connect(theatre.getTroupe()).get();
        url = theatre.getSite();
    }
}

 */