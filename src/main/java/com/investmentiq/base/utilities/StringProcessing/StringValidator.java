package com.investmentiq.base.utilities.StringProcessing;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class StringValidator {

    public boolean isNull(String string)
    {
        return Objects.isNull(string);
    }

    public boolean hasNoContent(String string)
    {
        return StringUtils.isAllBlank(string);
    }
}
