public class Main {


    public static String reverse(int num) {
        if (num == 0) {
            return "";
        }
        return (num % 10) + " " + reverse(num / 10);
    }

    public static String WriteLine(char ch, int count) {

        if (count == 0) {
            return "";
        }

        return String.valueOf(ch) + WriteLine(ch, count - 1);
    }


    public static String WriteBlock(char ch, int count, int lines) {
        if (lines == 0) {
            return "";
        }

        return WriteLine(ch, count) + "\n" + WriteBlock(ch, count, lines - 1);
    }


    public static String reverseArray(String[] strArr) {
        if (strArr.length == 0) {
            return "";
        }
        String[] nextArr = new String[strArr.length - 1];
        for (int i = 0; i < nextArr.length; i++) {
            nextArr[i] = strArr[i];
        }

        return strArr[strArr.length - 1] + reverseArray(nextArr);
    }

    public static void main(String args[]) {
        String[] arr = {"a", "b", "c", "d", "e"};
        System.out.println(reverse(527));
        System.out.println(WriteLine('*', 5));
        System.out.println(WriteBlock('B', 5, 3));
        System.out.println(reverseArray(arr));
    }


}
