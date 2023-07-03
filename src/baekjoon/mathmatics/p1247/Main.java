package src.baekjoon.mathmatics.p1247;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 3; i++) {
            BigInteger result = new BigInteger("0");
            String lineString = bufferedReader.readLine();
            for (int j = 0; j < Integer.parseInt(lineString); j++) {
                String token = bufferedReader.readLine();
                BigInteger bigInteger = new BigInteger(token);
                result = result.add(bigInteger);
            }
            switch (result.signum()) {
                case 1 -> System.out.println("+");
                case 0 -> System.out.println("0");
                case -1 -> System.out.println("-");
            }
        }
    }
}
