package com.pedropathing.pathgen;

import com.pedropathing.localization.Pose;

public class SafePoint extends Point{
    private static double frontLength = 0;

    /**
     * Set the front length of the robot chassis.
     *
     * @param fL front length of the robot chassis
     */
    public static void setFrontLength(double fL) {
        frontLength = fL;
    }

    /**
     * Get the front length of the robot chassis.
     *
     * @return front length of the robot chassis
     */
    public static double getFrontLength() {
        return frontLength;
    }

    public SafePoint(Point Previous, Point Final) {
        super(0, 0);

        double distance = MathFunctions.distance(Final, Previous);

        double x = Final.getX()
                + MathFunctions.getSign(
                        Previous.getX()
                        - Final.getX())
                * Math.abs(
                        Previous.getX()
                        - Final.getX())
                * frontLength
                / distance;

        double y = Final.getY()
                + MathFunctions.getSign(
                        Previous.getY()
                        - Final.getY())
                * Math.abs(
                        Previous.getY()
                        - Final.getY())
                * frontLength
                / distance;

        setCoordinates(x, y, Point.CARTESIAN);
    }

    public SafePoint(Point Previous, Pose Final) {
        super(0, 0);

        double distance = MathFunctions.distance(Final, Previous);

        double x = Final.getX()
                + MathFunctions.getSign(
                Previous.getX()
                        - Final.getX())
                * Math.abs(
                Previous.getX()
                        - Final.getX())
                * frontLength
                / distance;

        double y = Final.getY()
                + MathFunctions.getSign(
                Previous.getY()
                        - Final.getY())
                * Math.abs(
                Previous.getY()
                        - Final.getY())
                * frontLength
                / distance;

        setCoordinates(x, y, Point.CARTESIAN);
    }
}
