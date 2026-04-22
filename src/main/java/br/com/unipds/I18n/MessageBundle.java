package br.com.unipds.I18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MessageBundle {
    private static final String BASE_NAME = "messages";
    private static Locale currentLocale = Locale.of("pt", "BR");
    private static ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, currentLocale);

    /**
     * Define o locale atual par ao sistema.
     *
     * @param locale Novo locale a ser utilizado
     */
    public static void setLocale(Locale locale) {
        currentLocale = locale;
        bundle = ResourceBundle.getBundle(BASE_NAME, currentLocale);
    }

    /**
     * Obtém o locale atual do sistema.
     *
     * @return Locale atual
     */
    public static Locale getCurrentLocale() {
        return currentLocale;
    }

    /**
     * Obtém uma mensagem sem parâmetros.
     *
     * @param key chave da mensagem no arquivo properties
     * @return Mensagem traduzida
     */
    public static String getMessage(String key) {
        try {
            return bundle.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    /**
     * Obtém uma mensagem com parãmetros formatados.
     *
     * @param key    chave da mensagem no arquivo properties
     * @param params Parâmetros a serem inseridos
     * @return Mensagem traduzida e formatada
     */
    public static String getMessage(String key, Object... params) {
        try {
            String pattern = bundle.getString(key);
            return MessageFormat.format(pattern, params);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
