package jadecocoonwiki.saveeditor.helper;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public final class FormatterProvider
{
    private FormatterProvider()
    {
    }

    public static NumberFormatter getStatsFormatter()
    {
        return getFormatter(Short.class, (short) 0, (short) 99);
    }

    public static NumberFormatter getHPFormatter()
    {
        return getFormatter(Integer.class, 1, 999);
    }

    public static NumberFormatter getUnsignedIntegerFormatter()
    {
        return getFormatter(Long.class, 0L, 0xFFFFFFFFL);
    }

    public static NumberFormatter getMoneyFormatter()
    {
        return getFormatter(Long.class, 0L, 9999999L);
    }

    private static NumberFormatter getFormatter(Class<?> valueClass, Comparable<?> minValue, Comparable<?> maxValue)
    {
        NumberFormatter hpFormatter = new NumberFormatter(NumberFormat.getInstance());
        hpFormatter.setValueClass(valueClass);
        hpFormatter.setMinimum(minValue);
        hpFormatter.setMaximum(maxValue);
        return hpFormatter;
    }
}
