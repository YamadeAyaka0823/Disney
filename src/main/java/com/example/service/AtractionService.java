package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Atraction;
import com.example.repository.AtractionRepository;

@Service
@Transactional
public class AtractionService {
	
	@Autowired
	private AtractionRepository atractionRepository;
	
	/**
	 * アトラクションの全件検索のためのサービス.
	 * @return
	 */
	public List<Atraction> findAll(){
		return atractionRepository.findAll();
	}
	
	/**
	 * アトラクション1件検索するサービス.
	 * @param id
	 * @return
	 */
	public Atraction load(Integer id) {
		return atractionRepository.load(id);
	}

}
