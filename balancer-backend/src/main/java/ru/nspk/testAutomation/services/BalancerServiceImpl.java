package ru.nspk.testAutomation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nspk.testAutomation.exception.NotFoundException;
import ru.nspk.testAutomation.model.HostConfiguration;
import ru.nspk.testAutomation.reader.ConfigurationReader;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class BalancerServiceImpl implements BalancerService {


    private List<HostConfiguration> hosts;

    private final ConfigurationReader configurationReader;

    @PostConstruct
    private void initHosts() throws IOException, URISyntaxException {
        hosts = configurationReader.readConfiguration();
    }

    @Override
    public List<HostConfiguration> getAll() {
        return hosts;
    }

    @Override
    public HostConfiguration addHost(HostConfiguration hostConfiguration) {
        hosts.add(hostConfiguration);
        return hostConfiguration;
    }

    @Override
    public HostConfiguration getAvailableHost() {
        return hosts.stream()
                .filter(host -> !host.isInProgress()).findFirst()
                .orElseThrow(() -> new NotFoundException("Not found available host"));
    }

    @Override
    public HostConfiguration changeHostProgress(String host, boolean progress) {
        HostConfiguration hostEntity = hosts.stream()
                .filter(hostConfiguration -> hostConfiguration.getHost().equals(host))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(String.format("Entity with host %s not found", host)));
        hostEntity.setInProgress(progress);
        return hostEntity;
    }

}
