package Client;

import Common.commandToSend.AddToSend;
import Common.commandToSend.CommandToSend;
import Common.commandToSend.HelpToSend;
import Common.exceptions.NoSuchCommandException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleManager {

    private Scanner userInput;
    private CommandManager commandManager;
    private ClientManager clientManager;

    public ConsoleManager(Scanner userInput, CommandManager commandManager, ClientManager clientManager) {
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
//        commandManager.addToHistory();
                commandManager.execute(command[0], command[1]);

            } while (true);
        } catch (NoSuchElementException exception) {
            ConsoleManager.printerror("No user input detected");
        } catch (IllegalStateException exception) {
            ConsoleManager.printerror("Something unexpected went wrong");
        } catch (NoSuchCommandException e) {
            ConsoleManager.printerror("No such command exist, check the list of available commands by calling 'help' command");
        }
    }

    public void serverMode() {
        java.lang.String[] command;
        CommandToSend helpToSend = new HelpToSend();
        CommandToSend addToSend = new AddToSend();
        String contents;
        try {
            do {
                command = (userInput.nextLine().trim() + " ").split(" ", 2);
                command[1] = command[1].trim();
                String commandName = command[0].toUpperCase();

                if (commandName=="HELP") {
                    helpToSend.setArgs(command[1]);
                    clientManager.send(helpToSend);
                }
//                switch (commandName) {
//                    case ("HELP"):
//                        helpToSend.setArgs(command[1]);
//                        clientManager.send(helpToSend);
//                        break;
//                }
//                    case ("ADD"):
//                        addToSend.setArgs(command[1]);
//                        clientManager.send(addToSend);
//                        ConsoleManager.println(clientManager.receiveMes());
//                }
            try {
                if (helpToSend.getName() == null) throw new NoSuchCommandException();
            } catch (NoSuchCommandException e) {
                ConsoleManager.printerror("No such command exists, try again");
            }
            ConsoleManager.println(clientManager.receive());
        } while (true) ;
    } catch(
    NoSuchElementException exception)

    {
        ConsoleManager.printerror("No user input detected");
    } catch(
    IllegalStateException exception)

    {
        ConsoleManager.printerror("Something unexpected went wrong");
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

