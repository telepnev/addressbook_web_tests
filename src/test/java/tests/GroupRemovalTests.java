package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        // предусловие
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("1", "2", "3"));
        }
        // подсчет кол-во групп
        int groupCount = app.groups().getCount();
        // действие
        app.groups().removeGroup();
        //
        int newGroupCount = app.groups().getCount();
        // проверка
        Assertions.assertEquals(groupCount - 1, newGroupCount);
    }

    @Test
    public void canRemoveAllGroupsAtOnes() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("1", "2", "3"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0,app.groups().getCount());
    }

}
