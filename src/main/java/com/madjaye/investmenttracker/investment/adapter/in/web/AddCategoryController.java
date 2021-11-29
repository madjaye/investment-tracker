package com.madjaye.investmenttracker.investment.adapter.in.web;

import com.madjaye.investmenttracker.investment.application.port.in.AddCategoryCommand;
import com.madjaye.investmenttracker.investment.application.port.in.AddCategoryUseCase;
import com.madjaye.investmenttracker.investment.application.service.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
record AddCategoryController(AddCategoryUseCase addCategoryUseCase) {

    @PostMapping(path = "/category/{category}/user/{userId}")
    ResponseEntity<Object> addCategory(@PathVariable("category") String category, @PathVariable("userId") Long userId) {
        var addCategoryCommand = new AddCategoryCommand(category, userId);
        try {
            addCategoryUseCase.addCategory(addCategoryCommand);
        } catch (BusinessException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage(), e);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
