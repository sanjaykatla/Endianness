import java.util.Arrays;

/*
 This class takes care of manual byte array conversion
 */
public class MainManual {

    public static byte[] toByteArrayFromIntLE(int num) {

        byte[] bArray = new byte[Integer.BYTES];
        for(int i=0; i<Integer.BYTES; i++){
            byte b = (byte) (num & 0xFF);
            bArray[i] = b;
            num >>= 8;
        }

        return bArray;
    }

    public static int toIntFromByteArrayLE(byte[] bArray) {

        int number = 0;
        for(int i=0; i<Integer.BYTES; i++){
            number |= ((bArray[i] & 0xFF) << (8*i));
        }

        return number;
    }

    public static int toIntFromByteArrayBE(byte[] bArray) {

        int number = 0;
        for(int i=Integer.BYTES-1; i>=0; i--){
            number |= ((bArray[i] & 0xFF) << (8*(Integer.BYTES - i - 1)));
        }

        return number;
    }

    public static void main(String[] args) {
        int number = 0x10203040;

        byte[] barrayLE = toByteArrayFromIntLE(number);
        System.out.println("Number " + number);
        System.out.println("Byte array as LE " + Arrays.toString(barrayLE));
        System.out.printf("LE interpretation: 0x%x, int value %d\n", toIntFromByteArrayLE(barrayLE), toIntFromByteArrayLE(barrayLE));
        System.out.printf("BE interpretation: 0x%x, int value %d\n", toIntFromByteArrayBE(barrayLE), toIntFromByteArrayBE(barrayLE));
    }
}
