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

public class TelaConversorMoedas extends javax.swing.JFrame {

    public TelaConversorMoedas() {
        initComponents();
    }

//__________________________________________________________________________    
//MÉTODO DE CONVERSÃO DA MOEDA DE REAL PARA OUTRAS MOEDAS *****  
    private void RealParaOutras() throws ParseException {
//Atributos (dados das moedas **De Real para Outras)
//Atualizar valores com base nas cotações dirárias posição dos índices {0,1,2, ...n} = {Dólar, Euro, Libra Esterlina} 
        //COTAÇÕES DIÁRIAS
        double moedaReal[] = {5.97, 6.32, 7.60, 0.005899, 0.00613};//MOEDAS {DÓLAR, EURO, LIBRA ESTERLINA, PESO ARGENTINO, PESO CHILENO}

        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();

//FORMATAÇÃO DOS DECIMAIS DE ENTRADA E SAÍDA        
        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
        DecimalFormat df1 = new DecimalFormat("###,##0.#####", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

//EXECUÇÃO DO COMANDO
        if (combo1.contains("Real") && combo2.contains("Dólar")) {
            double resultado = convertEntrada / moedaReal[0];
            txtSaida.setText("USD$ " + df.format(resultado) + "");
        } else if (combo1.contains("Real") && combo2.contains("Euro")) {
            double resultado = convertEntrada / moedaReal[1];
            txtSaida.setText("EUR € " + df.format(resultado) + "");
        } else if (combo1.contains("Real") && combo2.contains("Libra Esterlina")) {
            double resultado = convertEntrada / moedaReal[2];
            txtSaida.setText("GBP £ " + df.format(resultado) + "");
        } else if (combo1.contains("Real") && combo2.contains("Peso Argentino")) {
            double resultado = convertEntrada / moedaReal[3];
            txtSaida.setText("ARS $ " + df1.format(resultado) + "");
        } else if (combo1.contains("Real") && combo2.contains("Peso Chileno")) {
            double resultado = convertEntrada / moedaReal[4];
            txtSaida.setText("CLP $ " + df1.format(resultado) + "");
        }

//SAÍDA GERAL PARA A MOEDA REAL
        if (combo1.contains("Real") && combo2.contains("Dólar")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaReal[1]));
            saida2 = ("Em Libra Esterlina custa: GBP £ " + df.format(convertEntrada / moedaReal[2]) + "");
            saida3 = ("Em Peso Argentino custa: ARS $ " + df1.format(convertEntrada / moedaReal[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaReal[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Real") && combo2.contains("Euro")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Dólares custa: USD$ " + df.format(convertEntrada / moedaReal[0]));
            saida2 = ("Em Libra Esterlina custa: GBP £ " + df.format(convertEntrada / moedaReal[2]));
            saida3 = ("Em Peso Argentino custa: ARS $ " + df1.format(convertEntrada / moedaReal[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaReal[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Real") && combo2.contains("Libra Esterlina")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Dólares custa: USD$ " + df.format(convertEntrada / moedaReal[0]));
            saida2 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaReal[1]));
            saida3 = ("Em Peso Argentino custa: ARS $ " + df1.format(convertEntrada / moedaReal[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaReal[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Real") && combo2.contains("Peso Argentino")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Dólares custa: USD$ " + df.format(convertEntrada / moedaReal[0]));
            saida2 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaReal[1]));
            saida3 = ("Em Libra Esterlina custa: GBP £ " + df.format(convertEntrada / moedaReal[2]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaReal[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Real") && combo2.contains("Peso Chileno")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Dólares custa: USD$ " + df.format(convertEntrada / moedaReal[0]));
            saida2 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaReal[1]));
            saida3 = ("Em Libra Esterlina custa: GBP £ " + df.format(convertEntrada / moedaReal[2]) + "");
            saida4 = ("Em Peso Argentino custa: ARS $ " + df1.format(convertEntrada / moedaReal[3]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        }
    }
//__________________________________________________________________________    
//MÉTODO DE CONVERSÃO DA MOEDA DE DÓLAR PARA OUTRAS MOEDAS *****    

    private void DolarToOther() throws ParseException {
//Atributos (dados das moedas **De Real para Outras)
//Atualizar valores com base nas cotações dirárias posição dos índices {0,1,2} => {Real, Euro, Libra Esterlina}        
        double moedaDolar[] = {0.17, 1.09, 1.30, 0.001011, 0.001038};//MOEDAS {REAL, EURO, LIBRA ESTERLINA}

        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
        DecimalFormat df1 = new DecimalFormat("###,##0.#####", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Dólar") && combo2.contains("Real")) {
            double resultado = convertEntrada / moedaDolar[0];
            txtSaida.setText("R$ " + df.format(resultado) + "");
        } else if (combo1.contains("Dólar") && combo2.contains("Euro")) {
            double resultado = convertEntrada / moedaDolar[1];
            txtSaida.setText("EUR € " + df.format(resultado) + "");
        } else if (combo1.contains("Dólar") && combo2.contains("Libra Esterlina")) {
            double resultado = convertEntrada / moedaDolar[2];
            txtSaida.setText("GBP £ " + df.format(resultado) + "");
        } else if (combo1.contains("Dólar") && combo2.contains("Peso Argentino")) {
            double resultado = convertEntrada / moedaDolar[3];
            txtSaida.setText("ARS $ " + df1.format(resultado) + "");
        } else if (combo1.contains("Dólar") && combo2.contains("Peso Chileno")) {
            double resultado = convertEntrada / moedaDolar[4];
            txtSaida.setText("CLP $ " + df1.format(resultado) + "");
        }
        //SAÍDA GERAL PARA A MOEDA DÓLAR

        if (combo1.contains("Dólar") && combo2.contains("Real")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaDolar[1]));
            saida2 = ("Em Libra Esterlina custa: GBP £ " + df.format(convertEntrada / moedaDolar[2]) + "");
            saida3 = ("Em Peso Argentino custa: ARS £ " + df.format(convertEntrada / moedaDolar[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaDolar[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Dólar") && combo2.contains("Euro")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaDolar[0]));
            saida2 = ("Em Libra Esterlina custa: GBP £ " + df.format(convertEntrada / moedaDolar[2]));
            saida3 = ("Em Peso Argentino custa: ARS £ " + df.format(convertEntrada / moedaDolar[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaDolar[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Dólar") && combo2.contains("Libra Esterlina")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaDolar[0]));
            saida2 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaDolar[1]));
            saida3 = ("Em Peso Argentino custa: ARS £ " + df.format(convertEntrada / moedaDolar[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaDolar[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Dólar") && combo2.contains("Peso Argentino")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaDolar[0]));
            saida2 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaDolar[1]));
            saida3 = ("Em Libra Esterlina custa: GBP £ " + df.format(convertEntrada / moedaDolar[2]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaDolar[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Dólar") && combo2.contains("Peso Chileno")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaDolar[0]));
            saida2 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaDolar[1]));
            saida3 = ("Em Libra Esterlina custa: GBP £ " + df.format(convertEntrada / moedaDolar[2]) + "");
            saida4 = ("Em Peso Argentino custa: ARS $ " + df1.format(convertEntrada / moedaDolar[3]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        }
    }
//__________________________________________________________________________
//MÉTODO DE CONVERSÃO DA MOEDA DE EURO PARA OUTRAS MOEDAS *****    

    private void EuroToOther() throws ParseException {
//Atributos (dados das moedas **De Real para Outras)
//Atualizar valores com base nas cotações dirárias posição dos índices {0,1,2} = {Real, Dólar, Libra Esterlina}  
        //COTAÇÕES DIÁRIAS
        double moedaEuro[] = { 0.1583, 0.9454, 1.2041, 0.00094, 0.000971};//INDEX DAS MOEDAS {REAL, DÓLAR, LIBRA ESTERLINA, PESO ARGENTINO, PESO CHILENO}

        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
        DecimalFormat df1 = new DecimalFormat("###,##0.#####", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Euro") && combo2.contains("Real")) {
            double resultado = convertEntrada / moedaEuro[0];
            txtSaida.setText("R$ " + df.format(resultado) + "");
        } else if (combo1.contains("Euro") && combo2.contains("Dólar")) {
            double resultado = convertEntrada / moedaEuro[1];
            txtSaida.setText("USD$ " + df.format(resultado) + "");
        } else if (combo1.contains("Euro") && combo2.contains("Libra Esterlina")) {
            double resultado = convertEntrada / moedaEuro[2];
            txtSaida.setText("GBP £ " + df.format(resultado) + "");
        } else if (combo1.contains("Euro") && combo2.contains("Peso Argentino")) {
            double resultado = convertEntrada / moedaEuro[3];
            txtSaida.setText("ARS $ " + df1.format(resultado) + "");
        } else if (combo1.contains("Euro") && combo2.contains("Peso Chileno")) {
            double resultado = convertEntrada / moedaEuro[4];
            txtSaida.setText("CLP $ " + df1.format(resultado) + "");
        }
        //SAÍDA GERAL PARA A MOEDA EURO

        if (combo1.contains("Euro") && combo2.contains("Real")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Dólares: USD $ " + df.format(convertEntrada / moedaEuro[1]));
            saida2 = ("Em Libra Esterlina custa: GBP £ " + df.format(convertEntrada / moedaEuro[2]) + "");
            saida3 = ("Em Peso Argentino custa: ARS £ " + df.format(convertEntrada / moedaEuro[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaEuro[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Euro") && combo2.contains("Dólar")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaEuro[0]));
            saida2 = ("Em Libra Esterlina custa: GBP £ " + df.format(convertEntrada / moedaEuro[2]));
            saida3 = ("Em Peso Argentino custa: ARS £ " + df.format(convertEntrada / moedaEuro[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaEuro[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Euro") && combo2.contains("Libra Esterlina")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaEuro[0]));
            saida2 = ("Em Dólares custa: USD $ " + df.format(convertEntrada / moedaEuro[1]));
            saida3 = ("Em Peso Argentino custa: ARS £ " + df.format(convertEntrada / moedaEuro[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaEuro[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Euro") && combo2.contains("Peso Argentino")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaEuro[0]));
            saida2 = ("Em Dólares custa: USD $ " + df.format(convertEntrada / moedaEuro[1]));
            saida3 = ("Em Libra Esterlina custa: GBP £ " + df.format(convertEntrada / moedaEuro[2]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaEuro[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Euro") && combo2.contains("Peso Chileno")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaEuro[0]));
            saida2 = ("Em Dólares custa: USD $ " + df.format(convertEntrada / moedaEuro[1]));
            saida3 = ("Em Libra Esterlina custa: GBP £ " + df.format(convertEntrada / moedaEuro[2]) + "");
            saida4 = ("Em Peso Argentino custa: ARS $ " + df1.format(convertEntrada / moedaEuro[3]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        }
    }
//__________________________________________________________________________    
//MÉTODO DE CONVERSÃO DA MOEDA DE LIBRA ESTERLINA PARA OUTRAS MOEDAS *****    

    private void LibraEsterToOther() throws ParseException {
//Atributos (dados das moedas **De Dólar para outras)
        double moedaLibraEster[] = {0.1373, 0.77, 0.83, 0.000778, 0.000802};//MOEDAS {REAL, DÓLAR, EURO, PESO ARGENTINO, PESO CHILENO}    
/*  double moedaReal=0.14; //Atualizar valores com base nas cotações dirárias
    double moedaDolar=0.76; //Atualizar valores com base nas cotações dirárias
    double moedaEuro=0.84;//Atualizar valores com base nas cotações dirárias*/
        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.##", symbol);
        DecimalFormat df1 = new DecimalFormat("###,##0.#####", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Libra Esterlina") && combo2.contains("Real")) {
            double resultado = convertEntrada / moedaLibraEster[0];
            txtSaida.setText("R$ " + df.format(resultado) + "");
        } else if (combo1.contains("Libra Esterlina") && combo2.contains("Dólar")) {
            double resultado = convertEntrada / moedaLibraEster[0];
            txtSaida.setText("USD$ " + df.format(resultado) + "");
        } else if (combo1.contains("Libra Esterlina") && combo2.contains("Euro")) {
            double resultado = convertEntrada / moedaLibraEster[0];
            txtSaida.setText("EUR € " + df.format(resultado) + "");
        } else if (combo1.contains("Libra Esterlina") && combo2.contains("Peso Argentino")) {
            double resultado = convertEntrada / moedaLibraEster[3];
            txtSaida.setText("ARS $ " + df1.format(resultado) + "");
        } else if (combo1.contains("Libra Esterlina") && combo2.contains("Peso Chileno")) {
            double resultado = convertEntrada / moedaLibraEster[4];
            txtSaida.setText("CLP $ " + df1.format(resultado) + "");
        }

        //SAÍDA GERAL PARA A MOEDA LIBRA ESTERLINA
        if (combo1.contains("Libra Esterlina") && combo2.contains("Real")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Dólares: USD $ " + df.format(convertEntrada / moedaLibraEster[1]));
            saida2 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaLibraEster[2]) + "");
            saida3 = ("Em Peso Argentino custa: ARS $ " + df.format(convertEntrada / moedaLibraEster[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaLibraEster[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Libra Esterlina") && combo2.contains("Dólar")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaLibraEster[0]));
            saida2 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaLibraEster[2]));
            saida3 = ("Em Peso Argentino custa: ARS $ " + df.format(convertEntrada / moedaLibraEster[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaLibraEster[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Libra Esterlina") && combo2.contains("Euro")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaLibraEster[0]));
            saida2 = ("Em Dólares custa: USD $ " + df.format(convertEntrada / moedaLibraEster[1]));
            saida3 = ("Em Peso Argentino custa: ARS £ " + df.format(convertEntrada / moedaLibraEster[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaLibraEster[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Libra Esterlina") && combo2.contains("Peso Argentino")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaLibraEster[0]));
            saida2 = ("Em Dólares custa: USD $ " + df.format(convertEntrada / moedaLibraEster[1]));
            saida3 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaLibraEster[2]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df1.format(convertEntrada / moedaLibraEster[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        } else if (combo1.contains("Libra Esterlina") && combo2.contains("Peso Chileno")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaLibraEster[0]));
            saida2 = ("Em Dólares custa: USD $ " + df.format(convertEntrada / moedaLibraEster[1]));
            saida3 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaLibraEster[2]) + "");
            saida4 = ("Em Peso Argentino custa: ARS $ " + df1.format(convertEntrada / moedaLibraEster[3]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);
        }

    }

    
    //MÉTODO DE CONVERSÃO DA MOEDA PESO ARGENTINO PARA OUTRAS MOEDAS *****     
    private void PesosArgentinosToOther() throws ParseException {
        // Atributos (dados das moedas)
        //Variável moedaPesoArgentino tem o fator, por isso multiplicamos.
        //Ex.: {0.0058 é o valor em reais para cada peso, assim para as demais moedas}
        double moedaPesoArgentino[] = {0.0058, 0.00100, 0.00095, 0.00079, 0.00098}; // //MOEDAS {REAL, DÓLAR, EURO, LIBRA ESTERLINA, PESO CHILENO}

        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.#####", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Peso Argentino") && combo2.contains("Real")) {
            double resultado = convertEntrada * moedaPesoArgentino[0];
            txtSaida.setText("R$ " + df.format(resultado));
        } else if (combo1.contains("Peso Argentino") && combo2.contains("Dólar")) {
            double resultado = convertEntrada * moedaPesoArgentino[1];
            txtSaida.setText("USD$ " + df.format(resultado));
        } else if (combo1.contains("Peso Argentino") && combo2.contains("Euro")) {
            double resultado = convertEntrada * moedaPesoArgentino[2];
            txtSaida.setText("EUR € " + df.format(resultado));
        } else if (combo1.contains("Peso Argentino") && combo2.contains("Libra Esterlina")) {
            double resultado = convertEntrada * moedaPesoArgentino[3];
            txtSaida.setText("GBP £ " + df.format(resultado));
        } else if (combo1.contains("Peso Argentino") && combo2.contains("Peso Chileno ")) {
            double resultado = convertEntrada * moedaPesoArgentino[4];
            txtSaida.setText("CLP $ " + df.format(resultado));
        }

        // SAÍDA GERAL PARA A MOEDA PESO ARGENTINO
        if (combo1.contains("Peso Argentino") && combo2.contains("Real")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Dólares custa: USD$ " + df.format(convertEntrada * moedaPesoArgentino[1]));
            saida2 = ("Em Euros custa: EUR € " + df.format(convertEntrada * moedaPesoArgentino[2]) + "");
            saida3 = ("Em Libra Esterlina custa: GBP £  " + df.format(convertEntrada * moedaPesoArgentino[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $ " + df.format(convertEntrada * moedaPesoArgentino[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);

        } else if (combo1.contains("Peso Argentino") && combo2.contains("Dólar")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada * moedaPesoArgentino[0]));
            saida2 = ("Em Euros custa: EUR € " + df.format(convertEntrada * moedaPesoArgentino[2]) + "");
            saida3 = ("Em Libra Esterlina custa: GBP £  " + df.format(convertEntrada * moedaPesoArgentino[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $" + df.format(convertEntrada * moedaPesoArgentino[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);

        } else if (combo1.contains("Peso Argentino") && combo2.contains("Euro")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada * moedaPesoArgentino[0]));
            saida2 = ("Em Dólares custa: USD$ " + df.format(convertEntrada * moedaPesoArgentino[1]) + "");
            saida3 = ("Em Libra Esterlina custa: GBP £  " + df.format(convertEntrada * moedaPesoArgentino[3]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $" + df.format(convertEntrada * moedaPesoArgentino[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);

        } else if (combo1.contains("Peso Argentino") && combo2.contains("Libra Esterlina")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada * moedaPesoArgentino[0]));
            saida2 = ("Em Dólares custa: USD$ " + df.format(convertEntrada * moedaPesoArgentino[1]) + "");
            saida3 = ("Em Euros custa: EUR €  " + df.format(convertEntrada * moedaPesoArgentino[2]) + "");
            saida4 = ("Em Peso Chileno custa: CLP $" + df.format(convertEntrada * moedaPesoArgentino[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);

        } else if (combo1.contains("Peso Argentino") && combo2.contains("Peso Chileno")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada * moedaPesoArgentino[0]));
            saida2 = ("Em Dólares custa: USD$ " + df.format(convertEntrada * moedaPesoArgentino[1]) + "");
            saida3 = ("Em Libra Esterlina custa: GBP £  " + df.format(convertEntrada * moedaPesoArgentino[3]) + "");
            saida4 = ("Em Euros custa: EUR €" + df.format(convertEntrada * moedaPesoArgentino[2]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);

        }
    }
//REAL 0.0060, DÓLAR 0.0010, EURO 0.00098 , LIBRA ESTERLINA 0.00082, PESO ARGENTINO 1.03        
//MÉTODO DE CONVERSÃO DA MOEDA PESO CHILENO PARA OUTRAS MOEDAS *****    

    private void PesosChilenoParaOutras() throws ParseException {
        // Atributos (dados das moedas)
        double moedaChilena[] = {169.0114, 982.6700, 1023.1000, 1230.7900, 0.9784}; // //MOEDAS {REAL, DÓLAR, EURO, LIBRA ESTERLINA, PESO ARGENTINO}

        String combo1 = comboDe.getSelectedItem().toString();
        String combo2 = comboPara.getSelectedItem().toString();

        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("###,##0.#####", symbol);
        String pegueEntrada = txtEntrada.getText();
        double convertEntrada = (double) df.parse(pegueEntrada).doubleValue();

        if (combo1.contains("Peso Chileno") && combo2.contains("Real")) {
            double resultado = convertEntrada / moedaChilena[0];
            txtSaida.setText("R$ " + df.format(resultado));
        } else if (combo1.contains("Peso Chileno") && combo2.contains("Dólar")) {
            double resultado = convertEntrada / moedaChilena[1];
            txtSaida.setText("USD$ " + df.format(resultado));
        } else if (combo1.contains("Peso Chileno") && combo2.contains("Euro")) {
            double resultado = convertEntrada / moedaChilena[2];
            txtSaida.setText("EUR € " + df.format(resultado));
        } else if (combo1.contains("Peso Chileno") && combo2.contains("Libra Esterlina")) {
            double resultado = convertEntrada / moedaChilena[3];
            txtSaida.setText("GBP £ " + df.format(resultado));
        } else if (combo1.contains("Peso Chileno") && combo2.contains("Peso Argentino")) {
            double resultado = convertEntrada / moedaChilena[4];
            txtSaida.setText("ARS $ " + df.format(resultado));
        }

        // SAÍDA GERAL PARA A MOEDA PESO ARGENTINO
        if (combo1.contains("Peso Chileno") && combo2.contains("Real")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Dólares custa: USD$ " + df.format(convertEntrada / moedaChilena[1]));
            saida2 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaChilena[2]) + "");
            saida3 = ("Em Libra Esterlina custa: GBP £  " + df.format(convertEntrada / moedaChilena[3]) + "");
            saida4 = ("Em Peso Argentino custa: ARS $ " + df.format(convertEntrada / moedaChilena[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);

        } else if (combo1.contains("Peso Chileno") && combo2.contains("Dólar")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaChilena[0]));
            saida2 = ("Em Euros custa: EUR € " + df.format(convertEntrada / moedaChilena[2]) + "");
            saida3 = ("Em Libra Esterlina custa: GBP £  " + df.format(convertEntrada / moedaChilena[3]) + "");
            saida4 = ("Em Peso Argentino custa: ARS $ " + df.format(convertEntrada / moedaChilena[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);

        } else if (combo1.contains("Peso Chileno") && combo2.contains("Euro")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaChilena[0]));
            saida2 = ("Em Dólares custa: USD$ " + df.format(convertEntrada / moedaChilena[1]) + "");
            saida3 = ("Em Libra Esterlina custa: GBP £  " + df.format(convertEntrada / moedaChilena[3]) + "");
            saida4 = ("Em Peso Argentino custa: ARS $ " + df.format(convertEntrada / moedaChilena[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);

        } else if (combo1.contains("Peso Chileno") && combo2.contains("Libra Esterlina")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaChilena[0]));
            saida2 = ("Em Dólares custa: USD$ " + df.format(convertEntrada / moedaChilena[1]) + "");
            saida3 = ("Em Euros custa: EUR €  " + df.format(convertEntrada / moedaChilena[2]) + "");
            saida4 = ("Em Peso Argentino custa: ARS $ " + df.format(convertEntrada / moedaChilena[4]) + "");
            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);

        } else if (combo1.contains("Peso Chileno") && combo2.contains("Peso Argentino")) {
            String saida1, saida2, saida3, saida4;
            saida1 = ("Em Reais custa: R$ " + df.format(convertEntrada / moedaChilena[0]));
            saida2 = ("Em Dólares custa: USD$ " + df.format(convertEntrada / moedaChilena[1]) + "");
            saida3 = ("Em Euros custa: EUR €" + df.format(convertEntrada / moedaChilena[2]) + "");
            saida4 = ("Em Libra Esterlina custa: GBP £  " + df.format(convertEntrada / moedaChilena[3]) + "");

            txtRes.setText(saida1 + "\n" + saida2 + "\n" + saida3 + "\n" + saida4);

        }
    }
//__________________________________________________________________________    
//MÉTODO DO BOTÃO DE INVERTER *****      

    public void BtInverter() throws ParseException {
        String cbox1 = comboDe.getSelectedItem().toString();
        String cbox2 = comboPara.getSelectedItem().toString();

//A VARIÁVEL temp SIGNIFICA QUE RECEBERÁ UM VALOR 'TEMPORÁRIO' PARA SER USADO POSTERIORMENTE        
        if (cbox1.contains("Real") && cbox2.contains("Dólar") || cbox1.contains("Real") && cbox2.contains("Euro") || cbox1.contains("Real") && cbox2.contains("Libra Esterlina") || cbox1.contains("Real") && cbox2.contains("Peso Argentino") || cbox1.contains("Real") && cbox2.contains("Peso Chileno")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Dólar") && cbox2.contains("Real") || cbox1.contains("Dólar") && cbox2.contains("Euro") || cbox1.contains("Dólar") && cbox2.contains("Libra Esterlina") || cbox1.contains("Dólar") && cbox2.contains("Peso Argentino") || cbox1.contains("Dólar") && cbox2.contains("Peso Chileno")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Euro") && cbox2.contains("Real") || cbox1.contains("Euro") && cbox2.contains("Dólar") || cbox1.contains("Euro") && cbox2.contains("Libra Esterlina") || cbox1.contains("Euro") && cbox2.contains("Peso Argentino") || cbox1.contains("Euro") && cbox2.contains("Peso Chileno")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Libra Esterlina") && cbox2.contains("Real") || cbox1.contains("Libra Esterlina") && cbox2.contains("Dólar") || cbox1.contains("Libra Esterlina") && cbox2.contains("Euro") || cbox1.contains("Libra Esterlina") && cbox2.contains("Peso Argentino") || cbox1.contains("Libra Esterlina") && cbox2.contains("Peso Chileno")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Peso Argentino") && cbox2.contains("Real") || cbox1.contains("Peso Argentino") && cbox2.contains("Dólar") || cbox1.contains("Peso Argentino") && cbox2.contains("Euro") || cbox1.contains("Peso Argentino") && cbox2.contains("Libra Esterlina") || cbox1.contains("Peso Argentino") && cbox2.contains("Peso Chileno")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        } else if (cbox1.contains("Peso Chileno") && cbox2.contains("Real") || cbox1.contains("Peso Chileno") && cbox2.contains("Dólar") || cbox1.contains("Peso Chileno") && cbox2.contains("Euro") || cbox1.contains("Peso Chileno") && cbox2.contains("Libra Esterlina") || cbox1.contains("Peso Chileno") && cbox2.contains("Peso Argentino")) {
            String temp = comboDe.getSelectedItem().toString();
            comboDe.setSelectedItem(comboPara.getSelectedItem().toString());
            comboPara.setSelectedItem(temp);
        }
        //FALTA ADICIONAR(COMPLETAR) OS IF's PARA AS OUTRAS MOEDAS)
        //FORMATAÇÃO DOS DECIMAIS DE ENTRADA E SAÍDA         
        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator(',');
        DecimalFormat decimalF = new DecimalFormat("#,##0.##", symbol);
        String pegueEntrada = txtEntrada.getText();
        double entradaZero = (double) decimalF.parse(pegueEntrada).doubleValue();
        String combo1 = comboDe.getSelectedItem().toString();
        if (combo1.contains("Real") && entradaZero > 0) {
            RealParaOutras();
        } else if (combo1.contains("Dólar") && entradaZero > 0) {
            DolarToOther();
        } else if (combo1.contains("Euro") && entradaZero > 0) {
            EuroToOther();
        } else if (combo1.contains("Libra Esterlina") && entradaZero > 0) {
            LibraEsterToOther();
        } else if (combo1.contains("Peso Argentino") && entradaZero > 0) {
            PesosArgentinosToOther();
        } else if (combo1.contains("Peso Chileno") && entradaZero > 0) {
            PesosChilenoParaOutras();
        }
    }

//__________________________________________________________________________
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        comboDe = new javax.swing.JComboBox<>();
        comboPara = new javax.swing.JComboBox<>();
        txtEntrada = new javax.swing.JTextField();
        btConverter = new javax.swing.JButton();
        txtSaida = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRes = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btInverter = new javax.swing.JLabel();
        btLimpar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ConvertMaster - Moedas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboDe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Real", "Dólar", "Euro", "Libra Esterlina", "Peso Argentino", "Peso Chileno" }));
        getContentPane().add(comboDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 150, 30));

        comboPara.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboPara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Real", "Dólar", "Euro", "Libra Esterlina", "Peso Argentino", "Peso Chileno" }));
        comboPara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboParaActionPerformed(evt);
            }
        });
        getContentPane().add(comboPara, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 150, 30));

        txtEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEntradaKeyTyped(evt);
            }
        });
        getContentPane().add(txtEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 150, 22));

        btConverter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btConverter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BT_CONVERTER_MEDIDAS_1.png"))); // NOI18N
        btConverter.setBorderPainted(false);
        btConverter.setContentAreaFilled(false);
        btConverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConverterActionPerformed(evt);
            }
        });
        getContentPane().add(btConverter, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 150, 25));

        txtSaida.setEditable(false);
        txtSaida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSaida.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtSaida.setMinimumSize(new java.awt.Dimension(64, 22));
        getContentPane().add(txtSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 150, 22));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Moeda de Entrada");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Moeda de Saída");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Valor de entrada:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("O resultado aparecerá aqui:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setText("Conversor de Moedas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 80, 250, -1));

        btVoltar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BT_VOLTAR_TODOS.png"))); // NOI18N
        btVoltar.setBorderPainted(false);
        btVoltar.setContentAreaFilled(false);
        btVoltar.setPreferredSize(new java.awt.Dimension(150, 23));
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 410, 180, 25));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(234, 90));

        txtRes.setEditable(false);
        txtRes.setColumns(20);
        txtRes.setRows(5);
        jScrollPane1.setViewportView(txtRes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 310, 380, 90));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Resultados da conversão para outras moedas aparecerão aqui:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 290, -1, -1));

        btInverter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BT_INVERTER_MEDIDAS_01.png"))); // NOI18N
        btInverter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btInverterMouseClicked(evt);
            }
        });
        getContentPane().add(btInverter, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 160, 30, 30));

        btLimpar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão_Limpar tela.png"))); // NOI18N
        btLimpar.setBorderPainted(false);
        btLimpar.setContentAreaFilled(false);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 150, 25));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundo_moedas_1.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        setSize(new java.awt.Dimension(516, 508));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConverterActionPerformed
        if (txtEntrada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Acrescente algum valor na caixa de diálogo 'VALOR DE ENTRADA'.");
        } else {
            //NESTE BLOCO IF (){}ELSE{} NECESSITAMOS DA AJUDA DA A.I. (Artificial Intelligence)
            String entrada = txtEntrada.getText();
            if (!entrada.matches("[0-9.,]+")) { // Verifica se contém apenas números, ponto e vírgula
                JOptionPane.showMessageDialog(this, "Por favor, insira apenas números.");
                return; // Para a execução se o texto contiver caracteres inválidos
            }
            try {
//______________________________________________________________________
//ATRIBUTOS E VARIÁVEIS
                String combo1 = comboDe.getSelectedItem().toString();
                String combo2 = comboPara.getSelectedItem().toString();

//FORMATAÇÃO DOS DECIMAIS DE ENTRADA E SAÍDA
                DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
                symbol.setDecimalSeparator(',');
                DecimalFormat decimalF = new DecimalFormat("#,##0.##", symbol);
                String pegueEntrada = txtEntrada.getText();

//______________________________________________________________________ 
//VERIFICAÇÃO DOS DADOS DE ENTRADA (MENSAGEM DE ERRO E ALERTAS)
                try {
                    double entradaConvertida = (double) decimalF.parse(pegueEntrada).doubleValue();

                    if (combo1 == combo2) {
                        JOptionPane.showMessageDialog(this, "A moeda selecionada é a mesma de conversão, altere as moedas.");
                    } else if (entradaConvertida <= 0) {
                        JOptionPane.showMessageDialog(this, "Digite um valor maior que ZERO (0).");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
                }

//______________________________________________________________________
//CHAMANDO OS MÉTODOS DAS FÓRMULAS
                double entradaZero = (double) decimalF.parse(pegueEntrada).doubleValue();
                if (combo1.contains("Real") && entradaZero > 0) {
                    try {
                        RealParaOutras();
                    } catch (ParseException ex) {
                        Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (combo1.contains("Dólar") && entradaZero > 0) {
                    try {
                        DolarToOther();
                    } catch (ParseException ex) {
                        Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (combo1.contains("Euro") && entradaZero > 0) {
                    try {
                        EuroToOther();
                    } catch (ParseException ex) {
                        Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (combo1.contains("Libra Esterlina") && entradaZero > 0) {
                    try {
                        LibraEsterToOther();
                    } catch (ParseException ex) {
                        Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (combo1.contains("Peso Argentino") && entradaZero > 0) {
                    try {
                        PesosArgentinosToOther();
                    } catch (ParseException ex) {
                        Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (combo1.contains("Peso Chileno") && entradaZero > 0) {
                    try {
                        PesosChilenoParaOutras();
                    } catch (ParseException ex) {
                        Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btConverterActionPerformed

    private void comboParaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboParaActionPerformed

    }//GEN-LAST:event_comboParaActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        new TelaInicial().setVisible(true);
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btInverterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btInverterMouseClicked
        if (txtEntrada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Acrescente algum valor na caixa de diálogo 'VALOR DE ENTRADA'.");
        } else {
//______________________________________________________________________
//ATRIBUTOS E VARIÁVEIS
            String combo1 = comboDe.getSelectedItem().toString();
            String combo2 = comboPara.getSelectedItem().toString();

//FORMATAÇÃO DOS DECIMAIS DE ENTRADA E SAÍDA         
            DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
            symbol.setDecimalSeparator(',');
            DecimalFormat decimalF = new DecimalFormat("#,##0.##", symbol);
            String pegueEntrada = txtEntrada.getText();

//______________________________________________________________________ 
//VERIFICAÇÃO DOS DADOS DE ENTRADA (MENSAGEM DE ERRO E ALERTAS)
            try {
                double entradaConvertida = (double) decimalF.parse(pegueEntrada).doubleValue();

                if (combo1 == combo2) {
                    JOptionPane.showMessageDialog(this, "A moeda selecionada é a mesma de conversão, altere as moedas.");
                } else if (entradaConvertida <= 0) {
                    JOptionPane.showMessageDialog(this, "Digite um valor maior que ZERO (0).");
                }
            } catch (ParseException ex) {
                Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                BtInverter();
            } catch (ParseException ex) {
                Logger.getLogger(TelaConversorMoedas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btInverterMouseClicked

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        txtEntrada.setText("");
        txtSaida.setText("");
        txtRes.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void txtEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyTyped
//NESTE MÉTODO DA CAIXA DE ENTRADA NECESSITAMOS DA AJUDA DA A.I. (Artificial Intelligence)
        //Limita a entrada de dados em até 20 caracteres
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
        numberFormat.setMaximumFractionDigits(2); // Ajusta o número máximo de casas decimais para 2
        numberFormat.setMinimumFractionDigits(2); // Ajusta o número mínimo de casas decimais para 2

        // Usa SwingUtilities.invokeLater para garantir que a atualização da UI ocorra na thread correta
        SwingUtilities.invokeLater(() -> {
            try {
                // Obtém o texto do campo de entrada
                String text = txtEntrada.getText();
                // Remove a formatação existente (pontos e vírgulas)
                text = text.replace(".", "").replace(",", "");
                // Verifica se o texto está vazio e define para "0,00" se estiver
                if (text.isEmpty()) {
                    text = "0,00";
                    // Se o texto tiver apenas 1 caractere, adiciona "0,0" antes do caractere
                } else if (text.length() == 1) {
                    text = "0,0" + text;
                    // Se o texto tiver 2 caracteres, adiciona "0," antes dos caracteres
                } else if (text.length() == 2) {
                    text = "0," + text;
                    // Se o texto tiver mais de 2 caracteres, insere uma vírgula antes dos dois últimos caracteres
                } else {
                    text = text.substring(0, text.length() - 2) + "," + text.substring(text.length() - 2);
                }
                // Converte o texto para um valor double
                double value = Double.parseDouble(text.replace(",", ".")); // Formata o valor e define o texto do campo de entrada com o valor formatado
                txtEntrada.setText(numberFormat.format(value));
            } catch (NumberFormatException | StringIndexOutOfBoundsException ex) { // Em caso de erro, define o texto do campo de entrada para "0,00"
                txtEntrada.setText("0,00");
            }
        }
        );

    }//GEN-LAST:event_txtEntradaKeyTyped

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new TelaConversorMoedas().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextArea txtRes;
    private javax.swing.JTextField txtSaida;
    // End of variables declaration//GEN-END:variables
}
