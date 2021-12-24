package enumex;

public enum TestEnum {

    ACTIVE(0),
    DELETED,
    PENDING(4),
    DISABLED(3);

    public int k ;
    TestEnum(int k) {
        this.k = k;
    }

    TestEnum (){
    }

    public static TestEnum valueOfLabel(int label) {
        for (TestEnum e : values()) {
            if (e.k == label) {
                return e;
            }
        }
        return null;
    }
}
