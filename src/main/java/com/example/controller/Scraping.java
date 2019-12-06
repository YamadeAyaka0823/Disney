package com.example.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraping {

	public static void main(String[] args) throws IOException {
		
		Document document = Jsoup.connect("https://disneyreal.asumirai.info/realtime/disneyland-wait-today.html").get();
		Elements elements = document.select("p");
		
		for(Element element : elements) {
			System.out.println(element.text());
		}

	}

}
