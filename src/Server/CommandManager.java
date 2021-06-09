package Server;

import Common.exceptions.NoArgumentProvidedException;
import Common.exceptions.NoSuchCommandException;
import Common.managers.CollectionManager;
import Common.managers.HistoryManager;
import Common.managers.InputAndVerifier;

public class CommandManager {
    private CollectionManager collectionManager;
    private CommandFactory commandFactory;
    private InputAndVerifier inputAndVerifier;
    private HistoryManager historyManager;

    public CommandManager(HistoryManager historyManager, CollectionManager collectionManager, CommandFactory commandFactory, InputAndVerifier inputAndVerifier) {
        this.commandFactory = commandFactory;
        this.collectionManager = collectionManager;
        this.inputAndVerifier = inputAndVerifier;
        this.historyManager = historyManager;
    }

    public String execute(String commandName, String arg) throws NoSuchCommandException {
        StringBuilder sb = new StringBuilder();
        try {
            String result = commandFactory.getCommand(commandName).execute(arg);
            historyManager.addToHistory(commandName);
            return result;
//        } catch (NoArgumentProvidedException e) {
//            ConsoleManager.printerror("No argument provided, check requirements " + commandFactory.getCommand(commandName).getName());
//            sb.append("No argument provided, check requirements " + commandFactory.getCommand(commandName).getName());
        } catch (NoSuchCommandException e) {
            sb.append("No such command exists, check available commands" + "\n" + commandFactory.getCommand("HELP").execute(null));
            ConsoleManager.printerror("No such command exists, check available commands");
        }
        return sb.toString();
    }
}
