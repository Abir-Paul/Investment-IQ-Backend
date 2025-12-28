package com.investmentiq.base.utilities;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

public class StringHelper {

    public static boolean hasNoContent(String string) {
        return StringUtils.isAllBlank(string);
    }

    public static boolean hasContent(String string) {
        return !Objects.isNull(string) && !hasNoContent(string);
    }

    public static String getConcatenatedStringWithSeparator(String separator,boolean skipNull, List<String> stringList) {

        separator = hasNoContent(separator) ? "," : separator;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringList.size(); i++) {

            String element = stringList.get(i);

            if (hasContent(element) && skipNull) {
                if (i == 0) {
                    result = new StringBuilder(element);
                } else {
                    result.append(separator).append(element);
                }
            }

        }

        return result.toString();
    }
}
