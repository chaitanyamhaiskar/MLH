
import java.util.Scanner;

class PasswordEncryption {

    static Scanner sc = new Scanner(System.in);
    static String generateKey(String string , String key) {
        int x = string.length();
        for (int i = 0; ; i++) {
            if (x == i)
                i = 0;
            if (key.length() == string.length())
                break;
            key += (key.charAt(i));
        }
        return key;
    }

    static String cipherText(String string,String key){
        String ct = "";
        for (int i=0;i<string.length();i++){
            // converting in range 0-25
            int x = (string.charAt(i) + key.charAt(i)) %26;

            // convert into alphabets(ASCII)
            x += 'A';

            ct+=(char)(x);
        }
        return ct;
    }
    static String originalText(String ct, String key){
        String org_text="";
        for (int i=0;i<ct.length() && i<key.length();i++){
            // converting in range 0-25
            int x = (ct.charAt(i) -
                    key.charAt(i) + 26) %26;

            // convert into alphabets(ASCII)
            x += 'A';
            org_text+=(char)(x);
        }
        return org_text;
    }

    static String LowerToUpper(String s)
    {
        StringBuffer str =new StringBuffer(s);
        for(int i = 0; i < s.length(); i++)
        {
            if(Character.isLowerCase(s.charAt(i)))
            {
                str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
        s = str.toString();
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String Str = "CHAITANYA";
//        String Keyword = "MAMBA";

        //  System.out.println(generateKey("chaita","mamba"));
//        System.out.println(originalText("OHMJTMNKB","MAMBAMAMB"));

        System.out.println("Enter Password");
        String Str = sc.next();
        System.out.println("Enter Key");
        String Key = sc.next();
        String key = generateKey(Str,Key);
        System.out.println("Encrypted password:"+cipherText(Str,key));
    }

}
