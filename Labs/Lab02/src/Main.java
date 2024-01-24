import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main (String[] args) {
        String[] testArray = {"catcat", "no", "cat", "dogcat"};
        String testString = "cat";

        System.out.println(findLongest(testArray));
        System.out.println(countSubstring(testArray, testString));
        removeSubstring(testArray, testString);
        System.out.println(Arrays.toString(testArray));
        System.out.println(Arrays.toString(removeDup(testArray)));
    }


    public static int findLongest (String[] strArr) {
        int longestStringIndex = 0;
        int longestStringLength = 0;
        for(int i = 0; i < strArr.length; i++) {

            if(strArr[i].length() > longestStringLength) {
                longestStringLength = strArr[i].length();
                longestStringIndex = i;
            }
        }
        return longestStringIndex;
    }

    public static int countSubstring (String[] strArr, String str) {
        int count = 0;

        for(int i = 0; i < strArr.length; i++) {

            if (strArr[i] == str) {
                count++;

            }
        }

        return count;
    }

    public static void removeSubstring (String[] strArr, String str) {

        for (int i = 0; i < strArr.length; i++) {

            if (strArr[i].contains(str)) {
                strArr[i] = strArr[i].replace(str, "");
            }

        }


    }







    public static String[] removeDup (String[] strArr) {

        String[] newArr = new String[strArr.length];
        int removeCount = 0;

        for (int i=0; i < strArr.length; i++) {
            boolean duplicate = false;
            for (int j = 0; j < i; j++) {
                if (strArr[i].equals(newArr[j])) {
                    duplicate = true;
                }
            }

            if (!duplicate) {
                newArr[i] = strArr[i];
            }
        }

        // remove all null values


        int countNull = 0;
        for (String str : newArr) {
            if (str == null) {
                countNull++;
            }
        }

        String[] newArr2 = new String[newArr.length - countNull];

        int newIndex = 0;
        for (String str : newArr) {
            if (str != null) {
                newArr2[newIndex] = str;
                newIndex++;
            }
        }

        return newArr2;



    }

}
