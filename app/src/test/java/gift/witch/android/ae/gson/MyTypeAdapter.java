package gift.witch.android.ae.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * User: Geek_Soledad(msdx.android@qq.com)
 * Date: 2017-03-10
 * Time: 13:51
 * FIXME
 */
public class MyTypeAdapter extends TypeAdapter<MyClass> {

    @Override
    public void write(JsonWriter out, MyClass value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.beginObject();
        out.name("myclass_int");
        out.value(value.getM_int());
        out.name("myclass_string");
        out.value(value.getM_string());
        out.endObject();
    }

    @Override
    public MyClass read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        in.beginObject();
        MyClass myClass = new MyClass();
        while (in.peek() != JsonToken.END_OBJECT) {
            String name = in.nextName();

            if(name.equals("myclass_int")){
                int value = in.nextInt();
                myClass.setM_int(value);
            }else if(name.equals("myclass_string")){
                String string = in.nextString();
                myClass.setM_string(string);
            }
        }
        in.endObject();
        return myClass;
    }


}


