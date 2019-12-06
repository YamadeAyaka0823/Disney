package com.example.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todayPark")
public class TodayParkController {
	
	/**
	 * 待ち時間スクレイピング.
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/waitTime")
	public String waitTime(Model model) throws IOException {
		Document document = Jsoup.connect("https://disneyreal.asumirai.info/realtime/disneyland-wait-today.html").get();
		Elements elements = document.getElementsByClass("post wbox land");
		StringBuilder sb = new StringBuilder();
		for(Element element : elements) {
			sb.append(element.text());
		}
		model.addAttribute("time", sb.toString());
		return "today_park";
	}

}
