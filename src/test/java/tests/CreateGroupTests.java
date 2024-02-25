package tests;

import org.junit.jupiter.api.Test;

public class CreateGroupTests extends TestBase {

    @Test
    public void canCreateGroup() {
        openGroupsPage();
        createGroup("Group name", "Group header", "Group footer");
    }

    @Test
    public void canCreateGroupWithEmptyField() {
        openGroupsPage();
        createGroup("", "", "");
    }
}
