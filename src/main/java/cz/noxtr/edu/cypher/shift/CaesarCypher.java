package cz.noxtr.edu.cypher.shift;

import cz.noxtr.edu.cypher.Cypher;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class CaesarCypher implements Cypher {

    public String encode(String plainText, String secret) {
        if (!NumberUtils.isDigits(secret)) {
            throw new NumberFormatException("Invalid secret, must be number");
        }
        if (StringUtils.isBlank(plainText)) {
            throw new IllegalStateException("plain text cannot be blank");
        }
        plainText = plainText.toUpperCase();
        int shift = Integer.parseInt(secret);

        Map<Character, Character> encodeMap = createShiftMap(shift);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            result.append(encodeMap.get(plainText.charAt(i)));
        }

        return result.toString();
    }

    public String decode(String cypherText, String secret) {
        if (!NumberUtils.isDigits(secret)) {
            throw new NumberFormatException("Invalid secret, must be number");
        }
        if (StringUtils.isBlank(cypherText)) {
            throw new IllegalStateException("cypher text cannot be blank");
        }
        cypherText = cypherText.toUpperCase();
        int shift = Integer.parseInt(secret);

        Map<Character, Character> decodeMap = MapUtils.invertMap(createShiftMap(shift));

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cypherText.length(); i++) {
            result.append(decodeMap.get(cypherText.charAt(i)));
        }

        return result.toString();

    }

    private Map<Character, Character> createShiftMap(int shift) {
        Map<Character, Character> map = new HashMap<>();
        int alphabetLength = Cypher.ALPHABET.length();
        for (int i = 0; i < alphabetLength; i++) {
            char current = Cypher.ALPHABET.charAt(i);
            char shifted = Cypher.ALPHABET.charAt((i + shift) % alphabetLength);
            map.put(current, shifted);
        }
        return map;
    }
}
