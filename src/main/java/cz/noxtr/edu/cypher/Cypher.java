package cz.noxtr.edu.cypher;

public interface Cypher {

    String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String encode(String plainText, String secret);

    String decode(String cypherText, String secret);

}
