package com.xtrape.content.config;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import java.util.Locale;

public class I18nLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(@NotNull HttpServletRequest httpServletRequest) {
        String language = httpServletRequest.getHeader("content-language");
        Locale locale = Locale.getDefault();
        if (language != null && language.length() > 0) {
            String[] split = language.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Locale locale) {

    }
}
