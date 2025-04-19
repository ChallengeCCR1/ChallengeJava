package br.com.fiap.util;

import javax.swing.*;
import java.util.Base64;
import java.io.ByteArrayInputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class UtilImagem {

    public static ImageIcon converterBase64ParaImageIcon(String base64) {
        try {
            // Remove o prefixo "data:image/png;base64," se existir
            if (base64.contains(",")) {
                base64 = base64.split(",")[1];
            }

            byte[] imagemBytes = Base64.getDecoder().decode(base64);
            ByteArrayInputStream bis = new ByteArrayInputStream(imagemBytes);
            BufferedImage imagem = ImageIO.read(bis);
            return new ImageIcon(imagem);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}