import java.io.FileWriter;
import java.io.IOException;

public class Logger2 implements BoxInterface {
    private String[] messages = new String[10];

    @Override
    public void castMessage( String message) throws IOException {
        try (FileWriter file = new FileWriter("text.txt", true)){
            String text = message + "\n";
            file.write(text);

            file.flush();
        }

        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void addedMessage(String message) {
        for (int i=0; i< messages.length; i++){
            if (messages[i] == ""){
                messages[i]=message;
            }
            if (messages[messages.length - 1] != ""){
                for (int j=0; j < messages.length - 1; j++){
                    messages[j] = messages[j + 1];
                }
            }
        }
    }

    @Override
    public void castAllMessage() {
            try (FileWriter file = new FileWriter("text.txt", true)){
                for (int i=0; i< messages.length; i++){
                String text = messages[i] + "\n";
                file.write(text);
                }

                file.flush();
            }

            catch (IOException e){
                System.out.println(e.getMessage());
            }

    }
}
