package com.example.velocerentals.services.users;

import com.example.velocerentals.domain.entities.User;
import com.example.velocerentals.mapping.dtos.UserDTO;
import com.example.velocerentals.repositories.users.UserRepository;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserServiceImpl service;


    @Test
    void listUsers() {

        User userlist1 = User.builder().id(1L).name("Juanes").age(22).email("juanessaavedra@gmail.com").cellphone("1").build();
        User userList2 = User.builder().id(2L).name("Esteban").age(20).email("estebansaavedra@gmail.com").cellphone("2").build();

        Mockito.when(repository.findAll()).thenReturn(List.of(userlist1, userList2));

        List<UserDTO> resultList = service.listUsers();

        assertEquals(2, resultList.size());
        assertEquals("Juanes", resultList.get(0).name());
        assertEquals("Esteban", resultList.get(1).name());

    }
    @Test
    void saveUser() throws BadRequestException {
        User expected = User.builder()
                .id(1L)
                .name("Juanes")
                .age(22)
                .email("juanessaavedra@gmail.com")
                .cellphone("310")
                .build();

        Mockito.when(repository.save(Mockito.any())).thenReturn(expected);

        UserDTO result = service.saveUser(UserDTO.builder()
                .name("Juanes")
                .age(22)
                .email("juanessaavedra@gmail.com")
                .cellphone("310")
                .build());

        assertEquals(expected.getName(), result.name());
    }
        @Test
        void byIdUser () throws BadRequestException {
            User expected1 = User.builder()
                    .id(1L)
                    .name("Juanes")
                    .age(22)
                    .email("juanessaavedra@gmail.com")
                    .cellphone("310")
                    .build();

            Mockito.when(repository.findById(1L)).thenReturn(Optional.of(expected1));
            UserDTO result1 = service.byIdUser(1L);
            assertEquals(expected1.getId(), result1.id());
        }

        @Test
        void byEmailUser() throws BadRequestException {
            User expected2 = User.builder()
                   .id(1L)
                   .name("Juanes")
                   .age(22)
                   .email("juanessaavedra@gmail.com")
                   .cellphone("310")
                   .build();

            Mockito.when(repository.findByEmail("juanessaavedra@gmail.com")).thenReturn(Optional.of(expected2));
            Optional<UserDTO> result2 = service.byEmailUser("juanessaavedra@gmail.com");
            assertEquals(expected2.getEmail(), result2.get().email());
        }

    @Test
    void byPasswordUser() throws BadRequestException {
        User expected3 = User.builder()
                .id(1L)
                .name("Juanes")
                .age(22)
                .email("juanessaavedra@gmail.com")
                .cellphone("310")
                .password("123")
                .build();

        Mockito.when(repository.findByPassword("123")).thenReturn(Optional.of(expected3));
        Optional<UserDTO> result3 = service.byPassword("123");
        assertEquals(expected3.getPassword(), result3.get().password());
    }


       @Test
    void removeUser() {
        service.removeUser(1L);
        Mockito.verify(repository, Mockito.times(1)).deleteById(1L);
    }
}

