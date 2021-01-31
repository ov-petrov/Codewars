public class Abbreviator {
    public static String abbreviate(String string) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (char current : string.toCharArray()) {
            if (Character.isAlphabetic(current))
                word.append(current);
            else {
                result.append(abbrWord(word.toString()))
                        .append(current);
                word = new StringBuilder();
            }
        }
        result.append(abbrWord(word.toString()));

        return result.toString();
    }

    private static String abbrWord(String word) {
        if (word.length() < 4)
            return word;

        return word.charAt(0) +
                Integer.toString(word.length() - 2) +
                word.charAt(word.length() - 1);

    }
}
