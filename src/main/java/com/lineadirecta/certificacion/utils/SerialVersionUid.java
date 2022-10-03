package com.lineadirecta.certificacion.utils;

public enum SerialVersionUid {

    SERIAL6(6),
    SERIAL4(4),
    SERIAL2(2);

    private final int serialVersion;

    SerialVersionUid(int serialVersion) {
        this.serialVersion = serialVersion;
    }

    @Override
    public String toString() {
        return "SerialVersionUid{" +
                "serialVersion=" + serialVersion +
                '}';
    }
}