package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class CreateGroupTests extends TestBase {

    @Test
    public void canCreateGroup() {
        app.groups().createGroup(new GroupData("Group name", "Group header", "Group footer"));
    }

    @Test
    public void canCreateGroupWithEmptyField() {
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupData().withName("same Name"));
    }
    @Test
    public void canCreateGroupWithHeaderOnly() {
        app.groups().createGroup(new GroupData().withHeader("same Header"));
    }
    @Test
    public void canCreateGroupWithFooterOnly() {
        app.groups().createGroup(new GroupData().withFooter("same Footer"));
    }
}
