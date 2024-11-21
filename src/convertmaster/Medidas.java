package convertmaster;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Medidas extends javax.swing.JFrame {

    public Medidas() {
        initComponents();
    }

    private void milimetros() throws ParseException {
        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();

        double variavelConstante[] = {10, 100, 1000, 10000, 100000, 1000000};
        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        //AQUI, NESTE 'df' (Decimal Format) - formatação geral - basta acrescentar ou remover '#' para adiquirir ou remover casas decimais.
        //MANTER ESSA ESTRUTURA "###,##0.## (ALTERE SOMENTE AS '#' APÓS O '.' PARA ADICIONAR OU REMOVER CASAS DECIMAIS).
        DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Milímetro") && combo2.contains("Centímetro")) {
            double resultado = convertEntrada / variavelConstante[0];
            txtSaida.setText(df.format(resultado) + " cm");
        } else if (combo1.contains("Milímetro") && combo2.contains("Decímetro")) {
            double resultado = convertEntrada / variavelConstante[1];
            txtSaida.setText(df.format(resultado) + " dm");
        } else if (combo1.contains("Milímetro") && combo2.contains("Metro")) {
            double resultado = convertEntrada / variavelConstante[2];
            txtSaida.setText(df.format(resultado) + " m");
        } else if (combo1.contains("Milímetro") && combo2.contains("Decâmetro")) {
            double resultado = convertEntrada / variavelConstante[3];
            txtSaida.setText(df.format(resultado) + " dam");
        } else if (combo1.contains("Milímetro") && combo2.contains("Hectômetro")) {
            double resultado = convertEntrada / variavelConstante[4];
            txtSaida.setText(df.format(resultado) + " hm");
        } else if (combo1.contains("Milímetro") && combo2.contains("Quilômetro")) {
            //NESTE PONTO FOI CRIADO MAIS UMA VARIÁVEL 'df'(Decimal Format) PARA AUMENTAR O NÚMERO DE CASAS DECIMAIS
            DecimalFormat dfQuilometro = new DecimalFormat("###,##0.#########");
            double resultado = convertEntrada / variavelConstante[5];
            txtSaida.setText(dfQuilometro.format(resultado) + " km");
        }
        //SAÍDA GERAL PARA OUTRAS MEDIDAS
        //double variavelConstante[] = {10, 100, 1000, 10000, 100000, 1000000}; //(cm, dm, m, dam, hm, km)
        if (combo2.contains("Centímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            DecimalFormat dfQuilometro = new DecimalFormat("###,##0.#########");
            saida1 = ("Em decímetros: " + df.format(convertEntrada / variavelConstante[1]) + " dm");
            saida2 = ("Em metros: " + df.format(convertEntrada / variavelConstante[2]) + " m");
            saida3 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[3]) + " dam");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[4]) + " hm");
            saida5 = ("Em quilômetros: " + dfQuilometro.format(convertEntrada / variavelConstante[5]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        } else if (combo2.contains("Decímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            DecimalFormat dfQuilometro = new DecimalFormat("###,##0.#########");
            saida1 = ("Em centímetros: " + df.format(convertEntrada / variavelConstante[0]) + " cm");
            saida2 = ("Em metros: " + df.format(convertEntrada / variavelConstante[2]) + " m");
            saida3 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[3]) + " dam");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[4]) + " hm");
            saida5 = ("Em quilômetros: " + dfQuilometro.format(convertEntrada / variavelConstante[5]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Metro")) {
            String saida1, saida2, saida3, saida4, saida5;
            DecimalFormat dfQuilometro = new DecimalFormat("###,##0.#########");
            saida1 = ("Em centímetros: " + df.format(convertEntrada / variavelConstante[0]) + " cm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada / variavelConstante[1]) + " dm");
            saida3 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[3]) + " dam");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[4]) + " hm");
            saida5 = ("Em quilômetros: " + dfQuilometro.format(convertEntrada / variavelConstante[5]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Decâmetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            DecimalFormat dfQuilometro = new DecimalFormat("###,##0.#########");
            saida1 = ("Em centímetros: " + df.format(convertEntrada / variavelConstante[0]) + " cm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada / variavelConstante[1]) + " dm");
            saida3 = ("Em metros: " + df.format(convertEntrada / variavelConstante[2]) + " m");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[4]) + " hm");
            saida5 = ("Em quilômetros: " + dfQuilometro.format(convertEntrada / variavelConstante[5]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Hectômetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            DecimalFormat dfQuilometro = new DecimalFormat("###,##0.#########");
            saida1 = ("Em centímetros: " + df.format(convertEntrada / variavelConstante[0]) + " cm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada / variavelConstante[1]) + " dm");
            saida3 = ("Em metros: " + df.format(convertEntrada / variavelConstante[2]) + " m");
            saida4 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[3]) + " dam");
            saida5 = ("Em quilômetros: " + dfQuilometro.format(convertEntrada / variavelConstante[5]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Quilômetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em centímetros: " + df.format(convertEntrada / variavelConstante[0]) + " cm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada / variavelConstante[1]) + " dm");
            saida3 = ("Em metros: " + df.format(convertEntrada / variavelConstante[2]) + " m");
            saida4 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[3]) + " dam");
            saida5 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[4]) + " hm");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }

    }

    private void centimetros() throws ParseException {
        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();
        double variavelConstante[] = {10, 100, 1000, 10000, 100000};

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Centímetro") && combo2.contains("Milímetro")) {
            double resultado = convertEntrada * variavelConstante[0];
            txtSaida.setText(df.format(resultado) + " mm");
        } else if (combo1.contains("Centímetro") && combo2.contains("Decímetro")) {
            double resultado = convertEntrada / variavelConstante[0];
            txtSaida.setText(df.format(resultado) + " dm");
        } else if (combo1.contains("Centímetro") && combo2.contains("Metro")) {
            double resultado = convertEntrada / variavelConstante[1];
            txtSaida.setText(df.format(resultado) + " m");
        } else if (combo1.contains("Centímetro") && combo2.contains("Decâmetro")) {
            double resultado = convertEntrada / variavelConstante[2];
            txtSaida.setText(df.format(resultado) + " dam");
        } else if (combo1.contains("Centímetro") && combo2.contains("Hectômetro")) {
            double resultado = convertEntrada / variavelConstante[3];
            txtSaida.setText(df.format(resultado) + " hm");
        } else if (combo1.contains("Centímetro") && combo2.contains("Quilômetro")) {
            DecimalFormat dfQuilometro = new DecimalFormat("###,##0.#####");
            double resultado = convertEntrada / variavelConstante[4];
            txtSaida.setText(dfQuilometro.format(resultado) + " km");
        }

        //SAÍDA GERAL PARA OUTRAS MEDIDAS
        //double variavelConstante[] = {10, 100, 1000, 10000, 100000}; //(mm, dm, m, dam, hm, km)
        if (combo2.contains("Milímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            DecimalFormat dfQuilometro = new DecimalFormat("###,##0.#####");
            saida1 = ("Em decímetros: " + df.format(convertEntrada / variavelConstante[0]) + " dm");
            saida2 = ("Em metros: " + df.format(convertEntrada / variavelConstante[1]) + " m");
            saida3 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[2]) + " dam");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[3]) + " hm");
            saida5 = ("Em quilômetros: " + dfQuilometro.format(convertEntrada / variavelConstante[4]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        } else if (combo2.contains("Decímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            DecimalFormat dfQuilometro = new DecimalFormat("###,##0.#####");
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[0]) + " mm");
            saida2 = ("Em metros: " + df.format(convertEntrada / variavelConstante[1]) + " m");
            saida3 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[2]) + " dam");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[3]) + " hm");
            saida5 = ("Em quilômetros: " + dfQuilometro.format(convertEntrada / variavelConstante[4]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Metro")) {
            String saida1, saida2, saida3, saida4, saida5;
            DecimalFormat dfQuilometro = new DecimalFormat("###,##0.#####");
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[0]) + " mm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada / variavelConstante[0]) + " dm");
            saida3 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[2]) + " dam");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[3]) + " hm");
            saida5 = ("Em quilômetros: " + dfQuilometro.format(convertEntrada / variavelConstante[4]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Decâmetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            DecimalFormat dfQuilometro = new DecimalFormat("###,##0.#####");
            saida1 = ("Em milímetro: " + df.format(convertEntrada * variavelConstante[0]) + " mm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada / variavelConstante[0]) + " dm");
            saida3 = ("Em metros: " + df.format(convertEntrada / variavelConstante[1]) + " m");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[3]) + " hm");
            saida5 = ("Em quilômetros: " + dfQuilometro.format(convertEntrada / variavelConstante[4]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Hectômetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            DecimalFormat dfQuilometro = new DecimalFormat("###,##0.#####");
            saida1 = ("Em milímetro: " + df.format(convertEntrada * variavelConstante[0]) + " mm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada / variavelConstante[0]) + " dm");
            saida3 = ("Em metros: " + df.format(convertEntrada / variavelConstante[1]) + " m");
            saida4 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[2]) + " dam");
            saida5 = ("Em quilômetros: " + dfQuilometro.format(convertEntrada / variavelConstante[4]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Quilômetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[0]) + " mm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada / variavelConstante[0]) + " dm");
            saida3 = ("Em metros: " + df.format(convertEntrada / variavelConstante[1]) + " m");
            saida4 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[2]) + " dam");
            saida5 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[3]) + " hm");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }

    }

    private void decimetro() throws ParseException {
        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();
        double variavelConstante[] = {10, 100, 1000, 10000};

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Decímetro") && combo2.contains("Milímetro")) {
            double resultado = convertEntrada * variavelConstante[1];
            txtSaida.setText(df.format(resultado) + " mm");
        } else if (combo1.contains("Decímetro") && combo2.contains("Centímetro")) {
            double resultado = convertEntrada * variavelConstante[0];
            txtSaida.setText(df.format(resultado) + " cm");
        } else if (combo1.contains("Decímetro") && combo2.contains("Metro")) {
            double resultado = convertEntrada / variavelConstante[0];
            txtSaida.setText(df.format(resultado) + " m");
        } else if (combo1.contains("Decímetro") && combo2.contains("Decâmetro")) {
            double resultado = convertEntrada / variavelConstante[1];
            txtSaida.setText(df.format(resultado) + " dam");
        } else if (combo1.contains("Decímetro") && combo2.contains("Hectômetro")) {
            double resultado = convertEntrada / variavelConstante[2];
            txtSaida.setText(df.format(resultado) + " hm");
        } else if (combo1.contains("Decímetro") && combo2.contains("Quilômetro")) {
            double resultado = convertEntrada / variavelConstante[3];
            txtSaida.setText(df.format(resultado) + " km");
        }
        //SAÍDA GERAL PARA OUTRAS MEDIDAS
        //double variavelConstante[] = {10, 100, 1000, 1000}; //(mm, cm == m, dam, hm, km)
        if (combo2.contains("Milímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[0]) + " cm");
            saida2 = ("Em metros: " + df.format(convertEntrada / variavelConstante[0]) + " m");
            saida3 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[1]) + " dam");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[2]) + " hm");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[3]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        } else if (combo2.contains("Centímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[1]) + " mm");
            saida2 = ("Em metros: " + df.format(convertEntrada / variavelConstante[0]) + " m");
            saida3 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[1]) + " dam");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[2]) + " hm");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[3]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Metro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[1]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[0]) + " cm");
            saida3 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[1]) + " dam");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[2]) + " hm");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[3]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Decâmetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetro: " + df.format(convertEntrada * variavelConstante[1]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[0]) + " cm");
            saida3 = ("Em metros: " + df.format(convertEntrada / variavelConstante[0]) + " m");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[2]) + " hm");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[3]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Hectômetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[1]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[0]) + " cm");
            saida3 = ("Em metros: " + df.format(convertEntrada / variavelConstante[0]) + " m");
            saida4 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[1]) + " dam");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[3]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Quilômetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[1]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[0]) + " cm");
            saida3 = ("Em metros: " + df.format(convertEntrada / variavelConstante[0]) + " m");
            saida4 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[1]) + " dam");
            saida5 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[2]) + " hm");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }

    }

    private void metros() throws ParseException {

        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();
        double variavelConstante[] = {10, 100, 1000};//mm ; cm ; dm; m; dam; hm; km

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Metro") && combo2.contains("Milímetro")) {
            double resultado = convertEntrada * variavelConstante[2];
            txtSaida.setText(df.format(resultado) + " mm");
        } else if (combo1.contains("Metro") && combo2.contains("Centímetro")) {
            double resultado = convertEntrada * variavelConstante[1];
            txtSaida.setText(df.format(resultado) + " cm");
        } else if (combo1.contains("Metro") && combo2.contains("Decímetro")) {
            double resultado = convertEntrada * variavelConstante[0];
            txtSaida.setText(df.format(resultado) + " dm");
        } else if (combo1.contains("Metro") && combo2.contains("Decâmetro")) {
            double resultado = convertEntrada / variavelConstante[0];
            txtSaida.setText(df.format(resultado) + " dam");
        } else if (combo1.contains("Metro") && combo2.contains("Hectômetro")) {
            double resultado = convertEntrada / variavelConstante[1];
            txtSaida.setText(df.format(resultado) + " hm");
        } else if (combo1.contains("Metro") && combo2.contains("Quilômetro")) {
            double resultado = convertEntrada / variavelConstante[2];
            txtSaida.setText(df.format(resultado) + " km");
        }
        //SAÍDA GERAL PARA OUTRAS MEDIDAS
        //double variavelConstante[] = {10, 100, 1000}; //(mm, cm, dm, m, dam, hm, km) = {0, 1, 2}
        if (combo2.contains("Milímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[1]) + " cm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[0]) + " dm");
            saida3 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[0]) + " dam");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[1]) + " hm");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[2]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        } else if (combo2.contains("Centímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[2]) + " mm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[0]) + " dm");
            saida3 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[0]) + " dam");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[1]) + " hm");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[2]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Decímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[2]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[1]) + " cm");
            saida3 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[0]) + " dam");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[1]) + " hm");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[2]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Decâmetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetro: " + df.format(convertEntrada * variavelConstante[2]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[1]) + " cm");
            saida3 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[0]) + " dm");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[1]) + " hm");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[2]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Hectômetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[2]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[1]) + " cm");
            saida3 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[0]) + " dm");
            saida4 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[0]) + " dam");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[2]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Quilômetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[2]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[1]) + " cm");
            saida3 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[0]) + " dm");
            saida4 = ("Em decâmetros: " + df.format(convertEntrada / variavelConstante[0]) + " dam");
            saida5 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[1]) + " hm");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
    }

    private void decametro() throws ParseException {
        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();
        double variavelConstante[] = {10, 100, 1000, 10000};

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Decâmetro") && combo2.contains("Milímetro")) {
            double resultado = convertEntrada * variavelConstante[3];
            txtSaida.setText(df.format(resultado) + " mm");
        } else if (combo1.contains("Decâmetro") && combo2.contains("Centímetro")) {
            double resultado = convertEntrada * variavelConstante[2];
            txtSaida.setText(df.format(resultado) + " cm");
        } else if (combo1.contains("Decâmetro") && combo2.contains("Decímetro")) {
            double resultado = convertEntrada * variavelConstante[1];
            txtSaida.setText(df.format(resultado) + " dm");
        } else if (combo1.contains("Decâmetro") && combo2.contains("Metro")) {
            double resultado = convertEntrada * variavelConstante[0];
            txtSaida.setText(df.format(resultado) + " m");
        } else if (combo1.contains("Decâmetro") && combo2.contains("Hectômetro")) {
            double resultado = convertEntrada / variavelConstante[0];
            txtSaida.setText(df.format(resultado) + " hm");
        } else if (combo1.contains("Decâmetro") && combo2.contains("Quilômetro")) {
            double resultado = convertEntrada / variavelConstante[1];
            txtSaida.setText(df.format(resultado) + " km");
        }
        //SAÍDA GERAL PARA OUTRAS MEDIDAS
        //double variavelConstante[] = {10, 100, 1000, 10000}; //(mm, cm, dm, m, dam, hm, km) = {0, 1, 2, 3}
        if (combo2.contains("Milímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[2]) + " cm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[1]) + " dm");
            saida3 = ("Em metros: " + df.format(convertEntrada * variavelConstante[0]) + " m");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[0]) + " hm");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[1]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        } else if (combo2.contains("Centímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[3]) + " mm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[1]) + " dm");
            saida3 = ("Em metros: " + df.format(convertEntrada * variavelConstante[0]) + " m");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[0]) + " hm");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[1]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Decímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[3]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[2]) + " cm");
            saida3 = ("Em metros: " + df.format(convertEntrada * variavelConstante[0]) + " m");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[0]) + " hm");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[1]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Metro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetro: " + df.format(convertEntrada * variavelConstante[3]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[2]) + " cm");
            saida3 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[1]) + " dm");
            saida4 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[0]) + " hm");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[1]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Hectômetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[3]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[2]) + " cm");
            saida3 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[1]) + " dm");
            saida4 = ("Em metros: " + df.format(convertEntrada * variavelConstante[0]) + " m");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[1]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Quilômetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[3]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[2]) + " cm");
            saida3 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[1]) + " dm");
            saida4 = ("Em metros: " + df.format(convertEntrada * variavelConstante[0]) + " m");
            saida5 = ("Em hectômetros: " + df.format(convertEntrada / variavelConstante[0]) + " hm");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }

    }

    private void hectometro() throws ParseException {
        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();
        double variavelConstante[] = {10, 100, 1000, 10000, 100000};

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.###", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Hectômetro") && combo2.contains("Milímetro")) {
            double resultado = convertEntrada * variavelConstante[4];
            txtSaida.setText(df.format(resultado) + " mm");
        } else if (combo1.contains("Hectômetro") && combo2.contains("Centímetro")) {
            double resultado = convertEntrada * variavelConstante[3];
            txtSaida.setText(df.format(resultado) + " cm");
        } else if (combo1.contains("Hectômetro") && combo2.contains("Decímetro")) {
            double resultado = convertEntrada * variavelConstante[2];
            txtSaida.setText(df.format(resultado) + " dm");
        } else if (combo1.contains("Hectômetro") && combo2.contains("Metro")) {
            double resultado = convertEntrada * variavelConstante[1];
            txtSaida.setText(df.format(resultado) + " m");
        } else if (combo1.contains("Hectômetro") && combo2.contains("Decâmetro")) {
            double resultado = convertEntrada * variavelConstante[0];
            txtSaida.setText(df.format(resultado) + " dam");
        } else if (combo1.contains("Hectômetro") && combo2.contains("Quilômetro")) {
            double resultado = convertEntrada / variavelConstante[0];
            txtSaida.setText(df.format(resultado) + " km");
        }

//SAÍDA GERAL PARA OUTRAS MEDIDAS
        //double variavelConstante[] = {10, 100, 1000, 10000,100000}; //(mm, cm, dm, m, dam, hm, km) = {0, 1, 2, 3,4}
        if (combo2.contains("Milímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[3]) + " cm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[2]) + " dm");
            saida3 = ("Em metros: " + df.format(convertEntrada * variavelConstante[1]) + " m");
            saida4 = ("Em decâmetro: " + df.format(convertEntrada * variavelConstante[0]) + " dam");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[0]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        } else if (combo2.contains("Centímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[4]) + " mm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[2]) + " dm");
            saida3 = ("Em metros: " + df.format(convertEntrada * variavelConstante[1]) + " m");
            saida4 = ("Em decâmetro: " + df.format(convertEntrada * variavelConstante[0]) + " dam");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[0]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Decímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[4]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[3]) + " cm");
            saida3 = ("Em metros: " + df.format(convertEntrada * variavelConstante[1]) + " m");
            saida4 = ("Em decâmetro: " + df.format(convertEntrada * variavelConstante[0]) + " dam");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[0]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Metro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetro: " + df.format(convertEntrada * variavelConstante[4]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[3]) + " cm");
            saida3 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[2]) + " dm");
            saida4 = ("Em decâmetro: " + df.format(convertEntrada * variavelConstante[0]) + " dam");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[0]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Decâmetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[4]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[3]) + " cm");
            saida3 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[2]) + " dm");
            saida4 = ("Em metros: " + df.format(convertEntrada * variavelConstante[1]) + " m");
            saida5 = ("Em quilômetros: " + df.format(convertEntrada / variavelConstante[0]) + " km");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Quilômetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[4]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[3]) + " cm");
            saida3 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[2]) + " dm");
            saida4 = ("Em metros: " + df.format(convertEntrada * variavelConstante[1]) + " m");
            saida5 = ("Em decâmetro: " + df.format(convertEntrada * variavelConstante[0]) + " hm");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }

    }

    private void quilometro() throws ParseException {
        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();
        double variavelConstante[] = {10, 100, 1000, 10000, 100000, 1000000};

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.####", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Quilômetro") && combo2.contains("Milímetro")) {
            double resultado = convertEntrada * variavelConstante[5];
            txtSaida.setText(df.format(resultado) + " mm");
        } else if (combo1.contains("Quilômetro") && combo2.contains("Centímetro")) {
            double resultado = convertEntrada * variavelConstante[4];
            txtSaida.setText(df.format(resultado) + " cm");
        } else if (combo1.contains("Quilômetro") && combo2.contains("Decímetro")) {
            double resultado = convertEntrada * variavelConstante[3];
            txtSaida.setText(df.format(resultado) + " dm");
        } else if (combo1.contains("Quilômetro") && combo2.contains("Metro")) {
            double resultado = convertEntrada * variavelConstante[2];
            txtSaida.setText(df.format(resultado) + " m");
        } else if (combo1.contains("Quilômetro") && combo2.contains("Decâmetro")) {
            double resultado = convertEntrada * variavelConstante[1];
            txtSaida.setText(df.format(resultado) + " dam");
        } else if (combo1.contains("Quilômetro") && combo2.contains("Hectômetro")) {
            double resultado = convertEntrada * variavelConstante[0];
            txtSaida.setText(df.format(resultado) + " hm");
        }
//SAÍDA GERAL PARA OUTRAS MEDIDAS
        //double variavelConstante[] = {10, 100, 1000, 10000, 100000, 1000000}; //(mm, cm, dm, m, dam, hm, km) = {0, 1, 2, 3, 4, 5}
        if (combo2.contains("Milímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[4]) + " cm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[3]) + " dm");
            saida3 = ("Em metros: " + df.format(convertEntrada * variavelConstante[2]) + " m");
            saida4 = ("Em decâmetro: " + df.format(convertEntrada * variavelConstante[1]) + " dam");
            saida5 = ("Em hectômetro: " + df.format(convertEntrada * variavelConstante[0]) + " hm");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        } else if (combo2.contains("Centímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[5]) + " mm");
            saida2 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[3]) + " dm");
            saida3 = ("Em metros: " + df.format(convertEntrada * variavelConstante[2]) + " m");
            saida4 = ("Em decâmetro: " + df.format(convertEntrada * variavelConstante[1]) + " dam");
            saida5 = ("Em hectômetro: " + df.format(convertEntrada * variavelConstante[0]) + " hm");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Decímetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[5]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[4]) + " cm");
            saida3 = ("Em metros: " + df.format(convertEntrada * variavelConstante[2]) + " m");
            saida4 = ("Em decâmetro: " + df.format(convertEntrada * variavelConstante[1]) + " dam");
            saida5 = ("Em hectômetro: " + df.format(convertEntrada * variavelConstante[0]) + " hm");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Metro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetro: " + df.format(convertEntrada * variavelConstante[5]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[4]) + " cm");
            saida3 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[3]) + " dm");
            saida4 = ("Em decâmetro: " + df.format(convertEntrada * variavelConstante[1]) + " dam");
            saida5 = ("Em hectômetro: " + df.format(convertEntrada * variavelConstante[0]) + " hm");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Decâmetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[5]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[4]) + " cm");
            saida3 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[3]) + " dm");
            saida4 = ("Em metros: " + df.format(convertEntrada * variavelConstante[2]) + " m");
            saida5 = ("Em hectômetro: " + df.format(convertEntrada * variavelConstante[0]) + " hm");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }
        if (combo2.contains("Hectômetro")) {
            String saida1, saida2, saida3, saida4, saida5;
            saida1 = ("Em milímetros: " + df.format(convertEntrada * variavelConstante[5]) + " mm");
            saida2 = ("Em centímetros: " + df.format(convertEntrada * variavelConstante[4]) + " cm");
            saida3 = ("Em decímetros: " + df.format(convertEntrada * variavelConstante[3]) + " dm");
            saida4 = ("Em metros: " + df.format(convertEntrada * variavelConstante[2]) + " m");
            saida5 = ("Em decâmetro: " + df.format(convertEntrada * variavelConstante[1]) + " dam");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4 + "\n" + saida5);
        }

    }

//__________________________________________________________________________    
//MÉTODO DO BOTÃO DE INVERTER *****      
    public void BtInverter() throws ParseException {
        String cbox1 = comboDe.getSelectedItem().toString();
        String cbox2 = comboPara.getSelectedItem().toString();

//A VARIÁVEL temp SIGNIFICA QUE RECEBERÁ UM VALOR 'TEMPORÁRIO' PARA SER USADO POSTERIORMENTE        
        if (cbox1.contains("Milímetro") && cbox2.contains("Centímetro") || cbox1.contains("Milímetro") && cbox2.contains("Decímetro") || cbox1.contains("Milímetro") && cbox2.contains("Metro") || cbox1.contains("Milímetro") && cbox2.contains("Decâmetro") || cbox1.contains("Milímetro") && cbox2.contains("Hectômetro") || cbox1.contains("Milímetro") && cbox2.contains("Quilômetro")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Centímetro") && cbox2.contains("Milímetro") || cbox1.contains("Centímetro") && cbox2.contains("Decímetro") || cbox1.contains("Centímetro") && cbox2.contains("Metro") || cbox1.contains("Centímetro") && cbox2.contains("Decâmetro") || cbox1.contains("Centímetro") && cbox2.contains("Hectômetro") || cbox1.contains("Centímetro") && cbox2.contains("Quilômetro")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Decímetro") && cbox2.contains("Milímetro") || cbox1.contains("Decímetro") && cbox2.contains("Centímetro") || cbox1.contains("Decímetro") && cbox2.contains("Metro") || cbox1.contains("Decímetro") && cbox2.contains("Decâmetro") || cbox1.contains("Decímetro") && cbox2.contains("Hectômetro") || cbox1.contains("Decímetro") && cbox2.contains("Quilômetro")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Metro") && cbox2.contains("Milímetro") || cbox1.contains("Metro") && cbox2.contains("Centímetro") || cbox1.contains("Metro") && cbox2.contains("Decímetro") || cbox1.contains("Metro") && cbox2.contains("Decâmetro") || cbox1.contains("Metro") && cbox2.contains("Hectômetro") || cbox1.contains("Metro") && cbox2.contains("Quilômetro")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Decâmetro") && cbox2.contains("Milímetro") || cbox1.contains("Decâmetro") && cbox2.contains("Centímetro") || cbox1.contains("Decâmetro") && cbox2.contains("Decímetro") || cbox1.contains("Decâmetro") && cbox2.contains("Metro") || cbox1.contains("Decâmetro") && cbox2.contains("Hectômetro") || cbox1.contains("Decâmetro") && cbox2.contains("Quilômetro")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Hectômetro") && cbox2.contains("Milímetro") || cbox1.contains("Hectômetro") && cbox2.contains("Centímetro") || cbox1.contains("Hectômetro") && cbox2.contains("Decímetro") || cbox1.contains("Hectômetro") && cbox2.contains("Metro") || cbox1.contains("Hectômetro") && cbox2.contains("Decâmetro") || cbox1.contains("Hectômetro") && cbox2.contains("Quilômetro")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Quilômetro") && cbox2.contains("Milímetro") || cbox1.contains("Quilômetro") && cbox2.contains("Centímetro") || cbox1.contains("Quilômetro") && cbox2.contains("Decímetro") || cbox1.contains("Quilômetro") && cbox2.contains("Metro") || cbox1.contains("Quilômetro") && cbox2.contains("Decâmetro") || cbox1.contains("Quilômetro") && cbox2.contains("Hectômetro")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        }

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat decimalF = new DecimalFormat("#,##0.##", symbol);
        String pegueEntrada = txtEntrada.getText();
        double entradaZero = (double) decimalF.parse(pegueEntrada).doubleValue();

        String combo1 = comboDe.getSelectedItem().toString();
        if (combo1.contains("Milímetro") && entradaZero > 0) {
            milimetros();
        } else if (combo1.contains("Centímetro") && entradaZero > 0) {
            centimetros();
        }
        if (combo1.contains("Decímetro") && entradaZero > 0) {
            decimetro();
        }
        if (combo1.contains("Metro") && entradaZero > 0) {
            metros();
        }
        if (combo1.contains("Decâmtero") && entradaZero > 0) {
            decametro();
        }
        if (combo1.contains("Hectômetro") && entradaZero > 0) {
            hectometro();
        }
        if (combo1.contains("Quilômetro") && entradaZero > 0) {
            quilometro();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        comboDe = new javax.swing.JComboBox<>();
        comboPara = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btConverter = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRes = new javax.swing.JTextArea();
        txtEntrada = new javax.swing.JTextField();
        txtSaida = new javax.swing.JTextField();
        btInverter = new javax.swing.JLabel();
        planoDeFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ConvertMaster - Medidas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Milímetro", "Centímetro", "Decímetro", "Metro", "Decâmetro", "Hectômetro", "Quilômetro", " " }));
        getContentPane().add(comboDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 150, 30));

        comboPara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Milímetro", "Centímetro", "Decímetro", "Metro", "Decâmetro", "Hectômetro", "Quilômetro" }));
        getContentPane().add(comboPara, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 150, 30));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel6.setText("Conversor de medidas");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 260, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Medida de entrada");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Medida de saída");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        jLabel9.setText("Medida de entrada:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 150, -1));

        jLabel10.setText("Medida de saída:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 150, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Resultados da conversão para outras temperaturas aparecerão aqui:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        btConverter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btConverter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BT_CONVERTER_MEDIDAS_1.png"))); // NOI18N
        btConverter.setBorderPainted(false);
        btConverter.setFocusPainted(false);
        btConverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConverterActionPerformed(evt);
            }
        });
        getContentPane().add(btConverter, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 150, 25));

        btLimpar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão_Limpar tela.png"))); // NOI18N
        btLimpar.setBorderPainted(false);
        btLimpar.setFocusPainted(false);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 150, 25));

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BT_VOLTAR_TODOS.png"))); // NOI18N
        btVoltar.setBorder(null);
        btVoltar.setBorderPainted(false);
        btVoltar.setContentAreaFilled(false);
        btVoltar.setFocusPainted(false);
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 180, 25));

        txtRes.setEditable(false);
        txtRes.setColumns(20);
        txtRes.setRows(5);
        jScrollPane1.setViewportView(txtRes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 380, -1));

        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEntradaKeyTyped(evt);
            }
        });
        getContentPane().add(txtEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 150, 25));

        txtSaida.setEditable(false);
        getContentPane().add(txtSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 150, 25));

        btInverter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BT_INVERTER_MEDIDAS_01.png"))); // NOI18N
        btInverter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btInverterMouseClicked(evt);
            }
        });
        getContentPane().add(btInverter, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 160, 30, 30));

        planoDeFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundo_medidas_1.jpg"))); // NOI18N
        getContentPane().add(planoDeFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 501, 500));

        setSize(new java.awt.Dimension(520, 508));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btConverterActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (txtEntrada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Acrescente algum valor na caixa de diálogo 'VALOR DE ENTRADA'.");
        } else {
            String entrada = txtEntrada.getText();
            if (!entrada.matches("[0-9.,]+")) { // Verifica se contém apenas números, ponto e vírgula
                JOptionPane.showMessageDialog(this, "Por favor, insira apenas números.");
                return; // Para a execução se o texto contiver caracteres inválidos
            }

            try {

                String combo1 = comboDe.getSelectedItem().toString();
                String combo2 = comboPara.getSelectedItem().toString();

                //FORMATANDO OS DECIMAIS E AS VÍRGULAS
                DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
                symbol.setDecimalSeparator(',');
                DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
                String pegueEntrada = txtEntrada.getText();

//______________________________________________________________________
//VERIFICAÇÃO DOS DADOS DE ENTRADA (MENSAGEM DE ERRO E ALERTAS)
                try {
                    double entradaConvertida = (double) df.parse(pegueEntrada).doubleValue();

                    if (combo1 == combo2) {
                        JOptionPane.showMessageDialog(this, "A medida selecionada é a mesma de conversão, altere as medidas.");
                    } else if (entradaConvertida <= 0) {
                        JOptionPane.showMessageDialog(this, "Digite um valor maior que ZERO (0).");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
                }

//CHAMANDO OS MÉTODOS
                double entradaZero = (double) df.parse(pegueEntrada).doubleValue();
                if (combo1.contains("Milímetro") && entradaZero > 0) {
                    try {
                        milimetros();
                    } catch (ParseException ex) {
                        Logger.getLogger(Medidas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (combo1.contains("Centímetro") && entradaZero > 0) {
                    try {
                        centimetros();
                    } catch (ParseException ex) {
                        Logger.getLogger(Medidas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (combo1.contains("Decímetro") && entradaZero > 0) {
                    try {
                        decimetro();
                    } catch (ParseException ex) {
                        Logger.getLogger(Medidas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (combo1.contains("Metro") && entradaZero > 0) {
                    try {
                        metros();
                    } catch (ParseException ex) {
                        Logger.getLogger(Medidas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (combo1.contains("Decâmetro") && entradaZero > 0) {
                    try {
                        decametro();
                    } catch (ParseException ex) {
                        Logger.getLogger(Medidas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (combo1.contains("Hectômetro") && entradaZero > 0) {
                    try {
                        hectometro();
                    } catch (ParseException ex) {
                        Logger.getLogger(Medidas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (combo1.contains("Quilômetro") && entradaZero > 0) {
                    try {
                        quilometro();
                    } catch (ParseException ex) {
                        Logger.getLogger(Medidas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(Medidas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }                                           

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {                                         
        txtEntrada.setText("");
        txtSaida.setText("");
        txtRes.setText("");
    }                                        

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new TelaInicial().setVisible(true);
        dispose();
    }                                        

    private void btInverterMouseClicked(java.awt.event.MouseEvent evt) {                                        
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

//______________________________________________________________________ 
//VERIFICAÇÃO DOS DADOS DE ENTRADA (MENSAGEM DE ERRO E ALERTAS)
            try {
                double entradaConvertida = (double) df.parse(pegueEntrada).doubleValue();

                if (combo1 == combo2) {
                    JOptionPane.showMessageDialog(this, "A medida selecionada é a mesma de conversão, altere as medidas.");
                } else if (entradaConvertida <= 0) {
                    JOptionPane.showMessageDialog(this, "Digite um valor maior que ZERO (0).");
                }
            } catch (ParseException ex) {
                Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                BtInverter();
            } catch (ParseException ex) {
                Logger.getLogger(Medidas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }                                       

    private void txtEntradaKeyTyped(java.awt.event.KeyEvent evt) {                                    
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
    }                                   

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Medidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btConverter;
    private javax.swing.JLabel btInverter;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> comboDe;
    private javax.swing.JComboBox<String> comboPara;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel planoDeFundo;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextArea txtRes;
    private javax.swing.JTextField txtSaida;
    // End of variables declaration                   
}
