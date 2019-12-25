package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.ManagementInfo;
import com.example.repository.ManagementRepository;

@Service
@Transactional
public class ManagementService {
	
	@Autowired
	private ManagementRepository managementRepository;
	
	/**
	 * 7個ずつ運営情報を表示させるためのメソッド.
	 * @param managementInfo
	 * @return
	 */
	public List<List<ManagementInfo>> arrayTable(List<ManagementInfo> managementInfo){
		List<ManagementInfo> managementInfo7List = new ArrayList<>();
		
		List<List<ManagementInfo>> managementInfoAllList = new ArrayList<>();
		
		for(int i = 1; i < managementInfo.size(); i++) {
			managementInfo7List.add(managementInfo.get(i - 1));
			
			if((i%7) == 0) {
				managementInfoAllList.add(managementInfo7List);
				managementInfo7List = new ArrayList<>();
			}
		}
		if(managementInfo7List.size() == 0) {
			return managementInfoAllList;
		}
		managementInfoAllList.add(managementInfo7List);
		return managementInfoAllList;
	}
	
	/**
	 * 運営情報を全件検索するサービス.
	 * @return
	 */
	public List<List<ManagementInfo>> findAll(){
		return arrayTable(managementRepository.findAll());
	}
	
	/**
	 * IDで運営情報を一件検索するサービス.
	 * @param id
	 * @return
	 */
	public ManagementInfo load(Integer id) {
		return managementRepository.load(id);
	}

}
