package com.geometry;

import java.util.*;
import java.util.List;

public class Main {

    // Clean console
    public static final String CLEAN_CONSOLE = "\033[H\033[2J";

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

    public static final String[] colors = new String[] {GREEN_BOLD_BRIGHT, GREEN_BOLD_BRIGHT, GREEN_BOLD_BRIGHT, CYAN_BOLD_BRIGHT, PURPLE_BOLD_BRIGHT, YELLOW_BOLD_BRIGHT, RED_BOLD_BRIGHT, BLUE_BOLD_BRIGHT, WHITE_BOLD_BRIGHT};
    public static final Random rand = new Random();


    public static void main(String[] args) {
        waterTree(40);
    }

    public static void waterChristmasTree(int maxHeight) {
        for (int i = 1; i < maxHeight; i++) {
            drawChristmasTree(i, "*", "|", BLACK_BOLD_BRIGHT);
            sleep(100);
            cleanConsole();
        }
    }

    public static void waterTree(int maxHeight) {
        for (int i = 1; i < maxHeight; i++) {
            drawTree(i, "*", "|", GREEN, BLACK_BOLD_BRIGHT);
            sleep(100);
            cleanConsole();
        }
    }

    public static void drawChristmasTree(int height, String leavesChar, String trunkChar, String trunkColor) {
        drawColorfulTriangle(height, leavesChar);
        drawVRectangle(height, trunkChar, trunkColor, (height*2)/3);
    }

    public static void drawVRectangle(int height, String trunkChar, String trunkColor, int baseLen) {
        for (int i = 0; i<(height/2); i++) {
            System.out.println(trunkColor+addMargin(stringOf(trunkChar, baseLen), height-(baseLen/2)));
        }
    }
    public static void drawTree(int height, String leavesChar, String trunkChar, String leavesColor, String trunkColor) {
        drawTriangle(height, leavesChar, leavesColor);
        drawVRectangle(height, trunkChar, trunkColor, (height*2)/3);
    }

    public static void drawDefaultTree(int height, String leavesChar, String trunkChar) {
        drawTriangle(height, leavesChar, GREEN);
        drawVRectangle(height, trunkChar, BLACK_BOLD_BRIGHT, (height*2)/3);
    }



    public static void drawTriangle(int height, String c, String color) {
        //Nota: height = base/2
        //uses method enlarge which adds a character at first and last position: "*", "*,*,*"
        String s = c;
        for (int i = 0; i<height; i++) {
            System.out.println(color+addMargin(s, height-i-1)); // Le doy un margen a la izquierda
            s = enlarge(s, c); // Alargo string ("*") por ambos lados
        }
    }

    public static void drawColorfulTriangle(int height, String c) {
        String a = c;
        for (int i = height; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            if (i == height) {
                System.out.println(a);
            } else {
                System.out.println(a += colors[rand.nextInt(colors.length)]+c+colors[rand.nextInt(colors.length)]+c);
            }
        }
    }

    public static void drawTriangle3(int height) {
        String a = "*";
        for (int i = height; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            if (i == height) {
                System.out.println(a);
            } else {
                System.out.println(a += "**");
            }
        }
    }


    public static void drawTriangle2(int base, String c) {
        //Nota: height = base/2
        //contains "*****" and replaces first and last position with " "
        List<String> filas = new ArrayList<>();
        String s = stringOf(c, base);
        for (int i = 0; i<(base/2)+1; i++) {
            filas.add(0, s);
            s = replace(s, ' ', i);
            s = replace(s, ' ', s.length()-1-i);
        }
        for (var fila: filas) {
            System.out.println(fila);
        }
        //filas.stream().forEach(System.out::println);
    }

    public static String enlarge(String s, String t) {
        char [] a = s.toCharArray();
        //a = ['h', 'o', 'l', 'a']
        char [] aux = new char[s.length()+2];
        aToB(aux, a); //Meto en aux lo que contiene a
        //aux = ['h', 'o', 'l', 'a', 'null', 'null']

        for (int i = 0; i<s.length(); i++) {
            aux[i+1] = a[i];
        }
        //aux = ['h', 'h', 'o', 'l', 'a', 'null']

        aux[0] = t.charAt(0);
        //aux = ['*', 'h', 'o', 'l', 'a', 'null']
        aux[aux.length-1] = t.charAt(0);
        //aux = ['*', 'h', 'o', 'l', 'a', '*']

        return String.valueOf(aux);

    }

    public static String addMargin(String x, int marginLen) {
        char [] spaces =  stringOf(" ", marginLen).toCharArray();//spaces = [' ', ' ', ' ', ' ']
        char [] word = x.toCharArray();                             //word = ['h', 'o', 'l', 'a']
        char [] target = new char[spaces.length+word.length];       //objetivo: [' ', ' ', ' ', ' ', 'h', 'o', 'l', 'a']

        for (int i = 0; i<spaces.length; i++) {
            target[i] = spaces[i]; //meto espacios
        }

        for (int i = 0; i<word.length; i++) {
            target[i+spaces.length] = word[i]; //meto letras
        }
        // "    hola"
        return String.valueOf(target);
    }

    public static void minimize(String s, int x) {
        for (int i = 0; i<x; i++) {
            System.out.println(s);
            s = replace(s, ' ', i);
            s = replace(s, ' ', s.length()-1-i);
        }

    }
    public static void aToB(char [] s, char [] t) {
        for (int i = 0; i<t.length; i++) {
            s[i] = t[i];
        }
    }

    public static void drawTriangle3(int baseLen, String c) {
        Map<Integer, String> miMap = new HashMap<>();
        String s = stringOf(c, baseLen);
        for (int i = 0; i<baseLen; i++) {
            miMap.put(s.length()-1-i, s);

            s = replace(s, ' ', i);
            s = replace(s, ' ', s.length()-1-i);

        }
        System.out.println(miMap.size());
    }

    public static String replace(String s, char c, int position) {
        char [] chars = new char[s.length()];
        chars = s.toCharArray();
        chars [position] = c;
        return String.valueOf(chars);
    }

    public static String stringOf(String c, int stringSize) {
        char [] chars = new char[stringSize];
        for (int i = 0; i<stringSize; i++) {

            chars[i] = c.charAt(0);
        }
        return String.valueOf(chars);

    }

    public static void getArray(Object [] array) {
        for (int i = 0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void cleanConsole() {
        System.out.println(CLEAN_CONSOLE);
    }

    public static void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}