package DesignPatterns.Structural.Decorator;

import java.util.ArrayList;
import java.util.List;

public class ReportUtil {

    public static String getLinedText(String text) {
        String[] lineList = text.split("\n");

        String linedText = "";
        StringBuilder sb;
        for (String line : lineList) {

            char ch = '-';
            sb = new StringBuilder(line);
            sb.insert(0, ch);
            String updated = sb.toString();
            linedText += updated + "\n";
        }
        return linedText;
    }


    public static String fitText(String text, int width) {
        String[] lineList = text.split("\n");
        String fittedText = "";

        for (String line : lineList) {
            if (line.length() < width) {
                fittedText = addPassNewLine(fittedText, line);
            } else {
                // Dividing Text
                List<String> dividedText = divideText(line, width);
                for (String s : dividedText) {
                    fittedText = addPassNewLine(fittedText, s);
                }
            }

        }
        return fittedText;
    }


    private static String addPassNewLine(String mainText, String addedText) {
        return mainText + addedText + "\n";
    }

    /**
     * 1- 45 -> (30,15)
     * 2- 25 -> 25
     * 3- 65 -> (30,30,5)
     *
     * @param line
     * @param width
     * @return
     */
    private static List<String> divideText(String line, int width) {
        List<String> dividedText = new ArrayList<String>();
        for (int i = 0; i <= line.length() / width; i++) {
            int piece = i * width;
            int lastPiece = piece + width;

            if (lastPiece > line.length()) {
                lastPiece = line.length();
            }

            String text = line.substring(piece, lastPiece);

            if (text.trim().length() > 0)
                dividedText.add(text);
        }
        return dividedText;
    }

    public static String signedText(String text) {
        String sign = "\n\n\t\t\t\t\t Sign:Muharrem Aslan";
        return text + sign;
    }
}
