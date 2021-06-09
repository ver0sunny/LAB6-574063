package Client;

import Common.clientCommands.AddCommandClient;
import Common.clientCommands.HelpCommandClient;
import Common.managers.*;

import java.util.Scanner;

public class ClientRunner {
    public static void main(String[] args) {

        System.setProperty("fileName", "groupsCollection.json");

        System.setProperty("scriptName", "commandScript.txt");


        Serializer serializer = new Serializer();
        ConnectionPacket connectionChannel = new ConnectionPacket();
        ClientManager clientManager = new ClientManager(serializer, connectionChannel);
        ConsoleManager.println("..Client activated..");

        Scanner userInput = new Scanner(System.in);
        InputAndVerifier inputAndVerifier = new InputAndVerifier(userInput);
        FileManager fileManager = new FileManager(System.getProperty("fileName"));
        CollectionManager collectionManager = new CollectionManager(fileManager);
        HistoryManager historyManager = new HistoryManager();
        CommandFactory commandFactory = new CommandFactory(collectionManager,inputAndVerifier, new AddCommandClient(collectionManager,inputAndVerifier, clientManager),
                //new AddIfMinCommand(collectionManager,inputAndVerifier), new ClearCommand(collectionManager),
                //new ExecuteScript(), new ExitCommand(), new FilterByFormOfEducationCommand(collectionManager),
                new HelpCommandClient()); //new History(historyManager), new InfoCommand(collectionManager),
               // new InsertAtCommand(collectionManager, inputAndVerifier), new PrintDecendingBySemester(collectionManager),
               // new RemoveByIdCommand(collectionManager), new RemoveByStudentCount(collectionManager),
                //new ShowCommand(collectionManager), new UpdateCommand(collectionManager,inputAndVerifier) );
        CommandManager commandManager = new CommandManager(historyManager,commandFactory,inputAndVerifier);
        ConsoleManager consoleManager = new ConsoleManager(userInput,commandManager, clientManager);
        consoleManager.serverMode();
    }

}
