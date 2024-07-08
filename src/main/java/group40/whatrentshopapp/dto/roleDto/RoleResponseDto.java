package group40.whatrentshopapp.dto.roleDto;

import group40.whatrentshopapp.domain.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseDto {
    private int roleId;
    private RoleName roleName;
}
