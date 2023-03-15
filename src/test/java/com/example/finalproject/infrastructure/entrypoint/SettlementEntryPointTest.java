package com.example.finalproject.infrastructure.entrypoint;

import com.example.finalproject.domain.dto.EmployeeDTO;
import com.example.finalproject.domain.dto.SalaryDTO;
import com.example.finalproject.domain.dto.SettlementDTO;
import com.example.finalproject.domain.model.employee.*;
import com.example.finalproject.domain.model.settlement.CompletionContractDate;
import com.example.finalproject.domain.model.settlement.RetirementReason;
import com.example.finalproject.domain.model.settlement.Settlement;
import com.example.finalproject.domain.model.settlement.SettlementId;
import com.example.finalproject.domain.usecase.EmployeeUseCase;
import com.example.finalproject.domain.usecase.SalaryUseCase;
import com.example.finalproject.domain.usecase.SettlementUseCase;
import com.example.finalproject.domain.usecase.entity.EmployeeDBO;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class SettlementEntryPointTest {
    @MockBean
    private SalaryUseCase salaryUseCase;

    @MockBean
    private EmployeeUseCase employeeUseCase;

    @MockBean
    private SettlementUseCase settlementUseCase;

    @Autowired
    private MockMvc mockMvc;


//    @Test
//    @DisplayName("Save settlement not OK")
//    void saveSettlementNotOK() throws Exception {
//        //Arrange
//        Settlement settlement = new Settlement(new SettlementId(123), new EmployeeId("123234565"),
//                new CompletionContractDate("2023/05/05"), new RetirementReason("JUSTIFIED"));
//
//
//        SettlementDTO settlementDTO = SettlementDTO.fromDomain(settlement, null);
//
//        Mockito.when(settlementUseCase.saveSettlement(settlementDTO)).thenReturn(null);
//        ObjectMapper mapper = new ObjectMapper();
//        //Act
//        mockMvc.perform(post("/settlement")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(mapper.writeValueAsString(null)))
//                //Assert
//                .andExpect(status().isBadRequest());
//
//
//    }
//
//    @Test
//    @DisplayName("Get settlements OK")
//    void getSettlement() throws Exception{
//
//
//        Settlement settlement = new Settlement(new SettlementId(123), new EmployeeId("123234565"),
//                new CompletionContractDate("2022/05/05"), new RetirementReason("JUSTIFIED"));
//
//        EmployeeDTO employeeDTO = new EmployeeDTO("12345678912", "Santiago", 2000000,
//                "2021/01/01", "Developer Junior", "Active");
//        Employee employee = EmployeeDTO.toDomain(employeeDTO);
//
//        SettlementDTO settlementDTO = SettlementDTO.fromDomain(settlement, employee);
//        final List<SettlementDTO> dataList = new ArrayList<>();
//
//        dataList.add(settlementDTO);
//        Mockito.when(settlementUseCase.getSettlements()).thenReturn(dataList);
//
//
//        //Act
//
//
//
//    }


    @Test
    @DisplayName("Get settlements NOT OK")
    void getSalariesnOToK() throws Exception{



        final List<SettlementDTO> dataList = new ArrayList<>();


        Mockito.when(settlementUseCase.getSettlements()).thenReturn(dataList);


        //Act
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/settlemen")
                        .accept(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isNotFound());

    }

    @Test
    @DisplayName("Delete Settlement OK")
    void deleteSettlement() throws Exception {
        //Arrange

        Boolean result = true;
        Mockito.when(settlementUseCase.deleteSettlement("123")).thenReturn(result);
        //Act
        mockMvc.perform(delete("/settlement/1")
                        .contentType(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isOk());
    }

}