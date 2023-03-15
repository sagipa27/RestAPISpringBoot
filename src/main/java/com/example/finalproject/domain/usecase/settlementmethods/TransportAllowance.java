package com.example.finalproject.domain.usecase.settlementmethods;

public class TransportAllowance {

    private TransportAllowance() {
        throw new IllegalStateException("Utility class");
    }
    public static Integer calculateTransportAllowance(Integer salary) {


        if(salary < 2320000) {
            return  102854;
        }
        else {
            return 0;
        }

    }
}
