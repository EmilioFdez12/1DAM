package prog.unidad08.relacion02.proveedor.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prog.unidad08.relacion02.ProveedorAlmacenamientoEmpresa;
import prog.unidad08.relacion02.ProveedorAlmacenamientoEmpresaException;
import prog.unidad08.relacion02.entidades.Centro;
import prog.unidad08.relacion02.entidades.Departamento;

public class ProveedorAlmacenamientoEmpresaSQLite implements ProveedorAlmacenamientoEmpresa {

	// Sentencias
	private static final String SQL_GET_CENTRO_BY_CODIGO = "SELECT * FROM centro WHERE numce = ?"; // numce == codigo
	private static final String SQL_GET_ALL_CENTRO = "SELECT * FROM centro";
	private static final String SQL_GET_ALL_CENTRO_ORDENADO = "SELECT * FROM centro ORDER BY nomce ASC";
	private static final String SQL_ADD_CENTRO = "INSERT INTO centro(nomce) VALUES (?)";
	private static final String SQL_UPDATE_CENTRO = "UPDATE centro SET nomce = ? WHERE numce = ?";
	private static final String SQL_DELETE_CENTRO = "DELETE FROM centro WHERE numce = ?";
	
	// Sentencias departamento
	private static final String SQL_GET_ALL_DEPARTAMENTOS_ORDENADA = "SELECT * FROM departamento ORDER BY nomde ASC";
	private static final String SQL_GET_ALL_DEPARTAMENTOS = "SELECT * FROM departamento";

	// Ruta
	private static final String URL = "jdbc:sqlite:";

	// Campos de la tabla
	private static final String C_CENTRO_CODIGO = "numce";
	private static final String C_CENTRO_NOMBRE = "nomce";
	
	
	// Campos de la tabla departamento
	private static final String C_DEPARTAMENTO_CODIGO = "numde";
	private static final String C_DEPARTAMENTO_NUMERO = "numce";
	private static final String C_DEPARTAMENTO_DIRECCION = "direc";
	private static final String C_DEPARTAMENTO_DIRECTIVO = "tidir";
	private static final String C_DEPARTAMENTO_PRESUPUESTO = "presu";
	private static final String C_DEPARTAMENTO_DEPDE = "depde";
	private static final String C_DEPARTAMENTO_NOMBRE_DEPARTAMENTO = "nomde";

	// Atributos
	private String rutaDB;

	public ProveedorAlmacenamientoEmpresaSQLite(String rutaDB) {
		this.rutaDB = rutaDB;
	}

	@Override
	public Centro addCentro(Centro centro) {
		try (Connection conexion = getConexion();
				PreparedStatement sentencia = conexion.prepareStatement((SQL_ADD_CENTRO), Statement.RETURN_GENERATED_KEYS)) {
			// like de sql
			sentencia.setString(1, centro.getNombre());

			sentencia.executeUpdate();

			ResultSet rs = sentencia.getGeneratedKeys();

			if (rs.next()) {
				centro = new Centro(rs.getInt(1), centro.getNombre());
			}

			rs.close();
			return centro;
		} catch (SQLException e) {
			throw new ProveedorAlmacenamientoEmpresaException("ERROR JDBC en getCentroByCodigo" + e.getMessage());
		}

	}

	@Override
	public Centro getCentroByCodigo(int codigo) {
		try (Connection conexion = getConexion();
				PreparedStatement sentencia = conexion.prepareStatement(SQL_GET_CENTRO_BY_CODIGO);) {
			// like de sql
			sentencia.setInt(1, codigo);

			ResultSet rs = sentencia.executeQuery();

			Centro centro = null;

			if (rs.next()) {
				centro = getCentroFromResults(rs);
			}
			rs.close();
			return centro;
		} catch (SQLException e) {
			throw new ProveedorAlmacenamientoEmpresaException("ERROR JDBC en getCentroByCodigo" + e.getMessage());
		}
	}

	@Override
	public List<Centro> getAllCentro(boolean ordenarPorNombre) {
		String sql = ordenarPorNombre ? SQL_GET_ALL_CENTRO_ORDENADO : SQL_GET_ALL_CENTRO;

		try (Connection conexion = getConexion(); PreparedStatement sentencia = conexion.prepareStatement(sql);) {

			ResultSet rs = sentencia.executeQuery();

			List<Centro> listaCentros = new ArrayList<>();

			while (rs.next()) {
				listaCentros.add(getCentroFromResults(rs));
			}
			rs.close();
			return listaCentros;
		} catch (SQLException e) {
			throw new ProveedorAlmacenamientoEmpresaException("ERROR JDBC en getCentroByCodigo" + e.getMessage());
		}

	}

	@Override
	public void updateCentro(Centro centro) {
		try (Connection conexion = getConexion();
				PreparedStatement sentencia = conexion.prepareStatement(SQL_UPDATE_CENTRO);) {

			sentencia.setString(1, centro.getNombre());
			sentencia.setInt(2, centro.getCodigo());

			if (sentencia.executeUpdate() != 1) {
				throw new ProveedorAlmacenamientoEmpresaException(
						"Error en updateCentro. El centro indicado no existe en la base de datos");
			}
		} catch (SQLException e) {
			throw new ProveedorAlmacenamientoEmpresaException("ERROR JDBC en getCentroByCodigo" + e.getMessage());
		}
	}

	@Override
	public void deleteCentroByCodigo(int codigo) {
		try (Connection conexion = getConexion();
				PreparedStatement sentencia = conexion.prepareStatement(SQL_DELETE_CENTRO);) {

			sentencia.setInt(1, codigo);

			if (sentencia.executeUpdate() != 1) {
				throw new ProveedorAlmacenamientoEmpresaException(
						"Error en deleteCentroByCodigo. El centro indicado no existe en la base de datos;");
			}
		} catch (SQLException e) {
			throw new ProveedorAlmacenamientoEmpresaException("ERROR JDBC en getCentroByCodigo" + e.getMessage());
		}
	}
	
	@Override
	public List<Departamento> getDepartamentoAll(boolean ordenarPorNombre) {
		String sql = ordenarPorNombre ? SQL_GET_ALL_CENTRO_ORDENADO : SQL_GET_ALL_CENTRO;

		try (Connection conexion = getConexion(); PreparedStatement sentencia = conexion.prepareStatement(sql);) {

			ResultSet rs = sentencia.executeQuery();

			List<Departamento> listaDepartamentos = new ArrayList<>();

			while (rs.next()) {
				listaDepartamentos.add(getCentroFromResults(rs));
			}
			rs.close();
			return listaDepartamentos;
		} catch (SQLException e) {
			throw new ProveedorAlmacenamientoEmpresaException("ERROR JDBC en getCentroByCodigo" + e.getMessage());
		}

	}

	
	

	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Centro getCentroFromResults(ResultSet rs) throws SQLException {
		return new Centro(rs.getInt(C_CENTRO_CODIGO), rs.getString(C_CENTRO_NOMBRE));
	}
	
	private Departamento getDepartamentoFromResults(ResultSet rs) throws SQLException {
		return new Departamento(rs.getInt(C_DEPARTAMENTO_CODIGO), rs.getInt(C_CENTRO_NOMBRE));
	}

	private Connection getConexion() throws SQLException {
		return DriverManager.getConnection(URL + rutaDB);
	}


}
