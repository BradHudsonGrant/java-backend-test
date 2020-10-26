package com.marshmallow.javabackendtest.model.response;

import lombok.Data;

@Data
public class OilSpillResponse {

    private int[] finalPosition;
    private int oilPatchesCleaned;

}
