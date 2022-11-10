package com.geometry;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //drawTriangle4(4, "*");
        System.out.println(addMargin("hola", 5));


    }

    public static String addMargin(String s, int marginLen) {
        char [] a = new char[s.length()];
        a = s.toCharArray();
        char [] aux = new char[s.length()+marginLen];
        aToB(aux, a);
        for (int j = 0; j<marginLen; j++) {
            for (int i = 0; i<s.length(); i++) {
                aux[i+1] = a[i];
            }
            aux[j] = ' ';
        }

        return String.valueOf(aux);
    }
    public static void drawTriangle4(int height, String c) {
        String s = "";
        for (int i = 0; i<height; i++) {
            s = enlarge(s, c);
            System.out.println(s);
        }
    }
/*
    public static String func(String s, int paddingLen) {
        char [] aux = new char[s.length()+paddingLen*2];
        for (int i = 0; i<paddingLen; i++) {

        }
    }
*/
    public static String enlarge(String s, String t) {
        char [] a = new char[s.length()];
        a = s.toCharArray();
        char [] aux = new char[s.length()+2];
        aToB(aux, a);

        for (int i = 0; i<s.length(); i++) {
            aux[i+1] = a[i];
        }
        aux[0] = t.charAt(0);
        aux[aux.length-1] = t.charAt(0);
        return String.valueOf(aux);

    }



    public static void minimize(String s, int x) {
        for (int i = 0; i<x; i++) {
            System.out.println(s);
            s = replace(s, ' ', i);
            s = replace(s, ' ', s.length()-1-i);
        }

    }

    public static void drawTriangle(int base, char c) {
        Map<Integer, String> miMap = new HashMap<>();
        String s = stringOf(c, base);
        for (int i = 0; i<(base/2)+1; i++) {
            miMap.put(i, s);
            s = replace(s, ' ', i);
            s = replace(s, ' ', s.length()-1-i);
        }
        for (int i = base/2; i>0; i--) {
            System.out.println(miMap.get(i));
        }
    }

    public static void aToB(char [] s, char [] t) {
        for (int i = 0; i<t.length; i++) {
            s[i] = t[i];
        }
    }


    public static void drawTriangle2(int base, char c) {
        Map<Integer, String> miMap = new HashMap<>();
        String s = stringOf(c, base);
        for (int i = 0; i<(base/2)+1; i++) {
            miMap.put(s.length()-1-i, s);

            s = replace(s, ' ', i);
            s = replace(s, ' ', s.length()-1-i);

        }

        for (int i = base/2; i<base; i++) {
            System.out.println(miMap.get(i));

        }
    }


    public static void drawTriangle3(int baseLen, char c) {
        Map<Integer, String> miMap = new HashMap<>();
        String s = stringOf(c, baseLen);
        for (int i = 0; i<baseLen; i++) {
            miMap.put(s.length()-1-i, s);

            s = replace(s, ' ', i);
            s = replace(s, ' ', s.length()-1-i);

        }
        System.out.println(miMap.size());

        //System.out.println(lines.get(4));
        //System.out.println(lines.get(lines.size() - lines.indexOf(l)));

    }

    public static String replace(String s, char c, int position) {
        char [] chars = new char[s.length()];
        chars = s.toCharArray();
        chars [position] = c;
        return String.valueOf(chars);
    }

    public static String stringOf(char c, int stringSize) {
        char [] chars = new char[stringSize];
        for (int i = 0; i<stringSize; i++) {

            chars[i] = c;
        }
        return String.valueOf(chars);

    }

    /*
    public static String maximize(String s) {
        char aux = s.charAt(0);
        char [] chars = new char[s.length()+2];
        for (int i = 0; i<s.length(); i++) {
            chars[i+1] = s.charAt(i);
        }
        chars [0] = aux;
        chars [s.length()-1] = aux;
        return String.valueOf(chars);
    }
    */

    public static void getArray(int [] array) {
        for (int i = 0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }

}