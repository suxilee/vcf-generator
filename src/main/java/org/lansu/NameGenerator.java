package org.lansu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 姓名生成器
 *
 * @author feixuan-pc007
 * @date 2023/05/09
 */
public class NameGenerator {
    private static final Random RANDOM = new Random();

    /**
     * 生成名字
     *
     * @return {@link String}
     */
    public static String generateName() {
        String familyName = NameConstant.FAMILY_NAMES[RANDOM.nextInt(NameConstant.FAMILY_NAMES.length)];
        String firstName = NameConstant.FIRST_NAMES[RANDOM.nextInt(NameConstant.FIRST_NAMES.length)];
        return familyName + firstName;
    }


    /**
     * 生成名字
     *
     * @param count 指定名字数量
     * @return {@link List}<{@link String}>
     */
    public static List<String> generateNames(int count) {
        List<String> names = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            names.add(generateName());
        }
        return names;
    }
}
