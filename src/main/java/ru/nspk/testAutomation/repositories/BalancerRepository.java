package ru.nspk.testAutomation.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nspk.testAutomation.model.HostEntity;

import java.util.List;
import java.util.Optional;

public interface BalancerRepository extends CrudRepository<HostEntity, Long> {

    List<HostEntity> findAll();

    Optional<HostEntity> findByHost(String host);
}
