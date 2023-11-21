package com.example.demo.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Extension;

import reactor.core.publisher.Mono;

@Service
public class MyService {

    public Mono<Object> executar(int seconds) {

        return Mono.fromCallable(() -> {

            //Thread.sleep(seconds);

            Class<?> recordClass = Extension.class;
            Field[] fields = recordClass.getDeclaredFields();
            
            Object[] attributeValues = new Object[fields.length];

            for (int i = 0; i < fields.length; i++) {
                attributeValues[i] = UUID.randomUUID().toString();
            }

            return createRecord(recordClass, attributeValues);
           
        });
        
    }


    private Object createRecord(Class<?> recordClass, Object[] attributeValues) {

        try {
            Class<?>[] parameterTypes = Arrays.stream(attributeValues)
                    .map(Object::getClass)
                    .toArray(Class<?>[]::new);

            Constructor<?> constructor = recordClass.getDeclaredConstructor(parameterTypes);
            constructor.setAccessible(true);

            return constructor.newInstance(attributeValues);

        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
        }

        return null;
    }
   
}
