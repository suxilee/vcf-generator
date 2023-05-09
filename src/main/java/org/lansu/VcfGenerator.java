package org.lansu;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.parameter.TelephoneType;
import ezvcard.parameter.VCardParameter;
import ezvcard.parameter.VCardParameters;
import ezvcard.property.FormattedName;
import ezvcard.property.StructuredName;
import ezvcard.property.Telephone;

import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * vcf生成器
 *
 * @author feixuan-pc007
 * @date 2023/05/09
 */
public class VcfGenerator {

    /**
     * 生成
     *
     * @param names  名字
     * @param phones 手机
     */
    public static void generate(List<String> names, List<String> phones) {
        //获取时间戳
        long time = System.currentTimeMillis();
        //生成文件名 vcf_ + time + "_" +names.length +"个号码.vcf"
        String fileName = "vcf" + time + "_" + names.size() + "个号码.vcf";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            // 循环写入每个联系人的信息
            for (int i = 0; i < names.size(); i++) {
                // 写入VCF文件头部信息
                writer.write("BEGIN:VCARD\n");
                writer.write("VERSION:2.1\n");
                // 姓名
                writer.write("FN:" + names.get(i) + "\n");
                // 电话号码
                writer.write("TEL;TYPE=cell:" + phones.get(i) + "\n");
                // 结束当前联系人的信息
                writer.write("END:VCARD\n");
            }
            writer.close();
            System.out.println(fileName+",生成成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateVCard(String name, String cellPhone) {
        VCard vcard = new VCard();
        FormattedName formattedName = new FormattedName(name);
        vcard.setFormattedName(formattedName);
        Telephone tel = new Telephone(cellPhone);
        tel.getTypes().add(TelephoneType.CELL);
        vcard.addTelephoneNumber(tel);
        return Ezvcard.write(vcard).version(VCardVersion.V2_1).go();
    }
}

