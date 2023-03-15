package com.example.finalproject.infrastructure.entrypoint;

import com.example.finalproject.domain.dto.SalaryDTO;
import com.example.finalproject.domain.dto.SettlementDTO;
import com.example.finalproject.domain.usecase.EmployeeUseCase;
import com.example.finalproject.domain.usecase.SalaryUseCase;
import com.example.finalproject.domain.usecase.SettlementUseCase;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class SalaryEntryPointTest {


    @MockBean
    private SalaryUseCase salaryUseCase;

    @MockBean
    private EmployeeUseCase employeeUseCase;

    @MockBean
    private SettlementUseCase settlementUseCase;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Get salaries OK")
    void getSalaries() throws Exception{

        final List<SalaryDTO> dataList = new ArrayList<>();
        Mockito.when(salaryUseCase.findSalaries()).thenReturn(dataList);


        //Act
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/salary")
                        .accept(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isNoContent());

    }

    @Test
    @DisplayName("Get salaries not OK")
    void getSalariesNotOk() throws Exception{

        final List<SalaryDTO> dataList = new ArrayList<>();
        Mockito.when(salaryUseCase.findSalaries()).thenReturn(null);


        //Act
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/salary")
                        .accept(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isNotFound());

    }



    @Test
    @DisplayName("Get salary by id OK")
    void getSalary() throws Exception {

        final List<SalaryDTO> dataList = new ArrayList<>();

        SalaryDTO salaryDTO = new SalaryDTO(1, 200000, "2021-01-01", "12345678912");

        dataList.add(salaryDTO);

        Mockito.when(salaryUseCase.findSalariesByCostumerId("12345678912")).thenReturn(dataList);


        //Act
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/salary/12345678912")
                        .accept(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Get salary by id not OK")
    void getSalaryNotOk() throws Exception {

        final List<SalaryDTO> dataList = new ArrayList<>();

        SalaryDTO salaryDTO = new SalaryDTO(1, 200000, "2021-01-01", "123456789");

        dataList.add(salaryDTO);

        Mockito.when(salaryUseCase.findSalariesByCostumerId("12345678912")).thenReturn(dataList);


        //Act
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/salary/1234567")
                        .accept(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isNotFound());

    }

    @Test
    @DisplayName("Delete Salary OK")
    void deleteSalary() throws Exception {
        //Arrange

        Boolean result = true;
        Mockito.when(salaryUseCase.deleteSalary("123")).thenReturn(result);
        //Act
        mockMvc.perform(delete("/settlement/1")
                        .contentType(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isOk());
    }

}