import lombok.NonNull;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CollectionMedia implements Collection{
    public ArrayList<byte[]> mediaList = new ArrayList<byte[]>();

    @Override
    public void Add(@NonNull String path) {

        try{
            FileReader reader = new FileReader(path);
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {
                mediaList.add(scanner.nextLine().getBytes());
            }

        }
         catch (Exception e) {
            System.out.println("Не считало");
        }
    }

    @Deprecated
    @Override
    public void Remove(int index) {
        mediaList.remove(index);
    }

    @Override
    public void Clear() {
        mediaList.clear();
    }

    @Override
    public void Display() { //упрощенный вариант
        for (byte[] media : mediaList) {
            System.out.println(new String(media));
        }
    }
}
