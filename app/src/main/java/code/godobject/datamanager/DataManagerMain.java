package java.code.godobject.datamanager;

public class DataManagerMain {
    public static void main(String[] args) {
        DataReader reader = new DataReader();
        DataWriter writer = new DataWriter();
        DataValidator validator = new DataValidator();
        DataBackup backup = new DataBackup();

        reader.readData();
        writer.writeData();
        validator.validateData();
        backup.backupData();
    }
}
