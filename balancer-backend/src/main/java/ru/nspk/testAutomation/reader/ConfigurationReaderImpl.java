package ru.nspk.testAutomation.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.nspk.testAutomation.model.HostConfiguration;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class ConfigurationReaderImpl implements ConfigurationReader {


    @Override
    public List<HostConfiguration> readConfiguration() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        String resourcePath = "configuration.json";
        URI fileUri = getClass().getClassLoader().getResource(resourcePath).toURI();
        return objectMapper.readValue(fileUri.toURL(), new TypeReference<List<HostConfiguration>>() {
        });
    }
}
