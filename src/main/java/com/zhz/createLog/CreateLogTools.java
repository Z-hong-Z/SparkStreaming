package com.zhz.createLog;


import com.github.javafaker.Faker;

import java.util.Locale;

public class CreateLogTools {
    private static final Faker faker = Faker.instance(Locale.CHINA);

    public static String create() {
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String name = faker.name().name();
        String address = faker.address().fullAddress();
        String ip = faker.internet().ipV4Address();
        return ip + "\t" + name + "\t" + address + "\t" + phoneNumber;
    }
}
