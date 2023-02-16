package Util;

public class StringParserForDescriptionTextArea {
    public static String parseString(String input)
    {
        int maxLength = 40;
        StringBuilder output = new StringBuilder(" ");
        String[] words = input.split(" ");
        int lineLength = 0;
        for (String word : words) {
            if (lineLength + word.length() > maxLength) {
                output.append("\n ");
                lineLength = 0;
            }
            output.append(word + " ");
            lineLength += word.length() + 1;
        }
        output.deleteCharAt(output.length()-1);
        if(!output.toString().contains(".")) output.append(".");
        return output.toString();
    }
}
