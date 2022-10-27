package com.company.component;

import com.company.support.SpringSupport;
import com.vendor.impl.ParamServiceImpl;
import com.vendor.impl.UserValidationServiceImpl;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class VerifyHelper {

    private UserValidationServiceImpl us;

    private ParamServiceImpl serviceImpl;

    public String performAction(String str) {

        if (str != null && str.length() > 0) {
            if (serviceImpl.getParam("NEW_CLIENT_MODEL").equals("YES")) {

                final String[] split = str.split(";");

                StringBuffer sb = new StringBuffer();
                sb.append("<xml><client_id>").append(split[0]).append("</client_id>");
                sb.append("<customer_code>").append(split[1]).append("</customer_code>");
                sb.append("<check_date>").append(new Date()).append("</check_date>");
                sb.append("</xml>");

                return us.validate(sb.toString());

            } else {

                StringBuffer sb = new StringBuffer();
                sb.append("<xml>").append("<client_id>").append(str).append("</client_id>")
                        .append("<check_date>").append(new Date()).append("</check_date>")
                        .append("</xml>");

                return us.validate(sb.toString());

            }
        } else {
            return "INVALID_PARAMETER";
        }
    }

    public VerifyHelper() {
        us = (UserValidationServiceImpl) SpringSupport.getBean("userValidation");
        serviceImpl = (ParamServiceImpl) SpringSupport.getBean("paramService");
    }
}
