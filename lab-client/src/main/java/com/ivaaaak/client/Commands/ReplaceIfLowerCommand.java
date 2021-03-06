package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.UserInputManager;
import com.ivaaaak.client.util.PersonMaker;

public class ReplaceIfLowerCommand extends Command {

    private final CollectionStorage collectionStorage;
    private final UserInputManager userInputManager;

    public ReplaceIfLowerCommand(CollectionStorage collectionStorage,
                                 UserInputManager userInputManager) {
        super("replace_if_lower");
        this.collectionStorage = collectionStorage;
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the key:");
        }
        try {
            Integer key = Integer.valueOf(arg);
            Person newPerson = new PersonMaker(userInputManager).makePerson(collectionStorage);
            if (collectionStorage.replaceIfNewLower(key, newPerson)) {
                return new CommandResult(false, "The element has been replaced");
            }
            return new CommandResult(false, "The element is lower than a new one or equal");
        } catch (NumberFormatException e) {
            return new CommandResult(false, "KEY is an integer number. Use \"show\" to get information about elements\n");
        }

    }
}
