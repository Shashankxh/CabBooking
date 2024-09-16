package com.cabbooking.cabbook.transformer;
import com.cabbooking.cabbook.dto.request.cabrequest;
import com.cabbooking.cabbook.dto.responce.CabResponse;
import com.cabbooking.cabbook.model.cab;
import com.cabbooking.cabbook.model.driver;

public class cabTransformer {
    public static CabResponse modelToDto(cab Cab){
        return CabResponse.builder()
                .carname(Cab.getCarname())
                .carmodel(Cab.getCarmodel())
                .cabtype(Cab.getCabtype())
                .fareKM(Cab.getFareKM())
                .avalable(true)
                .build();
    }
    public static cab dtoToModel(cabrequest cabRequest){
        return cab.builder().carmodel(cabRequest.getCarmodel())
                .carname(cabRequest.getCarname())
             //   .avalable(true)
                .fareKM(cabRequest.getFareKM())
                .Cabtype(cabRequest.getCabtype())
                .build();
    }
}
