package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.exercise;

class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("Warning: This is an old feature and should not be used.");
    }

    public void newFeature() {
        System.out.println("This is the new recommended feature.");
    }
}

public class DeprecatedDemo {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        // Calling the deprecated method (Compiler warning expected)
        api.oldFeature();

        // Calling the new method
        api.newFeature();
    }
}
