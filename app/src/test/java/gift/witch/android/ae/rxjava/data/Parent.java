package gift.witch.android.ae.rxjava.data;

import java.util.ArrayList;
import java.util.List;

public class Parent {

    private String name;

    private List<Child> childList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

}
