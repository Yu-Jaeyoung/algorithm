package hashing;

import java.util.LinkedList;

public class HashTable {
    LinkedList<Record>[] table;
    int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];

        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // 1. hash function
    int hash(String key) {
        // 문자열을 숫자로 변환하기 위함
        return Math.abs(key.hashCode()) % capacity;
    }

    // 2. put : 추가
    void put(Record record) {
        String key = record.key;
        // 2.1 : hash 함수 호출 -> index 얻어오기
        int index = hash(key);

        // 2.2 : 해당 index 에 값을 추가
        if (search(key) == null) {
            table[index].add(record);
        }
    }

    // 3. search
    Record search(String key) {
        // 3.1 : hash 함수 호출 -> index 얻어오기
        int index = hash(key);

        // 3.2 : 해당 index 값 찾기
        LinkedList<Record> bucket = table[index];

        for (Record record : bucket) {
            if (record.key.equals(key)) {
                return record;
            }
        }
        return null;
    }

    // 4. delete
    void remove(String key) {
        // 4.1 : hash 함수 호출 -> index 얻어오기
        int index = hash(key);

        // 4.2 : 해당 index 값 삭제하기
        LinkedList<Record> bucket = table[index];

        Record record = search(key);
        if (record != null) {
            bucket.remove(record);
        }
    }
}
