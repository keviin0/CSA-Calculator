package util;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class GoFishCard {


    public enum Suite {
        Spade, Club, Diamond, Heart;
        private static Suite[] suites = Suite.values();

        public static Suite getSuite(int i) {
            return Suite.suites[i];
        }
    }



}
