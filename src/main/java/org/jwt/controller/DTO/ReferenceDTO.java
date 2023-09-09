package org.jwt.controller.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReferenceDTO {
    @NotNull
    private String reference;
}
