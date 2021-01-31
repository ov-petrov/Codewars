public class CamelCase {
    public static String camelCase(String input) {
        if (input == null || input.isEmpty())
            return input;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i++) {
            builder.append(input.charAt(i));

            if (Character.isLowerCase(input.charAt(i)) && Character.isUpperCase(input.charAt(i + 1)))
                builder.append(" ");
        }
        builder.append(input.charAt(input.length() - 1));

        return builder.toString();
    }
}
