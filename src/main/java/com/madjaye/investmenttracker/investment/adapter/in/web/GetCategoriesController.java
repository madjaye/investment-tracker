package com.madjaye.investmenttracker.investment.adapter.in.web;

import com.madjaye.investmenttracker.investment.application.port.in.GetUserCategoriesUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class GetCategoriesController {

    private final GetUserCategoriesUserCase getUserCategoriesUserCase;

    @GetMapping(path = "/category/user/{userId}")
    ResponseEntity<CategoryDto> getCategoriesForUser(@PathVariable("userId") Long userId) {
        var categories = getUserCategoriesUserCase.getCategories(userId);
        return ResponseEntity.ok(new CategoryDto(categories));
    }

}
