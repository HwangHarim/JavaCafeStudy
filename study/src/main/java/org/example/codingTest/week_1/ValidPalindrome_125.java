package org.example.codingTest.week_1;
import java.lang.StringBuilder;
public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        String s_filtered = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();

        return s_filtered.equals(s_reversed);
    }
}
