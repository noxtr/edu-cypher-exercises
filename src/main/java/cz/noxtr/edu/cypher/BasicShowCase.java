package cz.noxtr.edu.cypher;

public class BasicShowCase {

    public static void stringIterate() {
        String alphabet = Cypher.ALPHABET;
        StringBuilder newString = new StringBuilder();
        String otherNonEffectiveWay="";
        for (int i = 0; i < alphabet.length(); i++) {
            //char on index
            char ch = alphabet.charAt(i);
            //append char to string
            newString.append(ch);
            //non effectiveWay how to appending string both are "almost" equals
            otherNonEffectiveWay = otherNonEffectiveWay + ch;
        }
        System.out.println(newString.toString());
        System.out.println(otherNonEffectiveWay);
    }

}
