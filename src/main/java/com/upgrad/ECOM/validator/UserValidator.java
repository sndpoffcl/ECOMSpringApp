package com.upgrad.ECOM.validator;

import com.upgrad.ECOM.entity.User;
import com.upgrad.ECOM.exception.APIException;
import com.upgrad.ECOM.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public void validateUser(User user) throws APIException{
        if(StringUtils.isEmptyOrNull(user.getName())){
            throw new APIException("Invalid name for user");
        }

        if(StringUtils.isEmptyOrNull(user.getEmail())){
            throw new APIException("Invalid email for user");
        }

        if(StringUtils.isEmptyOrNull(user.getPassword())){
            throw new APIException("Invalid password for user");
        }
    }
}
