package ru.nspk.testAutomation.services;

import ru.nspk.testAutomation.dto.HostEntityDto;
import ru.nspk.testAutomation.model.HostEntity;

import java.util.List;

public interface BalancerService {

    List<HostEntityDto> getAll();

    HostEntityDto getAvailableHost();

    HostEntity changeHostProgress(String host, boolean progress);
}
