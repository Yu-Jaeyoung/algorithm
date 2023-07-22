package src.baekjoon.p1076;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringBuffer print = new StringBuffer();

        for (int i = 0; i < 2; i++) {
            switch (bufferedReader.readLine()) {
                case "black":
                    print.append("0");
                    break;
                case "brown":
                    print.append("1");
                    break;
                case "red":
                    print.append("2");
                    break;
                case "orange":
                    print.append("3");
                    break;
                case "yellow":
                    print.append("4");
                    break;
                case "green":
                    print.append("5");
                    break;
                case "blue":
                    print.append("6");
                    break;
                case "violet":
                    print.append("7");
                    break;
                case "grey":
                    print.append("8");
                    break;
                case "white":
                    print.append("9");
                    break;
                default:
                    break;
            }
        }

        BigInteger bigInteger = new BigInteger(String.valueOf(print));

        switch (bufferedReader.readLine()) {
            case "black":
                System.out.print(Integer.parseInt(String.valueOf(print)));
                break;
            case "brown":
                System.out.print(Integer.parseInt(String.valueOf(print)) * 10);
                break;
            case "red":
                System.out.print(Integer.parseInt(String.valueOf(print)) * 100);
                break;
            case "orange":
                System.out.print(Integer.parseInt(String.valueOf(print)) * 1000);
                break;
            case "yellow":
                System.out.print(Integer.parseInt(String.valueOf(print)) * 10000);
                break;
            case "green":
                System.out.print(Integer.parseInt(String.valueOf(print)) * 100000);
                break;
            case "blue":
                System.out.print(Integer.parseInt(String.valueOf(print)) * 1000000);
                break;
            case "violet":
                System.out.print(bigInteger.multiply(BigInteger.valueOf(10000000)));
                break;
            case "grey":
                System.out.print(bigInteger.multiply(BigInteger.valueOf(100000000)));
                break;
            case "white":
                System.out.print(bigInteger.multiply(BigInteger.valueOf(1000000000)));
                break;
            default:
                break;
        }
    }
}
