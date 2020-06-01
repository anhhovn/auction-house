/**
 * Validate IPv4 Address class
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPv4 {
    private final static String IPV4_REGEX =
            "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    private final static Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);

    /**
     * using pattern and matcher to validate ip and return a boolean
     * @param ip
     * @return
     */
    public static boolean isValidIpv4Address(String ip){
        if(ip == null){
            return false;
        }
        Matcher matcher = IPv4_PATTERN.matcher(ip);
        return matcher.matches();
    }
}
