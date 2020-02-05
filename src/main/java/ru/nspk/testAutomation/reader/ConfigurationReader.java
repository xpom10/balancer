package ru.nspk.testAutomation.reader;

import ru.nspk.testAutomation.model.HostConfiguration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface ConfigurationReader {

    List<HostConfiguration> readConfiguration() throws IOException, URISyntaxException;
}
