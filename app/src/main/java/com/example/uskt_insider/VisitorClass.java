package com.example.uskt_insider;

public class VisitorClass {
    String _NAME;
    String _CNIC;
    String _PhoneNumber;
    String _REFby;
    String _CITY;

    public VisitorClass(String NAME, String CNIC, String PhoneNumber, String REFby, String CITY) {
        this._NAME = NAME;
        this._CNIC = CNIC;
        this._PhoneNumber = PhoneNumber;
        this._REFby = REFby;
        this._CITY = CITY;
    }

    public String get_NAME() {
        return _NAME;
    }

    public String get_CNIC() {
        return _CNIC;
    }

    public String get_PhoneNumber() {
        return _PhoneNumber;
    }

    public String get_REFby() {
        return _REFby;
    }

    public String get_CITY() {
        return _CITY;
    }
}
