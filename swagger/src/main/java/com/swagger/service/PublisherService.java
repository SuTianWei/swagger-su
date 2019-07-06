package com.swagger.service;

import com.swagger.Entity.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher savePublisher(Publisher publisher);

    List<Publisher> getAllPublisher();

    Publisher getPublisher(int id);

    void removePublisher(int id);
}
