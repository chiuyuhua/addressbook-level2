package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;


/**
 * Edit the name of a person identified using it's last displayed index from the address book.
 */
public class EditNameCommand extends Command {

    public static final String COMMAND_WORD = "edit name";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edit the name of a person identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX n/NAME\n"
            + "Example: " + COMMAND_WORD + "1 YuHua";

    public static final String MESSAGE_EDIT_NAME_PERSON_SUCCESS = "Person Name: %1$s";


    public EditNameCommand(int targetVisibleIndex, String newName) {
        super(targetVisibleIndex);
    }


    @Override
    public CommandResult execute() {
        try {
            final Person target = getTargetPerson();
            target.changeName(newName);
            return new CommandResult(String.format(MESSAGE_EDIT_NAME_PERSON_SUCCESS, target));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }
    }

}
