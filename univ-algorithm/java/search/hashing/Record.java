package hashing;

public class Record {
    String key;
    String name;
    String department;
    String phoneNumber;

    public Record(String key, String name, String department, String phoneNumber) {
        this.key = key;
        this.name = name;
        this.department = department;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Record{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
