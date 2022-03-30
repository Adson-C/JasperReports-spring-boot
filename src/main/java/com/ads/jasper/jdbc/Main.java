package com.ads.jasper.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        abrirJrxml("09");

    }

    private static void abrirJrxml(String numero) throws SQLException {

        Connection connection = JdbcConnection.connection();
        JasperService service = new JasperService();
        service.addParams("NIVEL_DESC", "JUNIOR");
        service.addParams("UF", "SP");
        service.abrirJasperView("relatorios/jrxml/funcionarios-" + numero + ".jrxml", connection);
        connection.close();
    }
}
