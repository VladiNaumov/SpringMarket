package com.naumdeveloper.web;


import com.naumdeveloper.web.dto.ResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {
    @GetMapping("/calc/add")
    public ResultDto calculateAdd(@RequestParam Integer a, @RequestParam Integer b) {
        return new ResultDto(a + b);
    }
}
