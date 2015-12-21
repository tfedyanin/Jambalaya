import java.io.ByteArrayOutputStream;

public class MysteryCode {

    public static void main(String[] unused) throws Exception {
        ByteArrayOutputStream stoned = new ByteArrayOutputStream(20480);
        int[] magic = {104, 116, 116, 112, 58, 47, 47, 98, 105, 116, 46, 108, 121, 47, 49, 98, 87, 119, 51, 75, 111};
        for (int weird : magic) stoned.write(weird);
        int crazy, unknown = 0;
        java.io.InputStream wtf = new java.net.URL(stoned.toString()).openStream();
        while ((crazy = wtf.read()) != -1) stoned.write(crazy);
        for (int strange : stoned.toByteArray()) {
            if (unknown == 2) {
                if (strange == 38) break;
                System.out.print((char) strange);
            } else if (17 + (unknown + 1) * 21 == strange) {
                unknown++;
            }
        }
    }
}
