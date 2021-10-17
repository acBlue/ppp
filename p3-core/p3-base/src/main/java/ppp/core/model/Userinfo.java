package ppp.core.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Userinfo implements Serializable {

    private String userId;

    private String userName;

    private String rentId;
}
