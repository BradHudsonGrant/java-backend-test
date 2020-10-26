package com.marshmallow.javabackendtest.service;

import com.marshmallow.javabackendtest.model.request.OilSpillRequest;
import com.marshmallow.javabackendtest.model.response.OilSpillResponse;

public interface OilSpillCleanService {

    public OilSpillResponse robotCleanCalculation(OilSpillRequest request);

}
