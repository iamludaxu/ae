package gift.witch.android.ae.dagger2;

/**
 * 在属性中注入的对象
 */
public class InjectPropertyData {

    private  String mTag;

    public InjectPropertyData(){
        mTag = "InjectMemberData";
    }

    public String getTag(){
        return mTag;
    }
}
