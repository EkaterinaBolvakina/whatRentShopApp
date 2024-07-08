package group40.whatrentshopapp.service.interfaces.roleServiceInterface;

import group40.whatrentshopapp.domain.Role;
import group40.whatrentshopapp.dto.roleDto.RoleResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFindRoleService {
    ResponseEntity<List<RoleResponseDto>> findAll();

    ResponseEntity<RoleResponseDto> findById(Integer id);

}
