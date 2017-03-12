package gift.witch.android.ae.gson;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

import java.lang.reflect.Modifier;

/**
 *
 * Gson
 *
 * https://iamludaxu.gitbooks.io/android/content/gson.html
 *
 */
public class GsonTest {

    @Test
    public void testPrimitives() {
        // Serialization
        Gson gson = new Gson();
        String json1 = gson.toJson(1);            // ==> 1
        String json2 = gson.toJson("abcd");       // ==> "abcd"
        String json3 = gson.toJson(new Long(10)); // ==> 10
        int[] values = {1};
        String json4 = gson.toJson(values);       // ==> [1]

        System.out.println(json1);
        System.out.println(json2);
        System.out.println(json3);
        System.out.println(json4);

        // Deserialization
        int fjson1 = gson.fromJson("1", int.class);
        Integer fjson2 = gson.fromJson("1", Integer.class);
        Long fjson3 = gson.fromJson("1", Long.class);
        Boolean fjson4 = gson.fromJson("false", Boolean.class);
        String fjson5 = gson.fromJson("\"abc\"", String.class);
        String[] fjson6 = gson.fromJson("[\"abc\"]", String[].class);

        System.out.println(fjson1);
        System.out.println(fjson2);
        System.out.println(fjson3);
        System.out.println(fjson4);
        System.out.println(fjson5);
        System.out.println(fjson6);
    }


    @Test
    public void testGsonBuilder(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        /**
         * 设置在序列化时忽略null元素
         */
        gsonBuilder.serializeNulls();

        /**
         * 设置不对序列化内部类，内部类
         */
        gsonBuilder.disableInnerClassSerialization();
        /**
         * 设置高于版本号被忽略，配合@Since
         */
        gsonBuilder.setVersion(1.0);
        /**
         *
         */
        gsonBuilder.excludeFieldsWithModifiers(Modifier.STATIC);
        /**
         * 设置格式化打印
         */
        gsonBuilder.setPrettyPrinting();
        /**
         * 禁止html转码
         */
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        MyClass myClass = new MyClass();
        myClass.setM_int(50);
        String string = gson.toJson(myClass);
        System.out.println(string);

    }

    @Test
    public void testTypeAdapter(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        //gsonBuilder.registerTypeAdapter(MyClass.class,new MyTypeAdapter());
        gsonBuilder.registerTypeAdapter(MyClass.class,new MyJsonSerializerAndJsonDeserializer());
        Gson gson = gsonBuilder.create();

        MyClass myClass = new MyClass();
        myClass.setM_int(3);
        myClass.setM_string("我是陆大旭");
        String string = gson.toJson(myClass);
        System.out.println(string);

        String string2 = "{\"myclass_int\":3,\"myclass_string\":\"我是陆大旭\"}";
        MyClass myClass1 = gson.fromJson(string2,MyClass.class);
        System.out.println("myClass1:"+myClass1.toString());

    }


}
