package com.example.elk.stack.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoggingController {

  @GetMapping("/log")
  public String logMessage(
      @RequestParam(defaultValue = "info") String level,
      @RequestParam(defaultValue = "Hello ELK!") String message) {
    switch (level.toLowerCase()) {
      case "debug":
        log.debug(message);
        break;
      case "warn":
        log.warn(message);
        break;
      case "error":
        log.error(message);
        break;
      default:
        log.info(message);
    }
    return "Log message sent: " + message;
  }
}
