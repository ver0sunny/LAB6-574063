package Server;

import Common.managers.*;
import Common.serverCommands.AddCommand;
import Common.serverCommands.ClearCommand;
import Common.serverCommands.HelpCommand;

import java.util.Scanner;

public class ServerRunner {
    public static void main(String[] args) {
        System.setProperty("fileName", "groupsCollection.json");

        System.setProperty("scriptName", "commandScript.txt");

        Serializer serializer = new Serializer();
        ConnectionChannel connectionChannel = new ConnectionChannel(serializer);
        Scanner userInput = new Scanner(System.in);
        InputAndVerifier inputAndVerifier = new InputAndVerifier(userInput);
        FileManager fileManager = new FileManager(System.getProperty("fileName"));
        CollectionManager collectionManager = new CollectionManager(fileManager);
        collectionManager.loadCollection();
        HistoryManager historyManager = new HistoryManager();
        CommandFactory commandFactory = new CommandFactory(collectionManager, inputAndVerifier, new AddCommand(collectionManager,connectionChannel),// new AddIfMinCommand(collectionManager, inputAndVerifier),
                 new ClearCommand(collectionManager,connectionChannel),new HelpCommand(connectionChannel));
                //new ExecuteScript(), new ExitCommand(collectionManager), new FilterByFormOfEducationCommand(collectionManager),
                // new History(historyManager), new InfoCommand(collectionManager),
               // new InsertAtCommand(collectionManager, inputAndVerifier), new PrintDecendingBySemester(collectionManager),
              //  new RemoveByIdCommand(collectionManager), new RemoveByStudentCount(collectionManager),
              //  new SaveCommand(collectionManager), new ShowCommand(collectionManager), new UpdateCommand(collectionManager, inputAndVerifier));
        CommandManager commandManager = new CommandManager(historyManager, collectionManager, commandFactory, inputAndVerifier);
        ServerManager serverManager = new ServerManager(commandManager, serializer,connectionChannel);
//        serverManager.setUp();
        ServerConsoleManager consoleManager = new ServerConsoleManager(userInput, commandManager, serverManager, serializer);
        consoleManager.serverMode();
    }
}
