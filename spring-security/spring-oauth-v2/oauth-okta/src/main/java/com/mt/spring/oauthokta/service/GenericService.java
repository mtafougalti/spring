package com.mt.spring.oauthokta.service;

import com.mt.spring.oauthokta.model.Person;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GenericService<T, I> {

    protected Map<I,T> dataMap = new HashMap<>();

    public void save(I id, T type){
        dataMap.put(id, type);
    }
    public void delete(I id){
        dataMap.remove(id);
    }
    public Collection<T> findAll(){
        return dataMap.values();
    }
    public T findById(I id){
        return dataMap.get(id);
    }
}
