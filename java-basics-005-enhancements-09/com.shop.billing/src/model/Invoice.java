package model;

public class Invoice {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "code='" + code + '\'' +
                '}';
    }
}
