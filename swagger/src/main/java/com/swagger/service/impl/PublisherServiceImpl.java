package com.swagger.service.impl;

import com.swagger.Entity.Publisher;
import com.swagger.repository.BookRepository;
import com.swagger.repository.PublisherRepository;
import com.swagger.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("publisherService")
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> getAllPublisher() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisher(int id) {
        return publisherRepository.findOne(id);
    }

    @Override
    public void removePublisher(int id) {
        publisherRepository.delete(id);
    }
}
