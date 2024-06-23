package com.atilas.util;

import lombok.Getter;
import lombok.Setter;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@Setter
public class MessageBundle {

    private static ResourceBundle messageResources;
    private static String defaultMessage;
    private static final Logger LOG = Logger.getLogger(MessageBundle.class.getName());

    private MessageBundle(){}

    public static String getMessage(String key) {
        String msg;

        try {
            msg = messageResources.getString(key);
        } catch (MissingResourceException mre) {
            LOG.log(Level.FINE,"Código da mensagem não encontrado", mre);
            msg = defaultMessage;
        } catch (Exception e) {
            LOG.log(Level.SEVERE,"Não foi possível acessar arquivo de properties.", e);
            messageResources = null;
            msg = defaultMessage;
        }

        // Retornando mensagem
        return (msg == null ? "" : msg);
    }

    public static String getMessage(String key, String[] args) {
        String msg = getMessage(key);

        if (msg.isEmpty()) {
            return "";
        }

        MessageFormat mf = new MessageFormat(msg);
        msg = mf.format(args);
        return msg;
    }
}
