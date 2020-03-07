package main.java.excersices.wall;

public final class WallController {
    private WallController() {}

    public static boolean canWeBuildAWallOfSizeFrom(int availableBigBrick, int bigBrickSize, int availableSmallBrick,
                                                    int smallBrickSize, int wallSize) {
        int neededBB =  wallSize / bigBrickSize;
        int capacityFilledByBB = (Math.min(neededBB, availableBigBrick) * bigBrickSize);

        int neededSB = (wallSize - capacityFilledByBB) / smallBrickSize;
        int capacityFilledBySB = (Math.min(neededSB, availableSmallBrick) * smallBrickSize);

        int remainingUnfilledSize = wallSize - capacityFilledByBB - capacityFilledBySB;

        return neededBB <= availableBigBrick && neededSB <= availableSmallBrick && remainingUnfilledSize == 0;
    }
}
