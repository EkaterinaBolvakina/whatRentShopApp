package group40.whatrentshopapp.service.roleService;

import group40.whatrentshopapp.domain.Role;
import group40.whatrentshopapp.dto.roleDto.RoleResponseDto;
import group40.whatrentshopapp.exception_handling.exceptions.IsEmptyException;
import group40.whatrentshopapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentshopapp.repository.IRoleRepository;
import group40.whatrentshopapp.service.interfaces.roleServiceInterface.IFindRoleService;
import group40.whatrentshopapp.service.mapping.RoleConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FindRoleService implements IFindRoleService {
    private final IRoleRepository roleRepository;
    private final RoleConverter roleConverter;


    @Override
    public ResponseEntity<List<RoleResponseDto>> findAll() {
        List<Role> allRoles = roleRepository.findAll();
        List<RoleResponseDto> allRolesDto = allRoles.stream()
                .map(roleConverter::convertToDto)
                .toList();
        if (!allRoles.isEmpty()) {
            return new ResponseEntity<>(allRolesDto, HttpStatus.OK);
        } else {
            throw new IsEmptyException("No role exists");
        }
    }

    @Override
    public ResponseEntity<RoleResponseDto> findById(Integer id) {
        Optional<Role> foundedRoleOptional = roleRepository.findById(id);

        if (foundedRoleOptional.isPresent()) {
            RoleResponseDto foundedRoleDto = roleConverter.convertToDto(foundedRoleOptional.get());
            return new ResponseEntity<>(foundedRoleDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Role with id = " + id + " not found");
        }
    }
}
