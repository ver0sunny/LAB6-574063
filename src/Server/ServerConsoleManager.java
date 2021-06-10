package Server;

import Client.ClientConsoleManager;
import Common.exceptions.NoSuchCommandException;
import Common.managers.Serializer;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ServerConsoleManager {

    private Scanner userInput;
    private CommandManager commandManager;
    private ServerManager serverManager;
    private Serializer serializer;

    public ServerConsoleManager(Scanner userInput, CommandManager commandManager, ServerManager serverManager, Serializer serializer) {
        this.userInput = userInput;
        this.commandManager = commandManager;
        this.serverManager = serverManager;
        this.serializer = serializer;
    }

    public void normalMode() {
        String[] command;
        try {
            do {
                command = (userInput.nextLine().trim() + " ").split(" ", 2);
                command[1] = command[1].trim();
//        commandManager.addToHistory();
                commandManager.execute(command[0], command[1]);

            } while (true);
        } catch (NoSuchElementException exception) {
            ClientConsoleManager.printerror("No user input detected");
        } catch (IllegalStateException exception) {
            ClientConsoleManager.printerror("Something unexpected went wrong");
        } catch (NoSuchCommandException e) {
            ClientConsoleManager.printerror("No such command exist, check the list of available commands by calling 'help' command");
        }
    }

    public void serverMode() {
        try {
            do {
                serverManager.receiveExecute();
                serverManager.send();
            } while (true);
        } catch (NoSuchElementException exception) {
            ClientConsoleManager.printerror("No user input detected");
        } catch (IllegalStateException exception) {
            ClientConsoleManager.printerror("Something unexpected went wrong");
        }
    }

    public void scriptMode() {
        String[] command = {"", ""};
    }

    public static void print(Object someThing) {
        System.out.print("Server Message ~ " + someThing);
    }

    public static void println(Object someThing) {
        System.out.println("Server Message ~ " + someThing);
    }

    public static void printerror(Object someThing) {
        System.out.println("Server Message ~ " + "ERROR~ERROR ~ " + someThing);
    }

    @Override
    public String toString() {
        return "Console - works with output and input";
    }

}
