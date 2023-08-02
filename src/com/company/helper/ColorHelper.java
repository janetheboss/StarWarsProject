//package com.company.helper;
//
//import com.company.jedi.Jedi;
//import com.company.universe.Universe;
//import com.company.jedi.JediLightSaberColor;
//import com.company.jedi.JediRank;
//
//import java.util.HashSet;
//
//public class ColorHelper {
//    private static ColorHelper instance = null;
//
//    private ColorHelper() {
//    }
//
//    public static ColorHelper getInstance() {
//        if (instance == null) {
//            instance = new ColorHelper();
//        }
//        return instance;
//    }
//
//    public String getMostUsedSaberColor(String[] args) {
//        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
//        int greenCounter = 0, blueCounter = 0, yellowCounter = 0, purpleCounter = 0, redCounter = 0, cyanCounter = 0, whiteCounter = 0, orangeCounter = 0;
//        int max = 0;
//        String planetName = args[0];
//        for (Jedi jedi : jedis) {
//            if(jedi.getPlanet().getPlanetName().equalsIgnoreCase(planetName))
//            {
//            if (jedi.getRank().equalsIgnoreCase(JediRank.GRAND_MASTER.name())) {
//                if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Blue.name())) {
//                    blueCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Cyan.name())) {
//                    cyanCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Orange.name())) {
//                    orangeCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Red.name())) {
//                    redCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Green.name())) {
//                    greenCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.White.name())) {
//                    whiteCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Yellow.name())) {
//                    yellowCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Purple.name())) {
//                    purpleCounter += 1;
//                }
//            }
//            }
//        }
//        int[] counters = {greenCounter, blueCounter, yellowCounter, purpleCounter, redCounter, cyanCounter, whiteCounter, orangeCounter};
//        int maxIndex = 0;
//
//        for (int i = 1; i < counters.length; i++) {
//            if (counters[i] > counters[maxIndex]) {
//                maxIndex = i;
//            }
//        }
//
//        String highestColor = "";
//        switch (maxIndex) {
//            case 0:
//                highestColor = "Green";
//                break;
//            case 1:
//                highestColor = "Blue";
//                break;
//            case 2:
//                highestColor = "Yellow";
//                break;
//            case 3:
//                highestColor = "Purple";
//                break;
//            case 4:
//                highestColor = "Red";
//                break;
//            case 5:
//                highestColor = "Cyan";
//                break;
//            case 6:
//                highestColor = "White";
//                break;
//            case 7:
//                highestColor = "Orange";
//                break;
//        }
//
//        String result = "The color with the highest counter is " + highestColor;
//        System.out.println(result);
//        return result;
//    }
//    public String getMostUsedSaberColorWithRank(String[] args) {
//        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
//        int greenCounter = 0, blueCounter = 0, yellowCounter = 0, purpleCounter = 0, redCounter = 0, cyanCounter = 0, whiteCounter = 0, orangeCounter = 0;
//        int max = 0;
//        String planetName = args[0];
//        String rank = args[1];
//        for (Jedi jedi : jedis) {
//            if(jedi.getPlanet().getPlanetName().equalsIgnoreCase(planetName)){
//            if (jedi.getRank().equalsIgnoreCase(rank)) {
//                if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Blue.name())) {
//                    blueCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Cyan.name())) {
//                    cyanCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Orange.name())) {
//                    orangeCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Red.name())) {
//                    redCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Green.name())) {
//                    greenCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.White.name())) {
//                    whiteCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Yellow.name())) {
//                    yellowCounter += 1;
//                } else if (jedi.getSaber_color().equalsIgnoreCase(JediLightSaberColor.Purple.name())) {
//                    purpleCounter += 1;
//                }
//                }
//
//            }
//        }
//        int[] counters = {greenCounter, blueCounter, yellowCounter, purpleCounter, redCounter, cyanCounter, whiteCounter, orangeCounter};
//        int maxIndex = 0;
//
//        for (int i = 1; i < counters.length; i++) {
//            if (counters[i] > counters[maxIndex]) {
//                maxIndex = i;
//            }
//        }
//
//        String highestColor = "";
//        switch (maxIndex) {
//            case 0:
//                highestColor = "Green";
//                break;
//            case 1:
//                highestColor = "Blue";
//                break;
//            case 2:
//                highestColor = "Yellow";
//                break;
//            case 3:
//                highestColor = "Purple";
//                break;
//            case 4:
//                highestColor = "Red";
//                break;
//            case 5:
//                highestColor = "Cyan";
//                break;
//            case 6:
//                highestColor = "White";
//                break;
//            case 7:
//                highestColor = "Orange";
//                break;
//        }
//
//        String result = "The color with the highest counter is " + highestColor;
//        System.out.println(result);
//        return result;
//    }
//}
