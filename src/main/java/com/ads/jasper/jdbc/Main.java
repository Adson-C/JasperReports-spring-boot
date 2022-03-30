package com.ads.jasper.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
       // abrirJrxml("18");
       // exportarParaPDF("02", "C:\\Users\\adson\\Documents\\curso_jasper_relatórios\\" +"jasper=" + UUID.randomUUID() + ".pdf");
       abrirPontoJasper("09");
    }

    private static void abrirPontoJasper(String numero) throws SQLException {
        Connection connection = JdbcConnection.connection();
        JasperService service = new JasperService();
        //service.addParams("NIVEL_DESC", "JUNIOR");
        //service.addParams("UF", "SP");
        service.abrirPontoJasper("relatorios/jasper/funcionarios-" + numero + ".jasper", connection);
        connection.close();
    }

    private static void exportarParaPDF(String numero, String saida) throws SQLException {

        Connection connection = JdbcConnection.connection();
        JasperService service = new JasperService();
        service.exportarPDF("relatorios/jrxml/funcionarios-" + numero + ".jrxml", connection, saida);
        connection.close();
    }

    private static void abrirJrxml(String numero) throws SQLException {

        Connection connection = JdbcConnection.connection();
        JasperService service = new JasperService();
        //service.addParams("NIVEL_DESC", "JUNIOR");
        //service.addParams("UF", "SP");
        service.abrirJasperView("relatorios/jrxml/funcionarios-" + numero + ".jrxml", connection);
        connection.close();
    }
}
