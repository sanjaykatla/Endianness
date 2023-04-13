import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class Main {

    public static byte[] toByteArrayFromIntLE(int num) {
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.putInt(num);
        return buffer.array();
    }

    public static int toIntFromByteArrayLE(byte[] bArray) {

        ByteBuffer buffer = ByteBuffer.wrap(bArray);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        return buffer.getInt();
    }

    public static int toIntFromByteArrayBE(byte[] bArray) {
        ByteBuffer buffer = ByteBuffer.wrap(bArray);
        buffer.order(ByteOrder.BIG_ENDIAN);
        return buffer.getInt();
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
