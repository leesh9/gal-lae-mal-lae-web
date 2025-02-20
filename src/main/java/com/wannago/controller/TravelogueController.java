package com.wannago.controller;

import com.wannago.service.TravelogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.wannago.dto.TravelogueDTO;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/travelogues")
public class TravelogueController {

    @Autowired
    TravelogueService travelogueService;

    // 여행록 목록 ?page&size
    @GetMapping
    public ResponseEntity<Map<String, Object>> getTravelogueList(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "20") int size) {
        log.info("GET : /travelogues?page={}&size={}", page, size);
        return ResponseEntity.ok(travelogueService.getTravelogueList(page, size));
    }

}
