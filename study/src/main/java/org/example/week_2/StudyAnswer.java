package org.example.week_2;

import java.util.Arrays;

public class StudyAnswer {

    public static void main(String[] args) {
        //1.1 중복이 확인하는 알고리즘}

        System.out.println(isUnique("aacd"));

        boolean result = isPermutation("abcd", "dcba");
        System.out.println(result);

        char[] test = "Mr John Smith    ".toCharArray();
        replaceSpaces(test, 13);
        System.out.println(test);

        boolean result2 = isPermutationOfPalindrome("tact coa");
        System.out.println(result2); // true

        System.out.println(oneEditAway("pale","ple"));

        System.out.println(compressString("aabccccaaa"));

        int[][] init = new int[][] {{1,2},{4,5}};
        System.out.println(Arrays.deepToString(rotateMatrix(init)));
    }

    public static boolean isUnique(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c, i + 1) != -1) {
                return false;
            }
        }
        return true;
    }


    // 1-2
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false; // 두 문자열의 길이가 다르면 순열 관계일 수 없습니다.
        }

        int[] letters = new int[128]; // ASCII 코드를 가정합니다.

        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            letters[s2.charAt(i)]--;
            if (letters[s2.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }

    //1-3
    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index;

        // 공백의 개수를 계산합니다.
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        // '%20'을 넣을 공간을 확보하기 위해 인덱스를 계산합니다.
        index = trueLength + spaceCount * 2;

        // 공백을 '%20'으로 바꿉니다.
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    //1-4
    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int countOdd = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    //-----------------------------------------------------------

    //1-5
    public static boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0, index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    //1-6
    public static String compressString(String str) {
        StringBuilder builder = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                builder.append(str.charAt(i));
                builder.append(count);
                count = 1;
            }
        }

        String result = builder.toString();
        return result.length() < str.length() ? result : str;
    }

    //1-7
    public static int[][] rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }
}
