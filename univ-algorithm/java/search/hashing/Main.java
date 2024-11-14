package hashing;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(13);

        hashTable.put(new Record("20180000", "jack", "정보통신공학과", "010-1234-1234"));
        hashTable.put(new Record("20180002", "jack", "정보통신공학과", "010-1242-2351"));

        Record search = hashTable.search("20180000");
        System.out.println(search);

        hashTable.remove("20180000");

        search = hashTable.search("20180000");
        System.out.println(search);

    }
}
