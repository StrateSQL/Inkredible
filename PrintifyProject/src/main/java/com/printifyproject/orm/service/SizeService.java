package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.SizeDao;
import com.printifyproject.orm.model.SizeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
@Transactional
public class SizeService {

    @Autowired
    private SizeDao dao;

    public SizeEntity add(SizeEntity entity) {
        return dao.insert(entity);
    }

    // Parallel execution of inserts
    // ExecutorService should be managed and shut down properly in the real application
    public List<SizeEntity> add(List<SizeEntity> entities) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<CompletableFuture<SizeEntity>> futures = entities.stream()
                .map(entity -> CompletableFuture.supplyAsync(() -> dao.insert(entity), executor))
                .toList();
        // Join all the futures. This is a blocking call.
        return futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public Optional<SizeEntity> findById(int id) {
        return dao.findById(id);
    }

    public SizeEntity findBySize(String size) {
        return dao.findBySize(size);
    }
    public List<SizeEntity> findAll() {
        return dao.findAll();
    }

    public SizeEntity update(SizeEntity entity) {
        return dao.update(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public void delete(SizeEntity entity) {
        dao.delete(entity);
    }

    public boolean existsById(int id) {
        return dao.existsById(id);
    }
    public boolean exists(SizeEntity entity) {
        return dao.exists(entity);
    }
    public long count() {
        return dao.count();
    }
}
