package gift.witch.android.ae.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * User: Geek_Soledad(msdx.android@qq.com)
 * Date: 2017-03-10
 * Time: 13:59
 * FIXME
 */
public class MyJsonSerializerAndJsonDeserializer implements JsonSerializer<MyClass>,JsonDeserializer<MyClass>{

    @Override
    public MyClass deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        /**
         * 反序列化
         */
        MyClass myClass = new MyClass();
        int myclass_int = json.getAsJsonObject().get("myclass_int").getAsJsonPrimitive().getAsInt();
        String myclass_string = json.getAsJsonObject().get("myclass_string").getAsString();
        myClass.setM_int(myclass_int);
        myClass.setM_string(myclass_string);
        return myClass;
    }

    @Override
    public JsonElement serialize(MyClass src, Type typeOfSrc, JsonSerializationContext context) {
        /**
         *序列化
         */
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("myclass_int",src.getM_int());
        jsonObject.addProperty("myclass_string",src.getM_string());
        return jsonObject;
    }
}
