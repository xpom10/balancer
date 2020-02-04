package ru.nspk.testAutomation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nspk.testAutomation.dto.HostEntityDto;
import ru.nspk.testAutomation.exception.NotFoundException;
import ru.nspk.testAutomation.model.HostEntity;
import ru.nspk.testAutomation.repositories.BalancerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class BalancerServiceImpl implements BalancerService {

    private final BalancerRepository balancerRepository;

    @Override
    public List<HostEntityDto> getAll() {
        return balancerRepository.findAll().stream()
                .map(HostEntityDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public HostEntityDto getAvailableHost() {
        return balancerRepository.findAll().stream()
                .filter(host -> !host.isInProgress()).findFirst().map(HostEntityDto::toDto)
                .orElseThrow(() -> new NotFoundException("Not found available host"));
    }

    @Override
    public HostEntity changeHostProgress(String host, boolean progress) {
        HostEntity hostEntity = balancerRepository
                .findByHost(host)
                .orElseThrow(() -> new NotFoundException(String.format("Entity with host %s not found", host)));
        hostEntity.setInProgress(progress);
        return balancerRepository.save(hostEntity);
    }


}
