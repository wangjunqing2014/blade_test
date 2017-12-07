package com.wjq.service;

import com.blade.ioc.annotation.Bean;
import com.wjq.model.entity.Attach;

@Bean
public class TestServiceA {

    public long getStatistics() {
        long attachs  = new Attach().count();
        System.out.print(attachs);
        return attachs;
    }

    public static void main(String[] args){
        TestServiceA test = new TestServiceA();
        test.getStatistics();
    }

}
