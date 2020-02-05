package ru.nspk.testAutomation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HostConfiguration {

    private String host;

    private String schema;

    private boolean inProgress;

}
