package hr4j;

import java.lang.Math;

public class Lib {
    public static String getHorizontalRule(String title, int length, String border, String filler) {
        String reversedBorder = new StringBuilder(border).reverse().toString();
        if (title.isEmpty()) {
            int fillerLength = Math.max(length - 2 - 2 * border.length(), 1);
            return String.format("%s %s %s", border, filler.repeat(fillerLength), reversedBorder);
        }
        int fillerLength = Math.max(length - 4 - title.length() - 2 * border.length(), 2);
        int sideFillerLength = Math.ceilDiv(fillerLength, 2);
        String sideFiller = filler.repeat(sideFillerLength);
        return String.format("%s %s %s %s %s", border, sideFiller, title, sideFiller,
                reversedBorder);
    }
}
