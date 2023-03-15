package com.example.finalproject.infrastructure.entrypoint;


import com.example.finalproject.domain.dto.SettlementDTO;
import com.example.finalproject.domain.usecase.SettlementUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/settlement")
public class SettlementEntryPoint {

    private final SettlementUseCase settlementUseCase;


    public SettlementEntryPoint(SettlementUseCase settlementUseCase) {
        this.settlementUseCase = settlementUseCase;
    }

    @GetMapping
    public ResponseEntity<?> getSettlements() {

        List<SettlementDTO> settlement = settlementUseCase.getSettlements();
        if (settlement.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(settlement, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveSettlement(@RequestBody SettlementDTO settlementDTO) throws Exception {

        SettlementDTO settlement = settlementUseCase.saveSettlement(settlementDTO);
        if(settlement == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
        return new ResponseEntity<>(settlement, HttpStatus.CREATED);

         }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSettlement(@PathVariable(name = "id") String id) {
        Boolean deleted = settlementUseCase.deleteSettlement(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }


}
