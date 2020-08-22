public class Activity1 {
    public static void main(String args[]) {
        String str = "abdulrehmana arifb";
        System.out.println(str);
        System.out.println(str.length());
        String[] parts = str.split(" ", 2);
        String firstName = parts[0];
        String lastName = parts[1];
        String str2 = (lastName + ", " + firstName);
        System.out.println(str2);

        // Creating array of string length
        char[] ch = new char[firstName.length()];
        char[] ch2 = new char[lastName.length()];
        // Copy character by character into array
        for (int i = 0; i < firstName.length(); i++) {
            ch[i] = firstName.charAt(i);
        }
        for (int i = 0; i < lastName.length(); i++) {
            ch2[i] = lastName.charAt(i);
        }
        System.out.println(ch2[lastName.length() - 1]);
        for (int i = 0; i < firstName.length(); i++) {
            if (ch[i] == ch2[lastName.length() - 1]) {
                int index = i-1;
                System.out.println(index+ " is the index of the first occurrence of the last character of your lastname in your firstname.");
            }
        }
        for (int i = 0; i < lastName.length(); i++) {
            if (ch2[i] == ch[firstName.length() - 1]) {
                int index = i-1;
                System.out.println(index+ " is the index of the last occurrence of the first character of your lastname in your firstname.");
            }
        }
        ch[0] = (char) (firstName.charAt(0) -32);
        ch2[0] = (char) (lastName.charAt(0) - 32);
        for (int i = 0; i < firstName.length(); i++) {
            System.out.print(ch[i]);
        }
        System.out.print(" ");
        for (int i = 0; i < lastName.length(); i++) {
            System.out.print(ch2[i]);
        }
    }
}
