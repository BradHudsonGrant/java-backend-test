package com.marshmallow.javabackendtest.model.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class OilSpillRequest {

    @NonNull
    private int[] areaSize;
    @NonNull
    private int[] startingPosition;
    @NonNull
    private int[][] oilPatches;
    @NonNull
    private String navigationInstructions;
}
