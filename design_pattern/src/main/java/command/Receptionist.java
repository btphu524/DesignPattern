package command;

import java.util.ArrayList;
import java.util.List;

public class Receptionist {
    private List<Command> commandList = new ArrayList<>();

    public void takeCommand(Command command) {
        commandList.add(command);
    }

    public void processCommands() {
        System.out.println("Receptionist: Processing all commands...");
        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}
