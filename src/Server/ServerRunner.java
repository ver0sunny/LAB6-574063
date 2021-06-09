package Server;

import Common.managers.*;
import Common.serverCommands.AddCommand;
import Common.serverCommands.HelpCommand;

import java.util.Scanner;

public class ServerRunner {
    public static void main(String[] args) {
        System.setProperty("fileName", "groupsCollection.json");

        System.setProperty("scriptName", "commandScript.txt");

        ConnectionChannel connectionChannel = new ConnectionChannel();
        Scanner userInput = new Scanner(System.in);
        InputAndVerifier inputAndVerifier = new InputAndVerifier(userInput);
        FileManager fileManager = new FileManager(System.getProperty("fileName"));
        CollectionManager collectionManager = new CollectionManager(fileManager);
        HistoryManager historyManager = new HistoryManager();
        CommandFactory commandFactory = new CommandFactory(collectionManager, inputAndVerifier, new AddCommand(collectionManager,connectionChannel),
               // new AddIfMinCommand(collectionManager, inputAndVerifier), new ClearCommand(collectionManager),
                //new ExecuteScript(), new ExitCommand(collectionManager), new FilterByFormOfEducationCommand(collectionManager),
                new HelpCommand());// new History(historyManager), new InfoCommand(collectionManager),
               // new InsertAtCommand(collectionManager, inputAndVerifier), new PrintDecendingBySemester(collectionManager),
              //  new RemoveByIdCommand(collectionManager), new RemoveByStudentCount(collectionManager),
              //  new SaveCommand(collectionManager), new ShowCommand(collectionManager), new UpdateCommand(collectionManager, inputAndVerifier));
        CommandManager commandManager = new CommandManager(historyManager, collectionManager, commandFactory, inputAndVerifier);
        Serializer serializer = new Serializer();
        ServerManager serverManager = new ServerManager(commandManager, serializer,connectionChannel);
//        serverManager.setUp();
        ConsoleManager consoleManager = new ConsoleManager(userInput, commandManager, serverManager, serializer);
        consoleManager.serverMode();
    }
}
