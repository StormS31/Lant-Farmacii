package Util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PassEncryption
{
    private static final String key = "85462200f9837d32cc0a4c850c79ecf3041cab27f4f0be2b10770fb4ccfc52645eb3ac0fc40677839f5c20cbb7b2bc48a7e22072620bb3b51ef2997624b4bf2f";
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        /* MessageDigest instance for hashing using SHA512*/
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        /* digest() method called to calculate message digest of an input and return array of byte */
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        /* Convert byte array of hash into digest */
        BigInteger number = new BigInteger(1, hash);

        /* Convert the digest into hex value */
        StringBuilder hexString = new StringBuilder(number.toString(16));

        /* Pad with leading zeros */
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    /* Driver code */
    public static String computePassword(String input)
    {
        try
        {
            String password =  toHexString(getSHA(input+key));
            return password;
        }
        catch (NoSuchAlgorithmException e)
        {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
            return "null";
        }

    }
}
