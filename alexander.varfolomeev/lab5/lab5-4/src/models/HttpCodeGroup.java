package models;

public enum HttpCodeGroup {
    INFO(100), SUCCESS(200), REDIRECT(300), CLIENT_ERROR(400), SERVER_ERROR(500);

    private final int code;

    HttpCodeGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static int getGeneralCodeBySpecific(int code) {
        return code / 100 * 100; // 4** -> 400
    }

}
