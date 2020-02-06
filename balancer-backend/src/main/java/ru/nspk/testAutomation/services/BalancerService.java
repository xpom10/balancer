package ru.nspk.testAutomation.services;

import ru.nspk.testAutomation.model.HostConfiguration;

import java.util.List;

public interface BalancerService {

    List<HostConfiguration> getAll();

    HostConfiguration getAvailableHost();

    HostConfiguration changeHostProgress(String host, boolean progress);
}
