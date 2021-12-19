package com.example.jpademo.repository;

import com.example.jpademo.config.TestQuerydslConfig;
import com.example.jpademo.dto.ProjectDto;
import com.example.jpademo.entity.Project;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = {QuerydslConfig.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestQuerydslConfig.class)
@Log4j2
class ProjectRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ProjectRepository repository;

    @Test
    void findAllTest() {
        List<Project> list = repository.findAll();
        log.info(list);
    }

    @Test
    void selectProjectsWithSubQuery() {
        List<ProjectDto> list = repository.selectProjectsWithSubQuery();
        log.info(list);
    }

    @Test
    void selectProjectsWithJoin() {
        List<ProjectDto> list = repository.selectProjectsWithJoin();
        log.info(list);
    }
}