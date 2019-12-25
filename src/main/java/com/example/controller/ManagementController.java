package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.ManagementInfo;
import com.example.service.ManagementService;

@Controller
@RequestMapping("/management")
public class ManagementController {
	
	@Autowired
	private ManagementService managementService;
	
	/**
	 * 運営情報カレンダー.
	 * @param model
	 * @return
	 */
	@RequestMapping("/calendar")
	public String calendar(Model model) {
		List<List<ManagementInfo>> managementInfoList = managementService.findAll();
		model.addAttribute("managementInfoList", managementInfoList);
		return "calendar";
	}
	
	/**
	 * 運営情報の詳細.
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail")
	public String detail(Integer id, Model model) {
		ManagementInfo managementInfo = managementService.load(id);
		model.addAttribute("managementInfo", managementInfo);
		return "calendar_detail";
	}

}
