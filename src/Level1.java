public class Level1 {
    public static String stringLength (String text) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') continue;
            else
                newString.insert(newString.length(), text.charAt(i));
        }

        return newString.toString();
    }

    public static char [][] matrixLength (String text) {
        int stringLength = stringLength(text).length();
        double sqrt = Math.sqrt(stringLength);
        int x = (int)sqrt;
        int y = (int)(sqrt * 10) - x * 10;
        if (x * y < stringLength)
            x++;

        char[][] matrix = new char[x][y];

        return matrix;
    }


    public static String finalStringTrue (char[][] matrix, String text) {
        int f = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int z = 0; z < matrix[0].length; z++, f++) {
                if (f >= stringLength(text).length())
                    matrix[i][z] = ' ';
                else
                    matrix[i][z] = stringLength(text).charAt(f);
            }
        }

        StringBuilder finalString = new StringBuilder();
        for (int x = 0; x < matrix[0].length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                if (matrix[y][x] == ' ') break;
                finalString.insert(finalString.length(), matrix[y][x]);
            }
            if (x != matrix[0].length - 1)
                finalString.insert(finalString.length(), " ");
        }
        return finalString.toString(); // кодировка
    }

    public static String finalStringFalse (char[][] matrix, String text) {
        int f = 0;
            for (int x = 0; x < matrix[0].length; x++) {
                for (int y = 0; y < matrix.length; y++, f++) {
                    if (f >= text.length()) {
                        matrix[y][x] = ' ';
                    } else
                        if (text.charAt(f) == ' ' && y < matrix.length - 1) {
                        y--;
                    } else
                        matrix[y][x] = text.charAt(f);
                }
            }

        StringBuilder finalString = new StringBuilder();
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (y < matrix[0].length - 1 && matrix[x][y] == ' ') break;
                else
                    finalString.insert(finalString.length(), matrix[x][y]);
            }
        }
        return finalString.toString();
    }

    public static String TheRabbitsFoot(String s, boolean encode) {
        if (encode)
            return finalStringTrue(matrixLength(s), s);
        else
            return finalStringFalse(matrixLength(s), s);
    }

}
