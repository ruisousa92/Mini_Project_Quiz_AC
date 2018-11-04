package org.academiadecodigo.codecadets.comms;

public enum Messages {
    RESPONSE,
    CORRECT,
    WRONG;

    public static String sendResponse(Messages messages, String[] args) {

        String arguments = "";

        if (args != null) {
            for (String arg : args) {
                arguments += (arg + " ");
            }
        }

        return messages + " " + arguments + "\n";
    }
}
