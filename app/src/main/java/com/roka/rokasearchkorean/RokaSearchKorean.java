package com.roka.rokasearchkorean;

/**
 * Created by roka on 2016. 10. 7..
 */

public class RokaSearchKorean {

    private final char[] CHOSUNG = {
            0xAC00, 0xAE4C, ' ', 0xB098, ' ', ' ', 0xB2E4, 0xB530, 0xB77C, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 0xB9C8,
            0xBC14, 0xBE60, ' ', 0xC0AC, 0xC2F8, 0xC544, 0xC790, 0xC9DC, 0xCC28, 0xCE74, 0xD0C0, 0xD30C, 0xD558};


    public boolean speedHangleCheck(String searchChar, String hangle) {
        // TODO : 찾으려는 초성이나 문자가 들어간 문자열이 맞는지 빠르게 검색하여 확인한다.
        String deletedTrim = searchChar.trim();
        if (deletedTrim.length() > hangle.length())
            return false;
        if (hangle.matches(".*"+searchChar.toString()+".*"))
            return true;
        boolean checkString = true;
        int i = 0, j = deletedTrim.length() - 1;
        int stringLength = (j % 2 == 0) ? j / 2 : j / 2 + 1;
        for (; i <= stringLength; i++, j--) {
            checkString = checkString && _getCheckCollect(searchChar.charAt(i), hangle.charAt(i))
                    && _getCheckCollect(searchChar.charAt(j), hangle.charAt(j));
            if (!checkString) return false;
        }
        return checkString;
    }

    private boolean _getCheckCollect(char searchChar, char oneChar) {
        // TODO : 문자하나의 범위를 이용하여 맞는지 안맞는지 확인
        boolean checkText = false; // 기본 문자도아니고 초성도아닐 때
        char range;
        if (0xAC00 <= searchChar && searchChar < 0xD7A4) { // 문자
            range = _getHangleRange(searchChar);
            checkText = (range <= oneChar && oneChar < range + 0x1c);
        } else if (0x3131 <= searchChar && searchChar < 0x314F) { // 초성일 때
            range = _getChosungRange(searchChar);
            checkText = (range <= oneChar && oneChar < range + 0x24c);
        } else if (searchChar == 0x20 && searchChar == oneChar) { // 공백
            checkText = true;
        }
        return checkText;
    }

    private char _getHangleRange(char searchChar) {
        // TODO : 한글이 주어졌을 때 범위 찾는다 . 초성+중성 일 때 범위 searchChar <= searchCHar < searchChar+28
        return searchChar;
    }

    private char _getChosungRange(char chosung) {
        // TODO : 초성이 주어졌을 때 한글 문자 하나의 범위를 얻는다. '가' 종류 일 때 44032 ~ 44520
        // ㄱ일 때 44032 ~ 44520
        int base = chosung - 0x3131;
        return CHOSUNG[base];
    }
}
