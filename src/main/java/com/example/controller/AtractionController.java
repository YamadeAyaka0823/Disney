package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Atraction;
import com.example.service.AtractionService;

@Controller
@RequestMapping("atraction")
public class AtractionController {
	
	@Autowired
	private AtractionService atractionService;
	
	/**
	 * アトラクションを全件検索する.
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model) {
		List<Atraction> atractionList = atractionService.findAll();
		model.addAttribute("atractionList", atractionList);
		return "atraction_list";
	}
	
	/**
	 * アトラクションの詳細.
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail")
	public String detail(Integer id, Model model) {
		Atraction atraction = atractionService.load(id);
		model.addAttribute("atraction", atraction);
		return "atraction_detail";
	}

}
