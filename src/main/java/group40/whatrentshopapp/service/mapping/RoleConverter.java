package group40.whatrentshopapp.service.mapping;

import group40.whatrentshopapp.domain.Category;
import group40.whatrentshopapp.domain.Role;
import group40.whatrentshopapp.dto.categoryDto.CategoryRequestDto;
import group40.whatrentshopapp.dto.categoryDto.CategoryResponseDto;
import group40.whatrentshopapp.dto.roleDto.RoleResponseDto;
import org.springframework.stereotype.Service;

@Service
public class RoleConverter {

    public RoleResponseDto convertToDto(Role role) {

        RoleResponseDto dto = new RoleResponseDto();

        dto.setRoleId(role.getId());

        if (role.getName() != null) {
            dto.setRoleName(role.getName());
        }

        return dto;
    }
}
