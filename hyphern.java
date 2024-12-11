public class hyphern {
    static void moveSpaceInFront(char[] str) {
        int i = str.length - 1;
        for (int j = i; j >= 0; j--) {
            if (str[j] != '-') {
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        // String s = "Code- 4 -lyf";
        // char[] str = s.toCharArray();
        // moveSpaceInFront(str);
        String str = "Code- 4 -lyf";

        // Move all hyphens to the beginning
        String res = str.replaceAll("[-]","")+str.replaceAll("[^-]","");

        // Print the result
        System.out.println(res);
    }
}
