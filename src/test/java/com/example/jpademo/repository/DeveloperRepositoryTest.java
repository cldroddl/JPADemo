package com.example.jpademo.repository;

import com.example.jpademo.config.TestQuerydslConfig;
import com.example.jpademo.entity.Developer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestQuerydslConfig.class)
@Log4j2
class DeveloperRepositoryTest {

    @Autowired
    private DeveloperRepository repository;

    @Test
    void findAllTest() {
        List<Developer> list = repository.findAll();
        log.info(list);
    }

}