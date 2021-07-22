package com.bi.wordcounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bi.wordcounter.domain.CounterResponse;
import com.bi.wordcounter.service.RankingService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RankingController {

	@Autowired
	RankingService rankingService;

	@GetMapping("/ranking")
	public CounterResponse getRanking() {
		return rankingService.getRanking();
	}
}
