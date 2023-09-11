package com.pluralsight.util;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

public class CalendarFactory implements FactoryBean<Calendar> {

    // Other Link about FactoryBean: https://www.baeldung.com/spring-factorybean
    private Calendar instance = Calendar.getInstance();

    @Override
    public Calendar getObject() throws Exception {
        return instance;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    public void addDay(int num) {
        instance.add(Calendar.DAY_OF_YEAR, num);
    }
}
