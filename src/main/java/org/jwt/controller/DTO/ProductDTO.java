package org.jwt.controller.DTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.jwt.entities.Category;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotBlank
    private String name;
    @NotNull
    private Integer stock;
    @NotNull
    private BigDecimal price;
    @NotNull
    private String brand;
    @NotNull
    private Category category;
    @NotNull
    private Boolean enabled;
}
