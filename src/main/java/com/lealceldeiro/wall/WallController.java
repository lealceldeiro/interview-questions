package com.lealceldeiro.wall;

public final class WallController {
    private WallController() {
    }

    /**
     * Given a "BigBrick" of size 5 meters and a "SmallBrick" of size 1 meter, a given "WallSize" can be constructed by
     * using zero, one or more big brick and zero, one or more small brick.
     * <p>
     * So, given the number of available big bricks and small bricks, can we construct a wall of a given size in meters?
     *
     * @param availableBigBrick   Number of available big bricks
     * @param availableSmallBrick Number of available small bricks
     * @param wallSize            Size of the wall to construct
     *
     * @return {@code true} if the wall can be constructed, {@code false} otherwise.
     */
    public static boolean canWeBuildAWallOfSizeFrom(int availableBigBrick, int availableSmallBrick, int wallSize) {
        int neededBB = wallSize / 5;
        int capacityFilledByBB = (Math.min(neededBB, availableBigBrick) * 5);

        int neededSB = wallSize - capacityFilledByBB;
        int capacityFilledBySB = Math.min(neededSB, availableSmallBrick);

        int remainingUnfilledSize = wallSize - capacityFilledByBB - capacityFilledBySB;

        return neededBB <= availableBigBrick && neededSB <= availableSmallBrick && remainingUnfilledSize == 0;
    }

    /**
     * Given the size of a "BigBrick" (BB) and the size of a "SmallBrick" (SB), a given
     * "WallSize" can be constructed by using zero, one or more BB and zero, one or more SB.
     * <p>
     * So, given the size of the BB and SM, how many BBs and SBs we need to construct a wall of a given size in meters?
     * <p>
     * Assume BB have priority to be used over SM.
     *
     * @param bigBrickSize   Size of the BBs
     * @param smallBrickSize Size of the SBs
     * @param wallSize       Size of the wall to construct
     *
     * @return An array of {@code int} with two elements. The first element is the number of required BBs to
     * construct the wall and second element is the number of SBs required to construct the wall. If there is no
     * possible combination to construct the wall then [-1, -1] is returned.
     */
    public static int[] getNumberOfRequiredBricksToBuildAWallOfSize(int bigBrickSize, int smallBrickSize, int wallSize) {
        if (wallSize == 0) { return new int[]{0, 0}; }

        int numberOfBB = wallSize / bigBrickSize;
        var remainingToBuild = wallSize - numberOfBB * bigBrickSize;
        int numberOfSB = remainingToBuild / smallBrickSize;
        remainingToBuild -= numberOfSB * smallBrickSize;

        var noCombination = new int[]{-1, -1};
        if (numberOfBB == 0 && numberOfSB == 0) { return noCombination; }

        while (remainingToBuild > 0 && remainingToBuild % smallBrickSize != 0) {
            if (numberOfBB > 0) {
                remainingToBuild += bigBrickSize;
                numberOfBB--;
            }
            numberOfSB++;
            remainingToBuild -= smallBrickSize;
        }
        return remainingToBuild >= 0
               ? new int[]{numberOfBB, numberOfSB + remainingToBuild / smallBrickSize}
               : noCombination;
    }
}
