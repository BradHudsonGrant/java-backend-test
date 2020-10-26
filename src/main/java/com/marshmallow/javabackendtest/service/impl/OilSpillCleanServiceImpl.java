package com.marshmallow.javabackendtest.service.impl;

import com.marshmallow.javabackendtest.model.request.OilSpillRequest;
import com.marshmallow.javabackendtest.model.response.OilSpillResponse;
import com.marshmallow.javabackendtest.service.OilSpillCleanService;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;

@Service
public class OilSpillCleanServiceImpl implements OilSpillCleanService {

    public OilSpillResponse robotCleanCalculation(OilSpillRequest request){
        OilSpillResponse response = new OilSpillResponse();
        int[][] seaGrid = initialiseSeaGrid(request.getAreaSize(), request.getOilPatches());
        int[] currentPosition = request.getStartingPosition();
        int cleanedOilPatchesCount = 0;
        String directions = request.getNavigationInstructions();

        if(checkForOilPatch(seaGrid, currentPosition)){
            removeOil(seaGrid, currentPosition);
            cleanedOilPatchesCount++;
        }
        for(char ch: directions.toCharArray()) {
            moveRobot(String.valueOf(ch), currentPosition, request.getAreaSize());
            if(checkForOilPatch(seaGrid, currentPosition)){
                removeOil(seaGrid, currentPosition);
                cleanedOilPatchesCount++;
            }
        }
        response.setFinalPosition(currentPosition);
        response.setOilPatchesCleaned(cleanedOilPatchesCount);
        return response;
    }

    public int[][] initialiseSeaGrid(int[] areaSize, int[][] oilPatches){
        // Set 2d Array Size
        int areaSizeX = (areaSize[0]);
        int areaSizeY = (areaSize[1]);

        int[][] seaGrid = new int[areaSizeX][areaSizeY];

        // Add oil patches to grid
        for (int[] oilPatch : oilPatches) {
            if(oilPatch[0]>areaSizeX || oilPatch[1]>areaSizeY){
                throw new ArrayIndexOutOfBoundsException("Oil Patch outside of sea grid");
            }
            seaGrid[(oilPatch[0])][(oilPatch[1])] = 1;
        }
        return seaGrid;
}

    public int[] moveRobot(String direction, int[] currentPosition, int[] areaSize){
        if (!direction.equals("N") && !direction.equals("S") && !direction.equals("E") && !direction.equals("W")){
            throw new InputMismatchException("Invalid direction");
        }
        switch (direction) {
            case "N":
                // Y axis +1
                if (currentPosition[1] != areaSize[1]) {
                    currentPosition[1]++;
                    return currentPosition;
                } else {
                    throw new ArrayIndexOutOfBoundsException("Movements go out of sea area");
                }
            case "S":
                // Y axis +1
                if (currentPosition[1] != 0) {
                    currentPosition[1]--;
                    return currentPosition;
                } else {
                    throw new ArrayIndexOutOfBoundsException("Movements go out of sea area");
                }
            case "E":
                // X axis +1
                if (currentPosition[0] != areaSize[0]) {
                    currentPosition[0]++;
                    return currentPosition;
                } else {
                    throw new ArrayIndexOutOfBoundsException("Movements go out of sea area");
                }
            case "W":
                // X axis -1
                if (currentPosition[0] != 0) {
                    currentPosition[0]--;
                    return currentPosition;
                } else {
                    throw new ArrayIndexOutOfBoundsException("Movements go out of sea area");
                }
        }
        return currentPosition;
    }

    public boolean checkForOilPatch(int[][] seaGrid, int[] currentPosition){
        return seaGrid[currentPosition[0]][currentPosition[1]] == 1;
    }

    public void removeOil(int[][] seaGrid, int[] currentPosition){
        seaGrid[currentPosition[0]][currentPosition[1]] = 0;
    }
}
