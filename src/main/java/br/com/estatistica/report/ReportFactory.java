package br.com.caelum.financas.relatorio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 * Fábrica de relatórios, responsável pelas operações que serão feitas a partir de
 * arquivos modelados pelo iReport, como compilar e exportá-lo para outros formatos
 * existentes, como <b>PDF, XML, CVS, HTML</b>, etc.
 * 
 * @author lhleonardo - Leonardo Braz
 * @since 1.5
 * @see JasperCompileManager, JRExporter, JasperPrint.
 *
 */
public class ReportFactory {

	/**
	 * Método responsável por compilar os arquivos jrxml e transformar pro formato
	 * .jasper, que será interpretado pelas bibliotecas jasper.
	 * 
	 * @param file
	 * @throws JRException
	 */
	public void compile(String file) throws JRException {
		JasperCompileManager.compileReportToFile(file);
	}

	/**
	 * Método responsável por criar o modelo do relatório a partir do arquivo pré-moldado
	 * pelo interpretador.
	 * 
	 * @param Conexão
	 *            com o banco de dados, onde serão tiradas as informações para
	 *            preenchimento do conteúdo do relatório.
	 * @param file
	 *            arquivo já compilado, sendo utilizado com o formato .jasper.
	 * @return JasperPrint modelo de "impressão" para determinado relatório.
	 * @throws JRException
	 */
	public JasperPrint createFillManager(Connection connection, String file) throws JRException {
		Map<String, Object> parameter = new HashMap<String, Object>();

		JasperPrint print = JasperFillManager.fillReport(file, parameter, connection);
		return print;
	}

	/**
	 * 
	 * Método responsável por exportar os relatórios que serão gerados para o formato XLS
	 * 
	 * @param print
	 *            arquivo já pré-configurado pelo método createFillManager.
	 * @param output
	 *            nome do arquivo que será exportado.
	 * @throws FileNotFoundException
	 *             caso não seja possível criar o arquivo de saída do relatório.
	 * @throws JRException
	 *             caso o arquivo .jasper não esteja funcional.
	 */
	public void exportToXLS(JasperPrint print, String output) throws FileNotFoundException, JRException {
		export(print, output, new JRXlsExporter());
	}

	/**
	 * 
	 * Método responsável por exportar diversos tipos de relatórios.
	 * 
	 * @param type
	 *            sendo o tipo de exportação para o arquivo pré-modelado
	 * @param print
	 *            arquivo já pré-configurado pelo método createFillManager.
	 * @param output
	 *            nome do arquivo que será exportado.
	 * @throws FileNotFoundException
	 *             caso não seja possível criar o arquivo de saída do relatório.
	 * @throws JRException
	 *             caso o arquivo .jasper não esteja funcional.
	 * @see JasperPrint, JRExporter
	 */
	public void export(JasperPrint print, String output, JRExporter type) throws FileNotFoundException,
	        JRException {
		JRExporter exporter = type;
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(output));
		exporter.exportReport();
	}

	/**
	 * Método responsável por exportar os relatórios que serão gerados para o formato XLS
	 * 
	 * @param print
	 *            arquivo já pré-configurado pelo método createFillManager.
	 * @param output
	 *            nome do arquivo que será exportado.
	 * @throws FileNotFoundException
	 *             caso não seja possível criar o arquivo de saída do relatório.
	 * @throws JRException
	 *             caso o arquivo .jasper não esteja funcional.
	 */
	public void exportToPDF(JasperPrint print, String output) throws FileNotFoundException, JRException {
		export(print, output, new JRPdfExporter());
	}

}
