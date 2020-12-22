import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Main {

    // 签名生成(sha256)
    static public String newSignature(byte[] key, byte[] data) {
        byte[] hmacSha256;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA256");
            mac.init(secretKeySpec);
            hmacSha256 = mac.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate hmac-sha256", e);
        }
        return String.format("%x", new BigInteger(1, hmacSha256));
    }

    public static void main(String[] args) {
        try {
            String sign = newSignature("key".getBytes("UTF-8"), "123".getBytes("UTF-8"));
            System.out.println(sign);
            // a7f7739b1dc5b4e922b1226c9fcbdc83498dee375382caee08fd52a13eb7cfe2
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
