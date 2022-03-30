package com.ads.jasper.jdbc;

import net.sf.jasperreports.repo.JasperDesignCache;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
       // abrirJrxml("18");
       // exportarParaPDF("02", "C:\\Users\\adson\\Documents\\curso_jasper_relatórios\\" +"jasper=" + UUID.randomUUID() + ".pdf");
       //abrirPontoJasper("09");
       // abrirPontoJasperSubRelatrio("10");
        abrirJrxmlComSubRelatorio("10");
    }

    private static void abrirJrxmlComSubRelatorio(String numero) throws SQLException {

        Connection connection = JdbcConnection.connection();
        JasperService service = new JasperService();

        service.abrirJrxmlComSubReport("relatorios/jrxml/funcionarios-" + numero + ".jrxml",
                "relatorios/jrxml/funcionarios-" + numero + "-subfones.jrxml",
                connection);
        connection.close();
    }

    private static void abrirPontoJasperSubRelatrio(String numero) throws SQLException {
        Connection connection = JdbcConnection.connection();
        JasperService service = new JasperService();
        service.addParams("SUB_REPORT_DIR", "relatorios/jasper/");
        service.abrirPontoJasper("relatorios/jasper/funcionarios-" + numero + ".jasper", connection);
        connection.close();
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
