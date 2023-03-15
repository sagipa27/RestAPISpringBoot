package com.example.finalproject.infrastructure.entrypoint;

import com.example.finalproject.domain.dto.EmployeeDTO;
import com.example.finalproject.domain.usecase.EmployeeUseCase;
import com.example.finalproject.domain.usecase.SalaryUseCase;
import com.example.finalproject.domain.usecase.SettlementUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class EmployeeEntryPointTest {

    @MockBean
    private EmployeeUseCase employeeUseCase;

    @MockBean
    private SalaryUseCase salaryUseCase;

    @MockBean
    private SettlementUseCase settlementUseCase;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Save employee OK")
    void saveEmployee() throws Exception {
        //Arrange
        EmployeeDTO employeeDTO = new EmployeeDTO("12345678912", "Santiago", 2000000,
                "2021/01/01", "Developer Junior", "Active");
        Mockito.when(employeeUseCase.saveEmployee(employeeDTO)).thenReturn(employeeDTO);
        ObjectMapper mapper = new ObjectMapper();
        //Act
        mockMvc.perform(post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(employeeDTO)))
                //Assert
                .andExpect(status().isCreated());


    }

    @Test
    @DisplayName("Update employee OK")
    void updateEmployee() throws Exception {
        //Arrange
        EmployeeDTO employeeDTO = new EmployeeDTO("12345678912", "Santiago", 2000000, "2021-01-01", "Developer Junior", "Active");
        Mockito.when(employeeUseCase.updateEmployee(employeeDTO)).thenReturn(employeeDTO);
        ObjectMapper mapper = new ObjectMapper();
        //Act
        mockMvc.perform(put("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(employeeDTO)))
                //Assert
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete employee OK")
    void deleteEmployee() throws Exception {
        //Arrange
        EmployeeDTO employeeDTO = new EmployeeDTO("12345678912", "Santiago", 2000000, "2021-01-01",
                "Developer Junior", "Active");
        Boolean result = true;
        Mockito.when(employeeUseCase.deleteEmployee("12345678912")).thenReturn(result);
        //Act
        mockMvc.perform(delete("/employee/12345678912")
                        .contentType(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("Get employees OK")
    void getEmployees() throws Exception {

        final List<EmployeeDTO> dataList = new ArrayList<>();

        EmployeeDTO employeeDTO = new EmployeeDTO("12345678912", "Santiago", 2000000, "2021-01-01",
                "Developer Junior", "Active");
        EmployeeDTO employeeDTO1 = new EmployeeDTO("12345678912", "Santiago", 2000000, "2021-01-01",
                "Developer Junior", "Active");
        dataList.add(employeeDTO);
        dataList.add(employeeDTO1);

        Mockito.when(employeeUseCase.getEmployees()).thenReturn(dataList);

        //Act
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employee")
                        .accept(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Get employees not Found")
    void getEmployeesNotFound() throws Exception {


        final List<EmployeeDTO> dataList = new ArrayList<>();

        Mockito.when(employeeUseCase.getEmployees()).thenReturn(dataList);

        //Act
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employee")
                        .accept(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isNotFound());

    }


    @Test
    @DisplayName("Get employee by id OK")
    void findEmployee() throws Exception {

        //Arrange

        EmployeeDTO employeeDTO = new EmployeeDTO("12345678912", "Santiago", 2000000, "2021-01-01",
                "Developer Junior", "Active");


        //Act
        Mockito.when(employeeUseCase.getEmployee("12345678912")).thenReturn(employeeDTO);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employee/{id}", "12345678912")
                        .accept(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get employee by id not OK")
    void findEmployeeNot() throws Exception {

        //Arrange

        EmployeeDTO employeeDTO = new EmployeeDTO("12345678912", "Santiago", 2000000, "2021-01-01",
                "Developer Junior", "Active");


        //Act
        Mockito.when(employeeUseCase.getEmployee("12345678912")).thenReturn(employeeDTO);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employee/{id}", "1234567891")
                        .accept(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isNotFound());
    }
}