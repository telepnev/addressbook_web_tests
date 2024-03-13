package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationsTests extends TestBase {

    @Test
    public void canModifyGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("1", "2", "3"));
        }
       app.groups().modifyGroup(new GroupData().withName("Modify name"));

    }
}
