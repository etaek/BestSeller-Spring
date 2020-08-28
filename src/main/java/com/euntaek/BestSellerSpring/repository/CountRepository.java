package com.euntaek.BestSellerSpring.repository;

import java.util.List;

public interface CountRepository{
    List<Long> findCount();
    List<String> findId();

}
