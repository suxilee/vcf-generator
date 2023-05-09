package org.lansu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 主要
 *
 * @author feixuan-pc007
 * @date 2023/05/09
 */
public class Main {
    public static void main(String[] args) throws IOException {
        banner();
        int vcfCount = 1;
        int minCount = 1;
        int maxCount = 1;
        //初始化生成数量
        Scanner scanner = new Scanner(System.in);
        //输出循环控制
        boolean validInput = false;
        while (!validInput) {
            System.out.print("请输入通讯录生成数量：");
            try {
                vcfCount = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("输入错误，请重新输入！");
                // 清除输入缓冲区中的非法输入
                scanner.next();
            }
        }
        validInput = false;
        while (!validInput) {
            System.out.print("请输入最小号码数量：");
            try {
                minCount = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("输入错误，请重新输入！");
                // 清除输入缓冲区中的非法输入
                scanner.next();
            }
        }
        validInput = false;
        while (!validInput) {
            System.out.print("请输入最大号码数量：");
            try {
                maxCount = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("输入错误，请重新输入！");
                // 清除输入缓冲区中的非法输入
                scanner.next();
            }
        }

        //开始生成...
        for (int i = 0; i < vcfCount; i++) {
            //开始生成通讯录
            Random random = new Random();
            // 生成指定范围内的随机整数
            int phoneCount = random.nextInt(maxCount - minCount + 1) + minCount;
            //获取指定数量姓名
            List<String> names = NameGenerator.generateNames(phoneCount);
            //获取指定数量号码
            List<String> phones = PhoneNumberGenerator.generatePhoneNumbers(phoneCount);
            //按vcfCount数量生成vcf文件
            VcfGenerator.generate(names, phones);
        }
        //退出
        System.out.println("\n按任意键退出程序...");
//        scanner.next();
        //获取任意内容
        System.in.read();
        //关闭输入流
        scanner.close();
        System.exit(0);
    }

    private static void banner() {
        System.out.println(" ████████             ██                     ██      ██          \n" +
                "░██░░░░░             ░░            ██   ██  ░██     ░██          \n" +
                "░██       ███████     ██  ██████  ░░██ ██   ░██     ░██  ██████  \n" +
                "░███████ ░░██░░░██   ░██ ██░░░░██  ░░███    ░██████████ ░░░░░░██ \n" +
                "░██░░░░   ░██  ░██   ░██░██   ░██   ░██     ░██░░░░░░██  ███████ \n" +
                "░██       ░██  ░██ ██░██░██   ░██   ██      ░██     ░██ ██░░░░██ \n" +
                "░████████ ███  ░██░░███ ░░██████   ██       ░██     ░██░░████████\n" +
                "░░░░░░░░ ░░░   ░░  ░░░   ░░░░░░   ░░        ░░      ░░  ░░░░░░░░ ");
    }


}