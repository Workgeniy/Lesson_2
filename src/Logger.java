public class Logger implements BoxInterface {

    private String[] messages = new String[10];
    @Override
    public void castMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void addedMessage(String message) {
        for (int i=0; i< messages.length; i++){
            if (messages[i] == ""){
                messages[i]=message;
            }
            else if (messages[messages.length - 1] != ""){
                for (int j=0; j < messages.length - 1; j++){
                    messages[j] = messages[j + 1];
                }
            }
        }
    }

    @Override
    public void castAllMessage() {
        for (int i=0; i< messages.length; i++){
            System.out.println(messages[i]);
        }
    }
}
