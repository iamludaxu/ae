package gift.witch.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 */
public class Test1 {

    public static void main(String[] args) {

        TestData testData = new TestData();
        testData.setName("Name Value");
        testData.setStatic_name("Static Name Value");
        testData.setPassword("Password Value");
        System.out.println("==================================");
        System.out.println("read before Serializable: ");
        System.out.println("name: " + testData.getName());
        System.out.println("static name: " + testData.getName());
        System.out.println("password: " + testData.getPassword());

        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("./doc/data.txt"));
            os.writeObject(testData);
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        testData.setStatic_name("Reset Static Name Value");
        testData.setName("Reset Name Value");

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
                    "./doc/data.txt"));
            TestData testData0 = (TestData) is.readObject();
            is.close();
            System.out.println("\n==================================");
            System.out.println("read after Serializable: ");
            System.out.println("name: " + testData0.getName());
            System.out.println("static name: " + testData0.getStatic_name());
            System.out.println("password: " + testData0.getPassword());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static class TestData implements Serializable {

        private String name;
        private static String static_name;
        private transient String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public static String getStatic_name() {
            return static_name;
        }

        public static void setStatic_name(String static_name) {
            TestData.static_name = static_name;
        }
    }

}


