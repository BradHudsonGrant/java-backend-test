package com.marshmallow.javabackendtest.service;

import com.marshmallow.javabackendtest.controller.OilSpillController;
import com.marshmallow.javabackendtest.model.request.OilSpillRequest;
import com.marshmallow.javabackendtest.model.response.OilSpillResponse;
import com.marshmallow.javabackendtest.service.impl.OilSpillCleanServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class OilSpillServiceImplTest {

    @InjectMocks
    private OilSpillCleanServiceImpl oilSpillCleanServiceImpl;


    @Test
    public void checkForOilPatchTest(){
        int[][] seaGrid = {{1}};
        int[] currentPosition = {0,0};
        assertTrue(oilSpillCleanServiceImpl.checkForOilPatch(seaGrid, currentPosition));
    }

    @Test
    public void checkForOilPatchFalseTest(){
        int[][] seaGrid = {{0}};
        int[] currentPosition = {0,0};
        assertFalse(oilSpillCleanServiceImpl.checkForOilPatch(seaGrid, currentPosition));
    }

    @Test
    public void moveRobotNorth(){
        String direction = "N";
        int[] currentPosition = {0,0};
        int[] areaSize = {5,5};
        int[] expectedResult = {0,1};
        int[] actualResult = oilSpillCleanServiceImpl.moveRobot(direction,currentPosition,areaSize);
        assertEquals(actualResult[0], expectedResult[0]);
    }

    @Test
    public void moveRobotSouth(){
        String direction = "S";
        int[] currentPosition = {0,1};
        int[] areaSize = {5,5};
        int[] expectedResult = {0,0};
        int[] actualResult = oilSpillCleanServiceImpl.moveRobot(direction,currentPosition,areaSize);
        assertEquals(actualResult[0], expectedResult[0]);
    }

    @Test
    public void moveRobotEast(){
        String direction = "E";
        int[] currentPosition = {0,0};
        int[] areaSize = {5,5};
        int[] expectedResult = {1,0};
        int[] actualResult = oilSpillCleanServiceImpl.moveRobot(direction,currentPosition,areaSize);
        assertEquals(actualResult[0], expectedResult[0]);
    }

    @Test
    public void moveRobotWest(){
        String direction = "W";
        int[] currentPosition = {1,0};
        int[] areaSize = {5,5};
        int[] expectedResult = {0,0};
        int[] actualResult = oilSpillCleanServiceImpl.moveRobot(direction,currentPosition,areaSize);
        assertEquals(actualResult[0], expectedResult[0]);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void moveRobotOutOfBoundsWest(){
        String direction = "W";
        int[] currentPosition = {0,0};
        int[] areaSize = {5,5};
        oilSpillCleanServiceImpl.moveRobot(direction,currentPosition,areaSize);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void moveRobotOutOfBoundsEast(){
        String direction = "E";
        int[] currentPosition = {5,0};
        int[] areaSize = {5,5};
        oilSpillCleanServiceImpl.moveRobot(direction,currentPosition,areaSize);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void moveRobotOutOfBoundsSouth(){
        String direction = "S";
        int[] currentPosition = {0,0};
        int[] areaSize = {5,5};
        oilSpillCleanServiceImpl.moveRobot(direction,currentPosition,areaSize);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void moveRobotOutOfBoundsNorth(){
        String direction = "N";
        int[] currentPosition = {0,5};
        int[] areaSize = {5,5};
        oilSpillCleanServiceImpl.moveRobot(direction,currentPosition,areaSize);
    }

    @Test(expected = InputMismatchException.class)
    public void moveRobotInvalidDirection(){
        String direction = "Q";
        int[] currentPosition = {5,0};
        int[] areaSize = {5,5};
        oilSpillCleanServiceImpl.moveRobot(direction,currentPosition,areaSize);
    }

    @Test
    public void initialiseSeaGridTest() {
        int[] areaSize = {5, 5};
        int[][] oilPatches = {{1,1}};
        int expectedSeaGrid = 1;
        int[][] actualSeaGrid = oilSpillCleanServiceImpl.initialiseSeaGrid(areaSize, oilPatches);

        assertEquals(actualSeaGrid[1][1], expectedSeaGrid);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void initialiseSeaGridOilOutOfBoundsTest() {
        int[] areaSize = {5, 5};
        int[][] oilPatches = {{6,6}};
        oilSpillCleanServiceImpl.initialiseSeaGrid(areaSize, oilPatches);
    }

    @Test
    public void robotCleanCalculationTest() {
        int[] areaSize = {5,5};
        int[] startingPosition = {0,0};
        int[][] oilPatches = {{0,0},{0,1}};
        String navigationInstructions = "NN";
        OilSpillRequest request = new OilSpillRequest(areaSize,startingPosition,oilPatches,navigationInstructions);

        int[] finalPosition = {0,2};
        int oilPatchesCleaned = 2;
        OilSpillResponse expected = new OilSpillResponse();
        expected.setFinalPosition(finalPosition);
        expected.setOilPatchesCleaned(oilPatchesCleaned);
        OilSpillResponse actual = oilSpillCleanServiceImpl.robotCleanCalculation(request);

        assertEquals(actual.getOilPatchesCleaned(), expected.getOilPatchesCleaned());
        assertArrayEquals(actual.getFinalPosition(), expected.getFinalPosition());

    }


}
