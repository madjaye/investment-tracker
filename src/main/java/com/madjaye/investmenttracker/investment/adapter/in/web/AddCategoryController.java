package com.madjaye.investmenttracker.investment.adapter.in.web;

import com.madjaye.investmenttracker.investment.application.port.in.AddCategoryCommand;
import com.madjaye.investmenttracker.investment.application.port.in.AddCategoryUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
record AddCategoryController(AddCategoryUseCase addCategoryUseCase) {

    @PostMapping(path = "/category/{category}/user/{userId}")
    ResponseEntity<Object> addCategory(@PathVariable("category") String category, @PathVariable("userId") Long userId) {
        var addCategoryCommand = new AddCategoryCommand(category, userId);
        addCategoryUseCase.addCategory(addCategoryCommand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
