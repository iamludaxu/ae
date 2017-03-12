package gift.witch.android.ae.gson;


import com.google.gson.annotations.Since;

public class MyClass {

    @Since(1.1)
    private String vv;

    private int m_int;

    private String m_string;


    public int getM_int() {
        return m_int;
    }

    public void setM_int(int m_int) {
        this.m_int = m_int;
    }

    public String getM_string() {
        return m_string;
    }

    public void setM_string(String m_string) {
        this.m_string = m_string;
    }

    public String getVv() {
        return vv;
    }

    public void setVv(String vv) {
        this.vv = vv;
    }

    @Override
    public String toString() {
        return "======m_int:"+m_int+" m_string:"+m_string;
    }
}
