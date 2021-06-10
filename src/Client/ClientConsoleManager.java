package Client;

import Common.commandToSend.*;
import Common.exceptions.NoArgumentException;
import Common.exceptions.NoSuchCommandException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientConsoleManager {

    private Scanner userInput;
    private CommandManager commandManager;
    private ClientManager clientManager;

    public ClientConsoleManager(Scanner userInput, CommandManager commandManager, ClientManager clientManager) {
        this.userInput = userInput;
        this.commandManager = commandManager;
        this.clientManager = clientManager;
    }

    public void normalMode() {
        java.lang.String[] command;
        try {
            do {
                command = (userInput.nextLine().trim() + " ").split(" ", 2);
                command[1] = command[1].trim();
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
        java.lang.String[] command;
        CommandToSend finalCommand = null;
        CommandToSend helpToSend = new HelpToSend();
        CommandToSend addToSend = new AddToSend();
        CommandToSend clearToSend = new ClearToSend();
        CommandToSend historyToSend = new HistoryToSend();
        String contents;
        try {
            do {
                command = (userInput.nextLine().trim() + " ").split(" ", 2);
                command[1] = command[1].trim();
                String commandName = command[0].toUpperCase();
                try {
                    if (commandName.equals("HELP")) {
                        helpToSend.setArgs(command[1]);
                        finalCommand = helpToSend;

                    } else if (commandName.equals("ADD")) {
                        addToSend.setArgs(command[1]);
                        finalCommand = addToSend;

                    } else if (commandName.equals("CLEAR")) {
                        clearToSend.setArgs(command[1]);
                        finalCommand = clearToSend;

                    } else if (commandName.equals("HISTORY")) {
                        historyToSend.setArgs(command[1]);
                        finalCommand = historyToSend;

                    } else throw new NoSuchCommandException();
                }catch (NoSuchCommandException e) {
                    ClientConsoleManager.printerror("no such command exists ... check available commands");
                }
                clientManager.send(finalCommand);
                ClientConsoleManager.println(clientManager.receiveMes());
                ClientConsoleManager.println(clientManager.receive());
            } while (true);
        } catch (
                NoSuchElementException exception) {
            ClientConsoleManager.printerror("No user input detected");
        } catch (
                IllegalStateException exception) {
            ClientConsoleManager.printerror("Something unexpected went wrong");
        }

    }

    public void scriptMode() {
        java.lang.String[] command = {"", ""};
    }

    public static void print(Object someThing) {
        System.out.print(someThing);
    }

    public static void println(Object someThing) {
        System.out.println(someThing);
    }

    public static void printerror(Object someThing) {
        System.out.println("ERROR~ERROR ~ " + someThing);
    }

    @Override
    public String toString() {
        return "Console - works with output and input";
    }

}

