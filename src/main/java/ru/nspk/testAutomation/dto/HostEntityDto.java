package ru.nspk.testAutomation.dto;

import lombok.Data;
import ru.nspk.testAutomation.model.HostEntity;

@Data
public class HostEntityDto {

    private Long id;

    private String host;

    private String schema;

    private boolean inProgress;

    public static HostEntityDto toDto(HostEntity hostEntity) {
        HostEntityDto dto = new HostEntityDto();
        dto.setId(hostEntity.getId());
        dto.setHost(hostEntity.getHost());
        dto.setSchema(hostEntity.getSchema());
        dto.setInProgress(hostEntity.isInProgress());
        return dto;
    }

}
