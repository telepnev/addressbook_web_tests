package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class CreateGroupTests extends TestBase {

    @Test
    public void canCreateGroup() {
        openGroupsPage();
        createGroup(new GroupData("Group name", "Group header", "Group footer"));
    }

    @Test
    public void canCreateGroupWithEmptyField() {
        openGroupsPage();
        createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        openGroupsPage();
        createGroup(new GroupData().withName("same Name"));
    }
    @Test
    public void canCreateGroupWithHeaderOnly() {
        openGroupsPage();
        createGroup(new GroupData().withHeader("same Header"));
    }
    @Test
    public void canCreateGroupWithFooterOnly() {
        openGroupsPage();
        createGroup(new GroupData().withFooter("same Footer"));
    }
}
