package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    private final String text;

    public ReversedSequence(String text) {
        var charArrays = invertCharArrays(text.toCharArray());
        text = charArrayToString(charArrays);
        this.text = text;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int i) {
        return text.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return text.substring(i, i1);
    }

    @Override
    public String toString() {
        return this.text;
    }

    public static char[] invertCharArrays(char[] arr) {
        char[] res = new char[arr.length];
        var length = arr.length % 2 == 0 ? arr.length / 2 : (arr.length - 1) / 2;
        for (var i = 0; i < length; i++) {
            var temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

    public static String charArrayToString(char[] arr) {
        StringBuilder res = new StringBuilder();
        for (char c : arr) {
            res.append(c);
        }
        return res.toString();
    }
}
// END
