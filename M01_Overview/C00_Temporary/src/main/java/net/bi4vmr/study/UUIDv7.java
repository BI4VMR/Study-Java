package net.bi4vmr.study;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

public class UUIDv7 {
    private static final SecureRandom random = new SecureRandom();

    public static UUID randomUUID() {
        byte[] value = randomBytes();
        ByteBuffer buf = ByteBuffer.wrap(value);
        long high = buf.getLong();
        long low = buf.getLong();
        return new UUID(high, low);
    }

    public static byte[] randomBytes() {
        // random bytes
        byte[] value = new byte[16];
        random.nextBytes(value);

        // current timestamp in ms
        ByteBuffer timestamp = ByteBuffer.allocate(Long.BYTES);
        timestamp.putLong(System.currentTimeMillis());

        // timestamp
        System.arraycopy(timestamp.array(), 2, value, 0, 6);

        // version and variant
        value[6] = (byte) ((value[6] & 0x0F) | 0x70);
        value[8] = (byte) ((value[8] & 0x3F) | 0x80);

        return value;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            var uuid = UUIDv7.randomUUID();
            // UUID uuid = UUID.randomUUID();
            // UUID uuid = UUID.nameUUIDFromBytes("ss".getBytes());
            // UUID uuid = UUID.fromString("1e4d5a6b-cdef-2abc-def0-1234567890ab");
            System.out.println(uuid);

            // gv5();
        }
    }

    private static void gv5() {
        // 生成一个版本5的UUID
        UUID namespaceUUID = UUID.fromString("12345678-1234-1234-1234-123456789012");
        String name = "example";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = md.digest((namespaceUUID.toString() + name).getBytes(StandardCharsets.UTF_8));
            long msb = 0;
            long lsb = 0;
            for (int i = 0; i < 8; i++) {
                msb = (msb << 8) | (hashBytes[i] & 0xFF);
            }
            for (int i = 8; i < 16; i++) {
                lsb = (lsb << 8) | (hashBytes[i] & 0xFF);
            }
            msb &= 0x0FFFFFFFFFFFFFFFL;
            msb |= 0x5000000000000000L;
            lsb &= 0x3FFFFFFFFFFFFFFFL;
            lsb |= 0x8000000000000000L;
            UUID uuid = new UUID(msb, lsb);
            System.out.println("Generated Version 5 UUID: " + uuid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}