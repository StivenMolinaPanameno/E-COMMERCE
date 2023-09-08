package org.jwt.controller.DTO;

import jakarta.persistence.Column;
import lombok.*;
import org.jwt.security.models.UserEntity;

import java.math.BigDecimal;
import java.util.Date;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private UserEntity user;
    private Date date;
    private BigDecimal total;
    private Boolean enable;
}
