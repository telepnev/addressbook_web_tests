package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        app.openGroupsPage();
        if (!app.isGroupPresent()) {
            app.createGroup(new GroupData("1", "2", "3"));
        }
        app.removeGroup();
    }

}
