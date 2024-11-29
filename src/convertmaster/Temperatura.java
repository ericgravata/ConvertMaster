package convertmaster;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Temperatura extends javax.swing.JFrame {

    public Temperatura() {
        initComponents();
    }

    //CRIAR OS MÉTODOS E CONSTRUTORES DAS FÓRMULAS
    //MÉTODO DE CONVERSÃO DE CELSIUS   
    private void Celsius() throws ParseException {
        double constantCelsius = (273.15);

        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();
        
        if (combo1.contains("Celsius") && combo2.contains("Fahrenheit")) {
            //FÓRMULA CELSIUS PARA FAHRENHEIT É: T(°F) = T(°C) * 1,80 + 32
            double resultado = (convertEntrada * (1.8)) + 32;
            txtSaida.setText(df.format(resultado) + " °F");
        } else if (combo1.contains("Celsius") && combo2.contains("Kelvin")) {
            //FÓRMULA CELSIUS PARA KELVIN É: T(k) = T(°C) + 273,15
            double resultado = (convertEntrada + constantCelsius);
            txtSaida.setText(df.format(resultado) + " °K");
        }

        //SAÍDA GERAL PARA AS OUTRAS TEMPERATURAS         
        if (combo2.contains("Fahrenheit")) {
            //MOSTRA-ME O RESULTADO EM KELVIN
            double resultado = (convertEntrada + constantCelsius);
            String saida1;
            saida1 = ("Em Kelvin: " + df.format(resultado) + " °K");
            txtRes.setText(saida1 + "\n");
        } else if (combo2.contains("Kelvin")) {
            //MOSTRA-ME O RESULTADO EM FAHRENHEIT
            double resultado = (convertEntrada * (1.8)) + 32;
            String saida1;
            saida1 = ("Em Fahrenheit: " + df.format(resultado) + " °F");
            txtRes.setText(saida1 + "\n");
        }

    }

    //MÉTODO DE CONVERSÃO DE FAHRENHEIT     
    private void Fahrenheit() throws ParseException {
        double constantFahrenheit = (459.67);

        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Fahrenheit") && combo2.contains("Celsius")) {
            /*EXISTEM 3 FÓRMULAS DE FAHRENHEIT PARA CELSIUS
1° -> °C = (°F - 32) * 5/9;
2° -> °C = (°F - 32) / (9/5);
3° -> °C = (°F - 32) / 1,8;*/
            double resultado = (convertEntrada - 32) / 1.8;
            txtSaida.setText(df.format(resultado) + " °C");
        } else if (combo1.contains("Fahrenheit") && combo2.contains("Kelvin")) {
            //A FÓRMULA PARA KELVIN É: T(°k) = (T(°F) + 459,67) * 5/9  //(5/9) = 0,5555555555555555
            double resultado = (convertEntrada + constantFahrenheit) * 0.55555555555555555555555555555556;
            txtSaida.setText(df.format(resultado) + " °K");
        }

        //SAÍDA GERAL PARA AS OUTRAS TEMPERATURAS         
        if (combo2.contains("Celsius")) {
            double resultado = (convertEntrada + constantFahrenheit) * 0.55555555555555555555555555555556;
            String saida1;
            saida1 = ("Em Kelvin: " + df.format(resultado) + " °K");
            txtRes.setText(saida1 + "\n");
        } else if (combo2.contains("Kelvin")) {
            double resultado = (convertEntrada - 32) / 1.8;
            String saida1;
            saida1 = ("Em Celsius: " + df.format(resultado) + " °C");
            txtRes.setText(saida1 + "\n");
        }
    }

    //MÉTODO DE CONVERSÃO DE KELVIN
    private void Kelvin() throws ParseException {
        double constantCelsius = (273.15);
        double constantFahrenheit = (459.67);

        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        //EXECUÇÃO DO COMANDO
        if (combo1.contains("Kelvin") && combo2.contains("Celsius")) {
            //A FÓRMULA DE KELVIN PARA CELSIUS É: T(°C) = T(K) - 273,15            
            double resultado = convertEntrada - constantCelsius;
            txtSaida.setText(df.format(resultado) + " °C");
        } else if (combo1.contains("Kelvin") && combo2.contains("Fahrenheit")) {
            //A FÓRMULA DE KELVIN PARA FAHRENHEIT É: T(°F) = T(K) * 9/5 - 459,67
            double resultado = ((convertEntrada * (1.8)) - constantFahrenheit);
            txtSaida.setText(df.format(resultado) + " °F");
        }

        //SAÍDA GERAL PARA AS OUTRAS TEMPERATURAS 
        if (combo2.contains("Celsius")) {
            double resultado = ((convertEntrada * (1.8)) - constantFahrenheit);
            String saida1;
            saida1 = ("Em Fahrenheit: " + df.format(resultado) + " °F");
            txtRes.setText(saida1 + "\n");
        } else if (combo2.contains("Fahrenheit")) {
            double resultado = convertEntrada - constantCelsius;
            String saida1;
            saida1 = ("Em Celsius: " + df.format(resultado) + " °C");
            txtRes.setText(saida1 + "\n");
        }
    }

//__________________________________________________________________________    
//MÉTODO DO BOTÃO DE INVERTER *****      
    public void BtInverter() throws ParseException {
        String cbox1 = comboDe.getSelectedItem().toString();
        String cbox2 = comboPara.getSelectedItem().toString();

        if (cbox1.contains("Celsius") && cbox2.contains("Fahrenheit") || cbox1.contains("Celsius") && cbox2.contains("Kelvin")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Fahrenheit") && cbox2.contains("Celsius") || cbox1.contains("Fahrenheit") && cbox2.contains("Kelvin")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Kelvin") && cbox2.contains("Celsius") || cbox1.contains("Kelvin") && cbox2.contains("Fahrenheit")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        }

        String combo1 = comboDe.getSelectedItem().toString();
        if (combo1.contains("Celsius")) {
            Celsius();
        } else if (combo1.contains("Fahrenheit")) {
            Fahrenheit();
        } else if (combo1.contains("Kelvin")) {
            Kelvin();
        }
    }

    //ÁREA RESERVADA PARA OUTROS MÉTODOS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboDe = new javax.swing.JComboBox<>();
        comboPara = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        txtSaida = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btConverter = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRes = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        btInverter = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ConvertMaster - Temperaturas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboDe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Celsius (°C)", "Fahrenheit (°F)", "Kelvin (K)" }));
        getContentPane().add(comboDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 150, 30));

        comboPara.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboPara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Celsius (°C)", "Fahrenheit (°F)", "Kelvin (K)" }));
        getContentPane().add(comboPara, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 150, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Temperatura de entrada");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Temperatura de saída");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Conversor de temperatura");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 80, 325, -1));

        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEntradaKeyTyped(evt);
            }
        });
        getContentPane().add(txtEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 150, -1));

        txtSaida.setEditable(false);
        getContentPane().add(txtSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 150, -1));

        jLabel3.setText("Temperatura de entrada:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel4.setText("Temperatura de saída:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        btConverter.setBackground(new java.awt.Color(51, 204, 0));
        btConverter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btConverter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BT_CONVERTER_TEMPERATURA_1.png"))); // NOI18N
        btConverter.setBorderPainted(false);
        btConverter.setContentAreaFilled(false);
        btConverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConverterActionPerformed(evt);
            }
        });
        getContentPane().add(btConverter, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 150, 25));

        btLimpar.setBackground(new java.awt.Color(255, 153, 0));
        btLimpar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BT_LIMPAR_TEMPERATURA.png.png"))); // NOI18N
        btLimpar.setBorderPainted(false);
        btLimpar.setContentAreaFilled(false);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 150, 25));

        txtRes.setEditable(false);
        txtRes.setColumns(20);
        txtRes.setRows(5);
        jScrollPane1.setViewportView(txtRes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 380, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Resultados da conversão para outras temperaturas aparecerão aqui:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        btVoltar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BT_VOLTAR_TODOS.png"))); // NOI18N
        btVoltar.setBorderPainted(false);
        btVoltar.setContentAreaFilled(false);
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 180, 25));

        btInverter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BT_INVERTER_TEMPERATURA_01_1.png"))); // NOI18N
        btInverter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btInverterMouseClicked(evt);
            }
        });
        getContentPane().add(btInverter, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 160, 30, 30));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundo_tempertura_1_1.jpg"))); // NOI18N
        fundo.setText("jLabel6");
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        setSize(new java.awt.Dimension(516, 508));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConverterActionPerformed
        if (txtEntrada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Acrescente algum valor na caixa de diálogo 'VALOR DE ENTRADA'.");
        } else {
            String entrada = txtEntrada.getText();
            if (!entrada.matches("[0-9.,]+")) { // Verifica se contém apenas números, ponto e vírgula
                JOptionPane.showMessageDialog(this, "Por favor, insira apenas números.");
                return; // Para a execução se o texto contiver caracteres inválidos
            }

            String combo1 = comboDe.getSelectedItem().toString();
            String combo2 = comboPara.getSelectedItem().toString();

            //FORMATANDO OS DECIMAIS E AS VÍRGULAS
            DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
            symbol.setDecimalSeparator(',');
            DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
            String pegueEntrada = txtEntrada.getText();

            //MENSAGENS DE ALERTAS E ERROS
            if (combo1 == combo2) {
                JOptionPane.showMessageDialog(this, "A temperatura selecionada é a mesma de conversão, altere as temperaturas.");
            }

            //CHAMANDO OS MÉTODOS
            if (combo1.contains("Celsius")) {
                try {
                    Celsius();
                } catch (ParseException ex) {
                    Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (combo1.contains("Fahrenheit")) {
                try {
                    Fahrenheit();
                } catch (ParseException ex) {
                    Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (combo1.contains("Kelvin")) {
                try {
                    Kelvin();
                } catch (ParseException ex) {
                    Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }//GEN-LAST:event_btConverterActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        txtEntrada.setText("");
        txtSaida.setText("");
        txtRes.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        new TelaInicial().setVisible(true);
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btInverterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btInverterMouseClicked
        if (txtEntrada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Acrescente algum valor na caixa de diálogo 'VALOR DE ENTRADA'.");
        } else {

            String combo1 = comboDe.getSelectedItem().toString();
            String combo2 = comboPara.getSelectedItem().toString();

            //FORMATANDO OS DECIMAIS E AS VÍRGULAS
            DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
            symbol.setDecimalSeparator(',');
            DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
            String pegueEntrada = txtEntrada.getText();

            //MENSAGENS DE ALERTAS E ERROS
            if (combo1 == combo2) {
                JOptionPane.showMessageDialog(this, "A temperatura selecionada é a mesma de conversão, altere as temperaturas.");
            }
            try {
                BtInverter();
            } catch (ParseException ex) {
                Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btInverterMouseClicked

    private void txtEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyTyped
        //Limita a entrada de dados em até 21 caracteres
        if (txtEntrada.getText().length() >= 20) {
            evt.consume();
        }
        AbstractDocument doc = (AbstractDocument) txtEntrada.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[0-9.,]*")) {
                    super.insertString(fb, offset, string, attr);

                } else {
                    JOptionPane.showMessageDialog(null, "Digite apenas números!");
                }

            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[0-9.,]*")) {
                    super.replace(fb, offset, length, text, attrs);

                } else {
                    JOptionPane.showMessageDialog(null, "Digite apenas números!");
                }

            }
        });
        // Configurando o formato de número para o padrão brasileiro
        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        numberFormat.setMaximumFractionDigits(2); // Ajusta o número máximo de casas decimais
        numberFormat.setMinimumFractionDigits(2); // Ajusta o número mínimo de casas decimais

        SwingUtilities.invokeLater(() -> {
            try {
                String text = txtEntrada.getText();
                text = text.replace(".", "").replace(",", ""); // Remover formatação
                if (text.isEmpty()) {
                    text = "0,00";
                } else if (text.length() == 1) {
                    text = "0,0" + text;
                } else if (text.length() == 2) {
                    text = "0," + text;
                } else {
                    text = text.substring(0, text.length() - 2) + "," + text.substring(text.length() - 2);
                }
                double value = Double.parseDouble(text.replace(",", "."));
                txtEntrada.setText(numberFormat.format(value));
            } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
                txtEntrada.setText("0,00");
            }
        }
        );
    }//GEN-LAST:event_txtEntradaKeyTyped

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Temperatura().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConverter;
    private javax.swing.JLabel btInverter;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> comboDe;
    private javax.swing.JComboBox<String> comboPara;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextArea txtRes;
    private javax.swing.JTextField txtSaida;
    // End of variables declaration//GEN-END:variables
}
