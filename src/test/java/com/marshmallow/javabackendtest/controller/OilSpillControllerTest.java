package com.marshmallow.javabackendtest.controller;

import com.marshmallow.javabackendtest.model.request.OilSpillRequest;
import com.marshmallow.javabackendtest.model.response.OilSpillResponse;
import com.marshmallow.javabackendtest.service.impl.OilSpillCleanServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class OilSpillControllerTest {

    @Mock
    private OilSpillCleanServiceImpl oilSpillCleanServiceImpl;

    @InjectMocks
    private OilSpillController oilSpillController;

    @Test
    public void happyResponse(){
        int[] areaSize = {5,5};
        int[] startingPosition = {0,0};
        int[][] oilPatches = {{0,0}};
        String navigationInstructions = "NN";
        OilSpillRequest request = new OilSpillRequest(areaSize,startingPosition,oilPatches,navigationInstructions);
        ResponseEntity<OilSpillResponse> result = oilSpillController.oilSpillClean(request);

        assertEquals(result.getStatusCodeValue(), 200);
    }

    @Test(expected = NullPointerException.class)
    public void outOfArea(){
        int[] areaSize = {5,5};
        int[] startingPosition = {0,0};
        int[][] oilPatches = null;
        String navigationInstructions = "N";
        OilSpillRequest request = new OilSpillRequest(areaSize,startingPosition,oilPatches,navigationInstructions);
        ResponseEntity<OilSpillResponse> result = oilSpillController.oilSpillClean(request);
    }

}
