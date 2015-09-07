package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Extractable<T> {

	T extract(ResultSet rs, Connection con) throws SQLException;

	List<T> extractAll(ResultSet rs, Connection con) throws SQLException;
}
