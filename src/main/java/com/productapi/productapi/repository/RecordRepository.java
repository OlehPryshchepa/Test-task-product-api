package com.productapi.productapi.repository;

import com.productapi.productapi.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    @Query("from Record")
    public List<Record> getAll();
}
