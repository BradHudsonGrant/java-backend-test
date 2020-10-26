package com.marshmallow.javabackendtest.controller;

import com.marshmallow.javabackendtest.model.request.OilSpillRequest;
import com.marshmallow.javabackendtest.model.response.OilSpillResponse;
import com.marshmallow.javabackendtest.service.OilSpillCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class OilSpillController {

    @Autowired
    private OilSpillCleanService oilSpillCleanService;

    @ResponseBody
    @PostMapping(path = "/oil-spill", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OilSpillResponse> oilSpillClean(@RequestBody OilSpillRequest request){
        OilSpillResponse response = oilSpillCleanService.robotCleanCalculation(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
