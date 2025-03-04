package com.pedropathing.pathgen;

import com.pedropathing.localization.Pose;

public class SafeInterpolationStartHeading {
    private final double value;

    public SafeInterpolationStartHeading(Pose startPose, Pose endPose) {
        double startHeading = startPose.getHeading();
        double endHeading = endPose.getHeading();
        this.value = startHeading
                - 0.1
                * MathFunctions.getTurnDirection(startHeading, endHeading)
                * MathFunctions.getSmallestAngleDifference(startHeading, endHeading);
    }

    public SafeInterpolationStartHeading(double startHeading, Pose endPose) {
        double endHeading = endPose.getHeading();
        this.value = startHeading
                - 0.1
                * MathFunctions.getTurnDirection(startHeading, endHeading)
                * MathFunctions.getSmallestAngleDifference(startHeading, endHeading);
    }

    public SafeInterpolationStartHeading(Pose startPose, double endHeading) {
        double startHeading = startPose.getHeading();
        this.value = startHeading
                - 0.1
                * MathFunctions.getTurnDirection(startHeading, endHeading)
                * MathFunctions.getSmallestAngleDifference(startHeading, endHeading);
    }

    public SafeInterpolationStartHeading(double startHeading, double endHeading) {
        this.value = startHeading
                - 0.1
                * MathFunctions.getTurnDirection(startHeading, endHeading)
                * MathFunctions.getSmallestAngleDifference(startHeading, endHeading);
    }

    public double getValue() {
        return value;
    }
}