package gift.witch.android.ae.dagger2;

/**
 *
 * 在构建函数中注入的对象
 *
 */
public class InjectConstructionData {

    private String mTag;

    public InjectConstructionData() {
        mTag = "InjectConstructionData";
    }

      public String getTag() {
        return mTag;
    }
}
