package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class CreateGroupTests extends TestBase {

    @Test
    public void canCreateGroup() {
        app.openGroupsPage();
        app.createGroup(new GroupData("Group name", "Group header", "Group footer"));
    }

    @Test
    public void canCreateGroupWithEmptyField() {
        app.openGroupsPage();
        app.createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.openGroupsPage();
        app.createGroup(new GroupData().withName("same Name"));
    }
    @Test
    public void canCreateGroupWithHeaderOnly() {
        app.openGroupsPage();
        app.createGroup(new GroupData().withHeader("same Header"));
    }
    @Test
    public void canCreateGroupWithFooterOnly() {
        app.openGroupsPage();
        app.createGroup(new GroupData().withFooter("same Footer"));
    }
}
