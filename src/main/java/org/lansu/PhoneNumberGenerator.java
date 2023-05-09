package org.lansu;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.property.StructuredName;
import ezvcard.property.Telephone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 电话号码生成器
 *
 * @author feixuan-pc007
 * @date 2023/05/09
 */
public class PhoneNumberGenerator {
    private static final String[] SEGMENTS = {"134", "135", "136", "137", "138", "139", "147", "150", "151", "152", "157", "158", "159", "165", "172", "178", "182", "183", "184", "187", "188", "198", "130", "131", "132", "145", "155", "156", "166", "171", "175", "176", "185", "186", "133", "149", "153", "173", "177", "180", "181", "189", "199"};
    private static final Random RANDOM = new Random();

    /**
     * 生成电话号码
     *
     * @return {@link String}
     */
    public static String generatePhoneNumber() {
        String segment = SEGMENTS[RANDOM.nextInt(SEGMENTS.length)];
        String number = String.format("%08d", RANDOM.nextInt(100000000));
        return segment + number;
    }

    /**
     * 生成电话号码
     *
     * @param count 数
     * @return {@link List}<{@link String}>
     */
    public static List<String> generatePhoneNumbers(int count) {
        List<String> phoneNumbers = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            phoneNumbers.add(generatePhoneNumber());
        }
        return phoneNumbers;
    }


}
