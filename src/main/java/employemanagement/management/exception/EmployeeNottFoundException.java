package employemanagement.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class EmployeeNottFoundException extends RuntimeException {
    
   
    public EmployeeNottFoundException( String msg){
        super(msg);
    }

    
}
