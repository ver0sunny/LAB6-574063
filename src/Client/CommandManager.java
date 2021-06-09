package Client;

import Common.exceptions.NoArgumentProvidedException;
import Common.exceptions.NoSuchCommandException;
import Common.managers.HistoryManager;
import Common.managers.InputAndVerifier;

public class CommandManager {

    private CommandFactory commandFactory;
    private InputAndVerifier inputAndVerifier;
    private HistoryManager historyManager;

    public CommandManager(HistoryManager historyManager, CommandFactory commandFactory, InputAndVerifier inputAndVerifier) {
        this.commandFactory = commandFactory;
        this.inputAndVerifier = inputAndVerifier;
        this.historyManager = historyManager;
    }

    public String execute(String commandName, String arg) throws NoSuchCommandException {
        try {
            if (arg.equals(null)) throw new NoArgumentProvidedException();
            String contents = commandFactory.getCommand(commandName).execute(arg);
            historyManager.addToHistory(commandName);
            return contents;
        } catch (NoArgumentProvidedException e) {
            ConsoleManager.printerror("No argument provided, check requirements " + commandFactory.getCommand(commandName).getName());
        } catch (NoSuchCommandException e) {
            ConsoleManager.printerror("No such command exists, check available commands" + commandFactory.getCommand("HELP").execute(""));
        }
        return null;
    }
}