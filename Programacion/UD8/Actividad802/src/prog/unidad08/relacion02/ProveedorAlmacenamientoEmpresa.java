package prog.unidad08.relacion02;

import java.util.List;

import prog.unidad08.relacion02.entidades.Centro;
import prog.unidad08.relacion02.entidades.Departamento;

public interface ProveedorAlmacenamientoEmpresa {

	/**
	 * Obtiene un centro a partir de su código
	 * 
	 * @param codigo Código del centro a obtener
	 * @return Centro con el código proporcionado o null si no existe un centro con
	 *         ese código
	 * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error
	 *                                                 accediendo al almacenamiento
	 */
	public Centro getCentroByCodigo(int codigo);
	
	
	/**
	 * Añade un nuevo centro
	 * 
	 * @param centro Centro a añadir. El código del centro se ignora y se genera
	 *               automaticamente
	 * @return Centro almacenado. El nombre será el mismo que el del centro de
	 *         entrada pero el código será el que ha generado el sistema
	 *         automáticamente. El mismo si no se pudo realizar la inserción
	 * @throws NullPointerException                    Si centro es null
	 * @throws ProveedorAlmacenamientoEmpresaException Si ocurrio algun error de
	 *                                                 almacenamiento
	 */
	public Centro addCentro(Centro centro);


	/**
	 * Obtiene todos los centros almacenados
	 * 
	 * @param ordenarPorNombre true si se desean obtener los centros ordenados por
	 *                         nombre en orden ascendente. false si no importa el
	 *                         orden en que aparecen los centros en la lista
	 * @return Lista con todos los centros almacenados, posiblemente ordenada. Vacía
	 *         si no hay centros
	 * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error
	 *                                                 accediendo al almacenamiento
	 */
	public List<Centro> getAllCentro(boolean ordenarPorNombre);

	/**
	 * Actualiza un centro en el almacenamiento
	 * 
	 * @param centro Centro a actualizar. Debe existir previamenteun centro con el
	 *               mismo código en el almacenamiento. No puede ser null
	 * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error
	 *                                                 accediendo al almacenamiento
	 *                                                 o no existe un centro en el
	 *                                                 almacenamiento con el código
	 *                                                 del centro proporcionado
	 */
	public void updateCentro(Centro centro);

	
	/**
	 * Elimina un centro del almacenamiento a partir de su código
	 * 
	 * @param codigo Código del centro a eliminar del almacenamiento
	 * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error
	 *                                                 accediendo al almacenamiento
	 *                                                 o no existe un centro en el
	 *                                                 almacenamiento con el código
	 *                                                 proporcionado
	 */
	public void deleteCentroByCodigo(int codigo);


	public List<Departamento> getDepartamentoAll(boolean b);
}
