package com.java.learningSeries.modernjavainaction;

import com.java.learningSeries.modernjavainaction.auxiliaryclasses.Apple;

import java.awt.*;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Fundamentals {

    public void methodReferences() {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        File[] hiddenFilesRefference = new File(".").listFiles(File::isHidden);
    }

    //-----------------------------------------------------------------------------------------

    public static boolean isGreenApple(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    static void useIt() {
        List<Apple> inventory = new ArrayList<>();
        filterApples(inventory, Fundamentals::isGreenApple);
        filterApples(inventory, Fundamentals::isHeavyApple);
    }

    //-----------------------------------------------------------------------------------------

}
