package com.example.prog4.controller.view;

import com.example.prog4.service.cnaps.DummyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class DummyController {
  private final DummyService service;

  @GetMapping("/dummy")
  public String getAll() {
    var dummyEntries = service.findAll();
    log.info("dummyEntries: {}", dummyEntries); // notice this get the data from the cnaps datasource
    return "redirect:/employee/list";
  }
}
